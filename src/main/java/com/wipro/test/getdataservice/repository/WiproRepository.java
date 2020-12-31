package com.wipro.test.getdataservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.test.getdataservice.entity.WiproEmployee;


@Repository
public interface WiproRepository extends MongoRepository<WiproEmployee, Integer>{

}
