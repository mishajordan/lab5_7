package com.example.gasstation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackForm implements Serializable {
    private Long branchId;

    @Size(min = 2, message = "Не меньше 2 знаков")
    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @Email
    @NotBlank
    private String email;

    @Size(min = 5, message = "Не меньше 5 знаков")
    @NotBlank
    private String body;
}
