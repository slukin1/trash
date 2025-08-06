package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.Size;
import java.util.List;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f50908a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50909b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f50910c;

    private d(WatermarkProcessor watermarkProcessor, List list, Size size) {
        this.f50908a = watermarkProcessor;
        this.f50909b = list;
        this.f50910c = size;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, Size size) {
        return new d(watermarkProcessor, list, size);
    }

    public final void run() {
        this.f50908a.setAnimatedPasterListInternal(this.f50909b, this.f50910c);
    }
}
