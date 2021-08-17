package com.example.postcodes.controller;

import com.example.postcodes.model.Area;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/postcodes")
public class PostCodesRestController {
    @PostMapping()
    public List<Area> createList(@RequestBody List<Area> areas) {
        return Collections.emptyList();
    }

    @GetMapping()
    public List<Area> getByPostcodes(@RequestParam List<String> postcodes) {
        return Collections.emptyList();
    }
}
