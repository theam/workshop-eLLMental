import json
import uvicorn
import requests

from dotenv import load_dotenv
from typing import List, Optional, Union
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel, ValidationError, validator
from fastapi.middleware.cors import CORSMiddleware
# from answering.api import router as answer_router

load_dotenv()

class TextContent(BaseModel):
    text: str

class InstructionTextContent(BaseModel):
    text: str
    instruction: str

class RequestItem(BaseModel):
    content: Union[TextContent, InstructionTextContent]
    metadata: dict
    cluster_id: Optional[str]

class LearnRequest(BaseModel):
    items: List[RequestItem]

class SearchRequest(BaseModel):
    query: Union[TextContent, InstructionTextContent]
    cluster_ids: List[str]
    limit: int

class SearchResult(BaseModel):
    id: str
    metadata: dict
    score: float
    cluster_id: Optional[str]

class Response(BaseModel):
    ids: List[str]



def create_app() -> FastAPI:
    app = FastAPI()
    app.add_middleware(CORSMiddleware, allow_origins=["*"])
    # app.include_router(answer_router())

    @app.post("/search", response_model=List[SearchResult])
    async def search(search_request: SearchRequest):
        # TODO: Implement your business logic here
        return []

    @app.post("/learn", response_model=Response)
    async def learn(learn_request: LearnRequest):
        # TODO: Implement your business logic here
        return {"ids": []}
    return app


app = create_app()
# Example data aligning with TextContent, InstructionTextContent, LearnRequest, SearchRequest models
search_data = {
    "query": {
        "text": "example query",
    },
    "cluster_ids": ["123", "234", "345"],
    "limit": 10
}

learn_data = {
    "items": [{
        "content": {
            "text": "example text",
            "instruction": "example instruction"
        },
        "metadata": {"id": 0, "text": "Esto es la mayor prueba de las pruebas"},
        "cluster_id": "123"
    }]
}

# Perform POST requests
search_response = requests.post('http://localhost:8000/search', data=json.dumps(search_data), headers={'Content-Type': 'application/json'})
learn_response = requests.post('http://localhost:8000/learn', data=json.dumps(learn_data), headers={'Content-Type': 'application/json'})

# Print the response 
print(search_response.json())
print(learn_response.json())
uvicorn.run("__main__:app", host="0.0.0.0", port=3090, reload=False)



