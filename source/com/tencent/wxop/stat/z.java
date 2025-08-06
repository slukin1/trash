package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

final class z extends BroadcastReceiver {

    /* renamed from: cm  reason: collision with root package name */
    public final /* synthetic */ g f51107cm;

    public z(g gVar) {
        this.f51107cm = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (this.f51107cm.f51072be != null) {
            this.f51107cm.f51072be.a(new ae(this));
        }
    }
}
