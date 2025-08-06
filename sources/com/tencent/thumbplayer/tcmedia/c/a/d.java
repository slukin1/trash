package com.tencent.thumbplayer.tcmedia.c.a;

import android.os.Looper;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public class d implements ITPAssetResourceLoadingRequest {

    /* renamed from: a  reason: collision with root package name */
    private int f49044a = 0;

    /* renamed from: b  reason: collision with root package name */
    private c f49045b;

    /* renamed from: c  reason: collision with root package name */
    private TPAssetResourceLoadingContentInformationRequest f49046c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49047d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49048e = false;

    public d(long j11, long j12, int i11, boolean z11) {
        this.f49044a = i11;
        c cVar = new c(j11, j12, z11);
        this.f49045b = cVar;
        cVar.a(i11);
    }

    public int a(long j11) {
        return this.f49045b.a(j11);
    }

    /* renamed from: a */
    public c getLoadingDataRequest() {
        return this.f49045b;
    }

    public void a(Looper looper) {
        this.f49045b.a(looper);
    }

    public void a(TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest) {
        this.f49046c = tPAssetResourceLoadingContentInformationRequest;
    }

    public void a(String str) {
        this.f49045b.a(str);
    }

    public synchronized void b() {
        this.f49047d = true;
        this.f49045b.b();
    }

    public synchronized void finishLoading() {
        this.f49048e = true;
    }

    public TPAssetResourceLoadingContentInformationRequest getContentInformation() {
        return this.f49046c;
    }

    public synchronized boolean isCancelled() {
        return this.f49047d;
    }

    public synchronized boolean isFinished() {
        return this.f49048e;
    }
}
