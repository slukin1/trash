package com.huobi.otc.handler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.pro.core.util.TransferAccountType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.account.event.OpenEarnEvent;
import com.huobi.account.event.OpenOtcEvent;
import com.huobi.account.event.OpenTradeEvent;
import com.huobi.coupon.bean.Coupon;
import com.huobi.coupon.service.CouponService;
import com.huobi.otc.widget.CouponItem;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import s9.a;
import s9.c;
import u6.g;

public class CouponHandler<T extends s9.a> implements c, CouponItem.c {

    public class a extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Coupon f78699b;

        public a(Coupon coupon) {
            this.f78699b = coupon;
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            EventBus.d().k(this.f78699b);
        }
    }

    public void b(View view, Coupon coupon) {
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        if (-1 == coupon.getState()) {
            HashMap hashMap = new HashMap();
            hashMap.put("activityId", Long.valueOf(coupon.getActivityId()));
            hashMap.put("coupon-id", Long.valueOf(coupon.getCouponId()));
            hashMap.put("platform", 2);
            ((CouponService) HbgRetrofit.request(CouponService.class)).getCoupon(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null)).subscribe(new a(coupon));
        } else if (1 != coupon.getState() && coupon.getState() != 0) {
        } else {
            if (Coupon.PRIME_LIST.equals(coupon.getBusinessType()) || Coupon.CANDY_DROP.equals(coupon.getBusinessType())) {
                HBBaseWebActivity.showWebView(context, coupon.getUrl(), (String) null, (String) null, true);
            } else if (TransferAccountType.SPOT.type.equalsIgnoreCase(coupon.getBusinessType())) {
                OpenTradeEvent openTradeEvent = new OpenTradeEvent();
                openTradeEvent.a(coupon);
                EventBus.d().k(openTradeEvent);
            } else if (Coupon.SAVINGS.equals(coupon.getBusinessType())) {
                OpenEarnEvent openEarnEvent = new OpenEarnEvent();
                openEarnEvent.b(coupon);
                EventBus.d().k(openEarnEvent);
            } else {
                OpenOtcEvent openOtcEvent = new OpenOtcEvent();
                openOtcEvent.setCoupon(coupon);
                EventBus.d().k(openOtcEvent);
            }
        }
    }

    public void c(HBDialogFragment hBDialogFragment, Coupon coupon) {
    }

    public void d(Coupon coupon) {
        EventBus.d().k(coupon);
    }

    public void e(View view, Coupon coupon) {
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, Coupon coupon, ViewGroup viewGroup) {
        CouponItem couponItem = (CouponItem) cVar.e().b(R$id.coupon_item);
        couponItem.l(coupon);
        couponItem.setMCallback(this);
        if (coupon.getCallback() != null) {
            couponItem.setMCallback(coupon.getCallback());
        }
    }

    public int getResId() {
        return R$layout.item_coupon;
    }

    public Activity getRootActivity() {
        return null;
    }
}
