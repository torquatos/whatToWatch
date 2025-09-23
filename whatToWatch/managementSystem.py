from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import flask_sqlalchemy

app = Flask(__name__)