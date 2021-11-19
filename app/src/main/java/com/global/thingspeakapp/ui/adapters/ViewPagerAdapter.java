package com.global.thingspeakapp.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Updated by Kim-ilguk on 25.4.2021.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	ArrayList<String> tabs = new ArrayList<>();
	ArrayList<Class<? extends Fragment>> fragments = new ArrayList<>();


	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public void addPage(String title, Class<? extends Fragment> fragmentClass){
		tabs.add(title);
		fragments.add(fragmentClass);
	}

	@Override
	public Fragment getItem(int position) {
		try {
			return fragments.get(position).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabs.get(position);
	}

	@Override
	public int getCount() {
		return tabs.size();
	}
}
