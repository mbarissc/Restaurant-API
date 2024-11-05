package com.skylab.akademi.dataAccess;

import com.skylab.akademi.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

    Optional<Restaurant> findRestaurantByName(String name);

}
