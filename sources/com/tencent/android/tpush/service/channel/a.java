package com.tencent.android.tpush.service.channel;

import android.util.SparseArray;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f69648a = new a();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<Object> f69649b = new SparseArray<>();

    public a() {
    }

    public boolean a() {
        return ((Boolean) this.f69649b.get(2, Boolean.FALSE)).booleanValue();
    }

    public String b() {
        return (String) this.f69649b.get(0, "");
    }

    public int c() {
        return ((Integer) this.f69649b.get(1, 0)).intValue();
    }

    public a(Object... objArr) {
        for (int i11 = 0; i11 < objArr.length; i11 += 2) {
            this.f69649b.put(objArr[i11].intValue(), objArr[i11 + 1]);
        }
    }
}
