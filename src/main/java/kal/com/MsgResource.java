package kal.com;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/messages")
public class MsgResource {

    @Inject
    MsgProducer producer;


    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response sendMessage(String message){
        producer.send(message);
        return Response.ok("Message sent: "+ message).build();
    }
}
