package com.global.thingspeakapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.model.ListStatusObject;
import com.global.thingspeakapp.ui.holder.ListStatusViewHolder;
import com.global.thingspeakapp.ui.holder.ViewHolder;
import com.global.thingspeakapp.ui.views.RecyclerListView;

/**
 * Updated by Kim-ilguk on 25.3.2021.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

	private ListContentProvider mListContentProvider;
	private ListStatusObject status;

	public RecyclerListAdapter(ListContentProvider provider){
		this.mListContentProvider = provider;
		mListContentProvider.setAdapter(this);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
		if(viewType == R.layout.listitem_status) return new ListStatusViewHolder(v);
		return ViewHolder.fromViewType(viewType, v);
	}

	@Override
	public void onBindViewHolder(RecyclerListView.ViewHolder holder, int position) {
		if(holder instanceof ListStatusViewHolder){
			((ListStatusViewHolder)holder).bind(status); //R.layout.listitem_status
		}else if(holder instanceof ViewHolder){
			((ViewHolder)holder).bind(mListContentProvider.get(position));
		}
	}

	@Override
	public int getItemViewType(int pos) {
		if(pos == mListContentProvider.size()) return R.layout.listitem_status;
		return mListContentProvider.get(pos).getViewType();
	}

		@Override
	public int getItemCount() {
		return mListContentProvider.size() + 1; // Status object
	}

	public void setStatus(ListStatusObject status) {
		this.status = status;
		notifyItemChanged(mListContentProvider.size()); // Notify that the last object has changed
	}
}
