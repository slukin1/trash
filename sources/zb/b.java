package zb;

import android.graphics.Bitmap;
import com.hbg.module.account.index.ui.view.AccountAvatarView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountAvatarView f62127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f62128c;

    public /* synthetic */ b(AccountAvatarView accountAvatarView, Bitmap bitmap) {
        this.f62127b = accountAvatarView;
        this.f62128c = bitmap;
    }

    public final void run() {
        AccountAvatarView.a.c(this.f62127b, this.f62128c);
    }
}
