package org.ninjav.dialamovie;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieTest {

	@Test
	public void canCreateMovie() {
		int priceCode = Movie.NEW_RELEASE;
		Movie m = new Movie("New release", priceCode);
		assertThat(m, is(notNullValue()));
		assertThat(m.title(), is(equalTo("New release")));
		assertThat(m.priceCode(), is(equalTo(Movie.NEW_RELEASE)));
	}
}
