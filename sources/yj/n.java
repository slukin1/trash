package yj;

import android.widget.PopupWindow;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class n implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Widget f61767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Widget f61768c;

    public /* synthetic */ n(Widget widget, Widget widget2) {
        this.f61767b = widget;
        this.f61768c = widget2;
    }

    public final void onDismiss() {
        this.f61767b.I(this.f61768c);
    }
}
