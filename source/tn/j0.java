package tn;

import android.view.View;
import android.view.ViewTreeObserver;
import com.huobi.login.v2.ui.SubAccountLoginActivityV2;
import ln.a;

public final /* synthetic */ class j0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubAccountLoginActivityV2 f37277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f37278c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f37279d;

    public /* synthetic */ j0(SubAccountLoginActivityV2 subAccountLoginActivityV2, View view, a aVar) {
        this.f37277b = subAccountLoginActivityV2;
        this.f37278c = view;
        this.f37279d = aVar;
    }

    public final void onGlobalLayout() {
        this.f37277b.yi(this.f37278c, this.f37279d);
    }
}
