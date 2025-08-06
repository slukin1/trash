package gu;

import android.view.View;
import com.huobi.view.bean.SelectorBean;
import com.huobi.view.viewhandler.SelectorItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectorBean f54891b;

    public /* synthetic */ a(SelectorBean selectorBean) {
        this.f54891b = selectorBean;
    }

    public final void onClick(View view) {
        SelectorItemHandler.lambda$handleView$0(this.f54891b, view);
    }
}
