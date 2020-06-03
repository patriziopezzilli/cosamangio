package com.cosamangio.repository;

import com.cosamangio.entity.QRCodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QRCodeRepository extends MongoRepository<QRCodeEntity, String> {

    QRCodeEntity findByCode(String code);

    QRCodeEntity findByMerchantCode(String code);
}
