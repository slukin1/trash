package ql;

import android.view.View;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.homemarket.handler.CollEditViewHandler;
import com.huobi.homemarket.model.CollEditModel;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollEditModel f60035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommonCheckBox f60036c;

    public /* synthetic */ j(CollEditModel collEditModel, CommonCheckBox commonCheckBox) {
        this.f60035b = collEditModel;
        this.f60036c = commonCheckBox;
    }

    public final void onClick(View view) {
        CollEditViewHandler.f(this.f60035b, this.f60036c, view);
    }
}
