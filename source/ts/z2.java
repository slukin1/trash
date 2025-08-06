package ts;

import android.view.View;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.swap.ui.SwapTradeView;

public final /* synthetic */ class z2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeView f60465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f60466c;

    public /* synthetic */ z2(SwapTradeView swapTradeView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f60465b = swapTradeView;
        this.f60466c = cVar;
    }

    public final void onClick(View view) {
        this.f60465b.d2(this.f60466c, view);
    }
}
