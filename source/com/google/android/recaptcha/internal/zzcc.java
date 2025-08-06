package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import d10.p;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzcc extends SuspendLambda implements p {
    public final /* synthetic */ String[] zza;
    public final /* synthetic */ zzcd zzb;
    public final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcc(String[] strArr, zzcd zzcd, String str, c cVar) {
        super(2, cVar);
        this.zza = strArr;
        this.zzb = zzcd;
        this.zzc = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzcc(this.zza, this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcc) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        ArrayList arrayList = new ArrayList(r1);
        for (String str : this.zza) {
            arrayList.add("\"" + str + "\"");
        }
        zzcd zzcd = this.zzb;
        String str2 = this.zzc;
        zzcd.zza.evaluateJavascript(str2 + "(" + CollectionsKt___CollectionsKt.k0(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null) + ")", (ValueCallback) null);
        return Unit.f56620a;
    }
}
