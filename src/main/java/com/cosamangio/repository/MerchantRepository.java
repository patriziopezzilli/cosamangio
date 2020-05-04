package com.cosamangio.repository;

import com.cosamangio.entity.MerchantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<MerchantEntity, String> {

    MerchantEntity findByEmailAndActive(String email, Boolean active);
}
