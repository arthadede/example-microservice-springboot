package com.arthadede.examplemicroservice.connector;

import com.arthadede.examplemicroservice.schema.GithubAccount;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

interface GithubService {
    @HttpExchange(url = "/user", method = "GET")
    GithubAccount getProfile();
}

@Component
public class GithubConnector {

    private static final String baseUrl = "https://api.github.com";
    private static final String authorization = "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";
    private final GithubService githubService;

    private void setDefaultHeaders(@NotNull HttpHeaders headers) {
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + authorization);
    }

    public GithubConnector() {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(this::setDefaultHeaders)
                .build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();

        githubService = httpServiceProxyFactory.createClient(GithubService.class);
    }

    public GithubAccount getProfile() {
        return this.githubService.getProfile();
    }
}
