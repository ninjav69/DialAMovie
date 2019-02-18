package org.ninjav.dialamovie;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String name;
	private final List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String name() {
		return name;
	}

	public void addRental(Rental r) {
		rentals.add(r);
	}

	public String statement() {
		String result = "Rental Record for " + name() + "\n";
		for (Rental rental : rentals) {
			//show figures for this rental
			result += "\t" + rental.movie().title() + "\t" +
					  String.valueOf(rental.charge()) + "\n";
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalCharge()) +
				  "\n";
		result += "You earned " + String.valueOf(totalFrequentRentalPoints())
				  +
				  " frequent renter points";
		return result;
	}

	double totalCharge() {
		return rentals.stream()
				.mapToDouble(r -> r.charge())
				.sum();
	}

	int totalFrequentRentalPoints() {
		return rentals.stream()
			   .mapToInt(r -> r.frequentRenterPoints())
			   .sum();
	}
}
