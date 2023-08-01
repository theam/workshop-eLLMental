# Semantic book application

Semantic book is a project that will allow us to obtain knowledge of a book (learn function), in order to be able to ask questions about it (search function).

## Initial steps

In this guide, you'll setup the basis for create the semantic book application. The whole process takes less than 5 minutes! 🌈

- Create a new repository.
- Initialize the repository using [poetry](https://python-poetry.org/docs/basic-usage/). Execute: `poetry new semantic_book`
- Define the **pyproject.toml** file. This will orchestrate your project and its dependencies. Check the [example](https://github.com/theam/workshop-eLLMental/blob/main/apps/qa-service/pyproject.toml) to learn how to set it up
- Define a **build.py** file. This file will allow us to execute the project. Check the [example](https://github.com/theam/workshop-eLLMental/blob/main/apps/qa-service/build.py) to learn how to configure it.
- In the following folder: `workshop-eLLMental/apps/qa-service/semantic_book`, create a `__main__.py` file

After we have configure the basis of the project, we can execute the project:

1. Run the following command to install the project dependencies: `poetry install`
2. To start the project, run the following command: `poetry run start`

## Create HTTP services

In order to use the services provided by eLLMental, we need to create HTTP services that enable communication with the eLLMental backend. Below are the HTTP services that we need to create:

The `learn` service is responsible for processing and sending chunks into eLLMental for learning purposes (creating embeddings). Here's an example implementation:

```python
@app.post("/learn")
async def learn(request: _Input_learn):
    # Split the book into chunks for processing
    book_chunks = chunked_book(request.file_path)
    
    # Prepare data for learning
    learn_data = {'items': book_chunks}
    
    # Send a POST request to the eLLMental backend for learning
    learn_response = requests.post('http://localhost:8000/learn', data=json.dumps(learn_data), headers={'Content-Type': 'application/json'})
    
    # Return the response from the eLLMental backend
    return learn_response.text
```

In this service, you need to replace `chunked_book` with the appropriate function that divides the book into smaller chunks for processing. After chunking the book, you send a POST request to the eLLMental backend to perform the learning process.

On the other hand, the `search` service allows you to perform embedding retrievl from the database. Here's an example implementation:

```python
@app.post("/search")
async def search(request: _Input_search):
    # Prepare data for the search query
    search_data = {
        "query": {
            "text": request.user_question,
        },
        "cluster_ids": request.cluster_ids,
        "limit": request.limit
    }
    
    # Send a POST request to the eLLMental backend for semantic search
    search_response = requests.post('http://localhost:8000/search', data=json.dumps(search_data), headers={'Content-Type': 'application/json'})
    
    # Return the response from the eLLMental backend
    return search_response.text
```

In this service, you receive a user's question, cluster IDs (if applicable), and the result limit. Then we send a POST request to the eLLMental backend, which performs the semantic search based on the user's question and returns the search results.

Remember to replace `'http://localhost:8000'` with the actual URL of the eLLMental backend service.

By creating these HTTP services and interacting with the eLLMental backend, you can seamlessly integrate eLLMental's powerful semantic search and learning capabilities into your applications and take advantage of its advanced natural language processing functionalities.

## Process the documentation

Since eLLMental currently only receives processed embeddings, we will begin by parsing the documentation. In this case, we will use the pragmatic programmer book as our example. We will divide the book into smaller chuncks to fit in the context window. For simplicity, we will adopt a straightforward approach in this example, which involves dividing the text into chunks of 1000 characters each. However, it's important to note that there are more sophisticated methods available, and using those can significantly enhance the performance of semantic search.

Once the documentation has been divided into chunks, we can utilize the "learn" functionality of eLLMental to create embeddings for each chunk. These embeddings represent the semantic meaning of the text and form the basis for searching and matching queries efficiently.

After generating the embeddings, we will store them locally in Chroma, a local storage solution for eLLMental. This ensures that the processed documentation is readily available for future searches and analysis without the need to repeatedly process the original text.

By processing the documentation and generating embeddings, we can leverage eLLMental's capabilities for powerful semantic search and knowledge extraction. This not only enhances the overall user experience but also enables better understanding and utilization of the pragmatic programmer book's contents.

Remember, while we used a simple approach to process the documentation in this example, more advanced methods can be applied to achieve even better results in real-world scenarios.

## Consume the documentation

To ask a question about the content, we will have to use the search function.
