package qa;

import android.view.View;
import com.hbg.lib.widgets.bean.CommonDateSelectorItemBean;
import com.hbg.lib.widgets.viewhandler.CommonDateTabItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonDateSelectorItemBean f53315b;

    public /* synthetic */ a(CommonDateSelectorItemBean commonDateSelectorItemBean) {
        this.f53315b = commonDateSelectorItemBean;
    }

    public final void onClick(View view) {
        CommonDateTabItemHandler.d(this.f53315b, view);
    }
}
