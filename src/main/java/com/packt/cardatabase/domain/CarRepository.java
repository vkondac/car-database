package com.packt.cardatabase.domain;

import com.packt.cardatabase.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrandOrColorOrModel(String brand, String color, String model);
}
