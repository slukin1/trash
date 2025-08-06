package dj;

import com.huobi.contract.entity.ContractOrderRspInfo;
import com.huobi.contract.ui.ContractTradeTriggerDetailActivity;
import rx.functions.Action1;

public final /* synthetic */ class b3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTriggerDetailActivity f53650b;

    public /* synthetic */ b3(ContractTradeTriggerDetailActivity contractTradeTriggerDetailActivity) {
        this.f53650b = contractTradeTriggerDetailActivity;
    }

    public final void call(Object obj) {
        this.f53650b.Qg((ContractOrderRspInfo) obj);
    }
}
