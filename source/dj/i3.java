package dj;

import android.view.View;
import com.huobi.contract.ui.ContractTradeView;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;

public final /* synthetic */ class i3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeView f53693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f53694c;

    public /* synthetic */ i3(ContractTradeView contractTradeView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f53693b = contractTradeView;
        this.f53694c = cVar;
    }

    public final void onClick(View view) {
        this.f53693b.g2(this.f53694c, view);
    }
}
