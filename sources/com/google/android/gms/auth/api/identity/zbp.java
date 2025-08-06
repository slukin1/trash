package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class zbp implements Api.ApiOptions.Optional {
    public final boolean equals(Object obj) {
        return obj instanceof zbp;
    }

    public final int hashCode() {
        return Objects.hashCode(zbp.class);
    }
}
