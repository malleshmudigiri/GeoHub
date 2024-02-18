/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.geohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.geohub.model.*;
import com.example.geohub.service.*;

@RestController
public class CityController {
    @Autowired
    public CityJpaService cityJpaService;

    @GetMapping("/countries/cities")
    public ArrayList<City> getCities() {
        return cityJpaService.getCities();
    }

    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City city) {
        return cityJpaService.addCity(city);

    }

    @GetMapping("/countries/cities/{cityId}")
    public City getCityById(@PathVariable("cityId") int cityId) {
        return cityJpaService.getCityById(cityId);

    }

    @GetMapping("/cities/{cityId}/country")
    public Country getCountryById(@PathVariable("cityId") int cityId) {
        return cityJpaService.getCountryById(cityId);

    }

    @PutMapping("/countries/cities/{cityId}")
    public City updateCity(@PathVariable("cityId") int cityId, @RequestBody City city) {
        return cityJpaService.updateCity(cityId, city);

    }

    @DeleteMapping("/countries/cities/{cityId}")
    public void deleteCity(@PathVariable("cityId") int cityId) {
        cityJpaService.deleteCity(cityId);

    }
}
