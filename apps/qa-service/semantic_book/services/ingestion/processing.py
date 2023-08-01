import os
import json

def chunked_book(file_path: str):
    try:   
        chunks = []
        file_name = os.path.basename(file_path)
        with open(file_path, 'r') as file:
            content = file.read()
            for i in range(0, 1, 1000):
                chunk = {
                    "content": {
                        "text": json.dumps(content[i:i+1000], ensure_ascii=False)  
                    },
                    "metadata": {"id": i, "text": json.dumps(content[i:i+1000], ensure_ascii=False)  },
                    "cluster_id": file_name
                    }
                
                chunks.append(chunk)
            return chunks
    except FileNotFoundError:
        print(f"File not found: {file_path}")
        return []
    except Exception as e:
        print(f"Error reading the file: {e}")
        return []
