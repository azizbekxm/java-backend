package com.epam.jmp.protocols.avro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private Integer id;
    private String favoriteColor;
    private String neutralColor;
    private String regretColor;
}
