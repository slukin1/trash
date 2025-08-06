package pn;

import android.graphics.Bitmap;
import com.huobi.login.ui.RegisterBottomTipsLayout;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegisterBottomTipsLayout.a f53197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f53198c;

    public /* synthetic */ h(RegisterBottomTipsLayout.a aVar, Bitmap bitmap) {
        this.f53197b = aVar;
        this.f53198c = bitmap;
    }

    public final void run() {
        this.f53197b.f(this.f53198c);
    }
}
