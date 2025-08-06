package ts;

import android.view.View;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.swap.ui.SwapTradeTogetherView;

public final /* synthetic */ class p1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapTradeTogetherView f60411b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f60412c;

    public /* synthetic */ p1(SwapTradeTogetherView swapTradeTogetherView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f60411b = swapTradeTogetherView;
        this.f60412c = cVar;
    }

    public final void onClick(View view) {
        this.f60411b.Z1(this.f60412c, view);
    }
}
