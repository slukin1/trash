package ql;

import android.view.View;
import com.huobi.homemarket.handler.CollEditViewHandler;
import com.huobi.homemarket.model.CollEditModel;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollEditModel f60034b;

    public /* synthetic */ i(CollEditModel collEditModel) {
        this.f60034b = collEditModel;
    }

    public final void onClick(View view) {
        CollEditViewHandler.h(this.f60034b, view);
    }
}
