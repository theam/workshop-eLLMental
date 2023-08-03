package com.theagilemonkeys.workshop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "semanticsearch")
public class SemanticSearchConfiguration {
    private String openaiKey;
    private String pineconeKey;
    private String pineconeUrl;

    public String getOpenaiKey() {
        return openaiKey;
    }

    public void setOpenaiKey(String openaiKey) {
        this.openaiKey = openaiKey;
    }

    public String getPineconeKey() {
        return pineconeKey;
    }

    public void setPineconeKey(String pineconeKey) {
        this.pineconeKey = pineconeKey;
    }

    public String getPineconeUrl() {
        return pineconeUrl;
    }

    public void setPineconeUrl(String pineconeUrl) {
        this.pineconeUrl = pineconeUrl;
    }
}
