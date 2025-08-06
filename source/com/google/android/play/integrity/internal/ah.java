package com.google.android.play.integrity.internal;

public final class ah implements al {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f66879a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile al f66880b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f66881c = f66879a;

    private ah(al alVar) {
        this.f66880b = alVar;
    }

    public static al b(al alVar) {
        return alVar instanceof ah ? alVar : new ah(alVar);
    }

    public final Object a() {
        Object obj = this.f66881c;
        Object obj2 = f66879a;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f66881c;
                if (obj == obj2) {
                    obj = this.f66880b.a();
                    Object obj3 = this.f66881c;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f66881c = obj;
                    this.f66880b = null;
                }
            }
        }
        return obj;
    }
}
