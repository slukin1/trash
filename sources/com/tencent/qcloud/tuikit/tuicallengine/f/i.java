package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48411a;

    public i(j jVar, TUICallObserver tUICallObserver) {
        this.f48411a = tUICallObserver;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48411a;
        if (tUICallObserver != null) {
            tUICallObserver.onUserSigExpired();
        }
    }
}
