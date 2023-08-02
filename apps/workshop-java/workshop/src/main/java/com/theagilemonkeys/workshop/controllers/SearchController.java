package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.SemanticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public SearchController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @PostMapping("/search")
    @ResponseBody
    public void search(@RequestBody String query) {
        this.semanticSearchService.search(query);
    }
}
