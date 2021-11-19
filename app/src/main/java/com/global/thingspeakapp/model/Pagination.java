package com.global.thingspeakapp.model;

/**
 * Updated by Kim-ilguk on 24.3.2021.
 */
public class Pagination {
	private int current_page;
	private int per_page;
	private int total_entries;

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal_entries() {
		return total_entries;
	}

	public void setTotal_entries(int total_entries) {
		this.total_entries = total_entries;
	}

	public boolean isLastPage(){
		return current_page >= (int) (Math.ceil(total_entries / per_page));
	}
}
