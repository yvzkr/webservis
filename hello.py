from flask import Flask, render_template,request
from SOAPpy import WSDL
import zeep
app = Flask(__name__)
wsdl = 'http://localhost:8080/WebApplication1/NewWebService1?wsdl'
client = zeep.Client(wsdl=wsdl)
#http://127.0.0.1:5000/send
@app.route('/',methods=['GET','POST'])
def index():
    if request.method=='POST':
        if request.form.get('site')=="instagram":
            return render_template("goster.html",picUrl=client.service.GetInsPic(request.form['username']))
        else:
            return render_template("goster.html",picUrl=client.service.GetTwitPic(request.form['username']))
    return render_template("goster.html")

if __name__=="__main__":
    app.run()
