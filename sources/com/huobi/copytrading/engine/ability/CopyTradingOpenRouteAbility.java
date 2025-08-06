package com.huobi.copytrading.engine.ability;

import android.net.Uri;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import kotlin.jvm.internal.r;
import rj.b;

public final class CopyTradingOpenRouteAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43595a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            String b11 = b(bVar, (String) obj);
            if (b11 != null) {
                zn.a.d().v(Uri.parse(b11)).a().c();
            }
            if (aVar != null) {
                aVar.a(true, (Object) null);
            }
        } else if (aVar != null) {
            aVar.a(false, (Object) null);
        }
    }

    public final String b(b bVar, String str) {
        return str;
    }
}
