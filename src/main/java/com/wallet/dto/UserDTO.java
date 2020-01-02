package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private UUID id;
    @NotNull
    @Email(message = "Invalid email")
    private String email;
    @NotNull
    @Length(min = 3, max = 50, message = "Name need to contains between 3 and 50 characters")
    private String name;
    @NotNull
    @Length(min = 6, message = "Password need to contains 6 characters or more")
    private String password;

}
