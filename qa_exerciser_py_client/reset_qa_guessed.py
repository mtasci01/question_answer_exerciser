import requests


response = requests.put('http://localhost:8080/update_qapair_guessed?id=00461de0-5dca-4a6e-83a5-12cd89b24d73&guessed=true', json={})

print(response.text)