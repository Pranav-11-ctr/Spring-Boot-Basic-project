package com.springmvc.SpringMvcBasicProject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Schema(
        description = "UserDto model information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Schema(description = "User First Name")
    @NotEmpty(
            message = "user first name should not be null or empty"
    )
    private  String firstName;

    @Schema(description = "User Last Name")
    @NotEmpty(
            message = "user last name should not be null or empty"
    )
    private String lastName;

    @Schema(description = "User email")
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email Address should be valid")
    private  String email;
}
