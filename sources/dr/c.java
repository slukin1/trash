package dr;

import com.huobi.search.bean.SearchResultCategoryItem;
import com.huobi.search.presenter.SearchDataPresenter;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53894b;

    public /* synthetic */ c(String str) {
        this.f53894b = str;
    }

    public final Object call(Object obj) {
        return SearchDataPresenter.p(this.f53894b, (SearchResultCategoryItem) obj);
    }
}
