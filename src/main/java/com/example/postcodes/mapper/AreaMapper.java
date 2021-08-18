package com.example.postcodes.mapper;

import com.example.postcodes.dto.AreaDTO;
import com.example.postcodes.entity.Area;
import com.example.postcodes.entity.AreaId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AreaMapper {
    public AreaDTO mapToDTO(Area area) {
        return new AreaDTO(area.getId().getPostcode(), area.getId().getName());
    }

    public Area mapToEntity(AreaDTO areaDTO) {
        return new Area(new AreaId(areaDTO.getPostcode(), areaDTO.getName()));
    }

    public List<AreaDTO> mapToDTOs(List<Area> areas) {
        return areas.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<Area> mapToEntities(List<AreaDTO> areaDTOs) {
        return areaDTOs.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
