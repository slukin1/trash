package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DartMessenger f55129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55130c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f55131d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.HandlerInfo f55132e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f55133f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f55134g;

    public /* synthetic */ a(DartMessenger dartMessenger, String str, int i11, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j11) {
        this.f55129b = dartMessenger;
        this.f55130c = str;
        this.f55131d = i11;
        this.f55132e = handlerInfo;
        this.f55133f = byteBuffer;
        this.f55134g = j11;
    }

    public final void run() {
        this.f55129b.lambda$dispatchMessageToQueue$0(this.f55130c, this.f55131d, this.f55132e, this.f55133f, this.f55134g);
    }
}
