package fj;

import android.view.View;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.contract.viewhandler.ContractLeftDrawerItemHandler;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfoDrawerItem f54611b;

    public /* synthetic */ e(ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem) {
        this.f54611b = contractCurrencyInfoDrawerItem;
    }

    public final void onClick(View view) {
        ContractLeftDrawerItemHandler.g(this.f54611b, view);
    }
}
