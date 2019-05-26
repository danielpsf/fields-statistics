package com.danielpsf.labs.field.statistic.report.controller;

import com.danielpsf.labs.field.statistic.report.domain.StatisticResponse;
import com.danielpsf.labs.field.statistic.report.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/field-statistics")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public StatisticResponse getStatistic() {
        return service.generateStatisticReport();
    }
}
