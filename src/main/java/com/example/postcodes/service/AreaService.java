package com.example.postcodes.service;

import com.example.postcodes.dto.AreaDTO;
import com.example.postcodes.dto.NamesWithNumberOfCharactersDTO;

import java.util.List;

public interface AreaService {
    NamesWithNumberOfCharactersDTO findSortedNamesWithNumberOfCharactersByPostcodes(String postcodeFrom, String postcodeTo);

    List<AreaDTO> createWithList(List<AreaDTO> areas);
}
