package vp;

import android.view.View;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.CouponReturnItem;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponReturnItem f61148b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CouponReturn f61149c;

    public /* synthetic */ i(CouponReturnItem couponReturnItem, CouponReturn couponReturn) {
        this.f61148b = couponReturnItem;
        this.f61149c = couponReturn;
    }

    public final void onClick(View view) {
        this.f61148b.m(this.f61149c, view);
    }
}
