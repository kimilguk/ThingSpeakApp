package com.global.thingspeakapp.model;


/**
 * Updated by Kim-ilguk on 8.4.2021.
 */
public class ListStatusObject {

	public boolean isLoading = true;
	public String Message = "";

	public ListStatusObject(boolean isLoading, String message) {
		this.isLoading = isLoading;
		Message = message;
	}
}
