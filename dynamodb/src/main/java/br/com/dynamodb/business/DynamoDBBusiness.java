
package br.com.dynamodb.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.dynamodb.entyties.ProductInfo;
import br.com.dynamodb.repositories.PageProductInfoRepository;
import br.com.dynamodb.repositories.ProductInfoRepository;

@Component
public class DynamoDBBusiness {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private PageProductInfoRepository pageProductInfoRepository;
	
	public void saveProduct(final ProductInfo productInfo) {
		productInfoRepository.save(productInfo);
	}
	
	public List<ProductInfo> getProductAll() {
		return (List<ProductInfo>) productInfoRepository.findAll();
	}
	
	public Page<ProductInfo> getProductAllPage(final Pageable pageable) {
		return pageProductInfoRepository.findAll(pageable);
	}
}