package com.jumio.core.error;

import android.content.Context;
import com.jumio.core.enums.ErrorCase;
import com.jumio.sdk.error.JumioError;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

public final class Error extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final ErrorCase f39140a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39141b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39142c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Error(ErrorCase errorCase, int i11, int i12, int i13, r rVar) {
        this(errorCase, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
    }

    public final String getCode() {
        d0 d0Var = d0.f56774a;
        return String.format(Locale.ENGLISH, "%s%02d%04d", Arrays.copyOf(new Object[]{this.f39140a.getDomain(), Integer.valueOf(this.f39141b), Integer.valueOf(this.f39142c)}, 3));
    }

    public final String getDomain() {
        return this.f39140a.getDomain();
    }

    public final JumioError getJumioError(Context context) {
        return new JumioError(isRetryable(), getDomain(), getCode(), context.getString(this.f39140a.getMessage()));
    }

    public final String getMessage(Context context) {
        String string = context.getString(this.f39140a.getMessage());
        String code = getCode();
        return string + " " + code;
    }

    public final boolean isRetryable() {
        return this.f39140a.getRetry();
    }

    public Error(ErrorCase errorCase, int i11, int i12) {
        this.f39140a = errorCase;
        this.f39141b = i11;
        this.f39142c = i12;
    }
}
