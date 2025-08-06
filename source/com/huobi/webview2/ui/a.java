package com.huobi.webview2.ui;

import androidx.activity.result.ActivityResult;
import d10.l;
import v6.v;

public final /* synthetic */ class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JumioKycHelper f20913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f20914b;

    public /* synthetic */ a(JumioKycHelper jumioKycHelper, l lVar) {
        this.f20913a = jumioKycHelper;
        this.f20914b = lVar;
    }

    public final void launcherResult(ActivityResult activityResult) {
        JumioKycHelper.d(this.f20913a, this.f20914b, activityResult);
    }
}
