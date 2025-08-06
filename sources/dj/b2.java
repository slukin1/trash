package dj;

import android.view.View;
import com.huobi.contract.ui.ContractTradeTogetherView;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;

public final /* synthetic */ class b2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeTogetherView f53648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f53649c;

    public /* synthetic */ b2(ContractTradeTogetherView contractTradeTogetherView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f53648b = contractTradeTogetherView;
        this.f53649c = cVar;
    }

    public final void onClick(View view) {
        this.f53648b.S1(this.f53649c, view);
    }
}
