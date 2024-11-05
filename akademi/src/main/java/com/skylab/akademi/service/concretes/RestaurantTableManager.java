package com.skylab.akademi.service.concretes;

import com.skylab.akademi.dataAccess.RestaurantTableDao;
import com.skylab.akademi.entities.Restaurant;
import com.skylab.akademi.entities.RestaurantTable;
import com.skylab.akademi.requests.TableCreateRequest;
import com.skylab.akademi.service.abstracts.RestaurantService;
import com.skylab.akademi.service.abstracts.RestaurantTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableManager implements RestaurantTableService {
    private final RestaurantService restaurantService;
    private final RestaurantTableDao restaurantTableDao;

    public RestaurantTableManager(RestaurantTableDao restaurantTableDao, RestaurantService restaurantService) {
        this.restaurantTableDao = restaurantTableDao;
        this.restaurantService = restaurantService;
    }

    @Override
    public RestaurantTable addRestaurantTable(TableCreateRequest newTable) {
        Restaurant restaurant = restaurantService.getRestaurantById(newTable.getRestaurantId());
        if(restaurant==null)
            return null;
        RestaurantTable toSave = new RestaurantTable();
        toSave.setCapacity(newTable.getCapacity());
        toSave.setRestaurant(restaurant);
        return restaurantTableDao.save(toSave);

    }

    @Override
    public RestaurantTable getRestaurantTableById(int id) {
        return restaurantTableDao.findById(id).get();
    }

    @Override
    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableDao.findAll();
    }

    @Override
    public ResponseEntity<RestaurantTable> deleteRestaurantTableById(int id) {
        restaurantTableDao.deleteById(id);

        return null;
    }

    @Override
    public RestaurantTable reserveRestaurantTable(int id, String name){

        if(restaurantTableDao.existsById(id)==false){
            return null;
        }

        RestaurantTable restaurantTable = restaurantTableDao.findById(id).get();

        if(restaurantTable.isReserved()==true){
            return null;
        }
        if(restaurantTable.getReservedBy()!=null){
            return null;
        }
        restaurantTable.setReserved(true);
        restaurantTable.setReservedBy(name);
        return restaurantTableDao.save(restaurantTable);

    }

    @Override
    public ResponseEntity<RestaurantTable> deleteReservation(int id, String name){
        if(!restaurantTableDao.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        RestaurantTable restaurantTable = restaurantTableDao.findById(id).get();

        if(!restaurantTable.isReserved()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        if(restaurantTable.getReservedBy() == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        if (!restaurantTable.getReservedBy().equals(name)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        restaurantTable.setReserved(false);
        restaurantTable.setReservedBy(null);
        restaurantTableDao.save(restaurantTable);
        return ResponseEntity.ok(restaurantTable);
    }

}
