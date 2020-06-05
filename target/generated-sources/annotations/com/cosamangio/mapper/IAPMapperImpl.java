package com.cosamangio.mapper;

import com.cosamangio.dto.iap.IAPPurchase;
import com.cosamangio.entity.IAPPurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-05T17:18:14+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class IAPMapperImpl implements IAPMapper {

    @Override
    public IAPPurchaseEntity mapToEntity(IAPPurchase source) {
        if ( source == null ) {
            return null;
        }

        IAPPurchaseEntity iAPPurchaseEntity = new IAPPurchaseEntity();

        iAPPurchaseEntity.setId( source.getId() );
        iAPPurchaseEntity.setIapCode( source.getIapCode() );
        iAPPurchaseEntity.setMerchantCode( source.getMerchantCode() );
        iAPPurchaseEntity.setPaid( source.getPaid() );

        return iAPPurchaseEntity;
    }

    @Override
    public IAPPurchase mapToDto(IAPPurchaseEntity destination) {
        if ( destination == null ) {
            return null;
        }

        IAPPurchase iAPPurchase = new IAPPurchase();

        iAPPurchase.setId( destination.getId() );
        iAPPurchase.setIapCode( destination.getIapCode() );
        iAPPurchase.setMerchantCode( destination.getMerchantCode() );
        iAPPurchase.setPaid( destination.getPaid() );

        return iAPPurchase;
    }

    @Override
    public List<IAPPurchaseEntity> mapToEntities(List<IAPPurchase> source) {
        if ( source == null ) {
            return null;
        }

        List<IAPPurchaseEntity> list = new ArrayList<IAPPurchaseEntity>( source.size() );
        for ( IAPPurchase iAPPurchase : source ) {
            list.add( mapToEntity( iAPPurchase ) );
        }

        return list;
    }

    @Override
    public List<IAPPurchase> mapToDtos(List<IAPPurchaseEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<IAPPurchase> list = new ArrayList<IAPPurchase>( destination.size() );
        for ( IAPPurchaseEntity iAPPurchaseEntity : destination ) {
            list.add( mapToDto( iAPPurchaseEntity ) );
        }

        return list;
    }
}
