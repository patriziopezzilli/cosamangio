package com.cosamangio.mapper;

import com.cosamangio.dto.section.Section;
import com.cosamangio.entity.SectionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-05T17:18:14+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class SectionMapperImpl implements SectionMapper {

    @Autowired
    private SectionItemMapper sectionItemMapper;

    @Override
    public SectionEntity mapToEntity(Section source) {
        if ( source == null ) {
            return null;
        }

        SectionEntity sectionEntity = new SectionEntity();

        sectionEntity.setId( source.getId() );
        sectionEntity.setCode( source.getCode() );
        sectionEntity.setName( source.getName() );
        sectionEntity.setItemList( sectionItemMapper.mapToEntities( source.getItemList() ) );

        return sectionEntity;
    }

    @Override
    public Section mapToDto(SectionEntity destination) {
        if ( destination == null ) {
            return null;
        }

        Section section = new Section();

        section.setId( destination.getId() );
        section.setCode( destination.getCode() );
        section.setName( destination.getName() );
        section.setItemList( sectionItemMapper.mapToDtos( destination.getItemList() ) );

        return section;
    }

    @Override
    public List<SectionEntity> mapToEntities(List<Section> source) {
        if ( source == null ) {
            return null;
        }

        List<SectionEntity> list = new ArrayList<SectionEntity>( source.size() );
        for ( Section section : source ) {
            list.add( mapToEntity( section ) );
        }

        return list;
    }

    @Override
    public List<Section> mapToDtos(List<SectionEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<Section> list = new ArrayList<Section>( destination.size() );
        for ( SectionEntity sectionEntity : destination ) {
            list.add( mapToDto( sectionEntity ) );
        }

        return list;
    }
}
