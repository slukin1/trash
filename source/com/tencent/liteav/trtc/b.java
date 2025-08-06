package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TRTCCloudListener.TRTCSnapshotListener f21722a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f21723b;

    private b(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        this.f21722a = tRTCSnapshotListener;
        this.f21723b = bitmap;
    }

    public static Runnable a(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        return new b(tRTCSnapshotListener, bitmap);
    }

    public final void run() {
        TrtcCloudJni.lambda$onSnapshotComplete$1(this.f21722a, this.f21723b);
    }
}
