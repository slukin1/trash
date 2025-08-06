package bj;

import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import com.huobi.contract.helper.ContractCurrencyConfigImpl;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class m implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyConfigImpl f12452b;

    public /* synthetic */ m(ContractCurrencyConfigImpl contractCurrencyConfigImpl) {
        this.f12452b = contractCurrencyConfigImpl;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f12452b.A((List) obj, (ContractHiddenInstruments) obj2);
    }
}
