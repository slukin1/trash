package tn;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import ln.a;

public final /* synthetic */ class j1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV2 f37280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f37281c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f37282d;

    public /* synthetic */ j1(UserLoginActivityV2 userLoginActivityV2, View view, a aVar) {
        this.f37280b = userLoginActivityV2;
        this.f37281c = view;
        this.f37282d = aVar;
    }

    public final void onGlobalLayout() {
        this.f37280b.cj(this.f37281c, this.f37282d);
    }
}
