package com.example.postcodes.service;

import com.example.postcodes.dto.AreaDTO;
import com.example.postcodes.dto.NamesWithNumberOfCharactersDTO;

import java.util.List;

public interface AreaService {
    NamesWithNumberOfCharactersDTO findSortedNamesWithNumberOfCharactersByPostcodes(List<String> postcodes);

    List<AreaDTO> createWithList(List<AreaDTO> areas);
}
