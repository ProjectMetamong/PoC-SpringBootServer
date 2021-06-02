package com.metamong.dao;

import com.metamong.entity.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ExerciseDaoImpl implements ExerciseDao {

    private DbConnection connection;

    @Autowired
    public ExerciseDaoImpl(DbConnection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Exercise exercise) throws Exception {
        Connection c = connection.getConnection();
        int result_id = -1;

        String sql = "INSERT INTO EXERCISE(TITLE, DIFFICULTY, CREATOR, VIDEO_LENGTH, DESCRIPTION) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, exercise.getTitle());
        stmt.setString(2, exercise.getDifficulty());
        stmt.setString(3, exercise.getCreator());
        stmt.setInt(4, exercise.getVideoLength());
        stmt.setString(5, exercise.getDescription());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        while(rs.next())
        {
            result_id = rs.getInt(1);
        }

        stmt.close();
        c.close();


        return result_id;
    }

    @Override
    public Exercise getById(int id) throws Exception {
        Connection c = connection.getConnection();

        String sql = "SELECT * FROM EXERCISE WHERE EXERCISE_ID = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Exercise exercise = null;
        if (rs.next()) {
            exercise = getExercise(rs);
        }

        if (exercise == null)
            throw new EmptyResultDataAccessException(1);

        rs.close();
        ps.close();
        c.close();

        return exercise;
    }

    @Override
    public ArrayList<Exercise> getAll() throws Exception {
        ArrayList<Exercise> exList = new ArrayList<>();

        Connection c = connection.getConnection();

        String sql = "SELECT * FROM EXERCISE";
        return getExercisesInStmt(exList, c, sql);
    }

    @Override
    public ArrayList<Exercise> searchByString(String searchWord) throws Exception {
        ArrayList<Exercise> exList = new ArrayList<>();

        Connection c = connection.getConnection();

        String sql = "SELECT * FROM EXERCISE WHERE TITLE LIKE '%" + searchWord + "%'";
        return getExercisesInStmt(exList, c, sql);
    }

    private ArrayList<Exercise> getExercisesInStmt(ArrayList<Exercise> exList, Connection c, String sql) throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        Exercise exercise = null;
        while (rs.next()) {
            exercise = getExercise(rs);
            exList.add(exercise);
        }

        if (exercise == null)
            throw new EmptyResultDataAccessException(1);

        rs.close();
        ps.close();
        c.close();

        return exList;
    }

    private Exercise getExercise(ResultSet rs) throws SQLException {
        Exercise exercise;
        exercise = new Exercise();
        exercise.setExerciseId(rs.getInt("EXERCISE_ID"));
        exercise.setTitle(rs.getString("TITLE"));
        exercise.setDifficulty(rs.getString("DIFFICULTY"));
        exercise.setCreator(rs.getString("CREATOR"));
        exercise.setVideoLength(rs.getInt("VIDEO_LENGTH"));
        exercise.setDescription(rs.getString("DESCRIPTION"));
        return exercise;
    }

    @Override
    public void update(Exercise exercise) {

    }

    @Override
    public void deleteById(int id) {

    }
}
