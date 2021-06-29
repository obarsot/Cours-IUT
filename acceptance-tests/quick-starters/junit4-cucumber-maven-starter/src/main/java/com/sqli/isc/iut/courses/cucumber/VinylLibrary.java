package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VinylLibrary {

	private final List<Album> store = new ArrayList<>();

	public void addAlbum(final Album album) {
		store.add(album);
	}

	public List<Album> findAlbums(final Date from, final Date to) {
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		end.roll(Calendar.YEAR, 1);

		return store.stream()
				.filter(album -> from.before(album.getReleasedDate()) && end.getTime().after(album.getReleasedDate()))
				.sorted(Comparator.comparing(Album::getReleasedDate).reversed())
				.collect(Collectors.toList());
	}

}
