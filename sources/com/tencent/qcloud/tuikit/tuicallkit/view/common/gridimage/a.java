package com.tencent.qcloud.tuikit.tuicallkit.view.common.gridimage;

import android.graphics.Bitmap;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridImageSynthesizer f48576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f48577c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Bitmap f48578d;

    public /* synthetic */ a(GridImageSynthesizer gridImageSynthesizer, String str, Bitmap bitmap) {
        this.f48576b = gridImageSynthesizer;
        this.f48577c = str;
        this.f48578d = bitmap;
    }

    public final void run() {
        this.f48576b.lambda$loadImage$0(this.f48577c, this.f48578d);
    }
}
