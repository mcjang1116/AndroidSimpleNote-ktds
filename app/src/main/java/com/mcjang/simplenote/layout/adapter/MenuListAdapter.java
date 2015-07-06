package com.mcjang.simplenote.layout.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mcjang.simplenote.R;
import com.mcjang.simplenote.layout.MenuFragment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Minchang on 2015-07-01.
 */
public class MenuListAdapter extends BaseAdapter {

    private List<String> menus = null;
    private Fragment fragment;
    private Context context;

    public MenuListAdapter(Fragment fragment) {
        this.fragment = fragment;
        this.context = fragment.getActivity();
        this.menus = Arrays.asList(context.getResources().getStringArray(R.array.menus));
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MenuHolder holder = null;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_list, parent, false);

            holder = new MenuHolder();
            holder.menuItem = (TextView) convertView.findViewById(R.id.menuItem);
        }
        else {
            holder = (MenuHolder) convertView.getTag();
        }

        final int index = position;

        holder.menuItem.setText(getItem(position).toString());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MenuFragment)fragment).switchFragment(
                        ((MenuFragment) fragment).getFragment(index)
                );

            }
        });

        convertView.setTag(holder);

        return convertView;
    }

    private class MenuHolder {

        public TextView menuItem;

    }
}
