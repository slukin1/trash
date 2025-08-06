package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f37728j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static BinderAdapter f37729k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f37728j) {
            if (f37729k == null) {
                f37729k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f37729k;
        }
        return binderAdapter;
    }

    public int getConnTimeOut() {
        return 2001;
    }

    public int getMsgDelayDisconnect() {
        return 2002;
    }
}
