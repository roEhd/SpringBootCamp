package com.example.demo.controller;

import com.example.demo.dto.Observation;
import com.example.demo.service.FredService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
@RequestMapping("/fred")
@RequiredArgsConstructor
@Slf4j
public class FredController {
    final FredService fredService;
    @GetMapping(path = "/usbond10y")
    public Flux<Observation> getUsBond10() {
        return fredService.getUsGovernmentBond10Y();
    }

    @GetMapping(path = "/usbond10y_stream", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Observation> getUsBond10YStream() {
        return  Flux.interval(Duration.ofMillis(1000)).zipWith(fredService.getUsGovernmentBond10Y()).map(t -> t.getT2());
    }
    @GetMapping(path="/interval", produces  = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Long> interval(){
        return Flux.interval(Duration.ofMillis(300));
    }

}
