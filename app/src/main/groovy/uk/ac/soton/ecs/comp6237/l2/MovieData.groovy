package uk.ac.soton.ecs.comp6237.l2;

public class MovieData {
	public static def SMALLDATA = ['Lisa': ['Lady in the Water': 2.5, 'Snakes on a Plane': 3.5,
			'Just My Luck': 3.0, 'Superman Returns': 3.5, 'You, Me and Dupree': 2.5,
			'The Night Listener': 3.0],
		'Gene': ['Lady in the Water': 3.0, 'Snakes on a Plane': 3.5,
			'Just My Luck': 1.5, 'Superman Returns': 5.0, 'The Night Listener': 3.0,
			'You, Me and Dupree': 3.5],
		'Michael': ['Lady in the Water': 2.5, 'Snakes on a Plane': 3.0,
			'Superman Returns': 3.5, 'The Night Listener': 4.0],
		'Claudia': ['Snakes on a Plane': 3.5, 'Just My Luck': 3.0,
			'The Night Listener': 4.5, 'Superman Returns': 4.0,
			'You, Me and Dupree': 2.5],
		'Mick': ['Lady in the Water': 3.0, 'Snakes on a Plane': 4.0,
			'Just My Luck': 2.0, 'Superman Returns': 3.0, 'The Night Listener': 3.0,
			'You, Me and Dupree': 2.0],
		'Jack': ['Lady in the Water': 3.0, 'Snakes on a Plane': 4.0,
			'The Night Listener': 3.0, 'Superman Returns': 5.0, 'You, Me and Dupree': 3.5],
		'Toby': ['Snakes on a Plane':4.5,'You, Me and Dupree':1.0,'Superman Returns':4.0]]

	public static def SMALLDATA_SHORTNAMES = [
		'Lady in the Water': 'Lady',
		'Snakes on a Plane': 'Snakes',
		'Just My Luck': 'Luck',
		'Superman Returns': 'Superman',
		'You, Me and Dupree': 'Dupree',
		'The Night Listener': 'Night']

	public static def loadMovieLens100K() {
		def movies = [:]

		MovieData.class.getResource("movielens100k/u.item").eachLine { line ->
			def parts = line.split "\\|"
			movies[parts[0]] = parts[1]
		}

		def prefs = [:].withDefault{ [:] }
		MovieData.class.getResource("movielens100k/u.data").eachLine { line ->
			def parts = line.split "\t"
			def user=parts[0]
			def movieid=parts[1]
			def rating=parts[2]
			prefs[user][movies[movieid]] = rating as float
		}

		return prefs
	}
}
