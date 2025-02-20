import requests
import json

filepath = "E:/temp/abc.txt"

game_id = "c8a371a9-9362-487b-8764-b2657dc8b2c4"
override = "true"


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