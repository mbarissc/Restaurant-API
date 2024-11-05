package com.skylab.akademi.dataAccess;

import com.skylab.akademi.entities.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableDao extends JpaRepository<RestaurantTable, Integer> {



}
