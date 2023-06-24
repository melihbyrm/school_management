package com.schoolmanagement.entity;

import lombok.*;

import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Admin extends User {
    private boolean built_in;

}
