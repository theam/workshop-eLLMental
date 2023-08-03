package com.theagilemonkeys.workshop.services;

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration;
import kotlin.Unit;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SemanticSearchService {
    private SemanticSearch semanticSearch;

    public SemanticSearchService(SemanticSearchConfiguration semanticSearchConfiguration) {
        // TODO: Add eLLMental SemanticSearch component
    }

    public CompletableFuture<Unit> learn(String file_path) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }

    public CompletableFuture<SearchOutput> search(String text) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }
}
