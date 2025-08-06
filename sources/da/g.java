package da;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.viewhander.PaymentMethodMenuHandler;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItemBean.a f53560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItemBean f53561c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f53562d;

    public /* synthetic */ g(MenuItemBean.a aVar, MenuItemBean menuItemBean, int i11) {
        this.f53560b = aVar;
        this.f53561c = menuItemBean;
        this.f53562d = i11;
    }

    public final void onClick(View view) {
        PaymentMethodMenuHandler.d(this.f53560b, this.f53561c, this.f53562d, view);
    }
}
