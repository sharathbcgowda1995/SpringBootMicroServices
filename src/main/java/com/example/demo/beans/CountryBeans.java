package com.example.demo.beans;

public class CountryBeans {

	private int id;
	private String countryName;
	private String capital;

	public CountryBeans(int id, String countryName, String capital) {
		this.id = id;
		this.countryName = countryName;
		this.capital = capital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
