package bb;

import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lite.index.ui.LiteIndexFragment;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexFragment f12333b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItemBean f12334c;

    public /* synthetic */ i(LiteIndexFragment liteIndexFragment, MenuItemBean menuItemBean) {
        this.f12333b = liteIndexFragment;
        this.f12334c = menuItemBean;
    }

    public final void run() {
        this.f12333b.Nh(this.f12334c);
    }
}
