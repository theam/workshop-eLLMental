package com.theagilemonkeys.workshop.services

import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClient
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.LearnInput
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration
import org.springframework.stereotype.Service


@Service
class SemanticSearchService(private val semanticSearchConfiguration: SemanticSearchConfiguration) {
    private val semanticSearch: SemanticSearch =
        with(OpenAIClient(semanticSearchConfiguration.openaiKey)) {
            with(OpenAIEmbeddingsModel()) {
                with(
                    PineconeVectorStore(
                        semanticSearchConfiguration.pineconeKey,
                        semanticSearchConfiguration.pineconeUrl,
                        semanticSearchConfiguration.pineconeNamespace
                    )
                ) {
                    SemanticSearch()
                }
            }
        }

    suspend fun learn(input: LearnInput) = semanticSearch.learn(input)

    suspend fun search(text: String, itemsLimit: Int): SearchOutput = semanticSearch.search(text, itemsLimit)
}