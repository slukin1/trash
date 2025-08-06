package pm;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import pm.j;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.b f53184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f53185c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f53186d;

    public /* synthetic */ l(j.b bVar, ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
        this.f53184b = bVar;
        this.f53185c = contractCurrencyInfo;
        this.f53186d = z11;
    }

    public final void run() {
        this.f53184b.g(this.f53185c, this.f53186d);
    }
}
