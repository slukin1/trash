package fp;

import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.otc.edgeengine.p2p.widget.OtcPayMethodsEdgeWidget;
import com.huobi.otc.widget.PaymentGroupView;

public final /* synthetic */ class c implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OtcPayMethodsEdgeWidget f54733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PaymentGroupView f54734b;

    public /* synthetic */ c(OtcPayMethodsEdgeWidget otcPayMethodsEdgeWidget, PaymentGroupView paymentGroupView) {
        this.f54733a = otcPayMethodsEdgeWidget;
        this.f54734b = paymentGroupView;
    }

    public final void a(String str) {
        this.f54733a.Z(this.f54734b, str);
    }
}
