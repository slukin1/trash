package com.mob.commons.cc;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.ArrayList;

public class k extends ContentObserver implements t<k> {

    /* renamed from: a  reason: collision with root package name */
    private m f27136a;

    public k() {
        super((Handler) null);
    }

    public void onChange(boolean z11) {
        if (this.f27136a != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(Boolean.valueOf(z11));
            this.f27136a.a("onChange", arrayList);
        }
    }

    public void a(m mVar) {
        this.f27136a = mVar;
    }

    public boolean a(k kVar, Class<k> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (!"setHandler".equals(str) || objArr.length != 1 || objArr[0] == null || !(objArr[0] instanceof m)) {
            return false;
        }
        kVar.a(objArr[0]);
        return true;
    }
}
