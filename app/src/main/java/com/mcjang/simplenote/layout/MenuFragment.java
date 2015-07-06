package com.mcjang.simplenote.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.MainActivity;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.adapter.MenuListAdapter;
import com.mcjang.simplenote.layout.fragment.RegistrationSimpleMemoFragment;
import com.mcjang.simplenote.layout.fragment.SimpleMemoListFragment;

import java.util.ArrayList;

public class MenuFragment extends SherlockFragment {

	ListView listView;
	ArrayList<String> alItems;


	public MenuFragment() {
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.menu_frame, container, false);

		// 기본 변수 선언
		listView = (ListView) v.findViewById(R.id.list);
		listView.setAdapter(new MenuListAdapter(this));

		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	public Fragment getFragment(int index) {

		Fragment newContent = null;

		switch (index) {
			case 0:
				newContent = new SimpleMemoListFragment();
				break;
			case 1:
				newContent = new RegistrationSimpleMemoFragment();
				break;
		}

		return newContent;
	}

	public void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		}
	}
}