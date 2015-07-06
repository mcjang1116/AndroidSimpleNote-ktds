package com.mcjang.simplenote.layout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mcjang.simplenote.MainActivity;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.fragment.MemoDetailFragment;
import com.mcjang.simplenote.vo.MemoVO;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Minchang on 2015-07-01.
 */
public class MemoListAdapter extends BaseAdapter {

    private Context context;
    private List<MemoVO> memoVOList;

    public MemoListAdapter(Context context, List<MemoVO> memoVOList) {
        this.context = context;
        this.memoVOList = memoVOList;
    }

    @Override
    public int getCount() {
        return memoVOList.size();
    }

    @Override
    public Object getItem(int position) {
        return memoVOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoItemHolder memoItemHolder = null;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.memo_item, parent, false);

            memoItemHolder = new MemoItemHolder();
            memoItemHolder.subject = (TextView) convertView.findViewById(R.id.subject);
            memoItemHolder.crtDt = (TextView) convertView.findViewById(R.id.crtDt);
            memoItemHolder.mdfyDt = (TextView) convertView.findViewById(R.id.mdfyDt);
        }
        else {
            memoItemHolder = (MemoItemHolder) convertView.getTag();
        }

        final MemoVO memoVO = (MemoVO) getItem(position);

        String[] createDate = memoVO.getCreatedDate().split(" ");
        String[] modifiedDate = memoVO.getModifiedDate().split(" ");;

        String[] createDateArr = createDate[0].split("-");
        String[] modifiedDateArr = modifiedDate[0].split("-");

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        boolean isCreateToday = false;

        if( year == Integer.parseInt(createDateArr[0]) ) {
            if( month == Integer.parseInt(createDateArr[1]) ) {
                if( day == Integer.parseInt(createDateArr[2]) ) {
                    isCreateToday = true;
                }
            }
        }

        boolean isModifiedToday = false;
        if( year == Integer.parseInt(modifiedDateArr[0]) ) {
            if( month == Integer.parseInt(modifiedDateArr[1]) ) {
                if( day == Integer.parseInt(modifiedDateArr[2]) ) {
                    isModifiedToday = true;
                }
            }
        }

        if(isCreateToday) {
            memoItemHolder.crtDt.setText(createDate[1]);
        }
        else {
            memoItemHolder.crtDt.setText(createDate[0]);
        }

        if(isModifiedToday) {
            memoItemHolder.mdfyDt.setText(modifiedDate[1]);
        }
        else {
            memoItemHolder.mdfyDt.setText(modifiedDate[0]);
        }

        memoItemHolder.subject.setText(memoVO.getSubject());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).switchDetailContent(MemoDetailFragment.newInstance(memoVO));
            }
        });



        convertView.setTag(memoItemHolder);
        return convertView;
    }

    public class MemoItemHolder {

        public TextView subject;
        public TextView crtDt;
        public TextView mdfyDt;

    }
}
