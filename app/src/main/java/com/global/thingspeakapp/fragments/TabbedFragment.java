package com.global.thingspeakapp.fragments;

import androidx.viewpager.widget.ViewPager;

/**
 * Updated by Kim-ilguk on 24.9.2021.
 */
public interface TabbedFragment {

	void setOnViewPagerReadyListener(ViewPagerReadyListener listener);
	ViewPager getViewPager();

	interface ViewPagerReadyListener {
		void onInitTabs(TabbedFragment source);
	}
}
