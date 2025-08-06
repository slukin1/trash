package xb;

import android.content.Context;
import com.hbg.module.account.edgeengine.widget.AccountAvatarWidget;
import com.hbg.module.account.index.ui.view.AccountAvatarNewView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarWidget f61527b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61528c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarNewView f61529d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f61530e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f61531f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f61532g;

    public /* synthetic */ c(AccountAvatarWidget accountAvatarWidget, Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        this.f61527b = accountAvatarWidget;
        this.f61528c = context;
        this.f61529d = accountAvatarNewView;
        this.f61530e = str;
        this.f61531f = z11;
        this.f61532g = z12;
    }

    public final void run() {
        AccountAvatarWidget.f0(this.f61527b, this.f61528c, this.f61529d, this.f61530e, this.f61531f, this.f61532g);
    }
}
