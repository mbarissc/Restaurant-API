package com.skylab.akademi.webAPIController;

import com.skylab.akademi.entities.Restaurant;
import com.skylab.akademi.service.abstracts.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurants")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        var result = restaurantService.addRestaurant(restaurant);

        if(result == null){
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.status(201).body(result);

    }

    @GetMapping("/getRestaurantById/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        var result = restaurantService.getRestaurantById(id);
        if(result == null){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        var result = restaurantService.getAllRestaurants();
        if(result.isEmpty()){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteRestaurantById/{id}")
    public ResponseEntity<Restaurant> deleteRestaurantById(@PathVariable int id) {
       restaurantService.deleteRestaurantById(id);
       return ResponseEntity.ok(null);
    }

    @GetMapping("/getRestaurantByName")
    public ResponseEntity<Optional<Restaurant>> getRestaurantByName(@RequestParam String name) {
        var result = restaurantService.getRestaurantByName(name);
        if(result.isEmpty()){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }



}
