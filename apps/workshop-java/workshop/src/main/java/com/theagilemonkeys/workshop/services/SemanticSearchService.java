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

        OpenAI openAI = OpenAIClient(openAIKey);
        OpenAIEmbeddingsModel openAIEmbeddingsModel = new OpenAIEmbeddingsModel(openAI);

        PineconeVectorStore pineconeVectorStore = new PineconeVectorStore(pineconeKey, pineconeUrl);

        semanticSearch = new SemanticSearch(openAIEmbeddingsModel, pineconeVectorStore);
    }

    public CompletableFuture<Unit> learn(SearchInput input) {
        return semanticSearch.learn(input);
    }

    public CompletableFuture<SearchOutput> search(String text) {
        return semanticSearch.search(text);
    }
}
