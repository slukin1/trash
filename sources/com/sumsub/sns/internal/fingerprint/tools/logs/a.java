package com.sumsub.sns.internal.fingerprint.tools.logs;

import com.sumsub.sns.internal.log.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34670a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f34671b = "Fingerprint";

    public static /* synthetic */ void a(a aVar, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        aVar.a(str, th2);
    }

    public final void a(String str, Throwable th2) {
        if (th2 == null) {
            b.b(com.sumsub.sns.internal.log.a.f34862a, f34671b, str, (Throwable) null, 4, (Object) null);
        } else {
            b.b(com.sumsub.sns.internal.log.a.f34862a, f34671b, str, th2);
        }
    }
}
