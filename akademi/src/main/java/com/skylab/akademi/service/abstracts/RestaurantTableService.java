package com.skylab.akademi.service.abstracts;

import com.skylab.akademi.entities.Restaurant;
import com.skylab.akademi.entities.RestaurantTable;
import com.skylab.akademi.requests.TableCreateRequest;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;


public interface RestaurantTableService {
    RestaurantTable addRestaurantTable(TableCreateRequest newTable);
    RestaurantTable getRestaurantTableById(int id);
    List<RestaurantTable> getAllRestaurantTables();
    ResponseEntity<RestaurantTable> deleteRestaurantTableById(int id);
    RestaurantTable reserveRestaurantTable(int id, String name);
    ResponseEntity<RestaurantTable> deleteReservation(int id, String name);

}
