package com.dericon.financial.repositories;

import com.dericon.financial.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    public List<Product> findTop10ByOrderByFiguresSideYieldPaDesc();

    @Query(fields="{ 'derived.issuer.name' : 1, 'derived.underlying.name' : 1, 'ids.isin' : 1, 'figures.sideYieldPa' : 1}")
    List<Product> findByOrderByDerived();

}


