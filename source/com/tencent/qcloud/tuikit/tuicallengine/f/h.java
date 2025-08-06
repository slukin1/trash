package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48410a;

    public h(j jVar, TUICallObserver tUICallObserver) {
        this.f48410a = tUICallObserver;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48410a;
        if (tUICallObserver != null) {
            tUICallObserver.onKickedOffline();
        }
    }
}
