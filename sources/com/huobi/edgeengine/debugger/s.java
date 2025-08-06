package com.huobi.edgeengine.debugger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class s implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f44057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f44058c;

    public /* synthetic */ s(String str, ExecutorService executorService) {
        this.f44057b = str;
        this.f44058c = executorService;
    }

    public final Object call() {
        return t.c(this.f44057b, this.f44058c);
    }
}
