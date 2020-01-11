package com.situ.store.catalog.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.base.domain.PageData;
import com.situ.store.catalog.dao.CatalogDao;
import com.situ.store.catalog.domain.Catalog;
import com.situ.store.catalog.service.CatalogService;
import com.situ.store.product.dao.ProductDao;
import com.situ.store.util.JSONUtils;
import com.situ.store.util.PageUtils;

@Service
public class CatalogServiceImpl implements Serializable, CatalogService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CatalogDao catalogDao;
	@Autowired
	private ProductDao productDao;

	@Override
	public Long catalogSave(Catalog catalog, String createBy) {
		Long parentCatalogId = catalog.getParentCatalogId();
		if (parentCatalogId == -1) {
			Long max = Long.parseLong(catalogDao.getAllCount().toString());
			catalog.setOrderBy(max + 1);
		} else {
			List<Catalog> catalogs = catalogDao.findByParentId(parentCatalogId);
			if (catalogs.size() != 0) {
				Catalog catalogmax = catalogs.get(catalogs.size()-1);
				Long max1 = catalogmax.getOrderBy();
				catalog.setOrderBy(max1 + 1);
				catalogDao.updateByOrder(max1);
			} else {
				Catalog parentCatalog = catalogDao.get(parentCatalogId);
				Long max2 = parentCatalog.getOrderBy();
				catalog.setOrderBy(max2 + 1);
				catalogDao.updateByOrder(max2);
			}
		}
		System.out.println(catalog.getOrderBy());
		catalog.setActiveFlag(1);
		catalog.setCreateBy(createBy);
		catalog.setCreateDate(new Date());
		return catalogDao.save(catalog);
	}

	@Override
	public List<Catalog> findByPage(Integer pageNo, Catalog searchCatalog) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return catalogDao.findByPage(searchCatalog, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Catalog searchCatalog) {
		// 查询出数据总数
		Integer dataCount = catalogDao.getCount(searchCatalog);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Catalog findOneById(Long rowId) {
		return catalogDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Catalog catalog, String createBy) {
		catalog.setUpdateBy(createBy);
		catalog.setUpdateDate(new Date());
		catalogDao.update(catalog);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		catalogDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Catalog> findAll() {
		return catalogDao.findAll();
	}

	@Override
	public String checkCatalogName(String fieldId, String fieldValue, Long parentCatalogId) {
		Catalog catalog = catalogDao.getByNameAndParentId(fieldValue, parentCatalogId);
		Boolean bool = catalog != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public List<Catalog> findAllByParentId(long parentCatalogId) {
		List<Catalog> list = catalogDao.findByParentId(parentCatalogId);
		for (Catalog catalog:list) {//遍历将一级目录下的二级目录放集合属性
			catalog.setCatalogList(catalogDao.findByParentId(catalog.getRowId()));
		}
		return list;
	}

	@Override
	public List<Catalog> findAllChild() {
		List<Catalog> list = catalogDao.findAllChild();
		for (Catalog catalog:list) {//遍历将一级目录下的商品信息放集合属性
			catalog.setProductList(productDao.findByCatalogId(catalog.getRowId()));
		}
		return list;
	}

}
