package gr;

import android.view.View;
import com.huobi.search.viewhandler.SearchResultItemHandler;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54881c;

    public /* synthetic */ h(String str, String str2) {
        this.f54880b = str;
        this.f54881c = str2;
    }

    public final void onClick(View view) {
        SearchResultItemHandler.m(this.f54880b, this.f54881c, view);
    }
}
