package br.com.dynamodb.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.dynamodb.entyties.ProductInfo;

public interface PageProductInfoRepository extends PagingAndSortingRepository<ProductInfo, String> {

	public Page<ProductInfo> findByCost(final String cost, final Pageable pageable);
		
	@EnableScan
	@EnableScanCount
	public Page<ProductInfo> findAll(final Pageable pageable);
}
