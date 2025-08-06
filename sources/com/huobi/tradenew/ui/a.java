package com.huobi.tradenew.ui;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CircleClickImageButton f83360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f83361c;

    public /* synthetic */ a(CircleClickImageButton circleClickImageButton, int i11) {
        this.f83360b = circleClickImageButton;
        this.f83361c = i11;
    }

    public final void run() {
        this.f83360b.d(this.f83361c);
    }
}
