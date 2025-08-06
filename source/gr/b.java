package gr;

import android.view.View;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRecommendItemHandler f54863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54864c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54865d;

    public /* synthetic */ b(SearchRecommendItemHandler searchRecommendItemHandler, String str, int i11) {
        this.f54863b = searchRecommendItemHandler;
        this.f54864c = str;
        this.f54865d = i11;
    }

    public final void onClick(View view) {
        this.f54863b.k(this.f54864c, this.f54865d, view);
    }
}
