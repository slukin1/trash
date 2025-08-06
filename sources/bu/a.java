package bu;

import android.content.Context;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.tradingbot.widget.DashLineView;
import com.huobi.tradingbot.widget.DashLineWidget;

public final /* synthetic */ class a implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DashLineWidget f12990a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12991b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DashLineView f12992c;

    public /* synthetic */ a(DashLineWidget dashLineWidget, Context context, DashLineView dashLineView) {
        this.f12990a = dashLineWidget;
        this.f12991b = context;
        this.f12992c = dashLineView;
    }

    public final void a(String str) {
        this.f12990a.Z(this.f12991b, this.f12992c, str);
    }
}
