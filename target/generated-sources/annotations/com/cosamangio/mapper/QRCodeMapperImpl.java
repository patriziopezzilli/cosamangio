package com.cosamangio.mapper;

import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.entity.QRCodeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-05T17:18:15+0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_252 (Amazon.com Inc.)"
)
@Component
public class QRCodeMapperImpl implements QRCodeMapper {

    @Override
    public QRCodeEntity mapToEntity(QRCode source) {
        if ( source == null ) {
            return null;
        }

        QRCodeEntity qRCodeEntity = new QRCodeEntity();

        qRCodeEntity.setCode( source.getCode() );
        qRCodeEntity.setMerchantCode( source.getMerchantCode() );
        qRCodeEntity.setPdfUrl( source.getPdfUrl() );

        return qRCodeEntity;
    }

    @Override
    public QRCode mapToDto(QRCodeEntity destination) {
        if ( destination == null ) {
            return null;
        }

        QRCode qRCode = new QRCode();

        qRCode.setCode( destination.getCode() );
        qRCode.setMerchantCode( destination.getMerchantCode() );
        qRCode.setPdfUrl( destination.getPdfUrl() );

        return qRCode;
    }

    @Override
    public List<QRCodeEntity> mapToEntities(List<QRCode> source) {
        if ( source == null ) {
            return null;
        }

        List<QRCodeEntity> list = new ArrayList<QRCodeEntity>( source.size() );
        for ( QRCode qRCode : source ) {
            list.add( mapToEntity( qRCode ) );
        }

        return list;
    }

    @Override
    public List<QRCode> mapToDtos(List<QRCodeEntity> destination) {
        if ( destination == null ) {
            return null;
        }

        List<QRCode> list = new ArrayList<QRCode>( destination.size() );
        for ( QRCodeEntity qRCodeEntity : destination ) {
            list.add( mapToDto( qRCodeEntity ) );
        }

        return list;
    }
}
