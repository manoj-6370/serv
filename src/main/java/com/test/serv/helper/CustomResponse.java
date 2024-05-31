package com.test.serv.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {
    private String message;
    private HttpStatus httpStatus;
    private boolean success=false;
}
