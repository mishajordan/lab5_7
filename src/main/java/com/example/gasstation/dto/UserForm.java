package com.example.gasstation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm implements Serializable {
    @Size(min=3, message = "Не меньше 3 знаков")
    @NotBlank
    private String username;

    @Size(min=6, message = "Не меньше 6 знаков")
    @NotBlank
    private String password;

    private String passwordConfirm;
}
