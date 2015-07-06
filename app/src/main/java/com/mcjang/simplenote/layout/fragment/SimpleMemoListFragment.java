package com.mcjang.simplenote.layout.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.database.SimpleNoteDAO;
import com.mcjang.simplenote.layout.BaseActivity;
import com.mcjang.simplenote.layout.adapter.MemoListAdapter;
import com.mcjang.simplenote.layout.fragment.common.Title;

public class SimpleMemoListFragment extends SherlockFragment {

	private SimpleNoteDAO simpleNoteDAO;

	private ListView memoList;

	private View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		simpleNoteDAO = new SimpleNoteDAO(getActivity());

		v = inflater.inflate(R.layout.simple_memo_list_fragment, container, false);
		BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title);
		Title.setTitle(this, "메모보기");

		memoList = (ListView) v.findViewById(R.id.memoList);
		memoList.setAdapter(new MemoListAdapter(getActivity(), simpleNoteDAO.getAllMemo()));

		return v;
	}


}