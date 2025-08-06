package qk;

import android.view.View;
import com.huobi.feature.util.FutureTpSlHelper;
import com.huobi.view.TradePriceEditext;
import dj.k4;

public final /* synthetic */ class j0 implements k4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradePriceEditext f59975b;

    public /* synthetic */ j0(TradePriceEditext tradePriceEditext) {
        this.f59975b = tradePriceEditext;
    }

    public final void onFocusChange(View view, boolean z11) {
        FutureTpSlHelper.c1(this.f59975b, view, z11);
    }
}
