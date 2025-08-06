package com.tencent.rtmp.ui;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCloudVideoView f48677a;

    private a(TXCloudVideoView tXCloudVideoView) {
        this.f48677a = tXCloudVideoView;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView) {
        return new a(tXCloudVideoView);
    }

    public final void run() {
        this.f48677a.hideIndicatorView();
    }
}
