import requests

from common_stuff import get_game_id


response = requests.put('http://localhost:8080/reset_qa_guessed?gameId=' + get_game_id())

print(response.text)