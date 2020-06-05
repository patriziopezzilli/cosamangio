package com.cosamangio.repository;

import com.cosamangio.entity.IAPPurchaseEntity;
import com.cosamangio.entity.QRCodeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAPRepository extends MongoRepository<IAPPurchaseEntity, String> {

    IAPPurchaseEntity findByMerchantCodeAndIapCode(String merchantCode, String iapCode);
}
