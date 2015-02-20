/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.persistence.ActionRepository;
import ch.heigvd.ptl.sc.converter.ActionConverter;
import ch.heigvd.ptl.sc.model.Action;
import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.persistence.IssueRepository;
import ch.heigvd.ptl.sc.to.ActionTO;
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
@Path("/issues/{id}/actions")
public class ActionIssueResource {
    
    @Autowired
	private ActionRepository actionRepository;
	
	@Autowired
	private ActionConverter actionConverter;

        @Autowired
        private IssueRepository issueRepository;
        
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(actionConverter.convertSourceToTarget(actionRepository.findAll())).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(@PathParam("id") String issueId, ActionTO actionTO) {
            Issue issue = issueRepository.findOne(issueId);
            
            Action action = actionConverter.convertTargetToSource(actionTO);
            
            System.out.println("******************************************************");
            System.out.println("issue:"+issue+"|");
            System.out.println("issue.getid:"+issue.getId()+"|");
            System.out.println("issueId"+issueId+"|");
            
            action.setIssueId(issue.getId());
            
            Action actionSaved = actionRepository.save(action);
		
            issue.getActions().add(actionSaved);
            
            issueRepository.save(issue);
                
		return Response.ok(actionConverter.convertSourceToTarget(actionSaved)).status(201).build();
	}
        
}
