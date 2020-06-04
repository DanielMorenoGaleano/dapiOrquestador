package com.avianca.pagos.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.avianca.pagos.rest.dto.RequestDTO;
import com.avianca.pagos.rest.dto.RequestRecordDTO;
import com.avianca.pagos.rest.dto.RequestRemarksDTO;

/**
 * 
 * @author Assert Solutions S.A.S <info@assertsolutions.com>
 *         <br/>
 *         Date: 9/04/2018 7:02:19 a.m.
 *
 */
@Path("/")
public interface RestService {

    @POST
//    @Path("/usernotifications")
    @Consumes(value = { MediaType.APPLICATION_JSON })
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response getMethod(RequestDTO request);
    

    @POST
    @Path("/remarks")
    @Consumes(value = { MediaType.APPLICATION_JSON })
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response getMethod(RequestRemarksDTO request);
    
    @POST
    @Path("/records")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getMethod(RequestRecordDTO request);
}
