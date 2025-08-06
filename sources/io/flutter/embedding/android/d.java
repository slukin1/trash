package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f55120b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f55121c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f55122d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f55123e;

    public /* synthetic */ d(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j11, KeyEvent keyEvent) {
        this.f55120b = keyEmbedderResponder;
        this.f55121c = keyPair;
        this.f55122d = j11;
        this.f55123e = keyEvent;
    }

    public final void run() {
        this.f55120b.lambda$synchronizePressingKey$0(this.f55121c, this.f55122d, this.f55123e);
    }
}
