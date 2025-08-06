package com.tencent.ugc;

final /* synthetic */ class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50219a;

    private bi(TXVideoEditer tXVideoEditer) {
        this.f50219a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new bi(tXVideoEditer);
    }

    public final void run() {
        this.f50219a.mVideoProcessor.refreshOneFrame();
    }
}
