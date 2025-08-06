package com.huobi.otc.handler;

import android.view.ViewGroup;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.ExperienceItem;
import s9.a;
import s9.c;

public class ExperienceHandler<T extends a> implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, CouponReturn couponReturn, ViewGroup viewGroup) {
        ExperienceItem experienceItem = (ExperienceItem) cVar.e().b(R$id.experience_item);
        experienceItem.j(couponReturn);
        if (couponReturn.getExCallback() != null) {
            experienceItem.setExCallback(couponReturn.getExCallback());
        }
    }

    public int getResId() {
        return R$layout.item_experience_return;
    }
}
