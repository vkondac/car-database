package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository repository;
    @Autowired
    private OwnerRepository orepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("App started");
    }

    @Override
    public void run(String... args) throws Exception {
        Owner vanja = new Owner("Vanja","Kondac");
        Owner aleksa = new Owner("Aleksandar","Busbaher");
        Set<Owner> owners = new HashSet<Owner>();

        owners.add(vanja);
        owners.add(aleksa);

        Car car1 = new Car("Mercedes","S class","black","ns5252",100000,owners);

        Car car2 = new Car("Nissan", "quasqai", "black", "ns1212", 50000,owners);

        orepository.saveAll(Arrays.asList(vanja, aleksa));
        repository.saveAll(Arrays.asList(car1,car2));

        for (Car car : repository.findAll()){
            logger.info(car.getBrand() + " " + car.getModel());
        }

    }
}
