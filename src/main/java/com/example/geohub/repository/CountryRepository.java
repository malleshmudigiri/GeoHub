/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.geohub.repository;

import java.util.ArrayList;
import com.example.geohub.model.*;

public interface CountryRepository {
    ArrayList<Country> getCountries();

    Country addCountry(Country country);

    Country getCountryById(int countryId);

    Country updateCountry(int countryId, Country country);

    void deleteCountry(int countryId);

}
