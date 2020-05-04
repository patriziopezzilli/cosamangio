package com.cosamangio.repository;

import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.MerchantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<MenuEntity, String> {
}
