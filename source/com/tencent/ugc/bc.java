package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50181a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoJoiner.DurationControlMode f50182b;

    private bc(TXVideoEditer tXVideoEditer, TXVideoJoiner.DurationControlMode durationControlMode) {
        this.f50181a = tXVideoEditer;
        this.f50182b = durationControlMode;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoJoiner.DurationControlMode durationControlMode) {
        return new bc(tXVideoEditer, durationControlMode);
    }

    public final void run() {
        this.f50181a.mMediaListSource.setDurationControlMode(this.f50182b);
    }
}
