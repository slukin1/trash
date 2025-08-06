package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f66978b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Event f66979c;

    public /* synthetic */ o(Map.Entry entry, Event event) {
        this.f66978b = entry;
        this.f66979c = event;
    }

    public final void run() {
        ((EventHandler) this.f66978b.getKey()).handle(this.f66979c);
    }
}
