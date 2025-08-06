package dr;

import com.huobi.search.bean.SearchResultCategoryItem;
import com.huobi.search.presenter.SearchDataPresenter;
import java.util.Map;
import rx.functions.Func2;

public final /* synthetic */ class d implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53895b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53896c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f53897d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Map f53898e;

    public /* synthetic */ d(String str, String str2, Map map, Map map2) {
        this.f53895b = str;
        this.f53896c = str2;
        this.f53897d = map;
        this.f53898e = map2;
    }

    public final Object call(Object obj, Object obj2) {
        return SearchDataPresenter.s(this.f53895b, this.f53896c, this.f53897d, this.f53898e, (SearchResultCategoryItem) obj, (SearchResultCategoryItem) obj2);
    }
}
