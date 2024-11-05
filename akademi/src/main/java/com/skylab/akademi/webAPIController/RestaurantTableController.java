package com.skylab.akademi.webAPIController;

import com.skylab.akademi.entities.RestaurantTable;
import com.skylab.akademi.requests.TableCreateRequest;
import com.skylab.akademi.service.abstracts.RestaurantTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;


    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping("/addTables")
    public ResponseEntity<RestaurantTable> addTable(@RequestBody TableCreateRequest newTable) {
        var result = restaurantTableService.addRestaurantTable(newTable);

        if(result==null)
            return ResponseEntity.badRequest().body(result);

        return ResponseEntity.status(201).body(result);

    }
    @GetMapping("/getTableById/{id}")
    public ResponseEntity<RestaurantTable> getRestaurantTableById(@PathVariable int id) {
        var result = restaurantTableService.getRestaurantTableById(id);
        if(result == null){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllTables")
    public ResponseEntity<List<RestaurantTable>> getAllRestaurantTables() {
        var result = restaurantTableService.getAllRestaurantTables();
        if(result.isEmpty()){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteTableById/{id}")
    public ResponseEntity<RestaurantTable> deleteRestaurantTableById(@PathVariable int id) {
        restaurantTableService.deleteRestaurantTableById(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/reserveRestaurantTable")
    public ResponseEntity<RestaurantTable> reserveRestaurantTable(@RequestParam int id, @RequestParam String name) {
        var result = restaurantTableService.reserveRestaurantTable(id, name);
        if(result == null){
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteReservation")
    public ResponseEntity<Void> deleteReservation(@RequestParam int id, @RequestParam String name) {
        var result = restaurantTableService.deleteReservation(id, name);
        if(result == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().build();
    }

}
