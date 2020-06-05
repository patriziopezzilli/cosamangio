package com.cosamangio.repository;

import com.cosamangio.entity.MerchantEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MerchantRepository extends MongoRepository<MerchantEntity, String> {

    List<MerchantEntity> findByActiveAndGeoPointNear(Boolean active, Point p, Distance d);

    List<MerchantEntity> findByActive(Boolean active);

    MerchantEntity findByEmailAndActive(String email, Boolean active);

    MerchantEntity findByEmail(String email);

    MerchantEntity findByCode(String code);
}
