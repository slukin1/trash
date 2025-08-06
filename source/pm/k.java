package pm;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import java.util.List;
import pm.j;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.b f53180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f53181c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f53182d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f53183e;

    public /* synthetic */ k(j.b bVar, ContractCurrencyInfo contractCurrencyInfo, List list, boolean z11) {
        this.f53180b = bVar;
        this.f53181c = contractCurrencyInfo;
        this.f53182d = list;
        this.f53183e = z11;
    }

    public final void run() {
        this.f53180b.h(this.f53181c, this.f53182d, this.f53183e);
    }
}
