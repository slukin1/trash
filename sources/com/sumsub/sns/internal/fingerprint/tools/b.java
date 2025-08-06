package com.sumsub.sns.internal.fingerprint.tools;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.k;

public final class b {
    public static final <V> Object a(Object obj) {
        boolean r02 = Result.m3079isSuccessimpl(obj);
        if (r02) {
            k.b(obj);
            return ((Result) obj).m3081unboximpl();
        } else if (!r02) {
            Result.a aVar = Result.Companion;
            return Result.m3072constructorimpl(k.a(Result.m3075exceptionOrNullimpl(obj)));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
