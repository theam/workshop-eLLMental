package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.ellmental.core.schema.Embedding;
import com.theagilemonkeys.workshop.services.EmbeddingsSpaceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private final EmbeddingsSpaceService embeddingsSpaceService;

    public SearchController(EmbeddingsSpaceService embeddingsSpaceService) {
        this.embeddingsSpaceService = embeddingsSpaceService;
    }

    @GetMapping("/search")
    @CrossOrigin
    @ResponseBody
    public List<Embedding> search(@RequestParam String query, @RequestParam(defaultValue = "10") int itemsLimit) {
        // TODO: implement the search functionality using the EmbeddingsSpaceService
        throw new UnsupportedOperationException("TODO");
    }
}
