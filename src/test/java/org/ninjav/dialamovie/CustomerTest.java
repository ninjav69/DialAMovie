package org.ninjav.dialamovie;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {

	private Customer customer;

	@Before
	public void setup() {
		customer = new Customer("Name");
		assertThat(customer, is(notNullValue()));
		assertThat(customer.name(), is(equalTo("Name")));
	}

	@Test
	public void whenCustomerRent_customerMustHaveRented() {
		customer.addRental(new Rental(new Movie("Movie", Movie.NEW_RELEASE), 1));
	}

	@Test
	public void canRenderStatement() {
		String expected = "Rental Record for Name\n" +
						  "\tMovie 1\t3.0\n" +
						  "\tMovie 2\t2.0\n" +
						  "\tMovie 3\t1.5\n" +
						  "Amount owed is 6.5\n" +
						  "You earned 3 frequent renter points";
		seedTest();
		String result = customer.statement();
		assertThat(result, is(notNullValue()));
		assertThat(result.length(), is(not(0)));
		assertThat(result, is(equalTo(expected)));

		System.out.println(result);
	}

	private void seedTest() {
		customer.addRental(new Rental(new Movie("Movie 1", Movie.NEW_RELEASE), 1));
		customer.addRental(new Rental(new Movie("Movie 2", Movie.REGULAR), 1));
		customer.addRental(new Rental(new Movie("Movie 3", Movie.CHILDRENS), 1));
	}
}
