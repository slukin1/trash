package com.tencent.ugc.videobase.filter;

import java.util.List;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImagePerspectiveCorrectionFilter f50846a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50847b;

    /* renamed from: c  reason: collision with root package name */
    private final List f50848c;

    private a(TXCGPUImagePerspectiveCorrectionFilter tXCGPUImagePerspectiveCorrectionFilter, List list, List list2) {
        this.f50846a = tXCGPUImagePerspectiveCorrectionFilter;
        this.f50847b = list;
        this.f50848c = list2;
    }

    public static Runnable a(TXCGPUImagePerspectiveCorrectionFilter tXCGPUImagePerspectiveCorrectionFilter, List list, List list2) {
        return new a(tXCGPUImagePerspectiveCorrectionFilter, list, list2);
    }

    public final void run() {
        TXCGPUImagePerspectiveCorrectionFilter.lambda$setTransformPoints$0(this.f50846a, this.f50847b, this.f50848c);
    }
}
