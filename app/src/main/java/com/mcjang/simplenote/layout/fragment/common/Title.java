package com.mcjang.simplenote.layout.fragment.common;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.fragment.MemoDetailFragment;
import com.mcjang.simplenote.layout.fragment.RegistrationSimpleMemoFragment;
import com.mcjang.simplenote.layout.listener.TitleClickToHideKeyboardListener;

/**
 * Created by Minchang on 2015-07-01.
 */
public class Title {

    public static void setTitle(SherlockFragment sherlockFragment, String title) {
        TextView textTitleBar = (TextView) sherlockFragment.getSherlockActivity().findViewById(R.id.textTitle);
        textTitleBar.setText(title);
    }

    public static void hideKeyboard(SherlockFragment sherlockFragment, EditText editText) {
        Button button = (Button) sherlockFragment.getSherlockActivity().findViewById(R.id.btnToggle);
        button.setOnClickListener(new TitleClickToHideKeyboardListener(sherlockFragment.getSherlockActivity(), editText));
    }

    public static void deleteMemo(final SherlockFragment sherlockFragment) {
        Button delete = (Button) sherlockFragment.getSherlockActivity().findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MemoDetailFragment) sherlockFragment).deleteMemo();
            }
        });
    }

    public static void modifyDone(final SherlockFragment sherlockFragment) {
        Button doneModify = (Button) sherlockFragment.getSherlockActivity().findViewById(R.id.doneModify);
        doneModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MemoDetailFragment) sherlockFragment).modifyDone();
            }
        });
    }

    public static void addMenuListener(final SherlockFragment sherlockFragment) {

        Button add = (Button) sherlockFragment.getSherlockActivity().findViewById(R.id.addMemo);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegistrationSimpleMemoFragment) sherlockFragment).addMemo();
            }
        });

        final Button toggleYN = (Button) sherlockFragment.getSherlockActivity().findViewById(R.id.toggleNotiYN);
        toggleYN.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                boolean isNotiYN = ((RegistrationSimpleMemoFragment) sherlockFragment).setNotiYN();

                if(isNotiYN) {
                    toggleYN.setBackground(((RegistrationSimpleMemoFragment) sherlockFragment).getResources().getDrawable(R.drawable.ic_star_white_24dp));
                }
                else {
                    toggleYN.setBackground(((RegistrationSimpleMemoFragment) sherlockFragment).getResources().getDrawable(R.drawable.ic_star_border_white_24dp));
                }
            }
        });
    }
}
