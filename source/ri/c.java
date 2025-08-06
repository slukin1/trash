package ri;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.lend.viewhandler.C2CLendOrderItemHandler;
import oi.a;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f25662b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2CLoanOrderBean f25663c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f25664d;

    public /* synthetic */ c(a aVar, C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton) {
        this.f25662b = aVar;
        this.f25663c = c2CLoanOrderBean;
        this.f25664d = commonSwitchButton;
    }

    public final void onClick(View view) {
        C2CLendOrderItemHandler.f(this.f25662b, this.f25663c, this.f25664d, view);
    }
}
