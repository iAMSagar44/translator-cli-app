package dev.sagar.aicliapp.translator.app;

import dev.sagar.aicliapp.translator.configuraton.OpenAIClient;
import dev.sagar.aicliapp.translator.configuraton.requestmodel.CompletionsModel;
import dev.sagar.aicliapp.translator.configuraton.responsemodel.GPTResponseChoice;
import dev.sagar.aicliapp.translator.configuraton.responsemodel.TranslatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TextTranslatorApp {
    private final OpenAIClient openAIClient;
    @Autowired
    public TextTranslatorApp(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    @ShellMethod(key = "translate", value = "translate text to German")
    public String translatedResponse(){
        TranslatorResponse translated = openAIClient.translate(new CompletionsModel("text-davinci-003", "Translate this to German: What do you do during your freetime?",
                0.3f, 100, 1));
        GPTResponseChoice gptResponseChoice = translated.choices().stream().findFirst().orElse(new GPTResponseChoice("Not able to translate", 0L, 0, "stop"));
        return gptResponseChoice.text();
    }
}
