package dj;

import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.ui.AbstractMaintenanceView;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractMaintenanceView f53658b;

    public /* synthetic */ d(AbstractMaintenanceView abstractMaintenanceView) {
        this.f53658b = abstractMaintenanceView;
    }

    public final void call(Object obj) {
        this.f53658b.l((ContractHeartBeat) obj);
    }
}
