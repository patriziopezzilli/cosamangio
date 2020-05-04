package com.cosamangio.mapper;

import com.cosamangio.dto.merchant.Merchant;
import com.cosamangio.dto.social.Social;
import com.cosamangio.entity.MerchantEntity;
import com.cosamangio.entity.SocialEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocialMapper {

    @Mappings({})
    SocialEntity mapToEntity(Social source);

    @Mappings({})
    Social mapToDto(SocialEntity destination);

    @InheritConfiguration
    List<SocialEntity> mapToEntities(List<Social> source);

    @InheritConfiguration
    List<Social> mapToDtos(List<SocialEntity> destination);
}
