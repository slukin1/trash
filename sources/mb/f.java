package mb;

import android.view.View;
import com.hbg.lite.search.bean.LiteChooseCurrencyItem;
import com.hbg.lite.search.ui.LiteCurrencyChooseActivity;
import com.huobi.view.indexlist.IndexPartAdapter;

public final /* synthetic */ class f implements IndexPartAdapter.OnItemContentClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiteCurrencyChooseActivity f58148a;

    public /* synthetic */ f(LiteCurrencyChooseActivity liteCurrencyChooseActivity) {
        this.f58148a = liteCurrencyChooseActivity;
    }

    public final void onItemClick(View view, int i11, int i12, Object obj) {
        this.f58148a.qh(view, i11, i12, (LiteChooseCurrencyItem) obj);
    }
}
