package com.situ.store.indent.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.store.base.domain.PageData;
import com.situ.store.indent.dao.IndentDao;
import com.situ.store.indent.domain.Indent;
import com.situ.store.indent.service.IndentService;
import com.situ.store.util.JSONUtils;
import com.situ.store.util.PageUtils;

@Service
public class IndentServiceImpl implements IndentService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IndentDao indentDao;

	@Override
	public Long IndentSave(Indent indent, String createBy) {
		indent.setActiveFlag(1);
		indent.setCreateBy(createBy);
		indent.setCreateDate(new Date());
		return indentDao.save(indent);
	}

	@Override
	public List<Indent> findByPage(Integer pageNo, Indent searchIndent) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return indentDao.findByPage(searchIndent, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Indent searchIndent) {
		// 查询出数据总数
		Integer dataCount = indentDao.getCount(searchIndent);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Indent findOneById(Long rowId) {
		return indentDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Indent indent, String createBy) {
		indent.setUpdateBy(createBy);
		indent.setUpdateDate(new Date());
		indentDao.update(indent);
		return 1;
	}

	@Override
	public Integer doDelete(Long rowId) {
		indentDao.delete(rowId);
		return 1;
	}

	@Override
	public List<Indent> findAll() {
		return indentDao.findAll();
	}

	@Override
	public String checkCatalogName(String fieldId, String fieldValue) {
		Indent indent = indentDao.getByCode(fieldValue);
		Boolean bool = indent != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}


}
