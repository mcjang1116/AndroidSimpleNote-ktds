package com.mcjang.simplenote.layout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.MainActivity;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.database.SimpleNoteDAO;
import com.mcjang.simplenote.layout.BaseActivity;
import com.mcjang.simplenote.layout.fragment.common.Title;
import com.mcjang.simplenote.vo.MemoVO;

public class MemoDetailFragment extends SherlockFragment {

	private View v;
	private TextView detailContent;
	private EditText editDetailContent;

	private MemoVO memoVO;

	public static MemoDetailFragment newInstance(MemoVO memoVO) {
		Bundle bundle = new Bundle();
		bundle.putSerializable("memo", memoVO);

		MemoDetailFragment f = new MemoDetailFragment();
		f.setArguments(bundle);
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.noti_to_detail_activity, container, false);
		BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title_memo_detail);

		editDetailContent = (EditText) v.findViewById(R.id.editDetailContent);
		detailContent = (TextView) v.findViewById(R.id.detailContent);
		Title.setTitle(this, "상세보기");

		Bundle bundle = getArguments();

		if(bundle != null) {

			memoVO = (MemoVO) bundle.getSerializable("memo");
			detailContent.setText(memoVO.getContent());
			Title.setTitle(this, memoVO.getSubject());
			Title.deleteMemo(this);

			detailContent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity(), "편집모드", Toast.LENGTH_SHORT).show();
					BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title_memo_modify);
					Title.setTitle(MemoDetailFragment.this, memoVO.getSubject());
					Title.modifyDone(MemoDetailFragment.this);
					detailContent.setVisibility(View.GONE);
					editDetailContent.setText(detailContent.getText());
					editDetailContent.setVisibility(View.VISIBLE);
				}
			});

		}

		return v;
	}

	public void deleteMemo() {
		super.onDestroyView();
		Toast.makeText(getActivity(), "삭제", Toast.LENGTH_SHORT).show();
		new SimpleNoteDAO(getActivity()).deleteMemo(memoVO.getId());
		((MainActivity) getActivity()).removeDetailContent();
	}

	public void modifyDone() {
		editDetailContent.setVisibility(View.GONE);

		detailContent.setText(editDetailContent.getText());
		detailContent.setVisibility(View.VISIBLE);

		InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.editDetailContent.getWindowToken(), 0);

		memoVO.setContent(editDetailContent.getText().toString());
		new SimpleNoteDAO(getActivity()).updateMemo(memoVO);

		BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title_memo_detail);
		Title.setTitle(MemoDetailFragment.this, memoVO.getSubject());

	}

}