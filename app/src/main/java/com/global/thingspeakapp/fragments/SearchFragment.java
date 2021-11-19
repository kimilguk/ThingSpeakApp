package com.global.thingspeakapp.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.ui.adapters.ViewPagerAdapter;

/**
 * Updated by Kim-ilguk on 24.9.2021.
 */
public class SearchFragment extends Fragment implements TabbedFragment {

	ViewPager mViewPager;
	ViewPagerAdapter mAdapter;
	ViewPagerReadyListener listener;

	@Override
	public void setOnViewPagerReadyListener(ViewPagerReadyListener listener) {
		this.listener = listener;
	}

	@Override
	public ViewPager getViewPager() {
		return mViewPager;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_search, container, false);
		mViewPager = (ViewPager) v.findViewById(R.id.viewpager);

		mAdapter = new ViewPagerAdapter(getChildFragmentManager());
		mAdapter.addPage("by tag", PublicChannelsFragment.class);
		mAdapter.addPage("by user", PublicChannelsFragment.class);

		mViewPager.setAdapter(mAdapter);
		if (listener != null) listener.onInitTabs(this);

		return v;
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		listener = null;
	}
}
