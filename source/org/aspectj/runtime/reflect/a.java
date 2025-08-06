package org.aspectj.runtime.reflect;

public abstract class a extends e {

    /* renamed from: k  reason: collision with root package name */
    public Class[] f58996k;

    /* renamed from: l  reason: collision with root package name */
    public String[] f58997l;

    /* renamed from: m  reason: collision with root package name */
    public Class[] f58998m;

    public a(int i11, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i11, str, cls);
        this.f58996k = clsArr;
        this.f58997l = strArr;
        this.f58998m = clsArr2;
    }

    public Class[] m() {
        if (this.f58998m == null) {
            this.f58998m = e(5);
        }
        return this.f58998m;
    }

    public Class[] n() {
        if (this.f58996k == null) {
            this.f58996k = e(3);
        }
        return this.f58996k;
    }
}
