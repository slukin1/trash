package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzad extends zzah {
    public final /* synthetic */ zzae zza;

    public zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final void zzb(Account account) {
        this.zza.setResult(new zzai(account != null ? Status.RESULT_SUCCESS : zzal.zza, account));
    }
}
