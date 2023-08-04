package com.theagilemonkeys.workshop.services;

import com.aallam.openai.client.OpenAI;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClientKt;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.LearnInput;
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration;
import kotlin.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SemanticSearchService {
    private SemanticSearch semanticSearch;

    public SemanticSearchService(SemanticSearchConfiguration semanticSearchConfiguration) {
        OpenAI openAI = OpenAIClientKt.OpenAIClient(semanticSearchConfiguration.getOpenaiKey());
        semanticSearch = new SemanticSearch(
                new OpenAIEmbeddingsModel(openAI),
                new PineconeVectorStore(
                        semanticSearchConfiguration.getPineconeKey(),
                        semanticSearchConfiguration.getPineconeUrl(),
                        semanticSearchConfiguration.getPineconeNamespace()
                )
        );

    }

    public CompletableFuture<Unit> learn(List<String> chunks) {
        return semanticSearch.learn(new LearnInput(chunks));
    }

    public CompletableFuture<SearchOutput> search(String text, int itemsLimit) {
        return semanticSearch.search(text, itemsLimit);
    }
}
