package yj;

import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.huobi.edgeengine.template.widget.Widget;
import rj.n;

public final /* synthetic */ class o implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Widget f61769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Widget f61770c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f61771d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Window f61772e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ n f61773f;

    public /* synthetic */ o(Widget widget, Widget widget2, WindowManager.LayoutParams layoutParams, Window window, n nVar) {
        this.f61769b = widget;
        this.f61770c = widget2;
        this.f61771d = layoutParams;
        this.f61772e = window;
        this.f61773f = nVar;
    }

    public final void onDismiss() {
        this.f61769b.M(this.f61770c, this.f61771d, this.f61772e, this.f61773f);
    }
}
