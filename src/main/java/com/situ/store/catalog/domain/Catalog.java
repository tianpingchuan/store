package com.situ.store.catalog.domain;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.situ.store.base.domain.BaseClass;

/**
 * 商品目录类
 * 
 * @author Administrator
 *
 */
@Alias("Catalog")
public class Catalog extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long parentCatalogId;// 父级目录ID，最高级目录默认为-1，
	private String catalogInfo;// 目录介绍
	private String catalogName;// 目录名称
	private Long orderBy;//树形结构排序
	
	private List<Catalog> catalogList;//存放一级目录下的二级目录

	public List<Catalog> getCatalogList() {
		return catalogList;
	}

	public void setCatalogList(List<Catalog> catalogList) {
		this.catalogList = catalogList;
	}

	public Long getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

	public Long getParentCatalogId() {
		return parentCatalogId;
	}

	public String getCatalogInfo() {
		return catalogInfo;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setParentCatalogId(Long parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}

	public void setCatalogInfo(String catalogInfo) {
		this.catalogInfo = catalogInfo;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@Override
	public String toString() {
		return "Catalog [parentCatalogId=" + parentCatalogId + ", catalogInfo=" + catalogInfo + ", catalogName="
				+ catalogName + ", orderBy=" + orderBy + "]";
	}



}
