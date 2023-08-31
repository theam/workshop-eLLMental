package com.theagilemonkeys.workshop.services;

import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.workshop.config.EmbeddingsSpaceConfiguration;
import kotlin.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmbeddingsSpaceService {
    private EmbeddingsSpaceComponent embeddingsSpace;

    public EmbeddingsSpaceService(EmbeddingsSpaceConfiguration configuration) {
        // TODO: Add eLLMental SemanticSearch component
    }

    public CompletableFuture<Unit> save(String text) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }

    public CompletableFuture<List<Embedding>> search(String text, int itemsLimit) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }
}
