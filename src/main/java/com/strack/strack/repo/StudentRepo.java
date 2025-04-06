package com.strack.strack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.strack.strack.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
