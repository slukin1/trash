package com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class HomeWatcher {
    private Context mContext;
    private IntentFilter mFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private boolean mIsRegisted;
    /* access modifiers changed from: private */
    public OnHomePressedListener mListener;
    private InnerReceiver mReceiver = new InnerReceiver();

    public class InnerReceiver extends BroadcastReceiver {
        private static final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
        private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        public InnerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra("reason");
                if (HomeWatcher.this.mListener == null) {
                    return;
                }
                if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(stringExtra)) {
                    HomeWatcher.this.mListener.onHomePressed();
                } else if (SYSTEM_DIALOG_REASON_RECENT_APPS.equals(stringExtra)) {
                    HomeWatcher.this.mListener.onRecentAppsPressed();
                }
            }
        }
    }

    public interface OnHomePressedListener {
        void onHomePressed();

        void onRecentAppsPressed();
    }

    public HomeWatcher(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.mListener = onHomePressedListener;
    }

    public void startWatch() {
        InnerReceiver innerReceiver = this.mReceiver;
        if (innerReceiver != null && !this.mIsRegisted) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.mContext.registerReceiver(innerReceiver, this.mFilter, 2);
            } else {
                this.mContext.registerReceiver(innerReceiver, this.mFilter);
            }
            this.mIsRegisted = true;
        }
    }

    public void stopWatch() {
        try {
            InnerReceiver innerReceiver = this.mReceiver;
            if (innerReceiver != null) {
                this.mIsRegisted = false;
                this.mContext.unregisterReceiver(innerReceiver);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
