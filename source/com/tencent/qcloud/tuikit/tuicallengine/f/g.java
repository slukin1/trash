package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48407a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.MediaType f48408b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.MediaType f48409c;

    public g(j jVar, TUICallObserver tUICallObserver, TUICallDefine.MediaType mediaType, TUICallDefine.MediaType mediaType2) {
        this.f48407a = tUICallObserver;
        this.f48408b = mediaType;
        this.f48409c = mediaType2;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48407a;
        if (tUICallObserver != null) {
            tUICallObserver.onCallMediaTypeChanged(this.f48408b, this.f48409c);
        }
    }
}
