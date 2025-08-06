package xg;

import com.huobi.activity.CaptureAbility;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f61577b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f61578c;

    public /* synthetic */ q(b bVar, AbilityFunction.a aVar) {
        this.f61577b = bVar;
        this.f61578c = aVar;
    }

    public final void run() {
        CaptureAbility.c(this.f61577b, this.f61578c);
    }
}
