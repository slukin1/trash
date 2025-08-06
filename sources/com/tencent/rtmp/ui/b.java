package com.tencent.rtmp.ui;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCloudVideoView f48678a;

    /* renamed from: b  reason: collision with root package name */
    private final int f48679b;

    /* renamed from: c  reason: collision with root package name */
    private final int f48680c;

    /* renamed from: d  reason: collision with root package name */
    private final int f48681d;

    /* renamed from: e  reason: collision with root package name */
    private final int f48682e;

    private b(TXCloudVideoView tXCloudVideoView, int i11, int i12, int i13, int i14) {
        this.f48678a = tXCloudVideoView;
        this.f48679b = i11;
        this.f48680c = i12;
        this.f48681d = i13;
        this.f48682e = i14;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i11, int i12, int i13, int i14) {
        return new b(tXCloudVideoView, i11, i12, i13, i14);
    }

    public final void run() {
        this.f48678a.showFocusViewInternal(this.f48679b, this.f48680c, this.f48681d, this.f48682e);
    }
}
