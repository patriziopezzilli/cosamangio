package com.cosamangio.mapper;

import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.entity.QRCodeEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QRCodeMapper {

    @Mappings({})
    QRCodeEntity mapToEntity(QRCode source);

    @Mappings({})
    QRCode mapToDto(QRCodeEntity destination);

    @InheritConfiguration
    List<QRCodeEntity> mapToEntities(List<QRCode> source);

    @InheritConfiguration
    List<QRCode> mapToDtos(List<QRCodeEntity> destination);
}
