package com.schoolmanagement.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends User {

    private String motherName;

    private String fatherName;

    private int studentNumber;

    @Email(message = "provide valid email")
    @Column(unique = true)
    private String email;

    private boolean isActive;


}
