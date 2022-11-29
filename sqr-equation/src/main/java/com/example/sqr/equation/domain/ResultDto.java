package com.example.sqr.equation.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "result")
public class ResultDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_seq")
    private int id;
    private Double a;
    private Double b;
    private Double c;
    private Double firstRadical;
    private Double secondRadical;
}
