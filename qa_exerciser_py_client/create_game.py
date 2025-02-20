import requests
import json

response = requests.post('http://localhost:8080/create_game', json={"description":"EN-ITA Exercise"})

respJ = json.loads(response.text)

print(respJ)