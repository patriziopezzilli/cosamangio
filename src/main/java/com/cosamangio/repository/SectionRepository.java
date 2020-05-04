package com.cosamangio.repository;

import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.SectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<SectionEntity, String> {
}
