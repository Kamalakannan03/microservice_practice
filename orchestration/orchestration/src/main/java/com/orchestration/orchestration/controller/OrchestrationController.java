package com.orchestration.orchestration.controller;

import com.orchestration.orchestration.service.OrchestrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrchestrationController {
    private final OrchestrationService orchestrationService;

    public OrchestrationController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @GetMapping("/getArtist/{id}")
    public Object getArtist(@PathVariable String id){
        return orchestrationService.getArtist(id);
    }
}
