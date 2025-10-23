package kal.com;


import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class MsgProducer {

    @Channel("words-out")
    Emitter<String>emitter;

    public void send(String word){
        emitter.send(word);
        System.out.println("📤 Sent: " + word);

    }
}
