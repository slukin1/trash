package com.hbg.module.content.ui.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import org.json.JSONObject;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f18253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JSONObject f18254c;

    public /* synthetic */ a(AbilityFunction.a aVar, JSONObject jSONObject) {
        this.f18253b = aVar;
        this.f18254c = jSONObject;
    }

    public final void run() {
        ContentAbility$call$2$1.invoke$lambda$0(this.f18253b, this.f18254c);
    }
}
