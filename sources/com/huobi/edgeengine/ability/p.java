package com.huobi.edgeengine.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;
import td.g;

public final /* synthetic */ class p implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f43931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f43932b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43933c;

    public /* synthetic */ p(String str, b bVar, AbilityFunction.a aVar) {
        this.f43931a = str;
        this.f43932b = bVar;
        this.f43933c = aVar;
    }

    public final void a(boolean z11, Throwable th2) {
        EngineHandleFavorite.n(this.f43931a, this.f43932b, this.f43933c, z11, th2);
    }
}
