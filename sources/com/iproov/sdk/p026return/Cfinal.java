package com.iproov.sdk.p026return;

import com.iproov.sdk.IProovSessionState;
import com.iproov.sdk.IProovState;
import com.iproov.sdk.p009do.Ccase;
import com.iproov.sdk.p009do.Cnew;
import java.util.UUID;

/* renamed from: com.iproov.sdk.return.final  reason: invalid class name and invalid package */
public final class Cfinal implements Ccase {

    /* renamed from: do  reason: not valid java name */
    private final String f1524do;

    /* renamed from: for  reason: not valid java name */
    private final UUID f1525for = UUID.randomUUID();

    /* renamed from: if  reason: not valid java name */
    private final IProovState f1526if;

    /* renamed from: new  reason: not valid java name */
    private final boolean f1527new;

    public Cfinal(String str, IProovState iProovState) {
        this.f1524do = str;
        this.f1526if = iProovState;
        Cnew.f489do.m575do().d(new IProovSessionState(this, getCurrentState()));
    }

    public void cancel() {
    }

    public IProovState getCurrentState() {
        return this.f1526if;
    }

    public String getToken() {
        return this.f1524do;
    }

    public UUID getUuid() {
        return this.f1525for;
    }

    public boolean isActive() {
        return this.f1527new;
    }
}
