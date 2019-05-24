package com.danielpsf.labs.field.statistic.controller;

import com.danielpsf.labs.field.statistic.domain.request.StatisticRequest;
import com.danielpsf.labs.field.statistic.domain.response.StatisticResponse;
import com.danielpsf.labs.field.statistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/field-statistics")
public class StatisticController {

    private final StatisticService service;

    public StatisticController(StatisticService service) {
        this.service = service;
    }

    @GetMapping
    public StatisticResponse getStatistic() {
        return service.fetchStatistic();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postStatistic(@RequestBody StatisticRequest statisticRequest) {
        service.persistStatistic(statisticRequest);
    }
}
