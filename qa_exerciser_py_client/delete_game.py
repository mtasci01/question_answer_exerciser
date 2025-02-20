import requests

game_id = "75a3ed56-acb1-4dd2-9737-3135850917f0"

response = requests.delete('http://localhost:8080/delete_game?gameId=' + game_id)
print(response.text)