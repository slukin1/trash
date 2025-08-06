package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f55124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f55125c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f55126d;

    public /* synthetic */ e(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        this.f55124b = keyEmbedderResponder;
        this.f55125c = keyPair;
        this.f55126d = keyEvent;
    }

    public final void run() {
        this.f55124b.lambda$synchronizePressingKey$1(this.f55125c, this.f55126d);
    }
}
