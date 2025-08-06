package com.google.firebase.sessions;

import com.google.android.datatransport.Transformer;

public final /* synthetic */ class b implements Transformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventGDTLogger f67161a;

    public /* synthetic */ b(EventGDTLogger eventGDTLogger) {
        this.f67161a = eventGDTLogger;
    }

    public final Object apply(Object obj) {
        return this.f67161a.encode((SessionEvent) obj);
    }
}
