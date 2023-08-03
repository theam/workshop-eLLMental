package com.theagilemonkeys.workshop.controllers

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput
import com.theagilemonkeys.workshop.services.SemanticSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class SearchController(@Autowired private val semanticSearchService: SemanticSearchService) {
    @GetMapping("/search")
    suspend fun search(@RequestParam query: String, @RequestParam itemsLimit: Int = 10): SearchOutput {
        // TODO: implement the search functionality using the SemanticSearchService
        throw UnsupportedOperationException("Not implemented")
    }
}