package com.global.thingspeakapp.ui.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.model.ListViewable;

/**
 * Updated by Kim-ilguk on 25.3.2021.
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder {

	protected View root;

	public ViewHolder(View itemView) {
		super(itemView);
		this.root = itemView;
	}

	public abstract void bind(ListViewable data);

	public static ViewHolder fromViewType(int viewType, View v) {
		switch (viewType){
			case R.layout.listitem_channel: return new ChannelViewHolder(v);
			default: throw new AssertionError("Invalid viewType, Did you remember to add the viewType in ViewHolder class?");
		}
	}
}
