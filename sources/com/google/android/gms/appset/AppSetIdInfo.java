package com.google.android.gms.appset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AppSetIdInfo {
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    private final String zza;
    private final int zzb;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public AppSetIdInfo(String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    public String getId() {
        return this.zza;
    }

    public int getScope() {
        return this.zzb;
    }
}
