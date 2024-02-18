/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code her

package com.example.geohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.geohub.model.*;
import com.example.geohub.repository.*;

@Service
public class CountryJpaService implements CountryRepository {
    @Autowired
    private CountryJpaRepository countryJpaService;

    @Override
    public ArrayList<Country> getCountries() {
        List<Country> list = countryJpaService.findAll();
        ArrayList<Country> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override

    public Country addCountry(Country country) {
        countryJpaService.save(country);
        return country;

    }

    @Override

    public Country getCountryById(int countryId) {
        try {
            Country country1 = countryJpaService.findById(countryId).get();
            return country1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public void deleteCountry(int countryId) {
        Optional<Country> countryOptional = countryJpaService.findById(countryId);

        if (countryOptional.isPresent()) {
            countryJpaService.deleteById(countryId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

    @Override

    public Country updateCountry(int countryId, Country country) {
        try {
            Country country45 = countryJpaService.findById(countryId).get();
            if (country.getCountryName() != null) {
                country45.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                country45.setCurrency(country.getCurrency());
            }
            if (country.getLongitude() != null) {
                country45.setLongitude(country.getLongitude());
            }
            if (country.getLatitude() != null) {
                country45.setLatitude(country.getLatitude());
            }
            if (country.getPopulation() != 0) {
                country45.setPopulation(country.getPopulation());
            }

            countryJpaService.save(country45);
            return country45;

        } catch (Exception s) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
