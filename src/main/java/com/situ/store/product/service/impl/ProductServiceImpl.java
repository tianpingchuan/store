package com.situ.store.product.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.store.base.domain.PageData;
import com.situ.store.product.dao.ProductDao;
import com.situ.store.product.domain.Product;
import com.situ.store.product.service.ProductService;
import com.situ.store.util.JSONUtils;
import com.situ.store.util.PageUtils;
import com.situ.store.util.UploadUtils;

@Service
public class ProductServiceImpl implements ProductService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductDao productDao;

	@Override
	public Long productSave(Product product,HttpServletRequest request, String createBy) {
		
		CommonsMultipartFile userFile = product.getProFile();
		String filePath = UploadUtils.buildUpload(userFile, request);

		product.setProductFile(filePath);
		product.setPutawayOrSoldOut(1);
		product.setActiveFlag(1);
		product.setCreateBy(createBy);
		product.setCreateDate(new Date());
		return productDao.save(product);
	}

	@Override
	public List<Product> findByPage(Integer pageNo, Product searchProduct) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return productDao.findByPage(searchProduct, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Product searchProduct) {
		// 查询出数据总数
		Integer dataCount = productDao.getCount(searchProduct);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Product findOneById(Long rowId) {
		return productDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Product product, HttpServletRequest request, String createBy) {
		CommonsMultipartFile userFile = product.getProFile();
		String filePath = UploadUtils.buildUpload(userFile, request);
		product.setProductFile(filePath);
		product.setUpdateBy(createBy);
		product.setUpdateDate(new Date());
		productDao.update(product);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		productDao.delete(rowId);
		return 1;
	}

	@Override
	public Integer doOut(Long rowId) {
		productDao.doOut(rowId);
		return 1;
	}

	@Override
	public Integer doPut(Long rowId) {
		productDao.doPut(rowId);
		return 1;
	}

	@Override
	public String checkProductName(String fieldId, String fieldValue) {
		Product product = productDao.getByName(fieldValue);
		Boolean bool = product != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public String checkProductNum(String fieldId, String fieldValue) {
		Product product = productDao.getByNum(fieldValue);
		Boolean bool = product != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findByNum(String productNum) {
		return productDao.getByNum(productNum);
	}

}
