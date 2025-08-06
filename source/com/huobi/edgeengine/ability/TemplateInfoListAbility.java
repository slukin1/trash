package com.huobi.edgeengine.ability;

import android.util.Log;
import com.huobi.app.rms.HBRMSManager;
import com.huobi.edgeengine.ability.AbilityFunction;
import kotlin.jvm.internal.r;
import rj.b;

public final class TemplateInfoListAbility extends AbstractAbility {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43905a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar == null || obj == null) {
            Log.d("Console", "call ContentAbility error");
            return;
        }
        try {
            aVar.a(true, HBRMSManager.f42145q.a().w());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean b() {
        return false;
    }
}
