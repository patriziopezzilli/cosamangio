package com.cosamangio.repository;

import com.cosamangio.entity.QRCodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QRCodeRepository extends MongoRepository<QRCodeEntity, String> {

    QRCodeEntity findByCode(String code);

    List<QRCodeEntity> findByMerchantCode(String code);
}
