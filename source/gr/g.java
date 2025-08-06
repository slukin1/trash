package gr;

import android.view.View;
import com.huobi.search.viewhandler.SearchResultItemHandler;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResultItemHandler f54878b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f54879c;

    public /* synthetic */ g(SearchResultItemHandler searchResultItemHandler, int i11) {
        this.f54878b = searchResultItemHandler;
        this.f54879c = i11;
    }

    public final void onClick(View view) {
        this.f54878b.i(this.f54879c, view);
    }
}
