package dev.sagar.aicliapp.translator.configuraton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {
    @Bean
    OpenAIClient openAIClient() {
        WebClient client = WebClient.builder()
        				.baseUrl("https://api.openai.com")
        				.defaultHeader("Accept","application/json")
        				.build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(OpenAIClient.class);
    }
}
