package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.viewhandler.VirtualAddressViewHander;

public final /* synthetic */ class e3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VirtualAddressInfo f12576b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12577c;

    public /* synthetic */ e3(VirtualAddressInfo virtualAddressInfo, Context context) {
        this.f12576b = virtualAddressInfo;
        this.f12577c = context;
    }

    public final void onClick(View view) {
        VirtualAddressViewHander.i(this.f12576b, this.f12577c, view);
    }
}
