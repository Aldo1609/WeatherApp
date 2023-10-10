package com.aldob.app.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/app")
public class ApiService {

    // This is the API URL that we will use to get the weather data
    // Esta es la URL de la API que usaremos para obtener los datos del clima
    private String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=56e7f444b9c3472bbb69667fd447c500";
    // This is the WebClient that we will use to get the data from the API
    // Este es el WebClient que usaremos para obtener los datos de la API
    private final WebClient webClient;

    // This is the constructor that will be used to create the WebClient
    // Este es el constructor que se usará para crear el WebClient
    @Autowired
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }

    // This is the method that will be used to get the weather data
    // Este es el método que se usará para obtener los datos del clima
    @GetMapping(value = "/weather")
    public Mono<String> getWeather(@RequestParam("city") String city) {
        this.apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=56e7f444b9c3472bbb69667fd447c500";

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class);
    }
}
