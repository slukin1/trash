package com.huobi.otc.ui;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import bp.c;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.BusinessType;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.account.event.OpenEarnEvent;
import com.huobi.account.event.OpenOtcEvent;
import com.huobi.account.event.OpenTradeEvent;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.persenter.CouponPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import jp.k0;
import ky.j;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import sp.h;
import sp.i;
import sp.k;
import sp.l;
import sp.m;
import sp.n;
import sp.o;
import sp.p;
import u6.g;

public class CouponActivity extends BaseActivity<CouponPresenter, CouponPresenter.c> implements CouponPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f79235b = true;

    /* renamed from: c  reason: collision with root package name */
    public DecelerateInterpolator f79236c = new DecelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f79237d;

    /* renamed from: e  reason: collision with root package name */
    public CommonTextListIndicator f79238e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79239f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager f79240g;

    /* renamed from: h  reason: collision with root package name */
    public HorizontalScrollView f79241h;

    /* renamed from: i  reason: collision with root package name */
    public c f79242i;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            CouponActivity.this.f79240g.setCurrentItem(i11);
        }
    }

    public class b extends EasySubscriber<UserStepRateInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(UserStepRateInfo userStepRateInfo) {
            super.onNext(userStepRateInfo);
            if (userStepRateInfo.isPointSwitchOn()) {
                CouponActivity.this.vh();
            } else {
                CouponActivity.this.Eh();
            }
        }

        public void onAfter() {
            super.onAfter();
            CouponActivity.this.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(int i11, EasyRecyclerView easyRecyclerView, SmartRefreshLayout smartRefreshLayout, LoadingLayout loadingLayout, j jVar) {
        if (i11 == -1) {
            ((CouponPresenter) getPresenter()).V(easyRecyclerView, smartRefreshLayout, loadingLayout);
        } else {
            ((CouponPresenter) getPresenter()).W(easyRecyclerView, i11, smartRefreshLayout, loadingLayout);
        }
        if (easyRecyclerView == null || easyRecyclerView.getItemCount() <= 0) {
            loadingLayout.p();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView, View view) {
        Dh(i11, loadingLayout, smartRefreshLayout, easyRecyclerView);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(DialogFragment dialogFragment, Boolean bool) {
        if (bool.booleanValue()) {
            dialogFragment.dismiss();
            vh();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        HorizontalScrollView horizontalScrollView = this.f79241h;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(boolean z11) {
        if (z11) {
            this.f79239f.setVisibility(0);
            this.f79239f.animate().setInterpolator(this.f79236c).setDuration(300).translationX(0.0f).alpha(1.0f);
            return;
        }
        this.f79239f.animate().setInterpolator(this.f79236c).setDuration(300).translationX((float) this.f79239f.getWidth()).alpha(0.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f79241h.getChildAt(0).getWidth()) {
            th();
        } else {
            sh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView, j jVar) {
        Dh(i11, loadingLayout, smartRefreshLayout, easyRecyclerView);
    }

    public final void Dh(int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView) {
        loadingLayout.setTag("0");
        if (i11 == -1) {
            ((CouponPresenter) getPresenter()).V(easyRecyclerView, smartRefreshLayout, loadingLayout);
        } else {
            ((CouponPresenter) getPresenter()).W(easyRecyclerView, i11, smartRefreshLayout, loadingLayout);
        }
        if (easyRecyclerView == null || easyRecyclerView.getItemCount() <= 0) {
            loadingLayout.p();
        }
    }

    public final void Eh() {
        DialogUtils.b0(this, getResources().getString(R$string.n_coupon_point_discount_title), getResources().getString(R$string.n_coupon_point_discount_content), "", getResources().getString(R$string.n_coupon_point_discount_cancel), getResources().getString(R$string.n_coupon_point_discount_confirm), ad.b.f3517a, new m(this));
    }

    public void Fh(DialogFragment dialogFragment) {
        MapParamsBuilder c11 = MapParamsBuilder.c();
        c11.a("switchType", 1);
        OtcModuleConfig.a().s(c11.b()).compose(RxJavaHelper.t((g) null)).subscribe(d.c((g) null, new p(this, dialogFragment)));
    }

    public void addEvent() {
        this.f79237d.setNavigationOnClickListener(new h(this));
        this.f79239f.setOnClickListener(new i(this));
        this.f79238e.setOnScrollChangeCallback(new l(this));
        HorizontalScrollView horizontalScrollView = this.f79241h;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new k(this));
        }
    }

    public int getContentView() {
        return R$layout.activity_coupon;
    }

    public void initView() {
        this.f79237d = (Toolbar) this.viewFinder.b(R$id.toolbar_coupon);
        this.f79238e = (CommonTextListIndicator) this.viewFinder.b(R$id.common_text_list_indicator_coupon);
        this.f79239f = (ImageView) this.viewFinder.b(R$id.image_view_coupon_indicator_arrow_right);
        this.f79240g = (ViewPager) this.viewFinder.b(R$id.view_pager_coupon);
        this.f79238e.setCapitalTitle(false);
        EventBus.d().p(this);
    }

    public void initViewPager() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_coupon_state_pending));
        arrayList.add(getResources().getString(R$string.n_coupon_state_wait_use));
        arrayList.add(getResources().getString(R$string.n_coupon_state_using));
        arrayList.add(getResources().getString(R$string.n_coupon_state_used));
        arrayList.add(getResources().getString(R$string.n_coupon_state_expired));
        ArrayList arrayList2 = new ArrayList();
        LayoutInflater from = LayoutInflater.from(this);
        wh(arrayList2, from, -1);
        wh(arrayList2, from, 0);
        wh(arrayList2, from, 1);
        wh(arrayList2, from, 2);
        wh(arrayList2, from, 3);
        c cVar = new c(arrayList2);
        this.f79242i = cVar;
        this.f79240g.setAdapter(cVar);
        this.f79238e.setDataList(arrayList);
        this.f79238e.setCallback(new a());
        this.f79241h = (HorizontalScrollView) this.f79238e.findViewById(net.lucode.hackware.magicindicator.R$id.scroll_view);
        ViewPagerHelper.a(this.f79238e, this.f79240g);
        this.f79240g.setCurrentItem(1);
    }

    public boolean isAlive() {
        return true;
    }

    public boolean isCanBeSeen() {
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void openEarn(OpenEarnEvent openEarnEvent) {
        if (openEarnEvent != null && openEarnEvent.a() != null) {
            HBBaseWebActivity.showWebView(this, BaseModuleConfig.a().W() + "financial/earn/h5/", (String) null, "", false);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void openOtc(OpenOtcEvent openOtcEvent) {
        if (openOtcEvent != null && openOtcEvent.getCoupon() != null) {
            String baseCurrency = openOtcEvent.getCoupon().getBaseCurrency();
            if (!TextUtils.isEmpty(baseCurrency) && baseCurrency.contains("/")) {
                baseCurrency = baseCurrency.split("/")[0];
            }
            k0.p(this, baseCurrency);
            EventBus.d().k("10101");
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void openTrade(OpenTradeEvent openTradeEvent) {
        showProgressDialog();
        v7.b.a().L(BusinessType.PRO).b().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void refresh(Coupon coupon) {
        List<View> a11;
        int size;
        c cVar = this.f79242i;
        if (cVar != null && (a11 = cVar.a()) != null && (size = a11.size()) > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                Object tag = a11.get(i11).getTag();
                if (tag instanceof LoadingLayout) {
                    ((LoadingLayout) tag).getmOnRetryClickListener().onClick((View) tag);
                }
            }
        }
    }

    /* renamed from: rh */
    public CouponPresenter createPresenter() {
        return new CouponPresenter();
    }

    public final void sh() {
        if (!this.f79235b) {
            this.f79235b = true;
            this.f79239f.animate().setInterpolator(this.f79236c).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public void showOldProgressDialog(String str) {
    }

    public final void th() {
        if (this.f79235b) {
            this.f79235b = false;
            this.f79239f.animate().setInterpolator(this.f79236c).setDuration(300).translationX((float) this.f79239f.getWidth()).alpha(0.0f);
        }
    }

    /* renamed from: uh */
    public CouponPresenter.c getUI() {
        return this;
    }

    public final void vh() {
        OtcModuleConfig.b().D(this, false);
        EventBus.d().k("10101");
    }

    public final void wh(List<View> list, LayoutInflater layoutInflater, int i11) {
        View inflate = layoutInflater.inflate(R$layout.view_coupon_page, (ViewGroup) null);
        LoadingLayout loadingLayout = (LoadingLayout) inflate.findViewById(R$id.loading_layout_coupon_page);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R$id.smart_refresh_layout_coupon_page);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) inflate.findViewById(R$id.easy_recycler_view_coupon_page);
        int i12 = i11;
        SmartRefreshLayout smartRefreshLayout2 = smartRefreshLayout;
        smartRefreshLayout.d0(new o(this, i12, loadingLayout, smartRefreshLayout2, easyRecyclerView));
        smartRefreshLayout.b0(new n(this, i12, easyRecyclerView, smartRefreshLayout2, loadingLayout));
        loadingLayout.setTag("0");
        if (i11 == -1) {
            ((CouponPresenter) getPresenter()).V(easyRecyclerView, smartRefreshLayout, loadingLayout);
        } else {
            ((CouponPresenter) getPresenter()).W(easyRecyclerView, i11, smartRefreshLayout, loadingLayout);
        }
        View inflate2 = LayoutInflater.from(this).inflate(R$layout.item_coupon_empty, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = PixelUtils.a(90.0f);
        inflate2.setLayoutParams(layoutParams);
        loadingLayout.setEmptyView(inflate2);
        inflate2.setLayoutParams(layoutParams);
        loadingLayout.p();
        loadingLayout.setOnRetryClickListener(new sp.j(this, i11, loadingLayout, smartRefreshLayout, easyRecyclerView));
        list.add(inflate);
        inflate.setTag(loadingLayout);
    }
}
