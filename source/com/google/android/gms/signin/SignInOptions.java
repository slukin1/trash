package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions zaa = new SignInOptions(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null, (zaf) null);
    private final boolean zab = false;
    private final boolean zac = false;
    private final String zad = null;
    private final boolean zae = false;
    private final String zaf = null;
    private final String zag = null;
    private final boolean zah = false;
    private final Long zai = null;
    private final Long zaj = null;

    public /* synthetic */ SignInOptions(boolean z11, boolean z12, String str, boolean z13, String str2, String str3, boolean z14, Long l11, Long l12, zaf zaf2) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        boolean z11 = ((SignInOptions) obj).zab;
        return Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null) && Objects.equal((Object) null, (Object) null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hashCode(bool, bool, null, bool, bool, null, null, null, null);
    }
}
