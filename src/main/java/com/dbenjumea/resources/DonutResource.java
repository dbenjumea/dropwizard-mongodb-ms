package com.dbenjumea.resources;

import com.dbenjumea.api.Donut;
import com.dbenjumea.api.Response;
import com.dbenjumea.db.daos.DonutDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

// https://github.com/ricdev2/dropwizard-mongodb-ms/blob/b1279fcbc8d71eb97671dcf62895fc4936ac37f5/src/main/java/com/demo/
@Api(value = "donuts",
        description = "Donuts REST API for handle Donuts CRUD operations on donuts collection.",
        tags = {"donuts"})
@Path("/donuts")
@Produces(MediaType.APPLICATION_JSON)

public class DonutResource {
    /**
     * Logger class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DonutResource.class);

    /**
     * DAO donut.
     */
    private DonutDAO donutDAO;

    /**
     * Constructor.
     *
     * @param donutDAO the dao donut.
     */
    public DonutResource(final DonutDAO donutDAO) {
        this.donutDAO = donutDAO;
    }

    /**
     * Get all {@link Donut} objects.
     *
     * @return A object {@link Response} with the information of result this method.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation success."),
            @ApiResponse(code = 404, message = "Donuts not found")
    })
    @GET
    public javax.ws.rs.core.Response all() {
        LOGGER.info("List all Donuts.");
        final List<Donut> donutsFind = donutDAO.getAll();
        if (donutsFind.isEmpty()) {
            return javax.ws.rs.core.Response.accepted(new com.dbenjumea.api.Response("Donuts not found."))
                    .status(javax.ws.rs.core.Response.Status.NOT_FOUND)
                    .build();
        }
        return javax.ws.rs.core.Response.ok(donutsFind).build();
    }

    /**
     * Get a {@link Donut} by identifier.
     *
     * @param id the identifier.
     * @return A object {@link Response} with the information of result this method.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation success."),
            @ApiResponse(code = 404, message = "Donuts not found")
    })
    @GET
    @Path("/{id}")
    public javax.ws.rs.core.Response getOne(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id) {
        LOGGER.info("Find the donut by identifier : " + id.toString());
        final Donut donut = donutDAO.getOne(id);
        if (donut != null) {
            return javax.ws.rs.core.Response.ok(donut).build();
        }
        return javax.ws.rs.core.Response.accepted(new com.dbenjumea.api.Response("Donut not found.")).build();
    }

    /**
     * Persis a {@link Donut} object in a collection.
     *
     * @param donut The objecto to persist.
     * @return A object {@link Response} with the information of result this method.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation success.")
    })
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response save(@ApiParam(value = "Donut") @NotNull final Donut donut) {
        LOGGER.info("Persist a donut in collection with the information: {}", donut);
        donutDAO.save(donut);
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.CREATED).build();
    }

    /**
     * Update the information of a {@link Donut}.
     *
     * @param id    The identifier.
     * @param donut the donut information.
     * @return A object {@link Response} with the information of result this method.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation success.")
    })
    @PUT
    @Path("/{id}")
    public javax.ws.rs.core.Response update(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id,
                           @ApiParam(value = "Donut") @NotNull final Donut donut) {
        LOGGER.info("Update the information of a donut : {} ", donut);
        donutDAO.update(id, donut);
        return javax.ws.rs.core.Response.ok().build();
    }

    /**
     * Delete a {@link Donut} object.
     * @param id   the identifier.
     * @return  A object {@link Response} with the information of result this method.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation success.")
    })
    @DELETE
    @Path("/{id}")
    public javax.ws.rs.core.Response delete(@ApiParam(value = "id") @PathParam("id") @NotNull final ObjectId id) {
        LOGGER.info("Delete a donut from collection with identifier: " + id.toString());
        donutDAO.delete(id);
        return javax.ws.rs.core.Response.ok().build();
    }
}
