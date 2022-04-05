package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.stereotype.Component;

import com.example.demo.beans.CountryBeans;
import com.example.demo.controllers.Response;

@Component
public class CountryServices {

	HashMap<Integer, CountryBeans> data = new HashMap<Integer, CountryBeans>();

	// Data Setup
	public CountryServices() {
		CountryBeans c1 = new CountryBeans(1, "India", "Delhi");
		CountryBeans c2 = new CountryBeans(2, "USA", "WashingtonDC");
		CountryBeans c3 = new CountryBeans(3, "UK", "London");

		data.put(1, c1);
		data.put(2, c2);
		data.put(3, c3);

	}

	// All data
	public List getAllCountries() {
		List list = new ArrayList(data.values());
		return list;
	}
	
	/*public Map<Integer, CountryBeans> getAllCountries() {
		return data;
	}*/

	// Search by id
	public CountryBeans getCountryById(int id) {
		CountryBeans country = null;
		if (data.containsKey(id)) {
			country = data.get(id);
			return country;
		}
		return country;
	}

	// serach by country name
	public CountryBeans getCountryByName(String name) {
		CountryBeans countryName = null;
		for (Integer key : data.keySet()) {
			if (data.get(key).getCountryName().equals(name)) {
				countryName = data.get(key);
			}
		}
		return countryName;
	}

//--------------------------------------------------//
	// Add new data
	public CountryBeans addCountry(CountryBeans country) {

		country.setId(getMaxId());
		data.put(country.getId(), country);

		return country;
	}

	public int getMaxId() {
		int max = 0;
		for (int i : data.keySet()) {
			if (i > max) {
				max = i;
			}
		}
		return max + 1;

	}
//--------------------------------------------//

	// Update existing data
	public CountryBeans updateCountryDetails(CountryBeans country) {
		
		int i = country.getId();
		for (int j : data.keySet()) {
			if(j==i) {
				data.put(country.getId(), country);
				return country;
			}
			
		}
		country =null;
		return country;
		
	}

	// Delete Existing data
	public Response deleteCountry(int id) {

		Response resp = new Response();
		
		for (int j : data.keySet()) {
			if(j==id) {
				data.remove(id);
				
				resp.setMsg("Country deleted");
				resp.setId(id);
				return resp;
			}
			
		}
		resp.setMsg("No Match found to delete");
		resp.setId(id);
		return resp;
		
	}

}
