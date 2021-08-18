package com.example.postcodes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AreaDTO {
    private String postcode;
    private String name;
}
