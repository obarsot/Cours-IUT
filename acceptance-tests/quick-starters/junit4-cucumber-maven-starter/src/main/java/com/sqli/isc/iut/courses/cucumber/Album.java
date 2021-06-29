package com.sqli.isc.iut.courses.cucumber;

import java.util.Date;

public class Album {

	private String title;
	private String artistOrBand;
	private boolean band;
	private Date releasedDate;
	private String label;

	public Album(String title, String artistOrBand, boolean band, Date releasedDate, String label) {
		this.title = title;
		this.artistOrBand = artistOrBand;
		this.band = band;
		this.releasedDate = releasedDate;
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistOrBand() {
		return artistOrBand;
	}

	public void setArtistOrBand(String artistOrBand) {
		this.artistOrBand = artistOrBand;
	}

	public boolean isBand() {
		return band;
	}

	public void setBand(boolean band) {
		this.band = band;
	}

	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
