package io.reactivex.rxjava3.internal.util;

import j00.j;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f55710a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f55711b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f55712c;

    /* renamed from: d  reason: collision with root package name */
    public int f55713d;

    /* renamed from: io.reactivex.rxjava3.internal.util.a$a  reason: collision with other inner class name */
    public interface C0656a<T> extends j<T> {
        boolean test(T t11);
    }

    public a(int i11) {
        this.f55710a = i11;
        Object[] objArr = new Object[(i11 + 1)];
        this.f55711b = objArr;
        this.f55712c = objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r4) {
        /*
            r3 = this;
            int r0 = r3.f55710a
            int r1 = r3.f55713d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f55712c
            r2[r0] = r1
            r3.f55712c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f55712c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f55713d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.a.a(java.lang.Object):void");
    }

    public void b(C0656a<? super T> aVar) {
        int i11 = this.f55710a;
        for (Object[] objArr = this.f55711b; objArr != null; objArr = objArr[i11]) {
            int i12 = 0;
            while (i12 < i11) {
                Object[] objArr2 = objArr[i12];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i12++;
                } else {
                    return;
                }
            }
        }
    }
}
