package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zza;

    public GooglePlayServicesAvailabilityException(int i11, String str, Intent intent) {
        super(str, intent);
        this.zza = i11;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
