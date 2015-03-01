package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.persistence.UserRepository;
import ch.heigvd.ptl.sc.converter.UserConverter;
import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.to.UserTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/users")
public class UserResource {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll(
                @QueryParam("page") String pageParam,
                @QueryParam("sort") String sortParam,
                @QueryParam("order") String orderParam) {
            
            Sort.Direction order;
            
            if (orderParam != null && "desc".compareToIgnoreCase(orderParam) == 0)
                order = Sort.Direction.DESC;
            else
                order = Sort.Direction.ASC;
            
            if(sortParam == null)
                sortParam = "id";
            
            Sort sort = new Sort(order, sortParam);
            List<User> users;
            
            try {
                int page = Integer.parseInt(pageParam);
                Pageable pageable = new PageRequest(page, 5, sort);
                users = userRepository.findAll(pageable).getContent();
            } catch (NumberFormatException e) {
                users = userRepository.findAll();
            }
            
            return Response.ok(userConverter.convertSourceToTarget(users)).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(UserTO userTO) {
		User user = userRepository.save(userConverter.convertTargetToSource(userTO));
		
		return Response.ok(userConverter.convertSourceToTarget(user)).status(201).build();
	}
        
        @GET
	@Path("sort/{prop}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSort(@PathParam("prop") String prop,
                @RequestParam(value="page", defaultValue="0") String page) {
            Sort sort = new Sort(Sort.Direction.ASC, prop);
            Pageable pgbl = new PageRequest(Integer.parseInt(page), 5, sort);
		Page<User> users = userRepository.findAll(pgbl);
		
		if (users == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(userConverter.convertSourceToTarget(users.getContent())).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		User user = userRepository.findOne(id);
		
		if (user == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(userConverter.convertSourceToTarget(user)).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, UserTO userTO) {
		User user = userRepository.findOne(id);

		if (user == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		userConverter.fillSourceFromTarget(user, userTO);
		
		user = userRepository.save(user);

		return Response.ok(userConverter.convertSourceToTarget(user)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		userRepository.delete(id);
		return Response.ok().status(204).build();
	}
}
