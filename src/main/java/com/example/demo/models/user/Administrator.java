package com.example.demo.models.user;

import com.example.demo.models.Workout;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Administrator extends User {
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="administrator")
    private List<Trainer> trainers;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="administrator")
    private List<Athlete> athletes;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="administrator")
    private List<Workout> workouts;
}
