package kal.com;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class MsgConsumer {

    @Incoming("words-in")
    public void receive(String message){
        System.out.println("📥 Received: " + message);
    }
}
