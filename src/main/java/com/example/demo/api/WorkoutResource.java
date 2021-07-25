package com.example.demo.api;

//import com.example.demo.dao.ExerciseDao;
//import com.example.profit.dao.SuperSetDao;
//import com.example.profit.dao.WorkoutDao;
import com.example.demo.models.Exercise;
import com.example.demo.models.SuperSet;
import com.example.demo.models.Workout;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.SetRepository;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Service
@Path("/")
public class WorkoutResource {
    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private SetRepository setRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @GET
    @Path("/workout")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getAllWorkouts(){
        SuperSet set = new SuperSet(20.2, 14);
        SuperSet set1 = new SuperSet(10.2, 94);
        SuperSet set2 = new SuperSet(20.2, 14);
        SuperSet set3 = new SuperSet(10.2, 94);
        Exercise exercise = new Exercise("up",  new ArrayList<>(Arrays.asList(set, set1)));
        Exercise exercise1 = new Exercise("sit",  new ArrayList<>(Arrays.asList(set3, set2)));
        Workout workout = new Workout("Ноги", "dasfads", LocalDate.now(),
                "adfasfgfdasgv fsdbasdksdfjgijmdfbvms",
                new ArrayList<>(Arrays.asList(exercise, exercise1)));
        workoutRepository.save(workout);
        exercise.setWorkout(workout);
        exerciseRepository.save(exercise);
        exercise1.setWorkout(workout);
        exerciseRepository.save(exercise1);
        set1.setExercise(exercise);
        set.setExercise(exercise);
        setRepository.save(set);
        setRepository.save(set1);

        set2.setExercise(exercise1);
        set3.setExercise(exercise1);
        setRepository.save(set2);
        setRepository.save(set3);
        return Response.ok(workoutRepository.findAll()).build();
    }
}
