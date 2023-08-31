package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.workshop.services.SemanticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class SearchController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public SearchController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @GetMapping("/search")
    @ResponseBody
    public CompletableFuture<SearchOutput> search(@RequestParam String query, @RequestParam(defaultValue = "10") int itemsLimit) {
        // TODO: implement the search functionality using the SemanticSearchService
        throw new UnsupportedOperationException("TODO");
    }
}
