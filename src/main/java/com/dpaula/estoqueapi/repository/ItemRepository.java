package com.dpaula.estoqueapi.repository;

import com.dpaula.estoqueapi.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}