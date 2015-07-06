package com.mcjang.simplenote.database;

import android.content.Context;
import android.database.Cursor;

import com.mcjang.simplenote.R;
import com.mcjang.simplenote.vo.MemoVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minchang on 2015-07-01.
 */
public class SimpleNoteDAO extends SQLiteHelper {

    public SimpleNoteDAO(Context context) {
        super(context);
    }

    public void addMemo(MemoVO memoVO) {
        String query = context.getString(R.string.INSERT_MEMO);
        query = String.format(query,
                DB_NAME,
                "'" + memoVO.getSubject() + "'",
                "'" + memoVO.getContent() + "'",
                "DATETIME('NOW', 'LOCALTIME')",
                "DATETIME('NOW', 'LOCALTIME')");
        getWritableDatabase().execSQL(query);
    }

    public List<MemoVO> getAllMemo() {
        String query = context.getString(R.string.SELECT_MEMO);
        query = String.format(query, DB_NAME);
        Cursor cursor = getReadableDatabase().rawQuery(query, null);

        List<MemoVO> memoVOList = new ArrayList<MemoVO>();

        MemoVO memoVO = null;
        while(cursor.moveToNext()) {
            memoVO = new MemoVO();
            memoVO.setId(cursor.getInt(0));
            memoVO.setSubject(cursor.getString(1));
            memoVO.setContent(cursor.getString(2));
            memoVO.setCreatedDate(cursor.getString(3));
            memoVO.setModifiedDate(cursor.getString(4));

            memoVOList.add(memoVO);
        }

        return memoVOList;
    }

    public void updateMemo(MemoVO memoVO) {
        String query = context.getString(R.string.UPDATE_MEMO);
        query = String.format(query, DB_NAME,
                "'" + memoVO.getSubject() + "'",
                "'" + memoVO.getContent() + "'",
                "DATETIME('NOW', 'LOCALTIME')",
                memoVO.getId());

        getWritableDatabase().execSQL(query);
    }

    public void deleteMemo(int id) {
        String query = context.getString(R.string.DELETE_MEMO);
        query = String.format(query, DB_NAME, id);
        getWritableDatabase().execSQL(query);
    }
}
