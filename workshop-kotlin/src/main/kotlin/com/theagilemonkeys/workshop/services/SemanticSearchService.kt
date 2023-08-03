package com.theagilemonkeys.workshop.services

import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.LearnInput
import com.theagilemonkeys.ellmental.semanticsearch.SearchOutput
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.workshop.config.SemanticSearchConfiguration
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import org.springframework.stereotype.Service


@Service
class SemanticSearchService(private val semanticSearchConfiguration: SemanticSearchConfiguration) {
    private val semanticSearch: SemanticSearch = run {
        val openAIKey = semanticSearchConfiguration.openaiKey
        val pineconeKey = semanticSearchConfiguration.pineconeKey
        val pineconeUrl = semanticSearchConfiguration.pineconeUrl
        val pineconeNamespace = semanticSearchConfiguration.pineconeNamespace

        with(OpenAI(token = openAIKey)) {
            with(OpenAIEmbeddingsModel()) {
                with(PineconeVectorStore(apiKey = pineconeKey, url = pineconeUrl, namespace = pineconeNamespace)) {
                    SemanticSearch()
                }
            }
        }
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