package com.google.android.gms.auth;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent zza;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.zza = intent;
    }

    public Intent getIntent() {
        Intent intent = this.zza;
        if (intent == null) {
            return null;
        }
        return new Intent(intent);
    }
}
