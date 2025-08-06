package jp;

import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.coupon.bean.Coupon;
import com.huobi.coupon.bean.CouponsData;
import com.huobi.coupon.service.CouponService;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.Observable;

public final class z1 {
    public static List<Coupon> c(List<Coupon> list, String str, String str2, String str3) {
        if (CollectionsUtils.b(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (OtcModuleConfig.a().p(list.get(i11), str2, str3)) {
                if (TextUtils.isEmpty(str) || m.a(str).compareTo(BigDecimal.ZERO) < 0) {
                    arrayList.add(list.get(i11));
                } else if (OtcModuleConfig.a().V(list.get(i11), str)) {
                    arrayList.add(list.get(i11));
                }
            }
        }
        return arrayList;
    }

    public static Observable<CouponsData> d(String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put(PlaceFields.PAGE, 0);
        hashMap.put("state", 0);
        hashMap.put("limit", 100);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("countryId", str);
        }
        return ((CouponService) HbgRetrofit.request(CouponService.class)).getUserCoupon(hashMap).compose(HbgRetrofit.e()).map(x1.f56091b).onErrorResumeNext(y1.f56095b);
    }

    public static /* synthetic */ CouponsData e(CouponsData couponsData) {
        if (couponsData != null) {
            for (int i11 = 0; i11 < couponsData.getCoupons().size(); i11++) {
                couponsData.getCoupons().get(i11).setSysTime(couponsData.getSysTime());
            }
        }
        return couponsData;
    }
}
