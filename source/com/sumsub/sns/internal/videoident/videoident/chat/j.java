package com.sumsub.sns.internal.videoident.videoident.chat;

import com.twilio.video.RemoteDataTrackPublication;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteDataTrackPublication f37084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f37085c;

    public /* synthetic */ j(RemoteDataTrackPublication remoteDataTrackPublication, d dVar) {
        this.f37084b = remoteDataTrackPublication;
        this.f37085c = dVar;
    }

    public final void run() {
        d.a(this.f37084b, this.f37085c);
    }
}
