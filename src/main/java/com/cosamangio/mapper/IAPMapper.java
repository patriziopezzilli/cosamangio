package com.cosamangio.mapper;

import com.cosamangio.dto.iap.IAPPurchase;
import com.cosamangio.dto.qrcode.QRCode;
import com.cosamangio.entity.IAPPurchaseEntity;
import com.cosamangio.entity.QRCodeEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAPMapper {

    @Mappings({})
    IAPPurchaseEntity mapToEntity(IAPPurchase source);

    @Mappings({})
    IAPPurchase mapToDto(IAPPurchaseEntity destination);

    @InheritConfiguration
    List<IAPPurchaseEntity> mapToEntities(List<IAPPurchase> source);

    @InheritConfiguration
    List<IAPPurchase> mapToDtos(List<IAPPurchaseEntity> destination);
}
