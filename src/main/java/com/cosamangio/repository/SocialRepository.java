package com.cosamangio.repository;

import com.cosamangio.entity.SectionEntity;
import com.cosamangio.entity.SocialEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocialRepository extends MongoRepository<SocialEntity, String> {
}
