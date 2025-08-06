package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.internal.core.data.serializer.c;
import d10.l;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.d;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.i;
import kotlinx.serialization.json.m;
import kotlinx.serialization.json.t;
import kotlinx.serialization.modules.SerializersModuleBuilder;

public final class x {

    public static final class a extends Lambda implements l<d, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f32291a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(boolean z11) {
            super(1);
            this.f32291a = z11;
        }

        public final void a(d dVar) {
            dVar.e(true);
            dVar.d(true);
            dVar.f(this.f32291a);
            SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
            serializersModuleBuilder.d(Reflection.b(Object.class), c.f32960a);
            serializersModuleBuilder.d(Reflection.b(Date.class), com.sumsub.sns.internal.core.data.serializer.a.f32955a);
            dVar.g(serializersModuleBuilder.f());
            dVar.c(true);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((d) obj);
            return Unit.f56620a;
        }
    }

    public static final kotlinx.serialization.json.a a(boolean z11) {
        return m.b((kotlinx.serialization.json.a) null, new a(z11), 1, (Object) null);
    }

    public static final boolean b(g gVar) {
        t tVar = gVar instanceof t ? (t) gVar : null;
        if (tVar != null) {
            return tVar.c();
        }
        return false;
    }

    public static /* synthetic */ kotlinx.serialization.json.a a(boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = e0.f32018a.isDebug();
        }
        return a(z11);
    }

    public static final String a(g gVar) {
        String f11;
        if (!b(gVar)) {
            return gVar.toString();
        }
        t tVar = gVar instanceof t ? (t) gVar : null;
        if (tVar == null || (f11 = i.f(tVar)) == null) {
            return gVar.toString();
        }
        return f11;
    }
}
