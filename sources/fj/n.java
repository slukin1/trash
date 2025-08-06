package fj;

import aj.c;
import android.widget.LinearLayout;
import com.huobi.contract.viewhandler.ContractStopOrderListItemHandler;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f54624b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f54625c;

    public /* synthetic */ n(c cVar, LinearLayout linearLayout) {
        this.f54624b = cVar;
        this.f54625c = linearLayout;
    }

    public final void call(Object obj) {
        ContractStopOrderListItemHandler.f(this.f54624b, this.f54625c, (Void) obj);
    }
}
