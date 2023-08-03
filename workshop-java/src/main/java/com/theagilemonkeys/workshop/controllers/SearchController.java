package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.SemanticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;
@Controller
public class SearchController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public SearchController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @GetMapping("/search")
    @ResponseBody
    public CompletableFuture<SearchOutput> search(@RequestParam String query) {
        // implement the search functionality using the semanticSearchService
    }
}
