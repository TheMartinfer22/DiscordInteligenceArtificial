package tech.martindev.discordia.events;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.jetbrains.annotations.NotNull;
import tech.martindev.discordia.conditions.ImageContainsExactWord;

public class ChannelImageDetector extends ListenerAdapter {
    @SneakyThrows
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("data");
            tesseract.setLanguage("por");


            ImageContainsExactWord word = new ImageContainsExactWord();
            String result = tesseract.doOCR(event
                    .getMessage()
                    .getAttachments()
                    .get(0)
                    .downloadToFile()
                    .get());

            // Simple Words
            word.isHelloWorld(result, event.getChannel());
            word.isDiscord(result, event.getChannel());;

        } catch (IndexOutOfBoundsException ignored){}
    }
}
