package dr;

import com.huobi.search.bean.SearchResultCategoryItem;
import com.huobi.search.presenter.SearchDataPresenter;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53893b;

    public /* synthetic */ b(String str) {
        this.f53893b = str;
    }

    public final Object call(Object obj) {
        return SearchDataPresenter.r(this.f53893b, (SearchResultCategoryItem) obj);
    }
}
