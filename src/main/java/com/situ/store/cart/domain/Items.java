package com.situ.store.cart.domain;

import java.io.Serializable;

public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	private String item_name;//商品的名字
	private Integer quantity;//购买的数量
	private Integer _total;//购买的总金额
	private Integer _amount;//商品的单价
	public String getItem_name() {
		return item_name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Integer get_total() {
		return _total;
	}
	public Integer get_amount() {
		return _amount;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void set_total(Integer _total) {
		this._total = _total;
	}
	public void set_amount(Integer _amount) {
		this._amount = _amount;
	}
	@Override
	public String toString() {
		return "Items [item_name=" + item_name + ", quantity=" + quantity + ", _total=" + _total + ", _amount="
				+ _amount + "]";
	}
	
}
