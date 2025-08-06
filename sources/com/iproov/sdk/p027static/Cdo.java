package com.iproov.sdk.p027static;

import android.content.Context;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p016if.Cwhile;
import com.iproov.sdk.p026return.Cclass;
import com.iproov.sdk.p026return.Csuper;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: com.iproov.sdk.static.do  reason: invalid class name and invalid package */
public final class Cdo implements com.iproov.sdk.p004catch.Cdo {

    /* renamed from: do  reason: not valid java name */
    private final Context f1910do;

    public Cdo(Context context) {
        this.f1910do = context;
    }

    /* renamed from: do  reason: not valid java name */
    public Cwhile m1782do() throws UnexpectedErrorException {
        return !com.iproov.sdk.p009do.Cdo.m566do(getContext()) ? new Csuper(getContext(), (CoroutineDispatcher) null, 2, (r) null) : new Cclass(getContext(), (CoroutineDispatcher) null, 2, (r) null);
    }

    public Context getContext() {
        return this.f1910do;
    }
}
