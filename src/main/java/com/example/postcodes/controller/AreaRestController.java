package com.example.postcodes.controller;

import com.example.postcodes.dto.AreaDTO;
import com.example.postcodes.dto.NamesWithNumberOfCharactersDTO;
import com.example.postcodes.service.AreaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areas")
public class AreaRestController {
    private final AreaService areaService;

    public AreaRestController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/createWithList")
    public List<AreaDTO> createWithList(@RequestBody List<AreaDTO> areas) {
        return areaService.createWithList(areas);
    }

    @GetMapping("/findSortedNamesWithNumberOfCharactersByPostcodes")
    public NamesWithNumberOfCharactersDTO findSortedNamesWithNumberOfCharactersByPostcodes(
            @RequestParam String postcodeFrom, @RequestParam String postcodeTo) {
        return areaService.findSortedNamesWithNumberOfCharactersByPostcodes(postcodeFrom, postcodeTo);
    }
}
