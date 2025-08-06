package xg;

import com.huobi.activity.PingAbility;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PingAbility f61588b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61589c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f61590d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f61591e;

    public /* synthetic */ v(PingAbility pingAbility, String str, b bVar, AbilityFunction.a aVar) {
        this.f61588b = pingAbility;
        this.f61589c = str;
        this.f61590d = bVar;
        this.f61591e = aVar;
    }

    public final void run() {
        this.f61588b.e(this.f61589c, this.f61590d, this.f61591e);
    }
}
