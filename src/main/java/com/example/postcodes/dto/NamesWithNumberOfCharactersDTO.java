package com.example.postcodes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NamesWithNumberOfCharactersDTO {
    private List<String> names;
    private int numberOfCharacters;
}
