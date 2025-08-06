package ar;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.search.SearchHistoryView;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryView f12188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12189c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12190d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12191e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SymbolBean f12192f;

    public /* synthetic */ j(SearchHistoryView searchHistoryView, String str, Context context, String str2, SymbolBean symbolBean) {
        this.f12188b = searchHistoryView;
        this.f12189c = str;
        this.f12190d = context;
        this.f12191e = str2;
        this.f12192f = symbolBean;
    }

    public final void onClick(View view) {
        this.f12188b.m(this.f12189c, this.f12190d, this.f12191e, this.f12192f, view);
    }
}
