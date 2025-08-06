package sp;

import android.view.View;
import com.huobi.otc.ui.CouponActivity;

public final /* synthetic */ class k implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CouponActivity f26038a;

    public /* synthetic */ k(CouponActivity couponActivity) {
        this.f26038a = couponActivity;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f26038a.yh(view, i11, i12, i13, i14);
    }
}
