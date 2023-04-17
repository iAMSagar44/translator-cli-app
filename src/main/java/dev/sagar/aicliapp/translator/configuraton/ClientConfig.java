package dev.sagar.aicliapp.translator.configuraton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Value("${OPENAI_API_KEY}")
    private String client_key;

    @Bean
    OpenAIClient openAIClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.openai.com")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + client_key)
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(OpenAIClient.class);
    }
}
