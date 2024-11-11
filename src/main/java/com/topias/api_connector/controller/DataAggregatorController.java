package com.topias.api_connector.controller;

import com.topias.api_connector.model.AggregatedData;
import com.topias.api_connector.service.AggregatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAggregatorController {

    private final AggregatorService aggregatorService;

    public DataAggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/aggregated")
    public AggregatedData aggregated(@RequestParam String city) {
        return aggregatorService.getData(city);
    }

}
