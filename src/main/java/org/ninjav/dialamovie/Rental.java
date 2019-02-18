package org.ninjav.dialamovie;

public class Rental {
	private final Movie movie;
	private final int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie movie() {
		return movie;
	}

	public int daysRented() {
		return daysRented;
	}

	public double charge() {
		return movie().charge(daysRented());
	}

	public int frequentRenterPoints() {
		return movie().frequentRenterPoints(daysRented());
	}
}
