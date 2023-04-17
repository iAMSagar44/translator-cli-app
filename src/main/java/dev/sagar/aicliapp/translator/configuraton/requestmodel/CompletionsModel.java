package dev.sagar.aicliapp.translator.configuraton.requestmodel;

public record CompletionsModel(String model, String prompt,
                               float temperature, int max_tokens, int top_p) {

}
