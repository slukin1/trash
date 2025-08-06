package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zag<R extends Result> extends BasePendingResult<R> {
    private final R zae;

    public zag(GoogleApiClient googleApiClient, R r11) {
        super(googleApiClient);
        this.zae = r11;
    }

    public final R createFailedResult(Status status) {
        return this.zae;
    }
}
