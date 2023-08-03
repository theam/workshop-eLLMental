package com.theagilemonkeys.workshop.services

import com.theagilemonkeys.ellmental.semanticsearch.LearnInput
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration
import org.springframework.stereotype.Service


@Service
class SemanticSearchService(private val semanticSearchConfiguration: SemanticSearchConfiguration) {
    private val semanticSearch: SemanticSearch = run {
        // TODO: Add eLLMental SemanticSearch component
    }

    suspend fun learn(input: LearnInput) {
        // TODO: Implement method
        throw UnsupportedOperationException("TODO");
    }

    suspend fun search(text: String, itemsLimit: Int): SearchOutput {
        // TODO: Implement method
        throw UnsupportedOperationException("TODO");
    }
}