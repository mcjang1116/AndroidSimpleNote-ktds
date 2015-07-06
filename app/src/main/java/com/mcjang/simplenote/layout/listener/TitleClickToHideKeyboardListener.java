package com.mcjang.simplenote.layout.listener;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.mcjang.simplenote.layout.BaseActivity;

/**
 * Created by Minchang on 2015-07-01.
 */
public class TitleClickToHideKeyboardListener extends TitleClickListener implements View.OnClickListener {

    private EditText targetEditText;
    private Context context;

    public TitleClickToHideKeyboardListener(Context context, EditText targetEditText) {
        super(BaseActivity.baseActivity);
        this.targetEditText = targetEditText;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(targetEditText.getWindowToken(), 0);
    }
}
