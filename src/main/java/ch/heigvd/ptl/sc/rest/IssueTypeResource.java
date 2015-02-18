package ch.heigvd.ptl.sc.rest;


import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.converter.IssueTypeConverter;
import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.to.IssueTypeTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/issuestypes")
public class IssueTypeResource {
	@Autowired
	private IssueTypeRepository IssueTypeRepository;
	
	@Autowired
	private IssueTypeConverter IssueTypeConverter;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(IssueTypeConverter.convertSourceToTarget(IssueTypeRepository.findAll())).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(IssueTypeTO IssueTypeTO) {
		IssueType issueType = IssueTypeRepository.save(IssueTypeConverter.convertTargetToSource(IssueTypeTO));
		
		return Response.ok(IssueTypeConverter.convertSourceToTarget(issueType)).status(201).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		IssueType issueType = IssueTypeRepository.findOne(id);
		
		if (IssueType == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(IssueTypeConverter.convertSourceToTarget(issueType)).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, IssueTypeTO IssueTypeTO) {
		IssueType issueType = IssueTypeRepository.findOne(id);

		if (issueType == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		IssueTypeConverter.fillSourceFromTarget(issueType, IssueTypeTO);
		
		issueType = IssueTypeRepository.save(issueType);

		return Response.ok(IssueTypeConverter.convertSourceToTarget(issueType)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		IssueTypeRepository.delete(id);
		return Response.ok().status(204).build();
	}
}
