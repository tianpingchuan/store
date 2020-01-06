package com.situ.store.address.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.store.base.domain.BaseClass;

/**
 * 用户地址类
 * 
 * @author Administrator
 *
 */
@Alias("Address")
public class Address extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;// 用户ID
	private String userName;// 用户姓名
	private Long provinceCode;// 省（直辖市）CODE
	private String provinceName;// 省名称
	private Long cityCode;// 市CODE
	private String cityName;// 市名称
	private Long areaCode;// 区CODE
	private String areaName;// 县名称
	private String trueAddress;// 详细地址
	private Integer postCode;// 邮政编码
	private String userPhone;// 收货人电话

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public Long getProvinceCode() {
		return provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public Long getCityCode() {
		return cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public Long getAreaCode() {
		return areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getTrueAddress() {
		return trueAddress;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setProvinceCode(Long provinceCode) {
		this.provinceCode = provinceCode;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setTrueAddress(String trueAddress) {
		this.trueAddress = trueAddress;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "Address [userId=" + userId + ", userName=" + userName + ", provinceCode=" + provinceCode
				+ ", provinceName=" + provinceName + ", cityCode=" + cityCode + ", cityName=" + cityName + ", areaCode="
				+ areaCode + ", areaName=" + areaName + ", trueAddress=" + trueAddress + ", postCode=" + postCode
				+ ", userPhone=" + userPhone + "]";
	}

}
