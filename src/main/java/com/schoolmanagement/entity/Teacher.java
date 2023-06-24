package com.schoolmanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends User {
    private boolean isAdvisor;

    @Email(message = "please provide valid email")
    @Column(unique = true)
    private String email;

}
