package com.global.thingspeakapp.network;

import com.google.gson.annotations.SerializedName;
import com.global.thingspeakapp.model.Channel;
import com.global.thingspeakapp.model.Pagination;

import java.util.List;

/**
 * Updated by Kim-ilguk on 30.3.2021.
 */
public class PaginatedChannelResponce{

	@SerializedName("pagination")
	Pagination pagination;

	@SerializedName("channels")
	List<Channel> objects;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<Channel> getObjects() {
		return objects;
	}

	public void setObjects(List<Channel> objects) {
		this.objects = objects;
	}
}
