package com.example.technicalworkshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEvaluationDTO {
    private Integer userId;
    private String message;

}
