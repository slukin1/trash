package com.tencent.ugc.videoprocessor;

import com.tencent.liteav.base.util.Size;
import java.util.List;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f50911a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50912b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f50913c;

    private e(WatermarkProcessor watermarkProcessor, List list, Size size) {
        this.f50911a = watermarkProcessor;
        this.f50912b = list;
        this.f50913c = size;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, List list, Size size) {
        return new e(watermarkProcessor, list, size);
    }

    public final void run() {
        this.f50911a.setPasterListInternal(this.f50912b, this.f50913c);
    }
}
