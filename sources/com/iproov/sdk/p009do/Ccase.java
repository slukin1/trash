package com.iproov.sdk.p009do;

import com.iproov.sdk.IProovState;
import java.util.UUID;

/* renamed from: com.iproov.sdk.do.case  reason: invalid class name and invalid package */
public interface Ccase {
    void cancel();

    IProovState getCurrentState();

    String getToken();

    UUID getUuid();

    boolean isActive();
}
