package com.example.demo.models.user;

import com.example.demo.models.Workout;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Athlete extends User {
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="trainer")
    private List<Workout> workouts;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="administrator_id")
    private Administrator administrator;
}
