package com.example.demo.entity.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class FredId implements Serializable {
    String seriesId;
    String observationDate;
}
