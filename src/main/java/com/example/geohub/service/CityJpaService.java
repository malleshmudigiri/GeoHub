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

// Write your code here

package com.example.geohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.geohub.model.*;
import com.example.geohub.repository.*;

@Service
public class CityJpaService implements CityRepository {
   @Autowired
   private CityJpaRepository cityJpaRepository;
   @Autowired
   private CountryJpaRepository countryJpaService;

   @Override
   public ArrayList<City> getCities() {
      List<City> list = cityJpaRepository.findAll();
      ArrayList<City> arraylist = new ArrayList<>(list);
      return arraylist;
   }

   @Override

   public City addCity(City city) {
      Country country12 = city.getCountry();
      int countryId1 = country12.getCountryId();
      Country country122 = countryJpaService.findById(countryId1).get();
      city.setCountry(country122);
      cityJpaRepository.save(city);
      return city;

   }

   @Override
   public City getCityById(int cityId) {
      try {
         City city1 = cityJpaRepository.findById(cityId).get();
         return city1;
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }

   }

   @Override

   public void deleteCity(int cityId) {

      Optional<City> cityOptional = cityJpaRepository.findById(cityId);

      if (cityOptional.isPresent()) {
         cityJpaRepository.deleteById(cityId);
         throw new ResponseStatusException(HttpStatus.NO_CONTENT);

      } else {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);

      }
   }

   @Override
   public Country getCountryById(int cityId) {
      try {
         City city = cityJpaRepository.findById(cityId).get();
         Country country = city.getCountry();
         int countryId = country.getCountryId();
         Country country4 = countryJpaService.findById(countryId).get();
         return country4;
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);

      }

   }

   @Override
   public City updateCity(int cityId, City city) {
      try {
         City cityOld = cityJpaRepository.findById(cityId).get();
         if (city.getCityName() != null) {
            cityOld.setCityName(city.getCityName());
         }
         if (city.getPopulation() != 0) {
            cityOld.setPopulation(city.getPopulation());
         }
         if (city.getLatitude() != null) {
            cityOld.setLatitude(city.getLatitude());
         }
         if (city.getLongitude() != null) {
            cityOld.setLongitude(city.getLongitude());
         }
         if (city.getCountry() != null) {
            Country country = city.getCountry();
            int countryId = country.getCountryId();
            Country country4 = countryJpaService.findById(countryId).get();
            cityOld.setCountry(country4);
         }

         cityJpaRepository.save(cityOld);
         return cityJpaRepository.findById(cityId).get();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }

   }

}