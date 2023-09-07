package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.EmbeddingsSpaceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {

    record SaveRequest(String text) {}

    private final EmbeddingsSpaceService embeddingsSpaceService;

    public SaveController(EmbeddingsSpaceService embeddingsSpaceService) {
        this.embeddingsSpaceService = embeddingsSpaceService;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public void learn(@RequestBody SaveRequest request) {
        System.out.println("Saving text: " + request.text());
        // TODO: implement the search functionality using the SemanticSearchService
        throw new UnsupportedOperationException("TODO");
    }
}
