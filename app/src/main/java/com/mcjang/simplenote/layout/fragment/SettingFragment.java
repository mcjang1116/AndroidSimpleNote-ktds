package com.mcjang.simplenote.layout.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.BaseActivity;
import com.mcjang.simplenote.layout.fragment.common.Title;

public class SettingFragment extends SherlockFragment {

	private View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		v = inflater.inflate(R.layout.registration_simple_memo_fragment, container, false);
		BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title);

		Title.setTitle(this, "설정");
		
		return v;
	}

}