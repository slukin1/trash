package com.sumsub.sns.internal.fingerprint;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.x;
import d10.l;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import kotlin.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final x f34295a;

    public static final class a extends Lambda implements l<v<?>, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f34296a = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(v<?> vVar) {
            return vVar.a();
        }
    }

    public b(x xVar) {
        this.f34295a = xVar;
    }

    public final Object a(com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar) {
        return a((List<? extends v<?>>) this.f34295a.L(), aVar);
    }

    public final x b() {
        return this.f34295a;
    }

    public final Object a() {
        Result.a aVar = Result.Companion;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (v d11 : this.f34295a.L()) {
            linkedHashMap.putAll(d11.d());
        }
        return Result.m3072constructorimpl(linkedHashMap);
    }

    public final String a(com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar, List<? extends v<?>> list) {
        return aVar.a(CollectionsKt___CollectionsKt.k0(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.f34296a, 30, (Object) null));
    }

    public final Object a(List<? extends v<?>> list, com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar) {
        try {
            Result.a aVar2 = Result.Companion;
            return Result.m3072constructorimpl(a(aVar, list));
        } catch (Throwable th2) {
            Result.a aVar3 = Result.Companion;
            return Result.m3072constructorimpl(k.a(th2));
        }
    }
}
