package com.huobi.otc.handler;

import android.view.ViewGroup;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.CouponReturnItem;
import s9.a;
import s9.c;

public class CouponReturnHandler<T extends a> implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, CouponReturn couponReturn, ViewGroup viewGroup) {
        CouponReturnItem couponReturnItem = (CouponReturnItem) cVar.e().b(R$id.coupon_item);
        couponReturnItem.i(couponReturn);
        if (couponReturn.getCallback() != null) {
            couponReturnItem.setCallback(couponReturn.getCallback());
        }
    }

    public int getResId() {
        return R$layout.item_coupon_return;
    }
}
