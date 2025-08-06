package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;
import java.util.concurrent.FutureTask;

final /* synthetic */ class ep implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50479a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoJoiner.DurationControlMode f50480b;

    /* renamed from: c  reason: collision with root package name */
    private final FutureTask f50481c;

    private ep(UGCMediaListSource uGCMediaListSource, TXVideoJoiner.DurationControlMode durationControlMode, FutureTask futureTask) {
        this.f50479a = uGCMediaListSource;
        this.f50480b = durationControlMode;
        this.f50481c = futureTask;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, TXVideoJoiner.DurationControlMode durationControlMode, FutureTask futureTask) {
        return new ep(uGCMediaListSource, durationControlMode, futureTask);
    }

    public final void run() {
        UGCMediaListSource.lambda$setDurationControlMode$3(this.f50479a, this.f50480b, this.f50481c);
    }
}
