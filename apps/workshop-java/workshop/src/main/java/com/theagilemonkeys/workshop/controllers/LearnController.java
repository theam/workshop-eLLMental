package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.SemanticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LearnController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public LearnController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @PostMapping("/learn")
    @ResponseBody
    public void learn(@RequestBody String file_path) {
        this.semanticSearchService.learn(file_path);
    }
}
