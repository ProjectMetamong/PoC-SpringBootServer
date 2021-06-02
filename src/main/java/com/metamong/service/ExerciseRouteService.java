package com.metamong.service;

import com.metamong.dao.ExerciseDao;
import com.metamong.entity.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseRouteService {

    private ExerciseDao exerciseDao;

    @Autowired
    public void setExerciseDao(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Integer> createExercise(@RequestBody Exercise exercise) throws Exception {
        int saved_id = exerciseDao.create(exercise);

        if (saved_id == -1) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(saved_id);
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/get")
    public ResponseEntity<Exercise> getExerciseById(@RequestBody Map<String, Integer> param) throws Exception {
        int id = param.get("id");

        Exercise ex = exerciseDao.getById(id);

        if(ex == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ex);
    }

    @GetMapping("/getall")
    public ResponseEntity<ArrayList<Exercise>> getAllExercise() throws Exception {

        ArrayList<Exercise> exList = exerciseDao.getAll();

        if(exList.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(exList);
    }
}
