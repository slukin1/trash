package fj;

import android.content.Context;
import android.view.View;
import com.huobi.contract.viewhandler.ContractPositionViewHandler;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54618b;

    public /* synthetic */ h(Context context) {
        this.f54618b = context;
    }

    public final void onClick(View view) {
        ContractPositionViewHandler.m(this.f54618b, view);
    }
}
