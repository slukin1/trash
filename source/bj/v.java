package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class v implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b0 f12506b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12507c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12508d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f12509e;

    public /* synthetic */ v(b0 b0Var, ContractCurrencyInfo contractCurrencyInfo, String str, int i11) {
        this.f12506b = b0Var;
        this.f12507c = contractCurrencyInfo;
        this.f12508d = str;
        this.f12509e = i11;
    }

    public final void call(Object obj) {
        this.f12506b.I(this.f12507c, this.f12508d, this.f12509e, (List) obj);
    }
}
