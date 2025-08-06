package ar;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.search.SearchHistoryView;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryView f12180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12181c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12182d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12183e;

    public /* synthetic */ h(SearchHistoryView searchHistoryView, String str, Context context, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12180b = searchHistoryView;
        this.f12181c = str;
        this.f12182d = context;
        this.f12183e = contractCurrencyInfo;
    }

    public final void onClick(View view) {
        this.f12180b.l(this.f12181c, this.f12182d, this.f12183e, view);
    }
}
