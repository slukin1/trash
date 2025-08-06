package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f48398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f48399c;

    public c(j jVar, TUICallObserver tUICallObserver, String str, boolean z11) {
        this.f48397a = tUICallObserver;
        this.f48398b = str;
        this.f48399c = z11;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48397a;
        if (tUICallObserver != null) {
            tUICallObserver.onUserVideoAvailable(this.f48398b, this.f48399c);
        }
    }
}
