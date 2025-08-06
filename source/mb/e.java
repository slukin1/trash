package mb;

import com.hbg.lite.search.ui.LiteCurrencyChooseActivity;
import com.huobi.view.indexlist.IndexPartAdapter;
import java.util.List;

public final /* synthetic */ class e implements IndexPartAdapter.IndexCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiteCurrencyChooseActivity f58147a;

    public /* synthetic */ e(LiteCurrencyChooseActivity liteCurrencyChooseActivity) {
        this.f58147a = liteCurrencyChooseActivity;
    }

    public final void onFinished(List list) {
        this.f58147a.th(list);
    }
}
