package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import rx.functions.Func1;

public final /* synthetic */ class z implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12532b;

    public /* synthetic */ z(String str) {
        this.f12532b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(((ContractCurrencyInfo) obj).getContractShortType().equalsIgnoreCase(this.f12532b));
    }
}
