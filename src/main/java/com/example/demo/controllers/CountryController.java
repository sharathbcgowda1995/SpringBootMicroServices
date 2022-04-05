package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.CountryBeans;
import com.example.demo.services.CountryServices;

@RestController
public class CountryController {

	@Autowired
	CountryServices services;

	@GetMapping("/getCountries")
	public List getAllcountries() {
		return services.getAllCountries();
	}

	@GetMapping("/getCountries/{id}")
	public CountryBeans getCountryByID(@PathVariable(value="id") int id) {
		return services.getCountryById(id);
	}

	@GetMapping("/getCountries/countryName")
	public CountryBeans getCountryByName(@RequestParam(value = "name") String countryName) {
		return services.getCountryByName(countryName);
	}

	@PostMapping("/addCountry")
	public CountryBeans addCountry(@RequestBody CountryBeans beans) {
		return services.addCountry(beans);
	}

	@PutMapping("/updateCountry")
	public CountryBeans updateCountry(@RequestBody CountryBeans beans) {
		return services.updateCountryDetails(beans);
	}

	@DeleteMapping("/deleteCountry/{id}")
	public Response deleteCountry(@PathVariable(value = "id") int id) {
		return services.deleteCountry(id);
	}

}
