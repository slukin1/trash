package com.iproov.sdk.p009do;

import com.iproov.sdk.IProov;
import d10.a;
import java.util.UUID;
import kotlin.Unit;

/* renamed from: com.iproov.sdk.do.else  reason: invalid class name and invalid package */
public final class Celse implements IProov.Session {

    /* renamed from: do  reason: not valid java name */
    private final UUID f476do;

    /* renamed from: for  reason: not valid java name */
    private final a<IProov.IProovState> f477for;

    /* renamed from: if  reason: not valid java name */
    private final String f478if;

    /* renamed from: new  reason: not valid java name */
    private final a<Boolean> f479new;

    /* renamed from: try  reason: not valid java name */
    private final a<Unit> f480try;

    public Celse(UUID uuid, String str, a<? extends IProov.IProovState> aVar, a<Boolean> aVar2, a<Unit> aVar3) {
        this.f476do = uuid;
        this.f478if = str;
        this.f477for = aVar;
        this.f479new = aVar2;
        this.f480try = aVar3;
    }

    public void cancel() {
        this.f480try.invoke();
    }

    public IProov.IProovState getCurrentState() {
        return this.f477for.invoke();
    }

    public String getToken() {
        return this.f478if;
    }

    public UUID getUuid() {
        return this.f476do;
    }

    public boolean isActive() {
        return this.f479new.invoke().booleanValue();
    }
}
