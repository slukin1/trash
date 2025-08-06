package com.iproov.sdk;

import com.iproov.sdk.IProov;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Lcom/iproov/sdk/IProov$FailureResult;", "", "toLoggable", "iproov_release"}, k = 2, mv = {1, 5, 1})
public final class IProovKt {
    public static final String toLoggable(IProov.FailureResult failureResult) {
        return x.i("Reason=", failureResult.getReason());
    }
}
