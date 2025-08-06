package fj;

import android.view.View;
import com.huobi.contract.entity.OptionCurrencyInfoDrawerItem;
import com.huobi.contract.viewhandler.OptionLeftDrawerItemHandler;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionCurrencyInfoDrawerItem f54644b;

    public /* synthetic */ u(OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem) {
        this.f54644b = optionCurrencyInfoDrawerItem;
    }

    public final void onClick(View view) {
        OptionLeftDrawerItemHandler.h(this.f54644b, view);
    }
}
