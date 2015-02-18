package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.converter.IssueTypeConverter;
import ch.heigvd.ptl.sc.model.IssueType;
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
	private IssueTypeRepository issueTypeRepository;
	
	@Autowired
	private IssueTypeConverter issueTypeConverter;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
            
		return Response.ok(issueTypeConverter.convertSourceToTarget(issueTypeRepository.findAll())).build();
	}
        
        @GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		IssueType issueTpye = issueTypeRepository.findOne(id);
		
		if (issueTpye == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(issueTypeConverter.convertSourceToTarget(issueTpye)).build();
	}
        
}
