package com.cosamangio.mapper;

import com.cosamangio.dto.menu.Menu;
import com.cosamangio.dto.section.Section;
import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.SectionEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SectionItemMapper.class})
public interface SectionMapper {

    @Mappings({})
    SectionEntity mapToEntity(Section source);

    @Mappings({})
    Section mapToDto(SectionEntity destination);

    @InheritConfiguration
    List<SectionEntity> mapToEntities(List<Section> source);

    @InheritConfiguration
    List<Section> mapToDtos(List<SectionEntity> destination);
}
