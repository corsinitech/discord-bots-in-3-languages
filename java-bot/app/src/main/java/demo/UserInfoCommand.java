package demo;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class UserInfoCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        if(event.getMessageContent().equalsIgnoreCase("!user")){
            MessageAuthor author = event.getMessage().getAuthor();
            EmbedBuilder embed = new EmbedBuilder()
                .setTitle("User Roles")
                .addField("Display Name", author.getDisplayName(), true)
                .addField("Username", author.getDiscriminatedName(), true)
                .addField("Time Created", author.getCreationTimestamp().toString(), true)
                .setAuthor(author);

        event.getChannel().sendMessage(embed);
        }
    } 
}

