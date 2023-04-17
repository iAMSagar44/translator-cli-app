package dev.sagar.aicliapp.translator.configuraton.responsemodel;

import java.util.List;

public record TranslatorResponse (String id, String object, Long created,
                                  String model, List<GPTResponseChoice> choices, Usage usage){

}