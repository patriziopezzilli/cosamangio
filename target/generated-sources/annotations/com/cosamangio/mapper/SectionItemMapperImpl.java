package com.cosamangio.mapper;

import com.cosamangio.dto.item.Item;
import com.cosamangio.entity.SectionItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-20T10:58:53+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class SectionItemMapperImpl implements SectionItemMapper {

    @Override
    public SectionItem mapToEntity(Item source) {
        if ( source == null ) {
            return null;
        }

        SectionItem sectionItem = new SectionItem();

        sectionItem.setId( source.getId() );
        sectionItem.setCode( source.getCode() );
        sectionItem.setTitle( source.getTitle() );
        sectionItem.setSubtitle( source.getSubtitle() );
        sectionItem.setDescription( source.getDescription() );
        sectionItem.setPrice( source.getPrice() );

        return sectionItem;
    }

    @Override
    public Item mapToDto(SectionItem destination) {
        if ( destination == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( destination.getId() );
        item.setCode( destination.getCode() );
        item.setTitle( destination.getTitle() );
        item.setSubtitle( destination.getSubtitle() );
        item.setDescription( destination.getDescription() );
        item.setPrice( destination.getPrice() );

        return item;
    }

    @Override
    public List<SectionItem> mapToEntities(List<Item> source) {
        if ( source == null ) {
            return null;
        }

        List<SectionItem> list = new ArrayList<SectionItem>( source.size() );
        for ( Item item : source ) {
            list.add( mapToEntity( item ) );
        }

        return list;
    }

    @Override
    public List<Item> mapToDtos(List<SectionItem> destination) {
        if ( destination == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( destination.size() );
        for ( SectionItem sectionItem : destination ) {
            list.add( mapToDto( sectionItem ) );
        }

        return list;
    }
}
