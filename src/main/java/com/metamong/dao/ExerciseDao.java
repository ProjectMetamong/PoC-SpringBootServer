package com.metamong.dao;

import com.metamong.entity.Exercise;

public interface ExerciseDao {
    void create(Exercise exercise);

    void getById(int id);

    void update(Exercise exercise);

    void deleteById(int id);
}
