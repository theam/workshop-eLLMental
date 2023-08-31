package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.workshop.services.EmbeddingsSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class SearchController {
    private final EmbeddingsSpaceService embeddingsSpaceService;

    @Autowired
    public SearchController(EmbeddingsSpaceService embeddingsSpaceService) {
        this.embeddingsSpaceService = embeddingsSpaceService;
    }

    @GetMapping("/search")
    @ResponseBody
    public CompletableFuture<List<String>> search(@RequestParam String query, @RequestParam(defaultValue = "10") int itemsLimit) {
        System.out.println("Searching for: " + query);
        // TODO: implement the search functionality using the SemanticSearchService
        throw new UnsupportedOperationException("TODO");
    }
}
