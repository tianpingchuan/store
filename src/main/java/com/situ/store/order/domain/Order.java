package com.situ.store.order.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.store.base.domain.BaseClass;

/**
 * 订单列表类
 * 
 * @author Administrator
 *
 */
@Alias("Order")
public class Order extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String indentCode;// 订单编号
	private String productNum;// 商品编号
	private Integer bayCount;// 购买数量
	private Long totalPrices;// 商品总价

	public String getIndentCode() {
		return indentCode;
	}

	public void setIndentCode(String indentCode) {
		this.indentCode = indentCode;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public Integer getBayCount() {
		return bayCount;
	}

	public void setBayCount(Integer bayCount) {
		this.bayCount = bayCount;
	}

	public Long getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(Long totalPrices) {
		this.totalPrices = totalPrices;
	}

	@Override
	public String toString() {
		return "Order [indentCode=" + indentCode + ", productNum=" + productNum + ", bayCount=" + bayCount
				+ ", totalPrices=" + totalPrices + "]";
	}

}
