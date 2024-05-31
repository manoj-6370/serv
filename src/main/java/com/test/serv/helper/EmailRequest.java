package com.test.serv.helper;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {
    private String To;
    private String message;
    private String subject;

}
