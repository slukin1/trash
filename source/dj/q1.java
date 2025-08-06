package dj;

import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.ui.ContractTradeDetailActivity;
import java.util.Map;
import rx.functions.Action1;

public final /* synthetic */ class q1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeDetailActivity f53735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f53736c;

    public /* synthetic */ q1(ContractTradeDetailActivity contractTradeDetailActivity, Map map) {
        this.f53735b = contractTradeDetailActivity;
        this.f53736c = map;
    }

    public final void call(Object obj) {
        this.f53735b.ph(this.f53736c, (ContractOrderDetailResult) obj);
    }
}
