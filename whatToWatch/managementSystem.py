from flask import Flask, render_template, request, redirect, url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///mediaToWatch.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False 

db = SQLAlchemy(app)

class mediaToWatch(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    nameOfMedia = db.Column(db.String(100), nullable = False)
    typeOfMedia = db.Column(db.String(100), nullable = False)
    genre = db.Column(db.String(100), nullable = True)
    year = db.Column(db.Integer, nullable = True)
    seasons = db.Column(db.Integer, nullable = True)
    concluded = db.Column(db.Boolean(False), nullable = False)
    whereToWatch = db.Column(db.String(100), nullable = False)
    wasWatched = db.Column(db.Boolean(False), nullable = False)
    sinopse = db.Column(db.Text, nullable = True)

    def __repr__(self):
        return f'<mediaToWatch {self.nameOfMedia}>'

with app.app_context():
    db.create_all()

@app.route('/', methods=['GET', 'POST'])

def index():
    if request.method == 'POST':
        nameOfMedia = request.form[nameOfMedia]
        typeOfMedia = request.form[typeOfMedia]
        genre =request.form[genre]
        year = request.form[year]
        seasons = request.form[seasons]
        concluded = request.form[concluded]
        whereToWatch =request.form[whereToWatch]
        wasWatched = request.form[wasWatched]
        sinopse = request.form[sinopse]

        new_media = mediaToWatch(nameOfMedia=nameOfMedia, typeOfMedia=typeOfMedia, genre=genre, year=year, seasons=seasons, concluded=concluded, whereToWatch=whereToWatch, wasWatched=wasWatched, sinopse=sinopse)
        db.session.add(new_media)
        db.session.commit()
        return redirect(url_for('index'))

        medias = mediaToWatch.query.all()
        return render_template('index.html', medias=medias)

@app.route('/deleteItem/<int:id>')
def deleteItem(id):
    mediaDelete = mediaToWatch.query.get_or_404(id)
    db.session.delete(mediaDelete)
    db.session.commit()
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)