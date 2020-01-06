package com.situ.store.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.situ.store.base.domain.PageData;
import com.situ.store.product.domain.Product;

public interface ProductService {

	Long productSave(Product product, HttpServletRequest request, String createBy);

	List<Product> findByPage(Integer pageNo, Product searchProduct);

	PageData buildPageData(Integer pageNo, Product searchProduct);
	
	Product findOneById(Long rowId);

	Integer doUpdate(Product product, HttpServletRequest request, String createBy);

	Integer doDelete(Long rowId);

	Integer doOut(Long rowId);

	Integer doPut(Long rowId);

	String checkProductName(String fieldId, String fieldValue);

	String checkProductNum(String fieldId, String fieldValue);

	List<Product> findAll();

	Product findByNum(String productNum);

}
