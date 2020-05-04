package com.cosamangio.mapper;

import com.cosamangio.dto.menu.Menu;
import com.cosamangio.entity.MenuEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SectionMapper.class})
public interface MenuMapper {

    @Mappings({})
    MenuEntity mapToEntity(Menu source);

    @Mappings({})
    Menu mapToDto(MenuEntity destination);

    @InheritConfiguration
    List<MenuEntity> mapToEntities(List<Menu> source);

    @InheritConfiguration
    List<Menu> mapToDtos(List<MenuEntity> destination);
}
