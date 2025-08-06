package pk;

import android.view.View;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.feature.ui.FutureTradeView;

public final /* synthetic */ class q1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeView f53128b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlSettingDialogFragment.c f53129c;

    public /* synthetic */ q1(FutureTradeView futureTradeView, FutureTpSlSettingDialogFragment.c cVar) {
        this.f53128b = futureTradeView;
        this.f53129c = cVar;
    }

    public final void onClick(View view) {
        this.f53128b.e2(this.f53129c, view);
    }
}
