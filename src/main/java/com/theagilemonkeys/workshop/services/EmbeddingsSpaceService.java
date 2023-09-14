package com.theagilemonkeys.workshop.services;

import com.theagilemonkeys.ellmental.core.schema.Embedding;
import com.theagilemonkeys.ellmental.embeddingsspace.EmbeddingsSpaceComponent;
import com.theagilemonkeys.workshop.config.EmbeddingsSpaceConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbeddingsSpaceService {
    private final EmbeddingsSpaceComponent embeddingsSpace;

    public EmbeddingsSpaceService(EmbeddingsSpaceConfiguration configuration) {
        // TODO: Add eLLMental SemanticSearch component
    }

    public Embedding save(String text) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }

    public List<Embedding> search(String text, int itemsLimit) {
        // TODO: Implement method
        throw new UnsupportedOperationException("TODO");
    }
}
