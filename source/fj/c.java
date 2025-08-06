package fj;

import android.view.View;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentOrderItem;
import com.huobi.contract.viewhandler.ContractCurrentOrderHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCurrentOrderItem f54606b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrentOrderInfo f54607c;

    public /* synthetic */ c(ContractCurrentOrderItem contractCurrentOrderItem, ContractCurrentOrderInfo contractCurrentOrderInfo) {
        this.f54606b = contractCurrentOrderItem;
        this.f54607c = contractCurrentOrderInfo;
    }

    public final void onClick(View view) {
        ContractCurrentOrderHandler.e(this.f54606b, this.f54607c, view);
    }
}
