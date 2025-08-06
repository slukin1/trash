package da;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.viewhander.BottomMenuHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuItemBean.a f53548b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItemBean f53549c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f53550d;

    public /* synthetic */ a(MenuItemBean.a aVar, MenuItemBean menuItemBean, int i11) {
        this.f53548b = aVar;
        this.f53549c = menuItemBean;
        this.f53550d = i11;
    }

    public final void onClick(View view) {
        BottomMenuHandler.d(this.f53548b, this.f53549c, this.f53550d, view);
    }
}
