package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.workshop.services.SemanticSearchService;
import kotlin.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CompletableFuture;

@Controller
public class LearnController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public LearnController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @PostMapping("/learn")
    @ResponseBody
    public CompletableFuture<Unit> learn(@RequestBody SearchInput input) {
        return semanticSearchService.learn(input);
    }
}
