package gr;

import android.view.View;
import com.huobi.search.viewhandler.SearchHistoryViewHandler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54862c;

    public /* synthetic */ a(View view, String str) {
        this.f54861b = view;
        this.f54862c = str;
    }

    public final void run() {
        SearchHistoryViewHandler.b.b(this.f54861b, this.f54862c);
    }
}
