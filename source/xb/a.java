package xb;

import android.content.Context;
import com.hbg.module.account.edgeengine.widget.AccountAvatarWidget;
import com.hbg.module.account.index.ui.view.AccountAvatarNewView;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class a implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarWidget f61518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarNewView f61519b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61520c;

    public /* synthetic */ a(AccountAvatarWidget accountAvatarWidget, AccountAvatarNewView accountAvatarNewView, Context context) {
        this.f61518a = accountAvatarWidget;
        this.f61519b = accountAvatarNewView;
        this.f61520c = context;
    }

    public final void a(String str) {
        AccountAvatarWidget.d0(this.f61518a, this.f61519b, this.f61520c, str);
    }
}
