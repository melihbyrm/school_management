package com.schoolmanagement.entity;

import com.schoolmanagement.dto.ContactMessageRequest;
import com.schoolmanagement.dto.ContactMessageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Email
    @NotNull
    @Column(nullable = false)
    private String email;

    private String subject;

    private String message;

    private LocalDate date=formattedType(LocalDate.now());  // LocalDate normalde


    public static LocalDate formattedType(LocalDate localDate){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dtf.format(localDate));
    }

    public ContactMessage(ContactMessageRequest contactMessageRequest) {
        this.name= contactMessageRequest.getName();
        this.email= contactMessageRequest.getEmail();
        this.message= contactMessageRequest.getMessage();
        this.subject= contactMessageRequest.getSubject();
    }
}
