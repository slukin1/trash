package fj;

import android.view.View;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.viewhandler.ContractPositionViewHandler;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractPosition f54619b;

    public /* synthetic */ i(ContractPosition contractPosition) {
        this.f54619b = contractPosition;
    }

    public final void onClick(View view) {
        ContractPositionViewHandler.k(this.f54619b, view);
    }
}
