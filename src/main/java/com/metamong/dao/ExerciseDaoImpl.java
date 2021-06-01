package com.metamong.dao;

import com.metamong.entity.Exercise;
import org.springframework.stereotype.Repository;

@Repository
public class ExerciseDaoImpl implements ExerciseDao {
    private DbConnection connection;

    public ExerciseDaoImpl(DbConnection connection) {
        this.connection = connection;
    }
    
    @Override
    public void create(Exercise exercise) {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void update(Exercise exercise) {

    }

    @Override
    public void deleteById(int id) {

    }
}
