package com.schoolmanagement.dto;
import com.schoolmanagement.entity.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageRequest {

    @NotNull
    @Size(min = 3,max = 50,message = "name must be between {min} and {max}")
    private String name;

    @Email(message = "Please provide valid email")
    @NotNull
    private String email;

    @NotNull
    private String subject;

    @NotBlank
    private String message;


}