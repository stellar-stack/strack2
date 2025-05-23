//package com.strack.strack.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
////import jakarta.persistence.ManyToOne;
////import jakarta.persistence.JoinColumn;
//
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String studentId;
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String department;
//    private String course;
//    private String phone;
//
//}

package com.strack.strack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentId;
    private String firstname;
    private String lastname;
    private String email;
    private String department;
    private String course;
    private String phone;

}
