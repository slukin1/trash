package gr;

import android.content.Context;
import com.huobi.search.bean.NewSearchItem;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54869b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewSearchItem f54870c;

    public /* synthetic */ d(Context context, NewSearchItem newSearchItem) {
        this.f54869b = context;
        this.f54870c = newSearchItem;
    }

    public final void call(Object obj) {
        SearchRecommendItemHandler.j(this.f54869b, this.f54870c, obj);
    }
}
