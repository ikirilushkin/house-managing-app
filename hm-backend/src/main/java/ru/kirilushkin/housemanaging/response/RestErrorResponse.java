package ru.kirilushkin.housemanaging.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorResponse {

    private int code;

    private String message;
}