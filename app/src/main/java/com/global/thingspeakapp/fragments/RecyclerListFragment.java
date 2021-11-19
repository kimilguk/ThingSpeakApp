package com.global.thingspeakapp.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.model.ListStatusObject;
import com.global.thingspeakapp.ui.adapters.ListContentProvider;
import com.global.thingspeakapp.ui.views.RecyclerListView;

/**
 * Updated by Kim-ilguk on 25.3.2021.
 */
public abstract class RecyclerListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RecyclerListView.ScrollThresholdListener {

	protected RecyclerListView mRecyclerView;
	protected SwipeRefreshLayout mSwipeRefreshLayout;
	protected ListContentProvider mListContentProvider;
	private int mScrollThreshold = -1;

	public RecyclerListFragment(){

	}

	@Override
	public void onCreate(Bundle savedinstancestate){
		super.onCreate(savedinstancestate);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_recyclerlist, container, false);

		mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.SwipeRefresh);
		mSwipeRefreshLayout.setOnRefreshListener(this);
		int offset = getActivity().getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
		mSwipeRefreshLayout.setProgressViewOffset(false, offset / 2, offset + offset / 2);

		mRecyclerView = (RecyclerListView) v.findViewById(R.id.RecyclerListView);

		if(mListContentProvider != null) mRecyclerView.setListContentProvider(mListContentProvider);
		if(mScrollThreshold >= 0) mRecyclerView.addOnScrollThresholdListener(this);

		return v;
	}

	protected void setLoadMoreOnScroll(int threshold){
		mScrollThreshold = threshold;
	}

	@Override
	public void onResume(){
		super.onResume();
		//if(mRecyclerView != null && mRecyclerView.getAdapter() == null) mRecyclerView.setAdapter(mListAdapter);
	}

	@Override
	public void onSaveInstanceState(Bundle state){
		// TODO: save stuff here
		super.onSaveInstanceState(state);
	}

	@Override
	public void onStop(){
		super.onStop();
	}

	@Override
	public void onRefresh() {
		// this should be overridden
	}

	@Override
	public void onThresholdOverScrolled() {
		// this should be overridden
	}

	@Override
	public int getScrollThreshold() {
		return mScrollThreshold;
	}

	public void setStatus(ListStatusObject status){
		if(mRecyclerView != null) mRecyclerView.setStatus(status);
	}

	public void hideRefreshing() {
		if(mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()){
			mSwipeRefreshLayout.post(new Runnable() {
				@Override
				public void run() {
					mSwipeRefreshLayout.setRefreshing(false);
				}
			});
		}
	}
}
