package dev.sagar.aicliapp.translator.configuraton;

import dev.sagar.aicliapp.translator.configuraton.responsemodel.TranslatorResponse;
import org.springframework.web.service.annotation.PostExchange;

public interface OpenAIClient {
    @PostExchange("/v1/completions")
    TranslatorResponse translate();

}
