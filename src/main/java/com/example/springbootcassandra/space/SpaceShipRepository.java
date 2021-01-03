package com.example.springbootcassandra.space;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface SpaceShipRepository extends CassandraRepository<SpaceShip, String> {

//    @AllowFiltering
    List<SpaceShip> findByModelStartingWith(final String modelmatch);
}
