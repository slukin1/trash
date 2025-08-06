package ar;

import android.content.Context;
import android.view.View;
import com.huobi.search.SearchHistoryView;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryView f12174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12175c;

    public /* synthetic */ f(SearchHistoryView searchHistoryView, Context context) {
        this.f12174b = searchHistoryView;
        this.f12175c = context;
    }

    public final void onClick(View view) {
        this.f12174b.h(this.f12175c, view);
    }
}
