This workshop will teach us how to quickly create an application, which is based on semantic search as the core, using eLLMental.

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Quick Start Guide](#quick-start-guide)
- [Multilingual embeddings](#multilingual-embeddings)

## Quick Start Guide

In this guide, you'll have your own application based on a semantic search service. To do this, we will need to have the eLLMental library and create our services to consume this library:

To begin working locally with **eLLMental**, you'll need to clone the repository: `git clone https://github.com/theam/ellmental.py` and follow the quick start guide to use the default configuration or create our own configuration.

- Quick start guide: run the `quickstart.sh` script
- Create personal configuration: *WIP*

### Custom application
Once we have checked with postman that the eLLMental service for learn and search is working. We can start creating our application, in this case, we have chosen to use Python + Poetry. We will follow the next steps:

1. Create a new repository
2. Initialize the repository using poetry
3. Create HTTP services to consume the eLLMental application
4. As currently eLLMental only recieve the processed embedding. We will need to parser the book
5. Once we have processed in chunks we can use the learn functionality to create embeddings and store them locally in chroma.
6. To ask a question about the content we will have to use the search function.
7. With the last step the application is finished. 

## Multilingual embeddings

WIP