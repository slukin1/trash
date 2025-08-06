package com.google.android.gms.internal.p041authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* renamed from: com.google.android.gms.internal.auth-api.zbk  reason: invalid package */
final class zbk extends zbd {
    private final BaseImplementation.ResultHolder zba;

    public zbk(BaseImplementation.ResultHolder resultHolder) {
        this.zba = resultHolder;
    }

    public final void zbc(Status status) {
        this.zba.setResult(status);
    }
}
