package com.situ.store.indent.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.store.base.domain.BaseClass;

/**
 * 订单类
 * 
 * @author Administrator
 *
 */
@Alias("Indent")
public class Indent extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String indentCode;// 订单编号
	private Long userId;// 用户ID
	private String userName;// 用户名称
	private Long totalPrices;// 总价
	private Long addressId;// 收货地址ID
	private String trueAddress;// 详细收货地址
	private Integer indentState;// 订单状态：0：未发货,1：发货，2:收货
	private Integer payWay;// 支付方式1:支付宝，2:银行卡 3:微信

	public String getIndentCode() {
		return indentCode;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public Long getTotalPrices() {
		return totalPrices;
	}

	public Long getAddressId() {
		return addressId;
	}

	public String getTrueAddress() {
		return trueAddress;
	}

	public Integer getIndentState() {
		return indentState;
	}

	public Integer getPayWay() {
		return payWay;
	}

	public void setIndentCode(String indentCode) {
		this.indentCode = indentCode;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTotalPrices(Long totalPrices) {
		this.totalPrices = totalPrices;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void setTrueAddress(String trueAddress) {
		this.trueAddress = trueAddress;
	}

	public void setIndentState(Integer indentState) {
		this.indentState = indentState;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	@Override
	public String toString() {
		return "Indent [indentCode=" + indentCode + ", userId=" + userId + ", userName=" + userName + ", totalPrices="
				+ totalPrices + ", addressId=" + addressId + ", trueAddress=" + trueAddress + ", indentState="
				+ indentState + ", payWay=" + payWay + "]";
	}

}
