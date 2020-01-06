package com.situ.store.catalog.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.catalog.domain.Catalog;

public interface CatalogService {

	Long catalogSave(Catalog catalog, String createBy);

	List<Catalog> findByPage(Integer pageNo, Catalog searchCatalog);

	PageData buildPageData(Integer pageNo, Catalog searchCatalog);

	Catalog findOneById(Long rowId);

	Integer doUpdate(Catalog catalog, String createBy);

	Integer doDelete(Long rowId);

	List<Catalog> findAll();

	String checkCatalogName(String fieldId, String fieldValue, Long parentCatalogId);

	List<Catalog> findAllByParentId(long parentCatalogId);

}
