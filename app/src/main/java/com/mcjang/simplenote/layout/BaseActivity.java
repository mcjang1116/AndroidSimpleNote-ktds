package com.mcjang.simplenote.layout;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.actionbarsherlock.app.ActionBar;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.listener.TitleClickListener;

public class BaseActivity extends SlidingFragmentActivity {

	public static BaseActivity baseActivity;

	private Button btnToggle, addMemo, toggleNotiYN, doneModify, delete;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 액션바 설정
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.action_bar_title);

		getSupportActionBar().show();
		
		// 메뉴 토글 버튼 추가
		btnToggle = (Button) findViewById(R.id.btnToggle);
		btnToggle.setOnClickListener(new TitleClickListener(this));

		baseActivity = this;

	}

	public void changeTitleBar(int layout) {

		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(layout);

		getSupportActionBar().show();

		if(layout != R.layout.action_bar_title_memo_detail) {
			// 메뉴 토글 버튼 추가
			btnToggle = (Button) findViewById(R.id.btnToggle);
			btnToggle.setOnClickListener(new TitleClickListener(this));
		}

		if(layout == R.layout.action_bar_title_memo_regist) {
			addMemo = (Button) findViewById(R.id.addMemo);
			toggleNotiYN = (Button) findViewById(R.id.addMemo);
		}
		else if(layout == R.layout.action_bar_title_memo_modify) {
			doneModify = (Button) findViewById(R.id.doneModify);
		}
		else if(layout == R.layout.action_bar_title_memo_detail) {
			delete = (Button) findViewById(R.id.delete);
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent Data) { 
		super.onActivityResult(requestCode, resultCode, Data); 	
	}
	
	@Override 
	protected void onPostResume() {
	    super.onPostResume();
	}	
}
