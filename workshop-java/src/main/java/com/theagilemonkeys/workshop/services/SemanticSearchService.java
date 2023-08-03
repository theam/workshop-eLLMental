package com.theagilemonkeys.workshop.services;

import com.aallam.openai.client.*;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import kotlin.Unit;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClientKt.OpenAIClient;

@Service
public class SemanticSearchService {
    private final SemanticSearch semanticSearch;

    public SemanticSearchService(SemanticSearchConfiguration semanticSearchConfiguration) {
        String openAIKey = semanticSearchConfiguration.getOpenaiKey();
        String pineconeKey = semanticSearchConfiguration.getPineconeKey();
        String pineconeUrl = semanticSearchConfiguration.getPineconeUrl();

        OpenAI openAI = //TODO: Build an OpenAI client;
        OpenAIEmbeddingsModel openAIEmbeddingsModel = //TODO: Create OpenAIEmbeddingsModel;

        PineconeVectorStore pineconeVectorStore = //TODO: Create ChromaVectorStore or PineconeVectorStore;

        semanticSearch = //TODO: Create SemanticSearch;
    }

    public CompletableFuture<Unit> learn(String file_path) {
        //TODO: Implement method
    }

    public CompletableFuture<SearchOutput> search(String text) {
        //TODO: Implement method
    }
}