package dev.sagar.aicliapp.translator.configuraton;

import dev.sagar.aicliapp.translator.configuraton.requestmodel.CompletionsModel;
import dev.sagar.aicliapp.translator.configuraton.responsemodel.TranslatorResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface OpenAIClient {
    @PostExchange("/v1/completions")
    TranslatorResponse translate(@RequestBody CompletionsModel completionsModel);

}
