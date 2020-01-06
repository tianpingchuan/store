package com.situ.store.catalog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.store.catalog.domain.Catalog;

@Repository
public interface CatalogDao {

	
	Long save(Catalog catalog);

	List<Catalog> findByPage(@Param("searchCatalog") Catalog searchCatalog, @Param("firstResult") Integer firstResult,@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchCatalog") Catalog searchCatalog);
	
	Catalog get(Long rowId);

	void update(Catalog catalog);

	void delete(Long rowId);

	List<Catalog> findAll();

	Catalog getByNameAndParentId(@Param("catalogName")String catalogName, @Param("parentCatalogId")Long parentCatalogId);

	Integer getAllCount();

	List<Catalog> findByParentIdAndOrder(@Param("parentCatalogId")Long parentCatalogId, @Param("orderBy")Long orderBy);

	List<Catalog> findByParentId(Long parentCatalogId);

	void updateByOrder(Long orderBy);

	List<Catalog> findAllChild();
}
