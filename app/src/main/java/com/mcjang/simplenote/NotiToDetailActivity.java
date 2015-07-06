package com.mcjang.simplenote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mcjang.simplenote.vo.MemoVO;

/**
 * Created by Minchang on 2015-07-01.
 */
public class NotiToDetailActivity extends Activity {

    private TextView detailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.noti_to_detail_activity);

        detailContent = (TextView) findViewById(R.id.detailContent);

        Intent intent = getIntent();
        MemoVO memoVO = (MemoVO) intent.getSerializableExtra("memo");
        setTitle(memoVO.getSubject());
        detailContent.setText(memoVO.getContent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        MemoVO memoVO = (MemoVO) intent.getSerializableExtra("memo");
        setTitle(memoVO.getSubject());
        detailContent.setText(memoVO.getContent());
    }
}
