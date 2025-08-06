package wg;

import com.huobi.account.widget.AccountFixedQuickView;
import com.huobi.index.bean.IndexFeatureItem;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountFixedQuickView f61236b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f61237c;

    public /* synthetic */ a(AccountFixedQuickView accountFixedQuickView, IndexFeatureItem indexFeatureItem) {
        this.f61236b = accountFixedQuickView;
        this.f61237c = indexFeatureItem;
    }

    public final void call(Object obj) {
        this.f61236b.c(this.f61237c, (Void) obj);
    }
}
