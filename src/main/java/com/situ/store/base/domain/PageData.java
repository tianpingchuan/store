package com.situ.store.base.domain;

import java.io.Serializable;
import java.util.List;

public class PageData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer beginIndex;// 开始记录
	private Integer endIndex;// 结束记录
	private Integer countIndex;// 总数记录
	private Integer pageCurrent;// 当前的页号
	private Integer pageMaxNo;// 最大的页号
	private List<Integer> pageList;// 分页集合

	public PageData(Integer beginIndex, Integer endIndex, Integer countIndex, Integer pageCurrent, Integer pageMaxNo,
			List<Integer> pageList) {
		super();
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		this.countIndex = countIndex;
		this.pageCurrent = pageCurrent;
		this.pageMaxNo = pageMaxNo;
		this.pageList = pageList;
	}

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getCountIndex() {
		return countIndex;
	}

	public void setCountIndex(Integer countIndex) {
		this.countIndex = countIndex;
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getPageMaxNo() {
		return pageMaxNo;
	}

	public void setPageMaxNo(Integer pageMaxNo) {
		this.pageMaxNo = pageMaxNo;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

}
