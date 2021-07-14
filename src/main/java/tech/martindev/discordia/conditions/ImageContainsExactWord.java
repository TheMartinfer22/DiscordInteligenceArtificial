package tech.martindev.discordia.conditions;

import net.dv8tion.jda.api.entities.MessageChannel;

public class ImageContainsExactWord {
    private final String prefix = "A mensagem contém a palavra ";

    public void isHelloWorld(String args, MessageChannel eventChat){
        if (args.contains("Hello World")) {
            eventChat.sendMessage(prefix + "Hello World").queue();
        }
    }

    public void isDiscord(String args, MessageChannel eventChat){
        if (args.contains("Discord")) {
            eventChat.sendMessage(prefix + "Discord").queue();
        }
    }
}
