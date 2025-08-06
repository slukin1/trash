package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.SerialTaskQueue f55135b;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f55135b = serialTaskQueue;
    }

    public final void run() {
        this.f55135b.lambda$dispatch$0();
    }
}
