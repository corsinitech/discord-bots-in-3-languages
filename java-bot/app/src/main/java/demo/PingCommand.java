package demo;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingCommand implements MessageCreateListener{

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        if(event.getMessageContent().equalsIgnoreCase("!ping")){
            event.getChannel().sendMessage("Pong!");
        }
    }

}

