package com.huobi.otc.persenter;

import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.coupon.bean.Coupon;
import com.huobi.coupon.bean.CouponsData;
import com.huobi.coupon.service.CouponService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.List;
import u6.g;

public class CouponPresenter extends ActivityPresenter<c> {

    public class a extends EasySubscriber<CouponsData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EasyRecyclerView f78960b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LoadingLayout f78961c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f78962d;

        public a(EasyRecyclerView easyRecyclerView, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout) {
            this.f78960b = easyRecyclerView;
            this.f78961c = loadingLayout;
            this.f78962d = smartRefreshLayout;
        }

        /* renamed from: a */
        public void onNext(CouponsData couponsData) {
            super.onNext(couponsData);
            CouponPresenter.this.U(couponsData, this.f78962d, this.f78960b, this.f78961c);
        }

        public void onAfter() {
            super.onAfter();
            this.f78962d.e();
            this.f78962d.finishRefresh();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            CouponPresenter.this.X(this.f78961c, this.f78960b);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            CouponPresenter.this.T(aPIStatusErrorException, this.f78960b, this.f78961c);
        }

        public void onStart() {
            super.onStart();
            if (this.f78960b.getAdapter() == null || this.f78960b.getItemCount() == 0) {
                this.f78961c.p();
            }
        }
    }

    public class b extends EasySubscriber<CouponsData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EasyRecyclerView f78964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LoadingLayout f78965c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f78966d;

        public b(EasyRecyclerView easyRecyclerView, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout) {
            this.f78964b = easyRecyclerView;
            this.f78965c = loadingLayout;
            this.f78966d = smartRefreshLayout;
        }

        /* renamed from: a */
        public void onNext(CouponsData couponsData) {
            super.onNext(couponsData);
            CouponPresenter.this.U(couponsData, this.f78966d, this.f78964b, this.f78965c);
        }

        public void onAfter() {
            super.onAfter();
            this.f78966d.w();
            this.f78966d.finishRefresh();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            CouponPresenter.this.X(this.f78965c, this.f78964b);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            CouponPresenter.this.T(aPIStatusErrorException, this.f78964b, this.f78965c);
        }

        public void onStart() {
            super.onStart();
            if (this.f78964b.getAdapter() == null || this.f78964b.getItemCount() == 0) {
                this.f78965c.p();
            }
        }
    }

    public interface c extends g {
        void finish();

        void initViewPager();
    }

    public final void T(APIStatusErrorException aPIStatusErrorException, EasyRecyclerView easyRecyclerView, LoadingLayout loadingLayout) {
        if (aPIStatusErrorException != null && !TextUtils.isEmpty(aPIStatusErrorException.getErrCode()) && "10001".equals(aPIStatusErrorException.getErrCode())) {
            Z();
        } else if (easyRecyclerView.getItemCount() <= 0) {
            loadingLayout.k();
        }
    }

    public final void U(CouponsData couponsData, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView, LoadingLayout loadingLayout) {
        List c11;
        if (couponsData != null) {
            if (couponsData.getCoupons() != null) {
                List<Coupon> coupons = couponsData.getCoupons();
                for (int i11 = 0; i11 < coupons.size(); i11++) {
                    Coupon coupon = coupons.get(i11);
                    if (coupon != null) {
                        coupon.setSysTime(couponsData.getSysTime());
                    }
                }
            }
            if (couponsData.getNextPage() != couponsData.getPage()) {
                smartRefreshLayout.g(true);
                Object tag = loadingLayout.getTag();
                if (tag instanceof String) {
                    int parseInt = Integer.parseInt(tag.toString());
                    loadingLayout.setTag((parseInt + 1) + "");
                } else {
                    loadingLayout.setTag("0");
                }
            } else if (easyRecyclerView.getItemCount() == 0 && (couponsData.getCoupons() == null || couponsData.getCoupons().size() == 0)) {
                smartRefreshLayout.w();
                smartRefreshLayout.g(false);
            } else {
                smartRefreshLayout.e();
            }
            if (couponsData.getPage() == 0) {
                easyRecyclerView.e(couponsData.getCoupons());
            } else {
                v9.a adapter = easyRecyclerView.getAdapter();
                if ((adapter instanceof v9.a) && (c11 = adapter.c()) == null) {
                    c11.addAll(couponsData.getCoupons());
                    easyRecyclerView.e(c11);
                }
            }
            loadingLayout.g();
            if (easyRecyclerView.getItemCount() == 0) {
                loadingLayout.i();
                return;
            }
            return;
        }
        loadingLayout.i();
    }

    public void V(EasyRecyclerView easyRecyclerView, SmartRefreshLayout smartRefreshLayout, LoadingLayout loadingLayout) {
        HashMap hashMap = new HashMap();
        hashMap.put(PlaceFields.PAGE, loadingLayout.getTag());
        hashMap.put("limit", 15);
        ((CouponService) HbgRetrofit.request(CouponService.class)).getUnclaimedCoupon(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b(easyRecyclerView, loadingLayout, smartRefreshLayout));
    }

    public void W(EasyRecyclerView easyRecyclerView, int i11, SmartRefreshLayout smartRefreshLayout, LoadingLayout loadingLayout) {
        HashMap hashMap = new HashMap();
        hashMap.put(PlaceFields.PAGE, loadingLayout.getTag());
        hashMap.put("state", Integer.valueOf(i11));
        hashMap.put("limit", 15);
        String J = OtcModuleConfig.a().J();
        if (!TextUtils.isEmpty(J)) {
            hashMap.put("countryId", J);
        }
        ((CouponService) HbgRetrofit.request(CouponService.class)).getUserCoupon(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a(easyRecyclerView, loadingLayout, smartRefreshLayout));
    }

    public final void X(LoadingLayout loadingLayout, EasyRecyclerView easyRecyclerView) {
        Object tag = loadingLayout.getTag();
        if (tag != null && Integer.parseInt(tag.toString()) == 0 && easyRecyclerView.getItemCount() <= 0) {
            loadingLayout.k();
        }
    }

    /* renamed from: Y */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        ((c) getUI()).initViewPager();
    }

    public final void Z() {
        OtcModuleConfig.b().b(getActivity());
        ((c) getUI()).finish();
    }
}
