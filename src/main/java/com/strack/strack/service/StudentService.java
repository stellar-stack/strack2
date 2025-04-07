package com.strack.strack.service;

import com.strack.strack.model.Student;
import com.strack.strack.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }


    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

//    public Student updateStudent(Student student, Integer id) {
//        return studentRepo.findById(id).map(st -> {
//            st.setStudentId(student.getStudentId());
//            st.setFirstname(student.getFirstname());
//            st.setLastname(student.getLastname());
//            st.setEmail(student.getEmail());
//            st.setDepartment(student.getDepartment());
//            st.setCourse(student.getCourse());
//            st.setPhone(student.getPhone());
//            return studentRepo.save(st);
//        }).orElseThrow(() -> new StudentNotFoundException("Sorry No Student Found"));
//    }

    public Student updateStudent(Student student, Integer id) {
        // Fetch the existing student by id
        Student existingStudent = studentRepo.findById(id).orElse(null);

        // If student is found, update fields
        if (existingStudent != null) {
            // Only update the fields that can change
            existingStudent.setStudentId(student.getStudentId());
            existingStudent.setFirstname(student.getFirstname());
            existingStudent.setLastname(student.getLastname());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDepartment(student.getDepartment());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setPhone(student.getPhone());

            // Save the updated student to the database
            return studentRepo.save(existingStudent);
        } else {
            return null;  // Return null or throw exception if student not found
        }
    }

    public void deleteStudent(Integer id) {

        if(!studentRepo.existsById(id)) {
            throw new StudentNotFoundException("Sorry, Student Found");
        }

        studentRepo.deleteById(id);

    }

    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
    }


//    public Student getStudentByEmail(String email) {
//        return studentRepo.findByEmail(email).orElse(null);
//    }



}



