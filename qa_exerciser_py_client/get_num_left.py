import requests

from common_stuff import get_game_id


response = requests.get('http://localhost:8080/get_num_left?gameId=' + get_game_id())

print(response.text)