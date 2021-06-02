package com.metamong.dao;

import com.metamong.entity.Exercise;

import java.util.ArrayList;

public interface ExerciseDao {
    int create(Exercise exercise) throws Exception;

    Exercise getById(int id) throws Exception;

    ArrayList<Exercise> getAll() throws Exception;

    void update(Exercise exercise);

    void deleteById(int id);
}
