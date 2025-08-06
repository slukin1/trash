package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class p implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ p f67026a = new p();

    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.LITE_EXECUTOR.get();
    }
}
