package com.fdmgroup.com.SpringProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author chak8x8
 *
 *The table in MySQL is Movie. And it contains all attributes for a movie.
 */
@Entity
public class Movie {

	/**
	 * ID is the primary key in MySQL and the value will be auto generated.
	 */
	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private int rating;
	private int runtime;
	private int releaseYear;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Movie(String title, int rating, int runtime, int releaseYear, String genre) {
		super();
		this.title = title;
		this.rating = rating;
		this.runtime = runtime;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", runtime=" + runtime + ", releaseYear="
				+ releaseYear + ", genre=" + genre + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Movie) {
			Movie other = (Movie) o;
			return this.id.equals(other.id) && this.title.equals(other.title) && this.genre.equals(other.genre)
					&& this.rating == other.rating && this.runtime == other.runtime
					&& this.releaseYear == other.releaseYear;

		}
		return false;
	}

}
