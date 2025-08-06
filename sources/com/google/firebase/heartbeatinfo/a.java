package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f67091a;

    public /* synthetic */ a(Qualified qualified) {
        this.f67091a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatController.lambda$component$3(this.f67091a, componentContainer);
    }
}
