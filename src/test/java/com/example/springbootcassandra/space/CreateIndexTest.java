package com.example.springbootcassandra.space;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.util.List;
import java.util.Locale;

@SpringBootTest
public class CreateIndexTest {

    @Autowired
    CassandraTemplate template;


    @Test
    public void createIndex(){
        String cql = "CREATE INDEX on mike.spaceship ( model )";
        boolean execute = template.getCqlOperations().execute(cql);
        Assertions.assertTrue(execute);
    }

    @Test
    public void createTable(){
        String cql = "CREATE TABLE IF NOT EXISTS spaceship (name text, rank text, fuel int, id uuid, model text, secondname text, secondrank text, PRIMARY KEY (id));";
        boolean execute = template.getCqlOperations().execute(cql);
        Assertions.assertTrue(execute);
    }

    @Test
    public void selectStuff(){
        String cql = "select * from mike.spaceship where model='Mars';";
        List<SpaceShip> execute = template.select(cql, SpaceShip.class);
        execute.forEach(System.out::println);
    }


    @Test
    public void insertSpaceShip(){
        SpaceShipDummyData spaceShipDummyData = new SpaceShipDummyData();
        SpaceShip insert = template.insert(spaceShipDummyData.createOne());
        Assertions.assertNotNull(insert);
        Assertions.assertNotNull(insert.getCaptain());
        Assertions.assertNotNull(insert.getSecondaryCaptain());
        Assertions.assertNotNull(insert.getFuel());
        Assertions.assertNotNull(insert.getCaptain().getRank());
        Assertions.assertNotNull(insert.getId());
        System.out.println(insert);
    }


    @Test
    public void createMike3Table(){
        String cql = "CREATE TABLE IF NOT EXISTS mike3.flyingobject (name text, rank text, fuel int, id uuid, model text, secondname text, secondrank text, PRIMARY KEY (id));";
        boolean execute = template.getCqlOperations().execute(cql);
        Assertions.assertTrue(execute);
    }

    @Test
    public void createKeyspace(){
        String cql = "CREATE KEYSPACE \"mike3\" WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};";
        boolean execute = template.getCqlOperations().execute(cql);
        Assertions.assertTrue(execute);
    }
//
}