package com.strack.strack.controller;

import com.strack.strack.model.Result;
import com.strack.strack.model.Student;
import com.strack.strack.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;


//    getting all the results
    @GetMapping("/")
    public ResponseEntity<List<Result>> getAllResults() {
        return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
    }

//    getting result by id
    @GetMapping("/studentresult/{id}")
    public ResponseEntity<Result> getResult(@PathVariable int id){

        Result result = resultService.getResultById(id);
        if(result != null)
            return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addresult")
    public ResponseEntity<Result> addResult(@RequestBody Result result) {
        Result createdResult = resultService.addResult(result);

        // Return ResponseEntity with CREATED status and the created student in the body
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
    }

    @PutMapping("/updatedresult/{id}")
    public ResponseEntity<Result> updateResult(@RequestBody Result result, @PathVariable Integer id) {
        // Update the student and get the result
        Result updatedResult = resultService.updateResult(result, id);

        // If student was updated, return it with status 200 OK, else return 404 Not Found
        if (updatedResult != null) {
            return new ResponseEntity<>(updatedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/deleteresult/{id}")
    public void deleteStudent(@PathVariable Integer id){
        resultService.deleteResult(id);
    }
}
