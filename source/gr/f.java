package gr;

import android.widget.CheckBox;
import com.huobi.search.bean.NewSearchItem;
import com.huobi.search.viewhandler.SearchRecommendItemHandler;
import td.g;

public final /* synthetic */ class f implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchRecommendItemHandler f54873a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54874b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f54875c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54876d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NewSearchItem f54877e;

    public /* synthetic */ f(SearchRecommendItemHandler searchRecommendItemHandler, String str, CheckBox checkBox, String str2, NewSearchItem newSearchItem) {
        this.f54873a = searchRecommendItemHandler;
        this.f54874b = str;
        this.f54875c = checkBox;
        this.f54876d = str2;
        this.f54877e = newSearchItem;
    }

    public final void a(boolean z11, Throwable th2) {
        this.f54873a.l(this.f54874b, this.f54875c, this.f54876d, this.f54877e, z11, th2);
    }
}
