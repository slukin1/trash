package com.sumsub.sentry.android;

import android.content.Context;
import android.os.Process;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f30280a = new g();

    public final boolean a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
