package com.cosamangio.repository;

import com.cosamangio.entity.SectionEntity;
import com.cosamangio.entity.SectionItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionItemRepository extends MongoRepository<SectionItem, String> {
}
