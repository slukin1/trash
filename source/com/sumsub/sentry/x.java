package com.sumsub.sentry;

import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.p;
import kotlin.text.b;
import kotlinx.serialization.h;
import kotlinx.serialization.modules.d;

public final class x {

    /* renamed from: c  reason: collision with root package name */
    public static final a f30523c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final y f30524a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f30525b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final x a(z zVar) {
            kotlinx.serialization.json.a a11 = com.sumsub.sns.internal.core.common.x.a(false, 1, (Object) null);
            d a12 = a11.a();
            p n11 = Reflection.n(z.class);
            MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
            byte[] bytes = a11.b(h.d(a12, n11), zVar).getBytes(b.f56908b);
            return new x(new y("application/json", (String) null, SentryItemType.Event, (String) null, bytes.length), bytes);
        }

        public a() {
        }
    }

    public x(y yVar, byte[] bArr) {
        this.f30524a = yVar;
        this.f30525b = bArr;
    }

    public final byte[] a() {
        return this.f30525b;
    }

    public final y b() {
        return this.f30524a;
    }
}
