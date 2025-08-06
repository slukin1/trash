package ar;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.search.SearchHistoryView;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryView f12184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12185c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12186d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f12187e;

    public /* synthetic */ i(SearchHistoryView searchHistoryView, String str, Context context, SwapCurrencyInfo swapCurrencyInfo) {
        this.f12184b = searchHistoryView;
        this.f12185c = str;
        this.f12186d = context;
        this.f12187e = swapCurrencyInfo;
    }

    public final void onClick(View view) {
        this.f12184b.j(this.f12185c, this.f12186d, this.f12187e, view);
    }
}
