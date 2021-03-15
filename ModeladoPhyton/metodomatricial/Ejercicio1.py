import csv

with open('./dato/datos.csv', newline='') as f:
    reader = csv.reader(f)
    data = list(reader)

print(data)