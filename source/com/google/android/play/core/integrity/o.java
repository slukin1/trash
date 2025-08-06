package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ah;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.aj;
import com.google.android.play.integrity.internal.al;

final class o {

    /* renamed from: a  reason: collision with root package name */
    private final o f66842a = this;

    /* renamed from: b  reason: collision with root package name */
    private final al f66843b;

    /* renamed from: c  reason: collision with root package name */
    private final al f66844c;

    /* renamed from: d  reason: collision with root package name */
    private final al f66845d;

    /* renamed from: e  reason: collision with root package name */
    private final al f66846e;

    public /* synthetic */ o(Context context, n nVar) {
        ai b11 = aj.b(context);
        this.f66843b = b11;
        al b12 = ah.b(y.f66859a);
        this.f66844c = b12;
        al b13 = ah.b(new af(b11, b12));
        this.f66845d = b13;
        this.f66846e = ah.b(new x(b13));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f66846e.a();
    }
}
