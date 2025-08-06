package ri;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.huobi.c2c.lend.viewhandler.C2CLendOrderItemHandler;
import oi.a;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f25660b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2CLoanOrderBean f25661c;

    public /* synthetic */ b(a aVar, C2CLoanOrderBean c2CLoanOrderBean) {
        this.f25660b = aVar;
        this.f25661c = c2CLoanOrderBean;
    }

    public final void onClick(View view) {
        C2CLendOrderItemHandler.e(this.f25660b, this.f25661c, view);
    }
}
