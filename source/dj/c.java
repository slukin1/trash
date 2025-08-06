package dj;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.ui.AbstractMaintenanceView;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractMaintenanceView f53652b;

    public /* synthetic */ c(AbstractMaintenanceView abstractMaintenanceView) {
        this.f53652b = abstractMaintenanceView;
    }

    public final void call(Object obj) {
        this.f53652b.m((APIStatusErrorException) obj);
    }
}
