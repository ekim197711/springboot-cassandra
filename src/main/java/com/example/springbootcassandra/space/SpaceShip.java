package com.example.springbootcassandra.space;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("spaceship")
public class SpaceShip {
    @PrimaryKey
    private UUID id;
    private String model;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private Captain captain;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "second")
    private Captain secondaryCaptain;
    private Integer fuel;
}
