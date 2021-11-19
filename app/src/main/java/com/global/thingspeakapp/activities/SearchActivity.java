package com.global.thingspeakapp.activities;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.ui.adapters.ViewPagerAdapter;
import com.global.thingspeakapp.ui.views.SlidingTabLayout;
import com.global.thingspeakapp.ui.views.SuggestionSearchView;

/**
 * Updated by Kim-ilguk on 31.3.2021.
 */
public class SearchActivity extends AppCompatActivity implements SuggestionSearchView.SuggestionSearchViewCallbacks{

	Toolbar mToolbar;
	SlidingTabLayout mTabs;
	ViewPager mViewPager;
	ViewPagerAdapter mAdapter;
	SuggestionSearchView mSearchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabs = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		mSearchView = (SuggestionSearchView) findViewById(R.id.toolbarSearchInput);

		mSearchView.setSuggestionTable("search_suggestions");
		mSearchView.setCallbacksListener(this);
		mSearchView.setMinQueryLength(3);

		mAdapter = new ViewPagerAdapter(getSupportFragmentManager());

		//mAdapter.addTab(new NavItemFragment("by user", null, PublicChannelsFragment.class));
		//mAdapter.addTab(new NavItemFragment("by tag", null, PublicChannelsFragment.class));

		mViewPager.setAdapter(mAdapter);

		mTabs.setDistributeEvenly(true);
		mTabs.setViewPager(mViewPager);


		// TODO: Read parameters here "searchTerm", "type=tag/user"
		// to use with activity that has url scheme use getIntent().getDataString() and parse as url.
		// to get intent extras use getIntent().getExtras().containsKey("type")

	}

	@Override
	public void onSubmit(String query) {
		Log.d("Search","query=\""+query+"\"");
		//Todo: pass the query to a <? extends RecyclerListFragment>
	}

	@Override
	public void onCleared() {
		Log.d("Search","cleared");
	}
}
