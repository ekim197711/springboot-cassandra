package com.example.springbootcassandra.space;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpaceShipRepositoryTest {

    @Autowired
    SpaceShipRepository repository;

    @Test
    public void tryCas(){
        repository.deleteAll();

        Faker faker = new Faker(Locale.getDefault());
        for (int i = 0; i < 1000; i++) {
            Captain captain = new Captain(faker.name().firstName(), faker.name().title());
            Captain secondcaptain = new Captain(faker.name().firstName(), faker.name().title());
            SpaceShip spaceShip = new SpaceShip(
                    Uuids.timeBased().toString(),
                    faker.space().planet(),
                    captain,
                    secondcaptain,
                    faker.number().numberBetween(10, 100)
            );
            repository.save(spaceShip);
        }
        List<SpaceShip> p = repository.findByModelStartingWith("Mars");
        for (SpaceShip spaceShip : p) {
            System.out.println(spaceShip);
        }
    }
}