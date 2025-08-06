package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import java.util.List;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f48406b;

    public f(j jVar, TUICallObserver tUICallObserver, List list) {
        this.f48405a = tUICallObserver;
        this.f48406b = list;
    }

    public void run() {
        this.f48405a.onUserNetworkQualityChanged(this.f48406b);
    }
}
