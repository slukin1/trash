package xb;

import android.content.Context;
import com.hbg.module.account.edgeengine.widget.AccountAvatarWidget;
import com.hbg.module.account.index.ui.view.AccountAvatarNewView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarWidget f61521b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61522c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarNewView f61523d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f61524e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f61525f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f61526g;

    public /* synthetic */ b(AccountAvatarWidget accountAvatarWidget, Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        this.f61521b = accountAvatarWidget;
        this.f61522c = context;
        this.f61523d = accountAvatarNewView;
        this.f61524e = str;
        this.f61525f = z11;
        this.f61526g = z12;
    }

    public final void run() {
        AccountAvatarWidget.g0(this.f61521b, this.f61522c, this.f61523d, this.f61524e, this.f61525f, this.f61526g);
    }
}
