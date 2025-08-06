package com.huobi.edgeengine.debugger;

import android.content.Context;
import com.facebook.stetho.InspectorModulesProvider;

public final /* synthetic */ class q implements InspectorModulesProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f44048a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f44049b;

    public /* synthetic */ q(Context context, p pVar) {
        this.f44048a = context;
        this.f44049b = pVar;
    }

    public final Iterable get() {
        return r.e(this.f44048a, this.f44049b);
    }
}
