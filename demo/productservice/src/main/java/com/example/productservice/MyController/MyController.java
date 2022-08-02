package com.example.productservice.MyController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;

@RestController
public class MyController {
@CircuitBreaker(name = "inventory",fallbackMethod = "fallback")
@Retry(name = "inventory")
@TimeLimiter(name = "inventory")

    @GetMapping("/api/product")
    public CompletableFuture<String> rest(){
        return CompletableFuture.supplyAsync(()->slowbehavior());
    }
  public CompletableFuture<String> fallback(RuntimeException runtimeException){
    return CompletableFuture.supplyAsync(() -> "Failed");
  }
    @SneakyThrows
    public String slowbehavior(){

    return "sff";
  }
}
