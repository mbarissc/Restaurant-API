package com.skylab.akademi.service.abstracts;

import com.skylab.akademi.entities.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(int id);

    List<Restaurant> getAllRestaurants();

    ResponseEntity<Restaurant> deleteRestaurantById(int id);

    Optional<Restaurant> getRestaurantByName(String name);


}
