package com.cosamangio.mapper;

import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.entity.MerchantEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MenuMapper.class, SocialMapper.class})
public interface MerchantMapper {

    @Mappings({})
    MerchantEntity mapToEntity(Merchant source);

    @Mappings({})
    Merchant mapToDto(MerchantEntity destination);

    @InheritConfiguration
    List<MerchantEntity> mapToEntities(List<Merchant> source);

    @InheritConfiguration
    List<Merchant> mapToDtos(List<MerchantEntity> destination);
}
