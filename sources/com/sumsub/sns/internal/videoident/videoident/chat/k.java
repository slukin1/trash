package com.sumsub.sns.internal.videoident.videoident.chat;

import com.sumsub.sns.internal.videoident.videoident.chat.d;
import com.twilio.video.RemoteDataTrackPublication;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteDataTrackPublication f37086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f37087c;

    public /* synthetic */ k(RemoteDataTrackPublication remoteDataTrackPublication, d dVar) {
        this.f37086b = remoteDataTrackPublication;
        this.f37087c = dVar;
    }

    public final void run() {
        d.b.a(this.f37086b, this.f37087c);
    }
}
