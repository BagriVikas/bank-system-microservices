package com.bagrivikas.accounts.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMsg;
}
