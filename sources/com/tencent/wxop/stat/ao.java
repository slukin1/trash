package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class ao implements Runnable {
    public final /* synthetic */ f bN = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f50980e;

    public ao(Context context) {
        this.f50980e = context;
    }

    public final void run() {
        Context context = this.f50980e;
        if (context == null) {
            e.aV.error("The Context of StatService.onPause() can not be null!");
        } else {
            e.b(context, l.B(context), this.bN);
        }
    }
}
