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
		Action action = actionRepository.save(actionConverter.convertTargetToSource(actionTO));
		
		return Response.ok(actionConverter.convertSourceToTarget(action)).status(201).build();
	}
        
}
