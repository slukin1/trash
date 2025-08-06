package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f55136b;

    public /* synthetic */ c(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f55136b = serialTaskQueue;
    }

    public final void run() {
        this.f55136b.lambda$flush$1();
    }
}
