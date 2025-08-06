package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import java.util.Arrays;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class zzcd {
    /* access modifiers changed from: private */
    public final WebView zza;
    private final h0 zzb;

    public zzcd(WebView webView, h0 h0Var) {
        this.zza = webView;
        this.zzb = h0Var;
    }

    public final void zzb(String str, String... strArr) {
        n1 unused = i.d(this.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzcc((String[]) Arrays.copyOf(strArr, strArr.length), this, str, (c) null), 3, (Object) null);
    }
}
