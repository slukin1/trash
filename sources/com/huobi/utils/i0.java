package com.huobi.utils;

import android.content.Context;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import o9.a;
import o9.b;
import tg.r;
import u6.g;

public final class i0 {
    public static void a(Context context, String str) {
        b a11 = a.a();
        boolean F0 = r.x().F0();
        String h11 = ku.b.e().h(context);
        a11.d(F0 ? 1 : 0, str, h11, "10.54.0", (String) null).b().compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
    }
}
