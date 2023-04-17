package dev.sagar.aicliapp.translator.configuraton.responsemodel;

public record GPTResponseChoice(String text, Long index,
                                Integer logprobs, String finishReason) {
}
