package vg;

import android.view.View;
import com.huobi.account.bean.BoxToolRespBean;
import com.huobi.account.viewhandler.BoxToolHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxToolRespBean.ToolBean f61010b;

    public /* synthetic */ b(BoxToolRespBean.ToolBean toolBean) {
        this.f61010b = toolBean;
    }

    public final void onClick(View view) {
        BoxToolHandler.d(this.f61010b, view);
    }
}
