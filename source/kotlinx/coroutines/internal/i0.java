package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.f2;

public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f57314a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f57315b;

    /* renamed from: c  reason: collision with root package name */
    public final f2<Object>[] f57316c;

    /* renamed from: d  reason: collision with root package name */
    public int f57317d;

    public i0(CoroutineContext coroutineContext, int i11) {
        this.f57314a = coroutineContext;
        this.f57315b = new Object[i11];
        this.f57316c = new f2[i11];
    }

    public final void a(f2<?> f2Var, Object obj) {
        Object[] objArr = this.f57315b;
        int i11 = this.f57317d;
        objArr[i11] = obj;
        f2<Object>[] f2VarArr = this.f57316c;
        this.f57317d = i11 + 1;
        f2VarArr[i11] = f2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f57316c.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                this.f57316c[length].n(coroutineContext, this.f57315b[length]);
                if (i11 >= 0) {
                    length = i11;
                } else {
                    return;
                }
            }
        }
    }
}
