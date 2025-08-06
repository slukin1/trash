package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f69429a;

    /* renamed from: b  reason: collision with root package name */
    private long f69430b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f69431c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f69432d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f69433e = "";

    /* renamed from: f  reason: collision with root package name */
    private Context f69434f = null;

    /* renamed from: g  reason: collision with root package name */
    private Intent f69435g = null;

    public c(Context context, Intent intent) {
        this.f69434f = context.getApplicationContext();
        this.f69435g = intent;
    }

    public boolean a(PushMessageManager pushMessageManager, long j11, long j12, long j13) {
        return true;
    }
}
