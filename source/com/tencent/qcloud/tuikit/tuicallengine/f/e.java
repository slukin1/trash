package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import java.util.Map;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48403a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f48404b;

    public e(j jVar, TUICallObserver tUICallObserver, Map map) {
        this.f48403a = tUICallObserver;
        this.f48404b = map;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48403a;
        if (tUICallObserver != null) {
            tUICallObserver.onUserVoiceVolumeChanged(this.f48404b);
        }
    }
}
