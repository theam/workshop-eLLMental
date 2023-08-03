package com.theagilemonkeys.workshop.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "semanticsearch")
data class SemanticSearchConfiguration(
    var openaiKey: String = "",
    var pineconeKey: String = "",
    var pineconeUrl: String = "",
    var pineconeNamespace: String = ""
)

@Configuration
@EnableConfigurationProperties(SemanticSearchConfiguration::class)
class AppConfiguration {
    @Bean
    fun semanticSearchConfiguration(): SemanticSearchConfiguration {
        return SemanticSearchConfiguration()
    }
}
