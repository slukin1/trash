package com.iproov.sdk.p009do;

import com.iproov.sdk.IProov;
import java.util.UUID;

/* renamed from: com.iproov.sdk.do.goto  reason: invalid class name and invalid package */
public final class Cgoto implements IProov.Session {

    /* renamed from: do  reason: not valid java name */
    private final UUID f482do;

    /* renamed from: for  reason: not valid java name */
    private final IProov.IProovState f483for;

    /* renamed from: if  reason: not valid java name */
    private final String f484if;

    /* renamed from: new  reason: not valid java name */
    private final boolean f485new;

    public Cgoto(UUID uuid, String str, IProov.IProovState iProovState) {
        this.f482do = uuid;
        this.f484if = str;
        this.f483for = iProovState;
    }

    public void cancel() {
    }

    public IProov.IProovState getCurrentState() {
        return this.f483for;
    }

    public String getToken() {
        return this.f484if;
    }

    public UUID getUuid() {
        return this.f482do;
    }

    public boolean isActive() {
        return this.f485new;
    }
}
