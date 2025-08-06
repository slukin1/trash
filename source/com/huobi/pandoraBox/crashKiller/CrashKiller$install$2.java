package com.huobi.pandoraBox.crashKiller;

import android.os.Looper;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import zp.a;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CrashKiller$install$2 extends Lambda implements l<Throwable, Unit> {
    public static final CrashKiller$install$2 INSTANCE = new CrashKiller$install$2();

    public CrashKiller$install$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        a b11 = CrashKiller.f80300d;
        if (b11 != null) {
            b11.f(CrashKiller.g(), Looper.getMainLooper().getThread(), th2);
        }
        if (!CrashKiller.g()) {
            CrashKiller.f80297a.h();
        }
    }
}
