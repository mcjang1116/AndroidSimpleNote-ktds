package com.mcjang.simplenote.notification;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.mcjang.simplenote.NotiToDetailActivity;
import com.mcjang.simplenote.R;
import com.mcjang.simplenote.vo.MemoVO;

/**
 * Created by Minchang on 2015-07-01.
 */
public class Notification {

    private static int REQ_CODE = 1000;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void sendNotification(Context context, MemoVO memoVO) {

        Intent intent = new Intent(context, NotiToDetailActivity.class);
        intent.putExtra("memo", memoVO);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        android.app.Notification.Builder builder = new android.app.Notification.Builder(context);
        builder.setContentTitle(memoVO.getSubject());
        builder.setContentText(memoVO.getContent());
        builder.setSmallIcon(R.drawable.logo);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());

        android.app.Notification notification = builder.build();
        notification.flags = notification.flags | android.app.Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(REQ_CODE++, notification);

    }

}
