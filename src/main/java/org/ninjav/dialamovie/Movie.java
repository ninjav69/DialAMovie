package org.ninjav.dialamovie;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private final String title;
	private final int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String title() {
		return title;
	}

	public int priceCode() {
		return priceCode;
	}

	public double charge(int daysRented) {
		double result = 0;
		//determine amounts for each line
		switch (priceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
		}
		// add frequent renter points
		return result;
	}

	public int frequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 0;
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((priceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
