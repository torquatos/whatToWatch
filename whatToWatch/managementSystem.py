from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import flask_sqlalchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqkite:///mediaToWatch.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False 

db = SQLAlchemy(app)

class mediaToWatch(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    nameOfMedia = db.Column(db.String(100), nullable = False)
    typeOfMedia = db.Column(db.String(100), nullable = False)
    genre = db.Column(db.String(100), nullable = True)
    year = db.Column(db.Integer(4), nullable = True)
    seasons = db.Column(db.Integer(2), nullable = True)
    concluded = db.Column(db.Boolean(False), nullable = False)
    whereToWatch = db.Column(db.String(100), nullable = False)
    wasWatched = db.Column(db.Boolean(False), nullable = False)
    sinopse = db.Column(db.Text, nullable = True)

    def __repr__(self):
        return f'<mediaToWatch {self.nameOfMedia}>'

with app.app_context():
    db.create_all()
