package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48400a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f48401b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f48402c;

    public d(j jVar, TUICallObserver tUICallObserver, String str, boolean z11) {
        this.f48400a = tUICallObserver;
        this.f48401b = str;
        this.f48402c = z11;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48400a;
        if (tUICallObserver != null) {
            tUICallObserver.onUserAudioAvailable(this.f48401b, this.f48402c);
        }
    }
}
