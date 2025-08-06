package com.google.android.gms.internal.p041authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbf  reason: invalid package */
final class zbf extends zbd {
    public final /* synthetic */ zbg zba;

    public zbf(zbg zbg) {
        this.zba = zbg;
    }

    public final void zbb(Status status, Credential credential) {
        this.zba.setResult(new zbe(status, credential));
    }

    public final void zbc(Status status) {
        this.zba.setResult(new zbe(status, (Credential) null));
    }
}
