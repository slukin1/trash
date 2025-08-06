package pk;

import android.view.View;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.feature.ui.FutureTradeTogetherView;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeTogetherView f53088b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f53089c;

    public /* synthetic */ h0(FutureTradeTogetherView futureTradeTogetherView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f53088b = futureTradeTogetherView;
        this.f53089c = cVar;
    }

    public final void onClick(View view) {
        this.f53088b.b2(this.f53089c, view);
    }
}
