package sp;

import androidx.fragment.app.DialogFragment;
import com.huobi.otc.ui.CouponActivity;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponActivity f26066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogFragment f26067c;

    public /* synthetic */ p(CouponActivity couponActivity, DialogFragment dialogFragment) {
        this.f26066b = couponActivity;
        this.f26067c = dialogFragment;
    }

    public final void call(Object obj) {
        this.f26066b.Ch(this.f26067c, (Boolean) obj);
    }
}
