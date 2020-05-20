package com.cosamangio.mapper;

import com.cosamangio.dto.menu.Menu;
import com.cosamangio.entity.MenuEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-20T10:58:52+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public MenuEntity mapToEntity(Menu source) {
        if ( source == null ) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setId( source.getId() );
        menuEntity.setCode( source.getCode() );
        menuEntity.setLastUpdateDate( source.getLastUpdateDate() );
        menuEntity.setCurrency( source.getCurrency() );
        menuEntity.setPdf( source.getPdf() );
        menuEntity.setPdfUrl( source.getPdfUrl() );
        menuEntity.setLocale( source.getLocale() );
        menuEntity.setName( source.getName() );
        menuEntity.setSections( sectionMapper.mapToEntities( source.getSections() ) );

        return menuEntity;
    }

    @Override
    public Menu mapToDto(MenuEntity destination) {
        if ( destination == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setId( destination.getId() );
        menu.setCode( destination.getCode() );
        menu.setLastUpdateDate( destination.getLastUpdateDate() );
        menu.setCurrency( destination.getCurrency() );
        menu.setPdf( destination.getPdf() );
        menu.setPdfUrl( destination.getPdfUrl() );
        menu.setLocale( destination.getLocale() );
        menu.setName( destination.getName() );
        menu.setSections( sectionMapper.mapToDtos( destination.getSections() ) );

        return menu;
    }

    @Override
    public List<MenuEntity> mapToEntities(List<Menu> source) {
        if ( source == null ) {
            return null;
        }

        List<MenuEntity> list = new ArrayList<MenuEntity>( source.size() );
        for ( Menu menu : source ) {
            list.add( mapToEntity( menu ) );
        }

        return list;
    }

    @Override
    public List<Menu> mapToDtos(List<MenuEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<Menu> list = new ArrayList<Menu>( destination.size() );
        for ( MenuEntity menuEntity : destination ) {
            list.add( mapToDto( menuEntity ) );
        }

        return list;
    }
}
