package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SuperSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double weight;
    private int resp;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="exercise_id", nullable=false)
    private Exercise exercise;

    public SuperSet() {
    }

    public SuperSet(double weight, int resp) {
        this.weight = weight;
        this.resp = resp;
    }

    public SuperSet(long id, double weight, int resp) {
        this.id = id;
        this.weight = weight;
        this.resp = resp;
    }
}
