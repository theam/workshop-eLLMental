import json
from dataclasses import dataclass

import uvicorn
from dotenv import load_dotenv
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from marshmallow_dataclass import class_schema
from semantic_book.services.ingestion.processing import chunked_book

load_dotenv()

@dataclass(frozen=True)
class _Input_learn:
    file_path: str

@dataclass(frozen=True)
class _Input_search:
    user_question: str
    cluster_ids: list
    limit: int



def create_app() -> FastAPI:
    app = FastAPI()
    app.add_middleware(CORSMiddleware, allow_origins=["*"])

    @app.post("/learn")
    async def learn(request: _Input_learn):
        book_chuncks = chunked_book(request.file_path)
        learn_data = {'items': book_chuncks}
        learn_response = requests.post('http://localhost:8000/learn', data=json.dumps(learn_data), headers={'Content-Type': 'application/json'})
        return learn_response.text
    
    @app.post("/search")
    async def search(request: _Input_search):
        search_data = {
            "query": {
                "text": request.user_question,
            },
            "cluster_ids": request.cluster_ids,
            "limit": request.limit
        }
        search_response = requests.post('http://localhost:8000/search', data=json.dumps(search_data), headers={'Content-Type': 'application/json'})
        return search_response.text
    return app


app = create_app()
uvicorn.run("__main__:app", host="0.0.0.0", port=3090, reload=False)



