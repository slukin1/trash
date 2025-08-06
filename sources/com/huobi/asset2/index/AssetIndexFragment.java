package com.huobi.asset2.index;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.adapter.recyclerview.EasyAssetRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.widget.AssetLoadingPositionViewData;
import com.huobi.asset2.index.component.AssetSummaryView;
import com.huobi.asset2.index.component.FeatureEntranceBar;
import com.huobi.asset2.index.component.banner.AssetBanner;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.huobi.finance.ui.g7;
import com.huobi.finance.ui.r7;
import com.huobi.share.AssetShareHelper;
import com.huobi.view.BaseBottomCurrencyDialogFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qh.p0;
import uh.e;
import vh.x;
import vh.z;
import vk.k;
import vp.i0;
import wh.f;
import wh.g;
import wh.h;
import wh.i;
import wh.l;
import wh.m;
import wh.n;
import wh.o;
import wh.p;

public class AssetIndexFragment extends BaseFragment<AssetIndexFragmentPresenter, AssetIndexFragmentPresenter.h> implements AssetIndexFragmentPresenter.h, i0 {
    public FeatureEntranceBar A;
    public boolean B = true;
    public View C;
    public r7 D;
    public String E;
    public ImageView F;
    public TextView G;
    public ImageView H;
    public ViewGroup I;
    public TextView J;

    /* renamed from: l  reason: collision with root package name */
    public EasyAssetRecyclerView<BaseAssetPositionAccountData> f42497l;

    /* renamed from: m  reason: collision with root package name */
    public AssetSummaryView f42498m;

    /* renamed from: n  reason: collision with root package name */
    public SmartRefreshLayout f42499n;

    /* renamed from: o  reason: collision with root package name */
    public z f42500o;

    /* renamed from: p  reason: collision with root package name */
    public x f42501p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f42502q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f42503r;

    /* renamed from: s  reason: collision with root package name */
    public View f42504s;

    /* renamed from: t  reason: collision with root package name */
    public View f42505t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f42506u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f42507v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f42508w = false;

    /* renamed from: x  reason: collision with root package name */
    public AssetLoadingPositionViewData f42509x;

    /* renamed from: y  reason: collision with root package name */
    public BaseBottomCurrencyDialogFragment f42510y;

    /* renamed from: z  reason: collision with root package name */
    public AssetBanner f42511z;

    public class a implements ny.d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            ((AssetIndexFragmentPresenter) AssetIndexFragment.this.yh()).R1();
            AssetIndexFragment.this.f42511z.h(AssetIndexFragment.this.zh());
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            Log.e("addOnScrollListener", "newState=: " + i11);
            boolean z11 = true;
            if (i11 == 1 && AssetIndexFragment.this.f42500o.isShowing()) {
                AssetIndexFragment.this.f42500o.dismiss();
            }
            AssetIndexFragment assetIndexFragment = AssetIndexFragment.this;
            if (i11 != 0) {
                z11 = false;
            }
            assetIndexFragment.vi(z11);
        }
    }

    public class c implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BalanceProfitLossData f42514a;

        public c(BalanceProfitLossData balanceProfitLossData) {
            this.f42514a = balanceProfitLossData;
        }

        public int a() {
            return -1;
        }

        public int b() {
            if (this.f42514a.getTodayProfitRate() == null || Double.valueOf(this.f42514a.getTodayProfitRate()).doubleValue() == 0.0d) {
                return R$drawable.share_asset_cow_3;
            }
            if (Double.valueOf(this.f42514a.getTodayProfitRate()).doubleValue() > 0.0d) {
                return R$drawable.share_asset_cow_1;
            }
            return R$drawable.share_asset_cow_2;
        }

        public int c() {
            if (this.f42514a.getTodayProfitRate() == null || Double.valueOf(this.f42514a.getTodayProfitRate()).doubleValue() == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (Double.valueOf(this.f42514a.getTodayProfitRate()).doubleValue() > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    public class d implements x.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f42516a;

        public d(View view) {
            this.f42516a = view;
        }

        public void onCurrencyMethodChanged(String str) {
            if (TextUtils.equals(str, this.f42516a.getContext().getString(R$string.n_home_index_earn_more))) {
                AssetIndexFragment.this.si();
            } else {
                if ("usdt".equals(str) || "btc".equals(str)) {
                    LegalCurrencyConfigUtil.d0(str);
                } else {
                    LegalCurrencyConfigUtil.c0(str);
                    AssetIndexFragment.this.x1();
                    ((AssetIndexFragmentPresenter) AssetIndexFragment.this.yh()).L1();
                }
                AssetIndexFragment.this.ti(true);
            }
            AssetIndexFragment.this.f42501p.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Void voidR) {
        boolean z11 = !this.f42508w;
        this.f42508w = z11;
        if (z11) {
            this.f42507v.setImageResource(R$drawable.market_selected_up_light);
        } else {
            this.f42507v.setImageResource(R$drawable.market_selected_down_light);
        }
        ((AssetIndexFragmentPresenter) yh()).p2(this.f42508w);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gi(View view) {
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new f(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        wi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getResources().getString(R$string.n_option_delivery_tip), this.E, (String) null, getResources().getString(R$string.n_known), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ji(View view, Void voidR) {
        ri(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new g(this, view));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        e.a().d();
        ui();
        ((AssetIndexFragmentPresenter) yh()).l2(AssetAccountType.SPOT);
        ((AssetIndexFragmentPresenter) yh()).l2(AssetAccountType.MARGIN);
        ((AssetIndexFragmentPresenter) yh()).l2(AssetAccountType.OTC);
        ((AssetIndexFragmentPresenter) yh()).l2(AssetAccountType.WARRANT);
        x1();
        BaseModuleConfig.a().w("app_assets_hideSmallAssets_button_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        uh.b.b(view, getResources().getString(R$string.n_asset_hide_small_amount_tips), PixelUtils.a(100.0f));
        BaseModuleConfig.a().w("app_assets_hideSmallAssets_explanation_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        qi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        qi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        this.f42500o.i(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void li(View view) {
        ((AssetIndexFragmentPresenter) yh()).R1();
        Z2(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(String str) {
        ti(true);
        x1();
        ((AssetIndexFragmentPresenter) yh()).L1();
        gi.a.i(LegalCurrencyConfigUtil.O(str).toUpperCase(Locale.US));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oi() {
        AssetModuleConfig.a().E0(Boolean.TRUE);
        ((AssetIndexFragmentPresenter) yh()).R1();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void pi(View view) {
        new g7(getContext(), this, new wh.d(this)).f();
        gi.a.a();
        gi.a.t();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A3(BalanceProfitLossData balanceProfitLossData) {
        this.f42499n.finishRefresh();
        this.f42498m.setData(balanceProfitLossData);
        this.H.setVisibility(0);
        this.H.setTag(balanceProfitLossData);
        if (this.D == null) {
            this.D = new r7(getContext());
        }
        String a11 = this.D.a(balanceProfitLossData.getProfitAccountBalanceList());
        this.E = a11;
        ViewUtil.m(this.C, !TextUtils.isEmpty(a11));
    }

    public void Ah() {
        super.Ah();
        this.F.setOnClickListener(new l(this));
        this.G.setOnClickListener(new wh.b(this));
        this.f42502q.setOnClickListener(new n(this));
        this.f42503r.setOnClickListener(new wh.a(this));
        this.f42504s.setOnClickListener(new p(this));
        this.f42499n.e0(new a());
        this.H.setOnClickListener(new h(this));
        this.f42498m.x();
        this.C.setOnClickListener(new o(this));
        this.I.setOnClickListener(new wh.j(this));
        this.f42507v.setOnClickListener(new m(this));
        this.f42497l.addOnScrollListener(new b());
    }

    public void H1(List<k> list, String str, boolean z11) {
        this.f42500o.h(list);
        this.f42500o.dismiss();
        if (!TextUtils.isEmpty(str)) {
            this.f42506u.setText(str);
        }
    }

    public void K1(AssetAccountType assetAccountType) {
        if (this.B && al.l.f().i()) {
            int e11 = al.l.f().e(assetAccountType);
            if (ei(assetAccountType) && e11 > 0) {
                this.f42497l.c(e11 - 1);
            }
            this.f42497l.d(e11, TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION);
        }
    }

    public void M1(int i11, int i12) {
        this.f42497l.e(i11, i12);
    }

    public void M2() {
        Boolean F2 = AssetModuleConfig.a().F();
        this.f42498m.setProfitOpen(Boolean.valueOf(F2 != null && F2.booleanValue()).booleanValue());
        this.f42498m.setOpenProfitClickListener(new i(this));
    }

    public void S2(List<BaseAssetPositionAccountData> list) {
        this.f42505t.setVisibility(0);
        this.f42497l.setData(list);
    }

    /* renamed from: Xh */
    public AssetIndexFragmentPresenter xh() {
        return new AssetIndexFragmentPresenter();
    }

    /* renamed from: Yh */
    public AssetIndexFragmentPresenter.h zh() {
        return this;
    }

    public void Z2(int i11) {
        this.f42505t.setVisibility(8);
        if (i11 == 4) {
            xi();
        } else if (i11 == 2) {
            this.f42509x.i(2);
            this.f42497l.setLoadingView(this.f42509x);
        } else if (i11 == 1) {
            this.f42509x.i(1);
            this.f42497l.setLoadingView(this.f42509x);
        } else if (i11 == 3) {
            this.f42509x.i(3);
            this.f42497l.setLoadingView(this.f42509x);
        }
    }

    public final void Zh() {
        AssetBanner assetBanner = (AssetBanner) this.f67460i.b(R$id.asset_banner);
        this.f42511z = assetBanner;
        assetBanner.d(this);
        ViewGroup.LayoutParams layoutParams = this.f42511z.getLayoutParams();
        layoutParams.height = (i6.n.g(this.f42511z.getContext()) * 88) / 750;
        layoutParams.width = -1;
        this.f42511z.setLayoutParams(layoutParams);
        this.f42511z.h(zh());
    }

    public void a3(int i11, int i12) {
        this.f42497l.f(i11, i12);
    }

    public final void ai() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = (EasyAssetRecyclerView) this.f67460i.b(R$id.position_recycler_view);
        this.f42497l = easyAssetRecyclerView;
        easyAssetRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.f42505t.setVisibility(8);
        this.f42509x.i(1);
        this.f42497l.setLoadingView(this.f42509x);
    }

    public final void bi() {
        this.f42500o = new z(requireContext());
    }

    public final void ci() {
        View b11 = this.f67460i.b(R$id.asset_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        b11.setLayoutParams(layoutParams);
    }

    public final void di() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R$id.refresh_layout);
        this.f42499n = smartRefreshLayout;
        smartRefreshLayout.j0(new SmartRefreshHeader(getActivity()));
        this.f42499n.g(false);
        this.f42498m = (AssetSummaryView) this.f67460i.b(R$id.asset_summary_view);
        ti(true);
    }

    public final boolean ei(AssetAccountType assetAccountType) {
        return assetAccountType == AssetAccountType.SPOT;
    }

    public void finishRefresh() {
        SmartRefreshLayout smartRefreshLayout = this.f42499n;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        this.f42498m.x();
        x1();
    }

    public void initViews() {
        super.initViews();
        ci();
        this.C = this.f67460i.b(R$id.iv_warning);
        this.H = (ImageView) this.f67460i.b(R$id.btn_share);
        this.f42505t = this.f67460i.b(R$id.asset_index_position_header);
        this.f42502q = (TextView) this.f67460i.b(R$id.position_header_verify_proposal);
        this.f42503r = (TextView) this.f67460i.b(R$id.position_header_verify_proposal_font_icon);
        this.F = (ImageView) this.f67460i.b(R$id.iv_ck_box);
        ui();
        this.G = (TextView) this.f67460i.b(R$id.tv_hide_small_amount);
        this.f42504s = this.f67460i.b(R$id.position_header_sort_title_layout);
        this.f42506u = (TextView) this.f67460i.b(R$id.position_header_sort_title);
        this.f42507v = (ImageView) this.f67460i.b(R$id.position_header_sort_icon);
        this.A = (FeatureEntranceBar) this.f67460i.b(R$id.feature_entrance_bar);
        this.f42509x = new AssetLoadingPositionViewData(new wh.k(this));
        this.I = (ViewGroup) this.f67460i.b(R$id.llyt_currency_method);
        this.J = (TextView) this.f67460i.b(R$id.iv_account_currency_method_text);
        di();
        bi();
        Zh();
        ai();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onResume() {
        super.onResume();
        this.f42498m.x();
        this.A.q(this);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (zh() != null && getActivity() != null && zh().isCanBeSeen()) {
            AssetModuleConfig.a().g(getActivity());
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_asset_index, viewGroup, false);
    }

    public final void qi() {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R$string.balance_safety_hint)).i1(1).M0(Integer.valueOf(R$drawable.popups_safety_img)).P0(getContext().getString(R$string.contract_trade_i_know)).x0(false).y0(getContext().getString(R$string.contract_trigger_order_change_not_show)).q0(false).Q0(wh.c.f61284a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public void r3() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = this.f42497l;
        if (easyAssetRecyclerView != null && easyAssetRecyclerView.getScrollState() == 0) {
            this.f42497l.scrollToPosition(0);
        }
    }

    public final void ri(View view) {
        x xVar = new x(requireContext());
        this.f42501p = xVar;
        xVar.l(new d(view));
        this.f42501p.m(view);
        gi.a.m();
    }

    public final void si() {
        this.f42510y = AssetModuleConfig.a().J();
        if (getContext() != null && (getContext() instanceof FragmentActivity)) {
            this.f42510y.setOnCurrencyMethodChangeCallback(new wh.e(this));
            this.f42510y.show(getChildFragmentManager(), this.f42510y.getClass().getName());
            gi.a.p();
        }
        gi.a.n();
    }

    public final void ti(boolean z11) {
        if (z11) {
            this.f42498m.v();
        }
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        TextView textView = this.J;
        if (textView != null) {
            textView.setText(upperCase);
        }
        AssetSummaryView assetSummaryView = this.f42498m;
        if (assetSummaryView != null) {
            assetSummaryView.y(upperCase);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            ((AssetIndexFragmentPresenter) yh()).q2();
            ((AssetIndexFragmentPresenter) yh()).j2();
            ((AssetIndexFragmentPresenter) yh()).L1();
            ((AssetIndexFragmentPresenter) yh()).R1();
            ti(false);
            if (p0.n().p()) {
                p0.n().y();
                return;
            }
            return;
        }
        ((AssetIndexFragmentPresenter) yh()).k2();
    }

    public final void ui() {
        int i11;
        boolean b11 = e.a().b();
        ImageView imageView = this.F;
        if (b11) {
            i11 = R$drawable.asset_hide_ck_box_bg_selected;
        } else {
            i11 = R$drawable.asset_hide_ck_box_bg_unselected;
        }
        imageView.setImageResource(i11);
    }

    public void vi(boolean z11) {
        this.B = z11;
        ((AssetIndexFragmentPresenter) yh()).Z1(this.B);
    }

    public final void wi() {
        BalanceProfitLossData balanceProfitLossData = (BalanceProfitLossData) this.H.getTag();
        c cVar = new c(balanceProfitLossData);
        View loadView = AssetShareHelper.loadView(getContext(), balanceProfitLossData.getTodayProfitRate(), cVar);
        ((ConstraintLayout.LayoutParams) ((TextView) loadView.findViewById(R$id.tv_hield_currency)).getLayoutParams()).topMargin = (int) getContext().getResources().getDimension(R$dimen.dimen_35);
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        viewGroup.setBackgroundColor(0);
        ((ConstraintLayout.LayoutParams) viewGroup.getLayoutParams()).topMargin = (int) getContext().getResources().getDimension(R$dimen.dimen_22);
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        textView.setTextColor(getResources().getColor(R$color.white));
        textView.setTextSize(0, getResources().getDimension(R$dimen.dimen_13));
        textView.setText(cVar.c());
        viewGroup.addView(textView);
        viewGroup.setVisibility(0);
        AssetShareHelper.share(getContext(), loadView);
    }

    public void x1() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = this.f42497l;
        if (easyAssetRecyclerView != null) {
            easyAssetRecyclerView.b();
        }
    }

    public final void xi() {
        this.f42509x.i(4);
        this.f42497l.setLoadingView(this.f42509x);
    }
}
