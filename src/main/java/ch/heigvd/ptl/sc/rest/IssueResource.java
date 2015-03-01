package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.persistence.IssueRepository;
import ch.heigvd.ptl.sc.converter.IssueConverter;
import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.to.IssueTO;
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
import org.springframework.stereotype.Component;

@Component
@Path("/issues")
public class IssueResource {
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private IssueConverter issueConverter;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(issueConverter.convertSourceToTarget(issueRepository.findAll())).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(IssueTO issueTO) {
		Issue issue = issueRepository.save(issueConverter.convertTargetToSource(issueTO));
		
		return Response.ok(issueConverter.convertSourceToTarget(issue)).status(201).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		Issue issue = issueRepository.findOne(id);
		
		if (issue == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(issueConverter.convertSourceToTarget(issue)).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, IssueTO issueTO) {
		Issue issue = issueRepository.findOne(id);

		if (issue == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		issueConverter.fillSourceFromTarget(issue, issueTO);
		
		issue = issueRepository.save(issue);

		return Response.ok(issueConverter.convertSourceToTarget(issue)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		issueRepository.delete(id);
		return Response.ok().status(204).build();
	}
        
        
	@GET
	@Path("betweenDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBetweenDate(@QueryParam("start") String start,
                @QueryParam("end") String end) {
		List<Issue> issues = issueRepository.findByDateBetween(start, end);
		return Response.ok(issueConverter.convertSourceToTarget(issues)).build();
	}
        
        
	@GET
	@Path("type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBetweenDate(@PathParam("type") String type) {
		List<Issue> issues = issueRepository.findByIssueType(type);
		return Response.ok(issueConverter.convertSourceToTarget(issues)).build();
	}
        
        
	@GET
	@Path("unsolved")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUnsolved() {
		List<Issue> issues = issueRepository.findUnsolved();
		return Response.ok(issueConverter.convertSourceToTarget(issues)).build();
	}

}
