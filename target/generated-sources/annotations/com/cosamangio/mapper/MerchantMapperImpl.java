package com.cosamangio.mapper;

import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.entity.MerchantEntity;
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
public class MerchantMapperImpl implements MerchantMapper {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private SocialMapper socialMapper;

    @Override
    public MerchantEntity mapToEntity(Merchant source) {
        if ( source == null ) {
            return null;
        }

        MerchantEntity merchantEntity = new MerchantEntity();

        merchantEntity.setId( source.getId() );
        merchantEntity.setRating( source.getRating() );
        merchantEntity.setCode( source.getCode() );
        merchantEntity.setName( source.getName() );
        merchantEntity.setShortName( source.getShortName() );
        merchantEntity.setVatCode( source.getVatCode() );
        List<String> list = source.getAllergens();
        if ( list != null ) {
            merchantEntity.setAllergens( new ArrayList<String>( list ) );
        }
        merchantEntity.setEmail( source.getEmail() );
        merchantEntity.setDescription( source.getDescription() );
        merchantEntity.setValidationCode( source.getValidationCode() );
        merchantEntity.setValidated( source.getValidated() );
        merchantEntity.setAddress( source.getAddress() );
        merchantEntity.setLatitude( source.getLatitude() );
        merchantEntity.setLongitude( source.getLongitude() );
        List<String> list1 = source.getTags();
        if ( list1 != null ) {
            merchantEntity.setTags( new ArrayList<String>( list1 ) );
        }
        merchantEntity.setSocials( socialMapper.mapToEntities( source.getSocials() ) );
        merchantEntity.setPhotoUrl( source.getPhotoUrl() );
        merchantEntity.setWeeklyMenuActive( source.getWeeklyMenuActive() );
        merchantEntity.setDailyMenuActive( source.getDailyMenuActive() );
        merchantEntity.setActive( source.getActive() );
        merchantEntity.setMenus( menuMapper.mapToEntities( source.getMenus() ) );

        return merchantEntity;
    }

    @Override
    public Merchant mapToDto(MerchantEntity destination) {
        if ( destination == null ) {
            return null;
        }

        Merchant merchant = new Merchant();

        List<String> list = destination.getAllergens();
        if ( list != null ) {
            merchant.setAllergens( new ArrayList<String>( list ) );
        }
        merchant.setActive( destination.getActive() );
        merchant.setRating( destination.getRating() );
        merchant.setId( destination.getId() );
        merchant.setCode( destination.getCode() );
        merchant.setName( destination.getName() );
        merchant.setShortName( destination.getShortName() );
        merchant.setVatCode( destination.getVatCode() );
        merchant.setEmail( destination.getEmail() );
        merchant.setValidationCode( destination.getValidationCode() );
        merchant.setValidated( destination.getValidated() );
        merchant.setDescription( destination.getDescription() );
        merchant.setAddress( destination.getAddress() );
        merchant.setLatitude( destination.getLatitude() );
        merchant.setLongitude( destination.getLongitude() );
        List<String> list1 = destination.getTags();
        if ( list1 != null ) {
            merchant.setTags( new ArrayList<String>( list1 ) );
        }
        merchant.setSocials( socialMapper.mapToDtos( destination.getSocials() ) );
        merchant.setPhotoUrl( destination.getPhotoUrl() );
        merchant.setWeeklyMenuActive( destination.getWeeklyMenuActive() );
        merchant.setDailyMenuActive( destination.getDailyMenuActive() );
        merchant.setMenus( menuMapper.mapToDtos( destination.getMenus() ) );

        return merchant;
    }

    @Override
    public List<MerchantEntity> mapToEntities(List<Merchant> source) {
        if ( source == null ) {
            return null;
        }

        List<MerchantEntity> list = new ArrayList<MerchantEntity>( source.size() );
        for ( Merchant merchant : source ) {
            list.add( mapToEntity( merchant ) );
        }

        return list;
    }

    @Override
    public List<Merchant> mapToDtos(List<MerchantEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<Merchant> list = new ArrayList<Merchant>( destination.size() );
        for ( MerchantEntity merchantEntity : destination ) {
            list.add( mapToDto( merchantEntity ) );
        }

        return list;
    }
}
