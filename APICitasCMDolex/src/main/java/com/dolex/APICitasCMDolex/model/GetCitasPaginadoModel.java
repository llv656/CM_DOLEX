package com.dolex.APICitasCMDolex.model;

import java.util.List;

public class GetCitasPaginadoModel {
	
	private List<GetCitasModel> items;
	private int pages;
	private Long totalItems;
	
	public GetCitasPaginadoModel() {}
	
	public GetCitasPaginadoModel(List<GetCitasModel> items, int pages, Long totalItems) {
		this.items = items;
		this.pages = pages;
		this.totalItems = totalItems;
	}

	public List<GetCitasModel> getItems() {
		return items;
	}

	public void setItems(List<GetCitasModel> items) {
		this.items = items;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

}
