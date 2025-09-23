from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import flask_sqlalchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqkite:///mediaToWatch.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False 

db = SQLAlchemy(app)