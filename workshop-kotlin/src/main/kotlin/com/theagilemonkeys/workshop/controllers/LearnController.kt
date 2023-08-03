package com.theagilemonkeys.workshop.controllers

import com.theagilemonkeys.ellmental.semanticsearch.SearchInput
import com.theagilemonkeys.workshop.services.SemanticSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller
class LearnController(@Autowired private val semanticSearchService: SemanticSearchService) {
    @PostMapping("/learn")
    suspend fun learn(@RequestBody input: SearchInput) {
        semanticSearchService.learn(input)
    }
}