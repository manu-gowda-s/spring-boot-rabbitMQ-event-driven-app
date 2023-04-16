package com.manu.s.stockservice.repo;

import com.manu.s.stockservice.entity.StockDetails;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StockDetailsRepository extends MongoRepository<StockDetails, String>
{

}
