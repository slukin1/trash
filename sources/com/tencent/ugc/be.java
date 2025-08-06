package com.tencent.ugc;

final /* synthetic */ class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50187a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f50188b;

    private be(TXVideoEditer tXVideoEditer, float[] fArr) {
        this.f50187a = tXVideoEditer;
        this.f50188b = fArr;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float[] fArr) {
        return new be(tXVideoEditer, fArr);
    }

    public final void run() {
        this.f50187a.mAudioProcessor.setVideoVolumes(this.f50188b);
    }
}
