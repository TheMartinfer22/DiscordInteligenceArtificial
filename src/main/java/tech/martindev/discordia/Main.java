package tech.martindev.discordia;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import tech.martindev.discordia.events.ChannelImageDetector;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault("");
        builder.setActivity(Activity.listening("Lendo imagens"));
        builder.build().addEventListener(new ChannelImageDetector());
    }
}
