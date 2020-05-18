package com.cosamangio.repository;

import com.cosamangio.entity.MerchantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MerchantRepository extends MongoRepository<MerchantEntity, String> {

    List<MerchantEntity> findByActive(Boolean active);

    MerchantEntity findByEmailAndActive(String email, Boolean active);

    MerchantEntity findByEmail(String email);

    MerchantEntity findByCode(String code);
}
