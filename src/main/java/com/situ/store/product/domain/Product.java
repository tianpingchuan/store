package com.situ.store.product.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.store.base.domain.BaseClass;

/**
 * 产品类
 * 
 * @author Administrator
 *
 */
@Alias("Product")
public class Product extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long catalogId;// 目录ID
	private String catalogName;// 目录名称
	private String productName;// 商品名称
	private String productNum;// 商品编号
//	CommonsMultipartFile
	private CommonsMultipartFile proFile;
	private String productFile;// 商品图片地址
	private Integer productPrice;// 商品价格
	private Integer productCount;// 商品库存数量
	private Integer putawayOrSoldOut;// 商品上下架状态1:上架，0：下架
	private String productIntro;// 商品介绍

	public Long getCatalogId() {
		return catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductNum() {
		return productNum;
	}

	public CommonsMultipartFile getProFile() {
		return proFile;
	}

	public String getProductFile() {
		return productFile;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public Integer getPutawayOrSoldOut() {
		return putawayOrSoldOut;
	}

	public String getProductIntro() {
		return productIntro;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public void setProFile(CommonsMultipartFile proFile) {
		this.proFile = proFile;
	}

	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public void setPutawayOrSoldOut(Integer putawayOrSoldOut) {
		this.putawayOrSoldOut = putawayOrSoldOut;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}

	@Override
	public String toString() {
		return "Product [catalogId=" + catalogId + ", catalogName=" + catalogName + ", productName=" + productName
				+ ", productNum=" + productNum + ", proFile=" + proFile + ", productFile=" + productFile
				+ ", productPrice=" + productPrice + ", productCount=" + productCount + ", putawayOrSoldOut="
				+ putawayOrSoldOut + ", productIntro=" + productIntro + "]";
	}

}
