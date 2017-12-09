
import requests

URL = "http://localhost:8080/WebApplication3/webresources/restuni"

req = requests.get(URL, params={'par':'value'})
print(req.content)
#req = requests.post("http://musana.net", data={'kullanici':'musa', 'meslek':'talebe'})
r = requests.put(URL, data = 'Yavuz Kuru')
print(requests.get(URL, params={'par':'value'}).content)
