import requests
from common_stuff import get_game_id

filepath = "E:/temp/abc.txt"



game_id = get_game_id()
override = "true"

#file has alternating lines for questions and answers
f = open(filepath, "r", encoding="utf-8")

data = f.read() 
all_lines = data.split("\n") 

qa_pais_l = []

for i in range(0,len(all_lines) - 2,2):
    qa_pais_l.append({
        "question":all_lines[i].strip(),
        "answer":all_lines[i+1].strip()
    })




response = requests.post('http://localhost:8080/upload_qas?gameId=' + game_id + "&override=" + override, json=qa_pais_l)

print(response.text)