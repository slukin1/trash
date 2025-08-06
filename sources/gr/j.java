package gr;

import android.widget.CheckBox;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f54883b;

    public /* synthetic */ j(CheckBox checkBox) {
        this.f54883b = checkBox;
    }

    public final void call(Object obj) {
        HuobiToastUtil.v(this.f54883b.getContext().getString(R.string.market_delete_collection_success));
    }
}
