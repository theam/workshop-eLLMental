<!-- omit in toc -->
# eLLMental Kotlin - Java workshop
<!-- omit in toc -->
## Description

This workshop will teach us how to quickly create an application, which is based on semantic search as the core, using 
the library of eLLMental kotlin.

<!-- omit in toc -->
## Table of Contents

- [Prerequisites](#prerequisites)
- [Quick Start Guide](#quick-start-guide)

## Prerequisites

1. Please download the project [workshop-eLLMental](https://github.com/theam/workshop-eLLMental.git). If you find that you do not have access to this repository, please feel free to ask us to add you!

   In order to download the project execute the following command: 
   > git clone https://github.com/theam/workshop-eLLMental.git

2. To ensure a smooth and productive development experience, we highly recommend using IntelliJ IDEA as your primary 
Integrated Development Environment (IDE) for working with this project. You can download it from [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=mac).
You can use the free trial version or introduce the key that it's in our 1password.

3. Ensure you have Java Development Kit (JDK) installed on your local machine. This is needed to run the Kotlin
   compiler. You can download the JDK from
   the [official Oracle website](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or install
   it with a package manager of your choice. 

3. Install Kotlin command line compiler. Refer to
   Kotlin's [official guide](https://kotlinlang.org/docs/command-line.html) for installation instructions on your
   Operating System. 

4. Have Gradle installed. You can find the necessary instructions to install Gradle from
   their [official installation guide](https://gradle.org/install/).

## Quick Start Guide

In this guide, you'll have your application based on a semantic search service up and running on your computer. 
To do this, we will need to have the eLLMental kotlin library and complete the template functions that we have provided to consume this library. 

Before starting to modify the code, it is important to configure the environmental variables. You can find the API keys 
in our [1password](https://start.1password.com/open/i?a=Z7M3NNFDB5FWNDINTDJPDR6MI4&v=gohapx2edta6xazhcluyply6ku&i=xzh3u7o5zfgkvecmccd6dsuu2q&h=theagilemonkeys.1password.com).

## Complete the functionalities

In order to use the functionalities provided by eLLMental, we will need to use the SemanticSearch library. Below are the functionalities that we need to create:

The `learn` function is responsible for processing and sending chunks into the vector database for learning purposes (creating embeddings). Before consume this function  you need use the appropriate function to divides the book into smaller chunks for processing it.

On the other hand, the `search` function allows you to perform embedding retrieval from the database. This function expects to recieve the user's question.

Furthermore, we will develop HTTP services with SpringBoot to interact with the backend. This allows you to seamlessly integrate eLLMental's robust semantic search and learning capabilities into your applications and leverage its advanced natural language processing functionalities.

## Ingest the documentation

Since eLLMental currently only receives processed embeddings, we need to process the documentation first. In this kata, we have provided a basic function that divides the book into smaller chunks to fit the context window of the embedding model. For simplicity, we adopt a straightforward 
approach in this example, dividing the text into chunks of 1000 characters each. However, it's important to note that **more sophisticated methods are available**, and **utilizing them can significantly enhance the performance of semantic search**.

Once the documentation is divided into chunks, we can employ the "learn" function of SemanticSearch to generate embeddings for each chunk. These embeddings represent the semantic meaning of the text and serve as the foundation for efficient searching and matching of queries.

After generating the embeddings, we store them locally in Chroma (or another solution like pinecone), a vector storage solution. This ensures that the processed documentation is readily accessible for future searches and analysis, eliminating the need to repeatedly process the original text.

Remember, while we used a simple approach to process the documentation in this example, more advanced methods can be applied to achieve even better results in real-world scenarios.

