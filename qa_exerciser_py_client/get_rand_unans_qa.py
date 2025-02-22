import requests
import json

from common_stuff import get_game_id

response = requests.get('http://localhost:8080/get_rand_unans_qa?gameId=' +get_game_id())

respJ = json.loads(response.text)

print(respJ)