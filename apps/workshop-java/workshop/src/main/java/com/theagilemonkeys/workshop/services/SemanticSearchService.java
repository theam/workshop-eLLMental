package com.theagilemonkeys.workshop.services;

import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClientKt.OpenAIClient;

import java.util.HashMap;
import java.util.List;

@Service
public class SemanticSearchService {
    private final SemanticSearch semanticSearch;

    public SemanticSearchService(SemanticSearchConfiguration semanticSearchConfiguration) {
        String openAIKey = semanticSearchConfiguration.getOpenaiKey();
        String pineconeKey = semanticSearchConfiguration.getPineconeKey();
        String pineconeUrl = semanticSearchConfiguration.getPineconeUrl();

        OpenAIEmbeddingsModel openAIEmbeddingsModel = new OpenAIEmbeddingsModel(OpenAIClient(openAIKey));
        PineconeVectorStore pineconeVectorStore = new PineconeVectorStore(pineconeKey, pineconeUrl);

        this.semanticSearch = new SemanticSearch(openAIEmbeddingsModel, pineconeVectorStore);
    }

    public void learn(String file_path) {
        BookIngestionService bookIngestionService = new BookIngestionService(file_path);
        SearchInput input = new SearchInput(bookIngestionService.ProcessBookByCharacters());
        this.semanticSearch.learn(input);
    }

    public SearchOutput search(String text) {
        return this.semanticSearch.search(text);
    }
}
