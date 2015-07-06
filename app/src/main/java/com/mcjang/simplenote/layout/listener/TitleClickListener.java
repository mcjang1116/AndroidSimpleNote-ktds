package com.mcjang.simplenote.layout.listener;

import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by Minchang on 2015-07-01.
 */
public class TitleClickListener implements View.OnClickListener {

    protected SlidingFragmentActivity activity;

    public TitleClickListener(SlidingFragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.toggle();
    }
}
