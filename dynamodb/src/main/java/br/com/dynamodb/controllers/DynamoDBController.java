
package br.com.dynamodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dynamodb.business.DynamoDBBusiness;
import br.com.dynamodb.dtos.Response;
import br.com.dynamodb.entyties.ProductInfo;

@RestController
@RequestMapping("${api.path}/prod")
@ResponseStatus(HttpStatus.OK)
public class DynamoDBController {

	@Autowired
	private DynamoDBBusiness dynamoDBBusiness;

	@PostMapping
	public Response<?> saveProduct(@Valid @RequestBody final ProductInfo productInfo) {
		dynamoDBBusiness.saveProduct(productInfo);
		return new Response<>();
	}

	@GetMapping("/all")
	public Response<List<ProductInfo>> getAllProduct() {
		final List<ProductInfo> productInfos = dynamoDBBusiness.getProductAll();
		return new Response<>(productInfos);
	}
	
	@GetMapping
	public Response<Page<ProductInfo>> getAllProductPage(final Pageable pageable) {
		final Page<ProductInfo> productInfos = dynamoDBBusiness.getProductAllPage(pageable);
		return new Response<>(productInfos);
	}
}