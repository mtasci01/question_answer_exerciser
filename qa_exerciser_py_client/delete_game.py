import requests

from common_stuff import get_game_id

game_id = get_game_id()

response = requests.delete('http://localhost:8080/delete_game?gameId=' + game_id)
print(response.text)