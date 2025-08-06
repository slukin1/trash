package dr;

import com.huobi.search.bean.SearchResultCategoryItem;
import com.huobi.search.presenter.SearchDataPresenter;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53892b;

    public /* synthetic */ a(String str) {
        this.f53892b = str;
    }

    public final Object call(Object obj) {
        return SearchDataPresenter.q(this.f53892b, (SearchResultCategoryItem) obj);
    }
}
