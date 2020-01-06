package com.situ.store.indent.service;

import java.util.List;

import com.situ.store.base.domain.PageData;
import com.situ.store.indent.domain.Indent;

public interface IndentService {

	Long IndentSave(Indent indent, String createBy);

	List<Indent> findByPage(Integer pageNo, Indent searchIndent);

	PageData buildPageData(Integer pageNo, Indent searchIndent);

	Indent findOneById(Long rowId);

	Integer doUpdate(Indent indent, String createBy);

	Integer doDelete(Long rowId);

	List<Indent> findAll();

	String checkCatalogName(String fieldId, String fieldValue);

}
