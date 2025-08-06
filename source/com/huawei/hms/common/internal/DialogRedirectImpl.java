package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f37928a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37929b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f37930c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i11) {
        this.f37930c = intent;
        this.f37928a = activity;
        this.f37929b = i11;
    }

    public final void redirect() {
        Activity activity;
        Intent intent = this.f37930c;
        if (intent != null && (activity = this.f37928a) != null) {
            activity.startActivityForResult(intent, this.f37929b);
        }
    }
}
