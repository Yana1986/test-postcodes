package com.example.postcodes.service;

import com.example.postcodes.dto.AreaDTO;
import com.example.postcodes.dto.NamesWithNumberOfCharactersDTO;
import com.example.postcodes.entity.Area;
import com.example.postcodes.mapper.AreaMapper;
import com.example.postcodes.repository.AreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {
    private final AreaMapper areaMapper;
    private final AreaRepository areaRepository;

    @Override
    public NamesWithNumberOfCharactersDTO findSortedNamesWithNumberOfCharactersByPostcodes(List<String> postcodes) {
        List<Area> areas = areaRepository.findByIdPostcodeIn(postcodes);
        return new NamesWithNumberOfCharactersDTO(
                areas.stream().map(area -> area.getId().getName()).sorted().collect(Collectors.toList()),
                areas.stream().reduce(0, (num, area) -> num + area.getId().getName().length(), Integer::sum)
        );
    }

    @Override
    @Transactional
    public List<AreaDTO> createWithList(List<AreaDTO> areas) {
        areaRepository.deleteAllInBatch();
        return areaMapper.mapToDTOs(areaRepository.saveAll(areaMapper.mapToEntities(areas)));
    }
}
