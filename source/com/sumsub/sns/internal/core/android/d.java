package com.sumsub.sns.internal.core.android;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

public final /* synthetic */ class d implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f31952a;

    public /* synthetic */ d(a aVar) {
        this.f31952a = aVar;
    }

    public final void onActivityResult(Object obj) {
        a.a(this.f31952a, (Uri) obj);
    }
}
