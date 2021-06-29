package com.sqli.isc.iut.courses.cucumber;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VinylSearchSteps {

	private static final DateFormat DATE_FORMATER = new SimpleDateFormat("dd-MM-yyy");

	private static final DateFormat YEAR_FORMATER = new SimpleDateFormat("yyyy");

	private VinylLibrary vinylLibrary = new VinylLibrary();
	private List<Album> searchResult = new ArrayList<>();

	@Given("an album with the title {string}, created by the artist {string}, released in {string} on the label {string}")
	public void an_album_the_title_created_by_the_artist_released_in_on_the_label(String title, String artist,
			String releasedDateAsString, String label) throws ParseException {
		Date releasedDate = DATE_FORMATER.parse(releasedDateAsString);

		Album album = new Album(title, artist, false, releasedDate, label);
		vinylLibrary.addAlbum(album);
	}

	@Given("an album with the title {string}, created by the band {string}, released in {string} on the label {string}")
	public void an_album_with_the_title_created_by_the_band_released_in_on_the_label(String title, String band,
			String releasedDateAsString, String label) throws ParseException {
		Date releasedDate = DATE_FORMATER.parse(releasedDateAsString);

		Album album = new Album(title, band, true, releasedDate, label);
		vinylLibrary.addAlbum(album);
	}

	@When("the customer searches for vinyls released between {string} and {string}")
	public void the_customer_searches_for_vinyls_released_between_and(String fromYearAsString, String toYearAsString)
			throws ParseException {
		Date fromYear = YEAR_FORMATER.parse(fromYearAsString);
		Date toYear = YEAR_FORMATER.parse(toYearAsString);

		searchResult = vinylLibrary.findAlbums(fromYear, toYear);
	}

	@Then("{int} albums should have been found")
	public void albums_should_have_been_found(int numberOfAlbumsFound) {
		assertEquals(searchResult.size(), numberOfAlbumsFound);
	}

	@Then("album {int} should have the title {string}")
	public void album_should_have_the_title(int position, String title) {
		assertEquals(searchResult.get(position - 1).getTitle(), title);
	}

}
