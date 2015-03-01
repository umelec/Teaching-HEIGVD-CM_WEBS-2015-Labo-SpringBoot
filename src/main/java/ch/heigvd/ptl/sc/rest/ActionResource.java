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
@Path("/actions")
public class ActionResource {

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
    public Response create(ActionTO actionTO) {
        Action action = actionRepository.save(actionConverter.convertTargetToSource(actionTO));

        return Response.ok(actionConverter.convertSourceToTarget(action)).status(201).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Action action = actionRepository.findOne(id);

        if (action == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        return Response.ok(actionConverter.convertSourceToTarget(action)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, ActionTO actionTO) {
        Action action = actionRepository.findOne(id);

        if (action == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        actionConverter.fillSourceFromTarget(action, actionTO);

        action = actionRepository.save(action);

        return Response.ok(actionConverter.convertSourceToTarget(action)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        actionRepository.delete(id);
        return Response.ok().status(204).build();
    }
}
