package bj;

import com.huobi.contract.helper.ContractCurrencyUtils;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12460b;

    public /* synthetic */ n(String str) {
        this.f12460b = str;
    }

    public final Object call(Object obj) {
        return ContractCurrencyUtils.B(this.f12460b, (List) obj);
    }
}
