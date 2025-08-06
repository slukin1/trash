package com.huobi.pandoraBox.crashKiller.core.cleaner;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Handler f80306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PageCleaner f80307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f80308d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f80309e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f80310f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f80311g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f80312h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f80313i;

    public /* synthetic */ c(Handler handler, PageCleaner pageCleaner, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f80306b = handler;
        this.f80307c = pageCleaner;
        this.f80308d = i11;
        this.f80309e = i12;
        this.f80310f = i13;
        this.f80311g = i14;
        this.f80312h = i15;
        this.f80313i = i16;
    }

    public final boolean handleMessage(Message message) {
        return PageCleaner.i(this.f80306b, this.f80307c, this.f80308d, this.f80309e, this.f80310f, this.f80311g, this.f80312h, this.f80313i, message);
    }
}
