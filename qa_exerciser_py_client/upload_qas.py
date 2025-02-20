import requests
import json

filepath = "E:/temp/abc.txt"

game_id = "75a3ed56-acb1-4dd2-9737-3135850917f0"


f = open(filepath, "r", encoding="utf-8")

data = f.read() 
all_lines = data.split("\n") 

qa_pais_l = []

for i in range(0,len(all_lines) - 2,2):
    qa_pais_l.append({
        "question":all_lines[i].strip(),
        "answer":all_lines[i+1].strip()
    })


response = requests.post('http://localhost:8080/upload_qas?gameId=' + game_id, json=qa_pais_l)

print(response.text)