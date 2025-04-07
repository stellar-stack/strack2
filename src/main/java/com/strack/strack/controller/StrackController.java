package com.strack.strack.controller;

import com.strack.strack.model.Student;
import com.strack.strack.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/api")
public class StrackController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){

        Student student = studentService.getStudentById(id);
        if(student != null)
            return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);

        // Return ResponseEntity with CREATED status and the created student in the body
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}")
//    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id){
//        return studentService.updateStudent(student, id);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        // Update the student and get the result
        Student updatedStudent = studentService.updateStudent(student, id);

        // If student was updated, return it with status 200 OK, else return 404 Not Found
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
}
