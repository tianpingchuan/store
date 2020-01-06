package com.situ.store.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.product.domain.Product;

@Repository
public interface ProductDao {

	Long save(Product product);

	List<Product> findByPage(@Param("searchProduct") Product searchProduct, @Param("firstResult") Integer firstResult,@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchProduct") Product searchProduct);
	
	Product get(Long rowId);

	void update(Product product);

	void delete(Long rowId);

	List<Product> findAll();

	Product getByName(String productName);
	
	Product getByNum(String fieldValue);

	void doOut(Long rowId);

	void doPut(Long rowId);

	List<Product> findByCatalogId(Long rowId);

}
