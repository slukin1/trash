package jk;

import android.content.Context;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.engineutils.widget.BottomLineTextWidget;

public final /* synthetic */ class n implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f55977a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomLineTextView f55978b;

    public /* synthetic */ n(Context context, BottomLineTextView bottomLineTextView) {
        this.f55977a = context;
        this.f55978b = bottomLineTextView;
    }

    public final void a(String str) {
        BottomLineTextWidget.Z(this.f55977a, this.f55978b, str);
    }
}
