package com.example.sqr.equation.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
public class DtoResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_seq")
    private int id;
    private Double a;
    private Double b;
    private Double c;
    private Double radicalFirst;
    private Double radicalSecond;
}
