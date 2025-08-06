package vl;

import android.view.View;
import com.huobi.homemarket.view.OneKeyCollectView;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OneKeyCollectView f61085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61086c;

    public /* synthetic */ p(OneKeyCollectView oneKeyCollectView, View view) {
        this.f61085b = oneKeyCollectView;
        this.f61086c = view;
    }

    public final void call(Object obj) {
        this.f61085b.h(this.f61086c, (Void) obj);
    }
}
