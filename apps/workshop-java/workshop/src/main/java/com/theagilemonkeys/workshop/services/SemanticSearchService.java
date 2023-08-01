package com.theagilemonkeys.workshop.services;

import com.aallam.openai.api.http.Timeout;
import com.aallam.openai.client.*;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import org.springframework.stereotype.Service;
import static com.aallam.openai.client.OpenAIKt.OpenAI;

import com.aallam.openai.api.http.Timeout;

import java.util.HashMap;

@Service
public class SemanticSearchService {
    private final SemanticSearch semanticSearch;

    public SemanticSearchService(SemanticSearchConfiguration semanticSearchConfiguration) {
        String openAIKey = semanticSearchConfiguration.getOpenaiKey();
        String pineconeKey = semanticSearchConfiguration.getPineconeKey();
        String pineconeUrl = semanticSearchConfiguration.getPineconeUrl();

        // TODO: Uses Kotlin duration, which is not compatible in Java
        OpenAI openAI = OpenAI(
                openAIKey,
                new LoggingConfig(),
                new Timeout(30, 30, 30),
                null,
                new HashMap<>(),
                OpenAIHost.Companion.getOpenAI(),
                null,
                new RetryStrategy(3, 2, 60)
        );

        OpenAIEmbeddingsModel openAIEmbeddingsModel = new OpenAIEmbeddingsModel(openAI);

        // TODO: Needs @JVMOverload to avoid adding default parameters
        PineconeVectorStore pineconeVectorStore = new PineconeVectorStore(pineconeKey, pineconeUrl, HttpHandl().);

        semanticSearch = new SemanticSearch(openAI, openAIEmbeddingsModel, pineconeVectorStore);
    }

    public void learn(SearchInput input) {
        semanticSearch.learn(input);
    }

    public SearchOutput search(String text) {
        return semanticSearch.search(text);
    }
}
