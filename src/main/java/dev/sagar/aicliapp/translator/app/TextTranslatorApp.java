package dev.sagar.aicliapp.translator.app;

import dev.sagar.aicliapp.translator.configuraton.OpenAIClient;
import dev.sagar.aicliapp.translator.configuraton.requestmodel.CompletionsModel;
import dev.sagar.aicliapp.translator.configuraton.responsemodel.GPTResponseChoice;
import dev.sagar.aicliapp.translator.configuraton.responsemodel.TranslatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class TextTranslatorApp {
    private final OpenAIClient openAIClient;
    @Autowired
    public TextTranslatorApp(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    @ShellMethod(key = "german", value = "translate text to German")
    public String translateToGerman(@ShellOption(value = {"text"}) String text){
        return gptResponse("German", text).text();
    }

    @ShellMethod(key = "french", value = "translate text to French")
    public String translateToFrench(@ShellOption(value = {"text"}) String text){
        return gptResponse("French", text).text();
    }

    @ShellMethod(key = "english", value = "translate text to English")
    public String translateToEnglish(@ShellOption(value = {"text"}) String text){
        return gptResponse("English", text).text();
    }

    private GPTResponseChoice gptResponse(String language, String text){
        TranslatorResponse translated = openAIClient.translate(new CompletionsModel("text-davinci-003",
                "Translate this to" + language + text,
                0.3f, 100, 1));
        return translated.choices().stream().findFirst()
                .orElse(new GPTResponseChoice("Not able to translate", 0L, 0, "stop"));
    }
}
