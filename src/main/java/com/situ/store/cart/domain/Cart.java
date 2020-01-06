package com.situ.store.cart.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.store.base.domain.BaseClass;

/**
 * 购物车类
 * 
 * @author Administrator
 *
 */
@Alias("Cart")
public class Cart extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;// 用户ID
	private String userName;// 用户姓名
	private String productNum;// 商品编号
	private Integer bayCount;// 购买数量
	private Integer totalPrices;// 商品总价

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getProductNum() {
		return productNum;
	}

	public Integer getBayCount() {
		return bayCount;
	}

	public Integer getTotalPrices() {
		return totalPrices;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public void setBayCount(Integer bayCount) {
		this.bayCount = bayCount;
	}

	public void setTotalPrices(Integer totalPrices) {
		this.totalPrices = totalPrices;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", userName=" + userName + ", productNum=" + productNum + ", bayCount="
				+ bayCount + ", totalPrices=" + totalPrices + "]";
	}

}
