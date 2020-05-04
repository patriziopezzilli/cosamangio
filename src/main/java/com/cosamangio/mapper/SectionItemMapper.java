package com.cosamangio.mapper;

import com.cosamangio.dto.item.Item;
import com.cosamangio.entity.SectionItem;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionItemMapper {

    @Mappings({})
    SectionItem mapToEntity(Item source);

    @Mappings({})
    Item mapToDto(SectionItem destination);

    @InheritConfiguration
    List<SectionItem> mapToEntities(List<Item> source);

    @InheritConfiguration
    List<Item> mapToDtos(List<SectionItem> destination);
}
