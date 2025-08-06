package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.viewhandler.VirtualAddressViewHander;

public final /* synthetic */ class f3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12586b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VirtualAddressInfo f12587c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12588d;

    public /* synthetic */ f3(boolean z11, VirtualAddressInfo virtualAddressInfo, Context context) {
        this.f12586b = z11;
        this.f12587c = virtualAddressInfo;
        this.f12588d = context;
    }

    public final void onClick(View view) {
        VirtualAddressViewHander.j(this.f12586b, this.f12587c, this.f12588d, view);
    }
}
