package org.ninjav.dialamovie;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RentalTest {

	@Test
	public void canCreateRental() {
		int daysRented = 1;
		Rental r = new Rental(new Movie("Movie", Movie.NEW_RELEASE), daysRented);
		assertThat(r, is(notNullValue()));
	}

}
