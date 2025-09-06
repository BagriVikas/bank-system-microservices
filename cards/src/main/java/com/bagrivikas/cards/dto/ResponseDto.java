package com.bagrivikas.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;
}
