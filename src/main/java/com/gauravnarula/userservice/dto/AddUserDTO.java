package com.gauravnarula.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddUserDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private Date dob;
}
