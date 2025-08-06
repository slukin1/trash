package com.mob.commons.cc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;

public class p implements ServiceConnection, t<p> {

    /* renamed from: a  reason: collision with root package name */
    private m f27140a;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f27140a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(componentName);
                arrayList.add(iBinder);
                this.f27140a.a("onServiceConnected", arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f27140a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(componentName);
            this.f27140a.a("onServiceDisconnected", arrayList);
        }
    }

    public void a(m mVar) {
        this.f27140a = mVar;
    }

    public boolean a(p pVar, Class<p> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!"setHandler".equals(str) || objArr.length != 1) {
            return false;
        }
        pVar.a(objArr[0]);
        return true;
    }
}
