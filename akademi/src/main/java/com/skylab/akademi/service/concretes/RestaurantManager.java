package com.skylab.akademi.service.concretes;

import com.skylab.akademi.dataAccess.RestaurantDao;
import com.skylab.akademi.entities.Restaurant;
import com.skylab.akademi.service.abstracts.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantManager implements RestaurantService {

    private final RestaurantDao restaurantDao;

    public RestaurantManager(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        if(restaurant.getName().length()<5){
            return null;
        }
        if(restaurant.getRestaurantTable().isEmpty()){
            return null;
        }
        return restaurantDao.save(restaurant);

    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return restaurantDao.findById(id).get();

    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        return restaurantDao.findAll();
    }

    @Override
    public ResponseEntity<Restaurant> deleteRestaurantById(int id) {

        restaurantDao.deleteById(id);

        return null;
    }


    @Override
    public Optional<Restaurant> getRestaurantByName(String name) {

        return restaurantDao.findRestaurantByName(name);
    }
}
