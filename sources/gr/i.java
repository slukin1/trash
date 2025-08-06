package gr;

import android.widget.CheckBox;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f54882b;

    public /* synthetic */ i(CheckBox checkBox) {
        this.f54882b = checkBox;
    }

    public final void call(Object obj) {
        HuobiToastUtil.v(this.f54882b.getContext().getString(R.string.market_add_collection_success));
    }
}
