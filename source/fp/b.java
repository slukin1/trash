package fp;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.otc.edgeengine.p2p.widget.OtcBannerWidget;
import com.huobi.otc.widget.OtcTradeBannerView;

public final /* synthetic */ class b implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OtcBannerWidget f54730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f54731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcTradeBannerView f54732c;

    public /* synthetic */ b(OtcBannerWidget otcBannerWidget, Context context, OtcTradeBannerView otcTradeBannerView) {
        this.f54730a = otcBannerWidget;
        this.f54731b = context;
        this.f54732c = otcTradeBannerView;
    }

    public final void a(String str) {
        this.f54730a.b0(this.f54731b, this.f54732c, str);
    }
}
