package i6;

import android.view.View;
import android.view.ViewTreeObserver;
import com.hbg.lib.common.utils.SoftInputUtils;

public final /* synthetic */ class o implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f55009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SoftInputUtils.a f55010c;

    public /* synthetic */ o(View view, SoftInputUtils.a aVar) {
        this.f55009b = view;
        this.f55010c = aVar;
    }

    public final void onGlobalLayout() {
        SoftInputUtils.j(this.f55009b, this.f55010c);
    }
}
