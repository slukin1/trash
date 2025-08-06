package dj;

import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.ui.ContractTradeDetailActivity;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class r1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53742b;

    public /* synthetic */ r1(Map map) {
        this.f53742b = map;
    }

    public final Object call(Object obj) {
        return ContractTradeDetailActivity.oh(this.f53742b, (ContractOrderDetailResult) obj);
    }
}
