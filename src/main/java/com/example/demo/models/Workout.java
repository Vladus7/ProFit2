package com.example.demo.models;

import com.example.demo.models.user.Administrator;
import com.example.demo.models.user.Athlete;
import com.example.demo.models.user.Trainer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descriptions;
    private LocalDate date;
    private String review;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="workout")
    private List<Exercise> exercises;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="administrator_id")
    private Administrator administrator;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="athlete_id")
    private Athlete athlete;

    public Workout() {
    }

    public Workout(String name, String descriptions, LocalDate date, String review, List<Exercise> exercises) {
        this.name = name;
        this.descriptions = descriptions;
        this.date = date;
        this.review = review;
        this.exercises = exercises;
    }

    public Workout(long id, String name, String descriptions, LocalDate date, String review, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.date = date;
        this.review = review;
        this.exercises = exercises;
    }
}
