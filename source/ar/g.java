package ar;

import android.content.Context;
import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.huobi.search.SearchHistoryView;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryView f12176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12177c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12178d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f12179e;

    public /* synthetic */ g(SearchHistoryView searchHistoryView, String str, Context context, FutureContractInfo futureContractInfo) {
        this.f12176b = searchHistoryView;
        this.f12177c = str;
        this.f12178d = context;
        this.f12179e = futureContractInfo;
    }

    public final void onClick(View view) {
        this.f12176b.k(this.f12177c, this.f12178d, this.f12179e, view);
    }
}
