package com.hbg.module.content.ui.ability;

import android.os.Handler;
import com.huobi.edgeengine.ability.AbilityFunction;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class ContentAbility$call$2$1 extends Lambda implements p<Integer, Integer, Unit> {
    public final /* synthetic */ AbilityFunction.a $callback;
    public final /* synthetic */ Handler $handler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentAbility$call$2$1(Handler handler, AbilityFunction.a aVar) {
        super(2);
        this.$handler = handler;
        this.$callback = aVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AbilityFunction.a aVar, JSONObject jSONObject) {
        aVar.a(true, jSONObject.toString());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11, int i12) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("praiseNum", i11);
        jSONObject.put("praiseStatus", i12);
        this.$handler.post(new a(this.$callback, jSONObject));
    }
}
