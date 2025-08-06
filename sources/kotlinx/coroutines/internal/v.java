package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x0;

public final class v extends MainCoroutineDispatcher implements p0 {

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f57348c;

    /* renamed from: d  reason: collision with root package name */
    public final String f57349d;

    public v(Throwable th2, String str) {
        this.f57348c = th2;
        this.f57349d = str;
    }

    public boolean B(CoroutineContext coroutineContext) {
        J();
        throw new KotlinNothingValueException();
    }

    public MainCoroutineDispatcher G() {
        return this;
    }

    /* renamed from: I */
    public Void w(CoroutineContext coroutineContext, Runnable runnable) {
        J();
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Void J() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f57348c
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f57349d
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f57348c
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.u.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.v.J():java.lang.Void");
    }

    /* renamed from: K */
    public Void t(long j11, k<? super Unit> kVar) {
        J();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f57348c != null) {
            str = ", cause=" + this.f57348c;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        J();
        throw new KotlinNothingValueException();
    }
}
