
package br.com.dynamodb.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dynamodb.entyties.ProductInfo;
import br.com.dynamodb.repositories.ProductInfoRepository;

@Component
public class DynamoDBBusiness {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public void saveProduct(final ProductInfo productInfo) {
		productInfoRepository.save(productInfo);
	}
}