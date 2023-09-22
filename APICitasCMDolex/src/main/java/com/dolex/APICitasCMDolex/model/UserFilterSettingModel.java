package com.dolex.APICitasCMDolex.model;

public class UserFilterSettingModel {

	private int pageSize;
	private int pageNumber;
	private String sort;
	
	public UserFilterSettingModel() {}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
