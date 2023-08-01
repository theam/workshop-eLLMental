<!-- omit in toc -->
# eLLMental workshop
<!-- omit in toc -->
## Description

This workshop will teach us how to quickly create an application, which is based on semantic search as the core, using eLLMental.

<!-- omit in toc -->
## Table of Contents

- [Prerequisites](#prerequisites)
- [Quick Start Guide](#quick-start-guide)
  - [Using eLLMental default configuration](#using-ellmental-default-configuration)
  - [Using eLLMental custom configuration](#using-ellmental-custom-configuration)
- [Custom application](#custom-application)
- [Multilingual embeddings](#multilingual-embeddings)

## Prerequisites

- [eLLMental.py](https://github.com/theam/ellmental.py)
- [Python Poetry](https://python-poetry.org)

## Quick Start Guide

In this guide, you'll have your application based on a semantic search service up and running on your computer. To do this, we will need to have the eLLMental library and create our services to consume this library:

To begin working locally with **eLLMental**, you'll need to clone the repository: 

> git clone https://github.com/theam/ellmental.py

After that, we can follow the quick start guide to use the default configuration or create our own configuration. 

### Using eLLMental default configuration

To begin working locally with **eLLMental**, you'll need to first run the `quickstart.sh` script, which underneath calls
a local Docker instance. Said that here's a summary of the steps you'll need to follow:

1. Make sure [Docker](https://www.docker.com/) is installed on your system.
2. Clone the repository: `git clone https://github.com/theam/ellmental.py`
3. Navigate to the semantic search directory: `cd apps/semantic_search`

In this directory, you'll find the `quickstart.sh` script that will help you set up a semantic search service in no time, by
just running: `./quickstart.sh`

> This script will ask you for your OPENAI API key, and then it will start the service using
> docker.

### Using eLLMental custom configuration

To utilize a custom configuration, the initial step is to prepare the .env file. Regarding the application configuration, various options are available to us, including:
```
# Server configuration

SERVER_PORT= # Port to run the server. E.g: 8000

####################################################################################################

# Embedding generation configuration

EMBEDDING_GENERATOR= # Can be OPENAI | SPACES_TEXT | SPACES_INSTRUCT
BATCH_SIZE= # Number of embeddings to generate in each batch

################################################

# OpenAI provider (ONLY IF EMBEDDING_GENERATOR is OPENAI).

OPENAI_TYPE= # Can be azure | openai
OPENAI_API_KEY= # Your OpenAI API key
OPENAI_MODEL=  # Your OpenAI model. See: https://platform.openai.com/docs/guides/embeddings

# Azure OpenAI provider (ONLY IF OPENAI_TYPE is AZURE). See: https://learn.microsoft.com/en-us/azure/cognitive-services/openai/how-to/switching-endpoints

AZURE_OPENAI_ENDPOINT= # E.g: https://example-endpoint.openai.azure.com
AZURE_OPENAI_VERSION= # E.g: SERVER_PORT=
AZURE_OPENAI_USE_ACTIVE_DIRECTORY= # True if you want to use a token provided by Azure Active Directory

################################################

# Hugging Face Spaces provider (ONLY IF EMBEDDING_GENERATOR is SPACES_TEXT or SPACES_INSTRUCT)

SPACES_KEY= # Your Hugging Face Spaces API key
SPACES_URL= # Your Hugging Face Space URL

####################################################################################################

# Embedding store configuration

EMBEDDING_STORE= # Can be LOCAL | CHROMA | SUPABASE
MATCH_THRESHOLD= # Threshold to consider two embeddings as a match. Value from 0 to 1

################################################

## Local provider (ONLY IF EMBEDDING_STORE is LOCAL)

STORE_PATH= # Path to create the database file for the embeddings store. Can be any path you have permissions.

################################################

## ChromaDB provider (ONLY IF EMBEDDING_STORE is CHROMA)

CHROMA_URL= # URL to your Chroma server.
CHROMA_PORT= # Port to your Chroma server.
CHROMA_COLLECTION= # Collection name to store the embeddings.

################################################

## Supabase provider (ONLY IF EMBEDDING_STORE is SUPABASE)

SUPABASE_URL= # Your Supabase database URL
SUPABASE_KEY= # Your Supabase API key
SUPABASE_TABLE= # The database table used to save the embeddings.
SUPABASE_FUNCTION= # The database function used to query the embeddings.
```

After the configuration is done, we can execute the application using poetry:

1. Make sure [Poetry](https://python-poetry.org/docs/) is installed on your system.
2. Open a terminal and navigate to the project directory.
3. Run the following command to install the project dependencies: `poetry install`
4. To start the project, run the following command: `poetry run start`
## Custom application

Once we have confirmed using Postman that the eLLMental services are available (learning and searching), we can proceed to create our application. In this case, we have used Python + Poetry. To create the custom application, follow these subsequent steps:

1. Create a new repository. 
2. Initialize the repository using Poetry.
3. Create HTTP services to consume the eLLMental application.
4. As eLLMental currently only receives the processed embedding, we will need to parse the documentation. In this case, we will use the pragmatic programmer book.
5. Once we have processed the book in chunks, we can use the learn functionality to create embeddings and store them locally in Chroma.
6. To ask a question about the content, we will have to use the search function.
7. With the last step, the application is finished.

These steps can be found in detail in the semantic search folder.

## Multilingual embeddings

One of the options that the eLLMental configuration offers is to use custom embedding models, enabling the use of multi-language embedding models. With this model, we can make questions in any language and consume content in any other language. In general, we have deploy this custom models using huggingface spaces.

The model used in our experiments is: [multilingual-e5-large](https://huggingface.co/intfloat/multilingual-e5-large)