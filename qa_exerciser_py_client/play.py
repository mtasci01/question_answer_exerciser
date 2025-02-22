import json
import requests

from common_stuff import get_game_id


print('Play our question answer game!! Game id currently ' + get_game_id())


while True:

    response = requests.get('http://localhost:8080/get_num_left?gameId=' +get_game_id())
    num_left = int(response.text)
    if num_left == 0:
        response = requests.put('http://localhost:8080/reset_qa_guessed?gameId=' + get_game_id())
        print("All questions answered for game. Game resetted.")
    response = requests.get('http://localhost:8080/get_rand_unans_qa?gameId=' +get_game_id())
    respJ = json.loads(response.text)
    print("Question is -> " + respJ['question'])
    print("Do you know the answer? y/n/exit")
    user_input = input()
    if user_input.lower() == "exit":
        exit()
    elif user_input.lower() == "y":
        response = requests.put('http://localhost:8080/update_qapair_guessed?id=' + respJ['id'] + '&guessed=true', json={})
    elif user_input.lower() == 'n':
        response = requests.put('http://localhost:8080/update_qapair_guessed?id=' + get_game_id() + '&guessed=false', json={})    
    else:
        print("Unknown prompt, moving on")  
    print("Answer was -> " + respJ['answer'])      


