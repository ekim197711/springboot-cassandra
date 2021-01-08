package com.example.springbootcassandra.space;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.javafaker.Faker;

import java.util.Locale;

public class SpaceShipDummyData {
    public SpaceShip createOne(){
        Faker faker = new Faker(Locale.getDefault());
        Captain captain = new Captain(faker.name().firstName(), faker.name().title());
        Captain secondcaptain = new Captain(faker.name().firstName(), faker.name().title());

        SpaceShip spaceShip = new SpaceShip(
                Uuids.timeBased(),
                faker.space().planet(),
                captain,
                secondcaptain,
                faker.number().numberBetween(10, 100)
        );
        return spaceShip;
    }
}
