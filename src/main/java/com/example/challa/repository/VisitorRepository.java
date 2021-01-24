package com.example.challa.repository;

import com.example.challa.model.User;
import com.example.challa.model.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitorRepository extends MongoRepository<Visitor, String> {
}
