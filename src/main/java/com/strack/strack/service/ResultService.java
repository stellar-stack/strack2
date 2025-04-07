package com.strack.strack.service;

import com.strack.strack.model.Result;
import com.strack.strack.model.Student;
import com.strack.strack.repo.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepo resultRepo;

    public List<Result> getAllResults() {
        return resultRepo.findAll();
    }

    public Result getResultById(int id) {
        return resultRepo.findById(id).orElse(null);
    }

    public Result addResult(@RequestBody Result result) {
        return resultRepo.save(result);
    }


//    UPDATE
    public Result updateResult(Result result, Integer id) {
        // Fetch the existing result by id
        Result existingResult = resultRepo.findById(id).orElse(null);

        // If result is found, update fields
        if (existingResult != null) {
            // Update fields using Lombok-generated setters
            existingResult.setStudentid(result.getStudentid());  // Correct method names
            existingResult.setAnalyticalthinking(result.getAnalyticalthinking());
            existingResult.setCprogramming(result.getCprogramming());
            existingResult.setLinearalgebra(result.getLinearalgebra());
            existingResult.setOs(result.getOs());

            // Save the updated result to the database
            return resultRepo.save(existingResult);
        } else {
            return null;  // Return null or throw exception if result not found
        }
    }


    public void deleteResult(Integer id) {

        if(!resultRepo.existsById(id)) {
            throw new StudentNotFoundException("Sorry, No Result Found");
        }

        resultRepo.deleteById(id);

    }


//    updated from gpt
//    public Result getResultByEmail(String email) {
//        return resultRepo.findAll()
//                .stream()
//                .filter(r -> r.getStudentid().equals(email))
//                .findFirst()
//                .orElse(null);
//    }


}
