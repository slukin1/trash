package fj;

import aj.c;
import android.view.View;
import com.huobi.contract.viewhandler.ContractStopOrderListItemHandler;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f54623b;

    public /* synthetic */ m(c cVar) {
        this.f54623b = cVar;
    }

    public final void onClick(View view) {
        ContractStopOrderListItemHandler.e(this.f54623b, view);
    }
}
