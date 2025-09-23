from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import flask_sqlalchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqkite:///mediaToWatch.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False 

db = SQLAlchemy(app)

class mediaToWatch(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    nameOfMedia = db.Column(db.String(100), nullable = False)
    typeOfMedia = db.Column
    genre = db.Column
    year = db.Column
    seasons = db.Column
    concluded = db.Column
    whereToWatch = db.Column
    wasWatched = db.Column
    sinopse = db.Column
