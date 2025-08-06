package com.mob.commons.cc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;

public class i extends BroadcastReceiver implements t<i> {

    /* renamed from: a  reason: collision with root package name */
    private m f27135a;

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (this.f27135a != null) {
            try {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(intent);
                this.f27135a.a("onReceive", arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(m mVar) {
        this.f27135a = mVar;
    }

    public boolean a(i iVar, Class<i> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!"setHandler".equals(str) || objArr.length != 1 || objArr[0] == null || !(objArr[0] instanceof m)) {
            return false;
        }
        iVar.a(objArr[0]);
        return true;
    }
}
