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

public interface CityRepository {
    ArrayList<City> getCities();

    City addCity(City city);

    City getCityById(int cityId);

    City updateCity(int cityId, City city);

    Country getCountryById(int cityId);

    void deleteCity(int cityId);

}