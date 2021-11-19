package com.global.thingspeakapp.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.global.thingspeakapp.R;

/**
 * Updated by Kim-ilguk on 24.9.2021.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

	@Override
	public void onCreatePreferences(Bundle bundle, String s) {

	}

}
