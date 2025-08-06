package com.huobi.account.event;

import com.huobi.coupon.bean.Coupon;
import java.io.Serializable;

public class OpenOtcEvent implements Serializable {
    private Coupon coupon;

    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon2) {
        this.coupon = coupon2;
    }
}
