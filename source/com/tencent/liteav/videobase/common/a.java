package com.tencent.liteav.videobase.common;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final a f22139a = new a();

    private a() {
    }

    public static Runnable a() {
        return f22139a;
    }

    public final void run() {
        HDRCapability.checkIsHDR10Supported();
    }
}
