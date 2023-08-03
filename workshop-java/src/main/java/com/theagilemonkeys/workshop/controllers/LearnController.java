package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.SemanticSearchService;
import kotlin.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

class LearnRequest {
    private String file_path;

    public String getFile_path() {
        return file_path;
    }

}

@RestController
public class LearnController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public LearnController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @PostMapping("/learn")
    @ResponseBody
    public CompletableFuture<Unit> learn(@RequestBody LearnRequest file_path) {
        // TODO: implement the search functionality using the SemanticSearchService
        throw new UnsupportedOperationException("TODO");
    }
}
