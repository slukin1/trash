package com.hbg.module.libkt.utils;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class j implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f24905a;

    public /* synthetic */ j(Activity activity) {
        this.f24905a = activity;
    }

    public final void onComplete(Task task) {
        l.d(this.f24905a, task);
    }
}
