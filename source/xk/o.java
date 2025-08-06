package xk;

import com.huobi.finance.model.subaccount.OnChainDataProvider;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class o implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnChainDataProvider f61641b;

    public /* synthetic */ o(OnChainDataProvider onChainDataProvider) {
        this.f61641b = onChainDataProvider;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f61641b.g((List) obj, (List) obj2);
    }
}
