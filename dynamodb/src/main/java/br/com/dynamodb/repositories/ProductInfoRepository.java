package br.com.dynamodb.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.dynamodb.entyties.ProductInfo;

@EnableScan
@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {
     
    public List<ProductInfo> findById(final String id);
        
}