package com.huobi.feature.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.business.common.swapzero.data.SwapZeroSideModel;
import com.business.common.swapzero.view.SwapZeroSideView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.hbg.module.libkt.base.ext.f;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.feature.presenter.FutureTradePresenter;
import com.huobi.otcoption.ui.OtcOptionsIndexActivity;
import com.huobi.tradenew.ui.kline.KlineView;
import com.huobi.view.MarketTitleLayout;
import com.huobi.view.TitleLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.k0;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pk.p;
import pk.q;
import pk.s;
import pk.t;
import pk.u;
import pk.v;
import pk.w;
import pro.huobi.R;
import qk.n0;
import tg.r;
import yl.x;

public class FutureTradeFragment extends BaseFragment<FutureTradePresenter, FutureTradePresenter.d> implements FutureTradePresenter.d {
    public int A = 220;
    public HashMap<Integer, Integer> B = new HashMap<>(8);

    /* renamed from: l  reason: collision with root package name */
    public MarketTitleLayout f44715l;

    /* renamed from: m  reason: collision with root package name */
    public HorizontalScrollView f44716m;

    /* renamed from: n  reason: collision with root package name */
    public AppBarLayout f44717n;

    /* renamed from: o  reason: collision with root package name */
    public View f44718o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f44719p;

    /* renamed from: q  reason: collision with root package name */
    public List<String> f44720q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public int f44721r = -1;

    /* renamed from: s  reason: collision with root package name */
    public View f44722s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f44723t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f44724u;

    /* renamed from: v  reason: collision with root package name */
    public KlineView f44725v;

    /* renamed from: w  reason: collision with root package name */
    public View f44726w;

    /* renamed from: x  reason: collision with root package name */
    public View f44727x;

    /* renamed from: y  reason: collision with root package name */
    public KlineViewWrapper f44728y;

    /* renamed from: z  reason: collision with root package name */
    public View f44729z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FutureTradeFragment.this.w3();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ((FutureTradePresenter) FutureTradeFragment.this.yh()).t0(true);
            FutureTradeFragment.this.f44725v.r();
            FutureTradeFragment.this.f44726w.setVisibility(0);
            FutureTradeFragment.this.f67460i.b(R.id.future_tab_content).setPadding(0, 0, 0, FutureTradeFragment.this.f44725v.getHeight());
        }
    }

    public class c implements TitleLayout.OnTitleListener {
        public c() {
        }

        public void onTitleChange(int i11) {
            if (FutureTradeFragment.this.f44721r != i11) {
                int scrollX = FutureTradeFragment.this.f44716m.getScrollX();
                View childAt = FutureTradeFragment.this.f44715l.getChildAt(i11);
                int left = childAt.getLeft();
                if (left < scrollX) {
                    FutureTradeFragment.this.f44716m.smoothScrollBy(left - scrollX, 0);
                }
                int right = childAt.getRight();
                int measuredWidth = FutureTradeFragment.this.f44716m.getMeasuredWidth();
                if (measuredWidth + scrollX < right) {
                    FutureTradeFragment.this.f44716m.smoothScrollBy((right - scrollX) - measuredWidth, 0);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("margin_type", g.d());
                int intValue = FutureTradeFragment.this.B.get(Integer.valueOf(i11)).intValue();
                if (intValue == 0) {
                    ((FutureTradePresenter) FutureTradeFragment.this.yh()).z0();
                    g.j("contract_trade", (String) null, "usdt_contract", hashMap);
                } else if (intValue == 2) {
                    b2.a.d().a("/webView/index").withString("url", "holigeit://open/v1?url=ihuobiglobal://m.hbg.com/Contract/CopyTrading").navigation();
                    g.j("contract_trade", (String) null, "copytrading_contract", (HashMap) null);
                } else if (intValue == 3) {
                    zn.a.d().v(Uri.parse("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/trade/bot?source=app_bots_futurestrade")).c();
                    g.i("tradingbot_pageview_app_furures", (HashMap) null);
                } else if (intValue == 4) {
                    ((FutureTradePresenter) FutureTradeFragment.this.yh()).A0();
                    OtcOptionsIndexActivity.Qi((String) null, "futures", FutureTradeFragment.this.getActivity());
                    HashMap hashMap2 = new HashMap();
                    if (!TextUtils.isEmpty(xp.a.a())) {
                        hashMap2.put("symbol", xp.a.a());
                    }
                    is.a.j("6145", hashMap2, "1005379");
                    g.j("contract_trade", (String) null, "share_option", hashMap);
                } else if (intValue != 5) {
                    ((FutureTradePresenter) FutureTradeFragment.this.yh()).u0();
                    g.j("contract_trade", (String) null, "coin_contract", hashMap);
                } else if (r.x().X()) {
                    HuobiToastUtil.j(R.string.sub_account_not_support_otc);
                } else {
                    k0.k(FutureTradeFragment.this.getActivity());
                }
            }
        }

        public void onTitleStatueChange(int i11, boolean z11) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wh(NewBannerBean.BannerAdv bannerAdv, SwapZeroSideView swapZeroSideView, View view) {
        ((FutureTradePresenter) yh()).s0(bannerAdv);
        swapZeroSideView.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh(List list) {
        Log.d("合约", getClass().getSimpleName() + "-设置底部左侧资源位: " + f.e().toJson((Object) list));
        SwapZeroSideView swapZeroSideView = (SwapZeroSideView) this.f67460i.b(R.id.swapZeroSideView);
        if (list.isEmpty()) {
            swapZeroSideView.setVisibility(8);
            return;
        }
        NewBannerBean.BannerAdv bannerAdv = (NewBannerBean.BannerAdv) list.get(0);
        if (((FutureTradePresenter) yh()).m0(bannerAdv)) {
            swapZeroSideView.setCloseListener(new pk.r(this, bannerAdv, swapZeroSideView));
            swapZeroSideView.setTradeActivity(new SwapZeroSideModel(NightHelper.e().g() ? bannerAdv.getNightImageUrl() : bannerAdv.getImageUrl(), bannerAdv.getAdvId(), bannerAdv.getTitle(), bannerAdv.getJumpTo()));
            swapZeroSideView.setVisibility(0);
            return;
        }
        swapZeroSideView.setVisibility(8);
    }

    public static /* synthetic */ void Yh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "contracts_ad");
        hashMap.put("button_name", "contracts_ad_cancel");
        g.i("appclick_contracts", hashMap);
    }

    public static /* synthetic */ void Zh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        BaseModuleConfig.a().l0("/contract/activityZero", true);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "contracts_ad");
        hashMap.put("button_name", "contracts_ad_receive");
        g.i("appclick_contracts", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean) {
        String str = "";
        String valueOf = activityZeroAvailablePositionBean.getCount() == null ? str : String.valueOf(activityZeroAvailablePositionBean.getCount());
        if (activityZeroAvailablePositionBean.getHighestProfit() != null) {
            str = activityZeroAvailablePositionBean.getHighestProfit();
        }
        Resources resources = getResources();
        String string = resources.getString(R.string.n_zero_swap_max_profit_tips, new Object[]{valueOf, str + " USDT"});
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "contracts_ad");
        g.i("pageview_contracts", hashMap);
        DialogUtils.b0(getActivity(), getString(R.string.n_otc_use_tip), string, "", getString(R.string.n_cancel), getString(R.string.n_coupon_state_pending_button), u.f53146a, v.f53150a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bi() {
        this.f44727x.setTranslationY((float) this.f44725v.getLayoutParams().height);
        this.f44725v.setVisibility(0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "Kline");
        int i11 = this.f44721r;
        String str = i11 == 0 ? "usdt_contract" : i11 == 1 ? "coin_contract" : null;
        if (((FutureTradePresenter) yh()).l0()) {
            this.f67460i.b(R.id.future_tab_content).setPadding(0, 0, 0, 0);
            this.f44724u.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
            ViewPropertyAnimator duration = this.f44727x.animate().translationY((float) this.f44725v.getHeight()).setInterpolator(new DecelerateInterpolator()).setDuration((long) this.A);
            duration.setListener(new a());
            duration.start();
            g.j("contract_trade", str, "collect", hashMap);
        } else {
            this.f44724u.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_down_button, 0);
            ViewPropertyAnimator duration2 = this.f44727x.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration((long) this.A);
            duration2.setListener(new b());
            duration2.start();
            g.j("contract_trade", str, "spread", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof FutureTradeContainerActivity)) {
            activity.finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f44722s.setOnClickListener(new q(this));
        this.f44719p.setOnClickListener(new p(this));
        ((FutureTradePresenter) yh()).f44643p.observe(this, new t(this));
        ((FutureTradePresenter) yh()).f44645r.observe(this, new s(this));
    }

    public void B3(int i11) {
        this.f44721r = i11;
        this.f44715l.setIndex(i11);
    }

    public void D2() {
        this.f67460i.b(R.id.future_tab_content).setPadding(0, 0, 0, 0);
        this.f44728y.C();
    }

    /* renamed from: Qh */
    public FutureTradePresenter xh() {
        return new FutureTradePresenter();
    }

    public final int Rh(int i11) {
        for (Integer intValue : this.B.keySet()) {
            int intValue2 = intValue.intValue();
            if (this.B.get(Integer.valueOf(intValue2)).intValue() == i11) {
                return intValue2;
            }
        }
        return 1;
    }

    /* renamed from: Sh */
    public FutureTradePresenter.d zh() {
        return this;
    }

    public final void Th() {
        this.f44722s = this.f67460i.b(R.id.trade_vertical_kline_show_rl);
        this.f44723t = (TextView) this.f67460i.b(R.id.trade_vertical_kline_symbol_tv);
        this.f44724u = (TextView) this.f67460i.b(R.id.trade_vertical_kline_show_tv);
        this.f44728y = (KlineViewWrapper) this.f67460i.b(R.id.klineViewWrapper);
        this.f44729z = this.f67460i.b(R.id.kline_wrapper_container);
        this.f44725v = (KlineView) this.f67460i.b(R.id.klineViewWrapper_rl);
        this.f44726w = this.f67460i.b(R.id.klineViewWrapper_bottom_divider);
        View view = (View) this.f44725v.getParent();
        this.f44727x = view;
        view.post(new w(this));
    }

    public final void Uh() {
        int statusBarHeight = BaseActivity.getStatusBarHeight(getContext());
        View b11 = this.f67460i.b(R.id.future_trade_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = statusBarHeight;
        b11.setLayoutParams(layoutParams);
        View b12 = this.f67460i.b(R.id.appbar_layout);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b12.getLayoutParams();
        marginLayoutParams.topMargin = statusBarHeight;
        b12.setLayoutParams(marginLayoutParams);
    }

    public final void Vh() {
        this.f44720q.add(getResources().getString(R.string.n_contract_tab_usdt_top_title));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 0);
        this.f44720q.add(getResources().getString(R.string.n_contract_tab_coin_top_title));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 1);
        this.f44720q.add(getResources().getString(R.string.n_asset_contract_to_copy_trading));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 2);
        this.f44720q.add(getResources().getString(R.string.n_trade_bot));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 3);
        this.f44720q.add(getResources().getString(R.string.n_otc_options));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 4);
        this.f44720q.add(getResources().getString(R.string.n_trade_fiat_title));
        this.B.put(Integer.valueOf(this.f44720q.size() - 1), 5);
        this.f44715l.setUnableSelectedIndex(2);
        this.f44715l.setUnableSelectedIndex(4);
        this.f44715l.setUnableSelectedIndex(5);
        this.f44715l.setUnableSelectedIndex(3);
        this.f44715l.setItemSpace(0);
        this.f44715l.setItemPaddingLeft(getResources().getDimensionPixelOffset(R.dimen.dimen_8));
        this.f44715l.setItemPaddingRight(getResources().getDimensionPixelOffset(R.dimen.dimen_8));
        this.f44715l.setNormalTextSize((float) getResources().getDimensionPixelSize(R.dimen.dimen_18));
        this.f44715l.setSelectedTextSize((float) getResources().getDimensionPixelSize(R.dimen.dimen_18));
        this.f44715l.setNormalColor(getResources().getColor(R.color.baseColorSecondaryText));
        this.f44715l.setSelectedColor(getResources().getColor(R.color.baseColorPrimaryText));
        this.f44715l.setTitles(this.f44720q, Rh(n0.a()));
        this.f44715l.setTitleListener(new c());
        this.f44715l.showHidePoint(CouponExperienceRequestHelper.getInstance().mContractTabRedVisible, 0);
    }

    public void afterInit() {
        super.afterInit();
    }

    public void ci(boolean z11) {
        this.f44725v.setIsCoin(z11);
        if (((FutureTradePresenter) yh()).l0()) {
            this.f44725v.r();
        }
    }

    public void di(int i11) {
        this.f44725v.setVolPrecision(i11);
    }

    public void ei(CharSequence charSequence, String str, String str2, int i11, int i12) {
        if (charSequence instanceof SpannableStringBuilder) {
            this.f44723t.setText(((SpannableStringBuilder) charSequence).append(" ").append(getString(R.string.contract_kline_chart)));
        } else {
            TextView textView = this.f44723t;
            textView.setText(charSequence + " " + getString(R.string.contract_kline_chart));
        }
        if (!TextUtils.equals(str2, this.f44725v.M)) {
            w3();
            this.f44728y.G();
        }
        this.f44725v.i(false, str, str2, i11, i12);
        if (((FutureTradePresenter) yh()).l0()) {
            this.f44725v.r();
        }
    }

    public void initViews() {
        super.initViews();
        Uh();
        Th();
        this.f44715l = (MarketTitleLayout) this.f67460i.b(R.id.title_layout);
        this.f44716m = (HorizontalScrollView) this.f67460i.b(R.id.title_horizontal_scroll);
        this.f44717n = (AppBarLayout) this.f67460i.b(R.id.appbar_layout);
        this.f44718o = this.f67460i.b(R.id.title_divider_container);
        Vh();
        this.f44718o.setVisibility(0);
        this.f44719p = (ImageView) this.f67460i.b(R.id.future_trade_home_up);
        if (getActivity() instanceof FutureTradeContainerActivity) {
            this.f44719p.setVisibility(0);
        } else {
            this.f44719p.setVisibility(8);
        }
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void j0(int i11) {
        this.f44715l.setSelectedText(getString(i11));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractRedUpdate(CouponExperienceRequestHelper couponExperienceRequestHelper) {
        this.f44715l.showHidePoint(couponExperienceRequestHelper.mContractTabRedVisible, 0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onResume() {
        super.onResume();
        ((FutureTradePresenter) yh()).r0();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_future_trade, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            ClosePathFloatView.g(TradeType.CONTRACT.toString(), getActivity(), true);
            if (r.x().F0()) {
                ContractPriceProtectionHelper.b((c6.a) null);
                d7.k0.d(false).compose(RxJavaHelper.t(zh())).subscribe(new BaseSubscriber());
            }
            x.n().t(getActivity());
            ((FutureTradePresenter) yh()).q0();
            if (ConfigPreferences.c("user_config", "CONTRACT_NEW_GUIDE", false)) {
                ((FutureTradePresenter) yh()).p0();
            }
        }
    }

    public void w3() {
        this.f44724u.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
        if (((FutureTradePresenter) yh()).l0()) {
            this.f44727x.setTranslationY((float) this.f44725v.getHeight());
            D2();
        }
        ((FutureTradePresenter) yh()).t0(false);
        this.f44726w.setVisibility(8);
    }

    public void z8(boolean z11, boolean z12) {
        this.f44717n.setExpanded(z11, z12);
    }
}
