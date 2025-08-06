package gr;

import android.view.View;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRecommendItemHandler f54866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54867c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54868d;

    public /* synthetic */ c(SearchRecommendItemHandler searchRecommendItemHandler, String str, String str2) {
        this.f54866b = searchRecommendItemHandler;
        this.f54867c = str;
        this.f54868d = str2;
    }

    public final void onClick(View view) {
        this.f54866b.n(this.f54867c, this.f54868d, view);
    }
}
