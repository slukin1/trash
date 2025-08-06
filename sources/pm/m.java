package pm;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import pm.j;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.b f53187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f53188c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f53189d;

    public /* synthetic */ m(j.b bVar, ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
        this.f53187b = bVar;
        this.f53188c = contractCurrencyInfo;
        this.f53189d = z11;
    }

    public final void run() {
        this.f53187b.f(this.f53188c, this.f53189d);
    }
}
