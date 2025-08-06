package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class q implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q f67027a = new q();

    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BG_EXECUTOR.get();
    }
}
