package hp;

import android.view.View;
import com.huobi.otc.bean.OtcFastBuyMatchPaymentBean;
import com.huobi.otc.handler.OtcFastBuyMatchPaymentHandler;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFastBuyMatchPaymentBean f54972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f54973c;

    public /* synthetic */ r(OtcFastBuyMatchPaymentBean otcFastBuyMatchPaymentBean, int i11) {
        this.f54972b = otcFastBuyMatchPaymentBean;
        this.f54973c = i11;
    }

    public final void onClick(View view) {
        OtcFastBuyMatchPaymentHandler.e(this.f54972b, this.f54973c, view);
    }
}
