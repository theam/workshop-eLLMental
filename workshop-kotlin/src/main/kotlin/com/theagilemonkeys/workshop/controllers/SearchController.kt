package com.theagilemonkeys.workshop.controllers

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput
import com.theagilemonkeys.workshop.services.SemanticSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class SearchController(@Autowired private val semanticSearchService: SemanticSearchService) {
    @GetMapping("/search")
    suspend fun search(@RequestParam query: String): SearchOutput {
        return semanticSearchService.search(query)
    }
}