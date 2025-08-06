package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.Size;
import java.util.List;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f50905a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50906b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f50907c;

    private c(WatermarkProcessor watermarkProcessor, List list, Size size) {
        this.f50905a = watermarkProcessor;
        this.f50906b = list;
        this.f50907c = size;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, Size size) {
        return new c(watermarkProcessor, list, size);
    }

    public final void run() {
        this.f50905a.setSubtitleListInternal(this.f50906b, this.f50907c);
    }
}
