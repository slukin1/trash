package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class s implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ s f67029a = new s();

    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
    }
}
