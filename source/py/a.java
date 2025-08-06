package py;

import android.content.Context;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f40555c = new a();

    /* renamed from: a  reason: collision with root package name */
    public Context f40556a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f40557b = 0;

    public static a c() {
        return f40555c;
    }

    public long a() {
        return System.currentTimeMillis() + this.f40557b;
    }

    public String b() {
        return "" + a();
    }

    public void d(long j11) {
        this.f40557b = j11 - System.currentTimeMillis();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.f40556a     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0018
            if (r2 != 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            android.content.Context r0 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0016
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            r1.f40556a = r2     // Catch:{ all -> 0x001a }
            goto L_0x0018
        L_0x0016:
            r1.f40556a = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: py.a.e(android.content.Context):void");
    }

    public Context f() {
        return this.f40556a;
    }
}
