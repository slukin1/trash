package gr;

import android.widget.CheckBox;
import com.huobi.search.bean.NewSearchItem;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f54871b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewSearchItem f54872c;

    public /* synthetic */ e(CheckBox checkBox, NewSearchItem newSearchItem) {
        this.f54871b = checkBox;
        this.f54872c = newSearchItem;
    }

    public final void call(Object obj) {
        SearchRecommendItemHandler.m(this.f54871b, this.f54872c, obj);
    }
}
