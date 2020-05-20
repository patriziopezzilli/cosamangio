package com.cosamangio.mapper;

import com.cosamangio.dto.social.Social;
import com.cosamangio.entity.SocialEntity;
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
public class SocialMapperImpl implements SocialMapper {

    @Override
    public SocialEntity mapToEntity(Social source) {
        if ( source == null ) {
            return null;
        }

        SocialEntity socialEntity = new SocialEntity();

        socialEntity.setId( source.getId() );
        socialEntity.setCode( source.getCode() );
        socialEntity.setName( source.getName() );
        socialEntity.setUrl( source.getUrl() );

        return socialEntity;
    }

    @Override
    public Social mapToDto(SocialEntity destination) {
        if ( destination == null ) {
            return null;
        }

        Social social = new Social();

        social.setId( destination.getId() );
        social.setCode( destination.getCode() );
        social.setName( destination.getName() );
        social.setUrl( destination.getUrl() );

        return social;
    }

    @Override
    public List<SocialEntity> mapToEntities(List<Social> source) {
        if ( source == null ) {
            return null;
        }

        List<SocialEntity> list = new ArrayList<SocialEntity>( source.size() );
        for ( Social social : source ) {
            list.add( mapToEntity( social ) );
        }

        return list;
    }

    @Override
    public List<Social> mapToDtos(List<SocialEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<Social> list = new ArrayList<Social>( destination.size() );
        for ( SocialEntity socialEntity : destination ) {
            list.add( mapToDto( socialEntity ) );
        }

        return list;
    }
}
