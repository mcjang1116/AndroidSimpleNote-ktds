package com.mcjang.simplenote.layout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.database.SimpleNoteDAO;
import com.mcjang.simplenote.layout.BaseActivity;
import com.mcjang.simplenote.layout.fragment.common.Title;
import com.mcjang.simplenote.notification.Notification;
import com.mcjang.simplenote.vo.MemoVO;

public class RegistrationSimpleMemoFragment extends SherlockFragment {

	private View v;

	private SimpleNoteDAO simpleNoteDAO;

	private EditText etSubject, etContent;
	private Button toggleNotiYN;
	private Button btnAddMemo;

	private boolean isNotiYN;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		isNotiYN = false;
		simpleNoteDAO = new SimpleNoteDAO(getActivity());
		v = inflater.inflate(R.layout.registration_simple_memo_fragment, container, false);
		BaseActivity.baseActivity.changeTitleBar(R.layout.action_bar_title_memo_regist);

		etSubject = (EditText) v.findViewById(R.id.etSubject);
		etContent = (EditText) v.findViewById(R.id.etContent);

		Title.setTitle(this, "메모등록");
		Title.hideKeyboard(this, (EditText) v.findViewById(R.id.etSubject));
		Title.hideKeyboard(this, (EditText) v.findViewById(R.id.etContent));
		Title.addMenuListener(this);

		return v;
	}

	public void addMemo() {
		MemoVO memoVO = new MemoVO();
		memoVO.setSubject(this.etSubject.getText().toString());
		memoVO.setContent(this.etContent.getText().toString());

		simpleNoteDAO.addMemo(memoVO);

		InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.etSubject.getWindowToken(), 0);

		Toast.makeText(getActivity(), "등록되었습니다.", Toast.LENGTH_SHORT).show();

		if(isNotiYN) {
			Notification.sendNotification(getActivity(), memoVO);
		}
	}

	public boolean setNotiYN() {
		isNotiYN = !isNotiYN;
		return isNotiYN;
	}

}