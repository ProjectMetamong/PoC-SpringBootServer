package com.metamong.service;

import com.metamong.dao.ExerciseDao;
import com.metamong.entity.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
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
    public ResponseEntity<Message> createExercise(@RequestBody Exercise exercise) throws Exception {
        int saved_id = exerciseDao.create(exercise);

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        if (saved_id == -1) {
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setMessage("404");

            return ResponseEntity.notFound().build();
        }

        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(saved_id);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/get")
    public ResponseEntity<Message> getExerciseById(@RequestBody Map<String, Integer> param) throws Exception {
        int id = param.get("id");

        Exercise ex = exerciseDao.getById(id);

        if(ex == null) {
            return ResponseEntity.notFound().build();
        }

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(ex);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/getall")
    public ResponseEntity<Message> getAllExercise() throws Exception {

        ArrayList<Exercise> exList = exerciseDao.getAll();

        if(exList.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(exList);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Message> searchTitleByWord(
            @PathVariable("title") String keyword
    ) throws Exception {
        ArrayList<Exercise> exList = exerciseDao.searchByString(keyword);

        if(exList.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("200");
        message.setData(exList);

        return ResponseEntity.ok(message);
    }
}
