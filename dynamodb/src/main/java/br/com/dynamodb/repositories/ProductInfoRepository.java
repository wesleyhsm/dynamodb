package br.com.dynamodb.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.dynamodb.entyties.ProductInfo;

@EnableScan
public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {
     
    public List<ProductInfo> findByCost(final String cost);
    
}