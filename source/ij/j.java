package ij;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.coupon.bean.CouponReturnContainer;
import com.huobi.coupon.service.CouponService;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import u6.g;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static j f47597a = new j();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, ArrayList<CouponReturn>> f47598b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f47599c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f47600d;

    public class a extends EasySubscriber<CouponReturnContainer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f47602c;

        public a(String str, b bVar) {
            this.f47601b = str;
            this.f47602c = bVar;
        }

        /* renamed from: a */
        public void onNext(CouponReturnContainer couponReturnContainer) {
            super.onNext(couponReturnContainer);
            ArrayList arrayList = new ArrayList();
            List<CouponReturn> coupons = couponReturnContainer.getCoupons();
            if (!com.hbg.module.libkt.base.ext.b.w(coupons)) {
                String j11 = SP.j("couponChoose", "couponIds" + this.f47601b, "");
                StringBuilder sb2 = new StringBuilder();
                Iterator<CouponReturn> it2 = coupons.iterator();
                do {
                    sb2.append(it2.next().getId() + "");
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                } while (it2.hasNext());
                sb2.deleteCharAt(sb2.length() - 1);
                HashSet hashSet = new HashSet(Arrays.asList(sb2.toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                hashSet.removeAll(Arrays.asList(j11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                if (!hashSet.isEmpty()) {
                    SP.x("couponChoose", "hasNewCoupon" + this.f47601b, true);
                    we.b.l("tradeCouponPoint", Object.class).g(0);
                }
                SP.w("couponChoose", "couponIds" + this.f47601b, sb2.toString());
                arrayList.addAll(coupons);
            } else {
                SP.o("couponChoose", "hasNewCoupon" + this.f47601b);
                SP.o("couponChoose", "couponIds" + this.f47601b);
            }
            j.f47598b.put(this.f47601b, arrayList);
            boolean unused = j.f47600d = couponReturnContainer.isCheck();
            j.f47599c.put(this.f47601b, Integer.valueOf(arrayList.size()));
            this.f47602c.a(arrayList, arrayList.size());
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public interface b {
        void a(List<CouponReturn> list, int i11);
    }

    public static j g() {
        return f47597a;
    }

    public static /* synthetic */ Object k(b bVar, CouponReturnContainer couponReturnContainer, CouponReturnContainer couponReturnContainer2) {
        ArrayList arrayList = new ArrayList();
        List<CouponReturn> coupons = couponReturnContainer.getCoupons();
        List<CouponReturn> coupons2 = couponReturnContainer2.getCoupons();
        if (!com.hbg.module.libkt.base.ext.b.w(coupons)) {
            String j11 = SP.j("couponChoose", "couponIds9,12", "");
            StringBuilder sb2 = new StringBuilder();
            Iterator<CouponReturn> it2 = coupons.iterator();
            do {
                sb2.append(it2.next().getId() + "");
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            } while (it2.hasNext());
            sb2.deleteCharAt(sb2.length() - 1);
            HashSet hashSet = new HashSet(Arrays.asList(sb2.toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
            hashSet.removeAll(Arrays.asList(j11.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
            if (!hashSet.isEmpty()) {
                SP.x("couponChoose", "hasNewCoupon9,12", true);
                we.b.l("tradeCouponPoint", Object.class).g(0);
            }
            SP.w("couponChoose", "couponIds9,12", sb2.toString());
            arrayList.addAll(coupons);
        } else {
            SP.o("couponChoose", "hasNewCoupon9,12");
            SP.o("couponChoose", "couponIds9,12");
        }
        if (!com.hbg.module.libkt.base.ext.b.w(coupons2)) {
            arrayList.addAll(coupons2);
        }
        f47598b.put("9,12", arrayList);
        f47600d = couponReturnContainer.isCheck();
        f47599c.put("9,12", Integer.valueOf(coupons.size()));
        bVar.a(arrayList, coupons.size());
        return null;
    }

    public void e(b bVar) {
        Class cls = CouponService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("state", 0);
        hashMap.put("types", "9,12");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("state", 1);
        hashMap2.put("types", "12");
        new d9.a(Observable.zip(((CouponService) HbgRetrofit.request(cls)).getReturnCoupon(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null)), ((CouponService) HbgRetrofit.request(cls)).getReturnCoupon(hashMap2).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null)), new i(bVar))).d((RequestCallback1) null);
    }

    public ArrayList<CouponReturn> f(String str, CouponReturn couponReturn) {
        ArrayList<CouponReturn> arrayList = f47598b.get(str);
        if (arrayList == null) {
            return null;
        }
        Iterator<CouponReturn> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CouponReturn next = it2.next();
            if (couponReturn == null || couponReturn.getId() != next.getId()) {
                next.setSelected(false);
            } else {
                next.setSelected(true);
            }
        }
        return arrayList;
    }

    public int h(String str) {
        if (f47599c.containsKey(str)) {
            return f47599c.get(str).intValue();
        }
        return 0;
    }

    public void i(int i11, String str, b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(i11));
        hashMap.put("types", str);
        ((CouponService) HbgRetrofit.request(CouponService.class)).getReturnCoupon(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null)).subscribe(new a(str, bVar));
    }

    public boolean j() {
        return f47600d;
    }
}
