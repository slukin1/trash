package com.huobi.asset2.index;

import al.l;
import al.p;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.AutoSizeNumberAnimView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyAssetRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.widget.AssetLoadingPositionViewData;
import com.huobi.asset2.index.component.AssetSummaryViewNew;
import com.huobi.asset2.index.component.FeatureEntranceBar;
import com.huobi.asset2.index.component.banner.AssetBanner;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
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
import i6.n;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k20.h;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qh.p0;
import uh.e;
import vh.x;
import vh.z;
import vk.k;
import vp.i0;
import wh.a0;
import wh.b0;
import wh.c0;
import wh.d0;
import wh.e0;
import wh.f0;
import wh.g0;
import wh.q;
import wh.r;
import wh.s;
import wh.t;
import wh.u;
import wh.v;
import wh.w;
import wh.y;

public class AssetIndexFragmentNew extends BaseFragment<AssetIndexFragmentPresenterNew, AssetIndexFragmentPresenterNew.h> implements AssetIndexFragmentPresenterNew.h, i0 {
    public BaseBottomCurrencyDialogFragment A;
    public FeatureEntranceBar B;
    public boolean C = true;
    public View D;
    public r7 E;
    public String F;
    public ImageView G;
    public TextView H;
    public ImageView I;
    public ViewGroup J;
    public TextView K;
    public TextView L;
    public View M;

    /* renamed from: l  reason: collision with root package name */
    public EasyAssetRecyclerView<BaseAssetPositionAccountData> f42518l;

    /* renamed from: m  reason: collision with root package name */
    public AssetSummaryViewNew f42519m;

    /* renamed from: n  reason: collision with root package name */
    public SmartRefreshLayout f42520n;

    /* renamed from: o  reason: collision with root package name */
    public z f42521o;

    /* renamed from: p  reason: collision with root package name */
    public x f42522p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f42523q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f42524r;

    /* renamed from: s  reason: collision with root package name */
    public View f42525s;

    /* renamed from: t  reason: collision with root package name */
    public View f42526t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f42527u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f42528v;

    /* renamed from: w  reason: collision with root package name */
    public AutoSizeNumberAnimView f42529w;

    /* renamed from: x  reason: collision with root package name */
    public AssetBanner f42530x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f42531y = false;

    /* renamed from: z  reason: collision with root package name */
    public AssetLoadingPositionViewData f42532z;

    public class a implements ny.d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            ((AssetIndexFragmentPresenterNew) AssetIndexFragmentNew.this.yh()).c2();
            AssetIndexFragmentNew.this.f42530x.h(AssetIndexFragmentNew.this.zh());
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
            Log.e("addOnScrollListener", "newState=: " + i11);
            boolean z11 = true;
            if (i11 == 1 && AssetIndexFragmentNew.this.f42521o.isShowing()) {
                AssetIndexFragmentNew.this.f42521o.dismiss();
            }
            AssetIndexFragmentNew assetIndexFragmentNew = AssetIndexFragmentNew.this;
            if (i11 != 0) {
                z11 = false;
            }
            assetIndexFragmentNew.Ai(z11);
        }
    }

    public class c implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BalanceProfitLossData f42535a;

        public c(BalanceProfitLossData balanceProfitLossData) {
            this.f42535a = balanceProfitLossData;
        }

        public int a() {
            return -1;
        }

        public int b() {
            if (this.f42535a.getTodayProfitRate() == null || Double.valueOf(this.f42535a.getTodayProfitRate()).doubleValue() == 0.0d) {
                return R$drawable.share_asset_style_2;
            }
            if (Double.valueOf(this.f42535a.getTodayProfitRate()).doubleValue() > 0.0d) {
                return R$drawable.share_asset_style_1;
            }
            return R$drawable.share_asset_style_2;
        }

        public int c() {
            if (this.f42535a.getTodayProfitRate() == null || Double.valueOf(this.f42535a.getTodayProfitRate()).doubleValue() == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (Double.valueOf(this.f42535a.getTodayProfitRate()).doubleValue() > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    public class d implements x.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f42537a;

        public d(View view) {
            this.f42537a = view;
        }

        public void onCurrencyMethodChanged(String str) {
            if (TextUtils.equals(str, this.f42537a.getContext().getString(R$string.n_home_index_earn_more))) {
                AssetIndexFragmentNew.this.wi();
            } else {
                if ("usdt".equals(str) || "btc".equals(str)) {
                    LegalCurrencyConfigUtil.d0(str);
                } else {
                    LegalCurrencyConfigUtil.c0(str);
                    AssetIndexFragmentNew.this.x1();
                    ((AssetIndexFragmentPresenterNew) AssetIndexFragmentNew.this.yh()).W1();
                }
                AssetIndexFragmentNew.this.xi(true);
            }
            AssetIndexFragmentNew.this.f42522p.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new wh.x(this, view));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(Void voidR) {
        boolean z11 = !this.f42531y;
        this.f42531y = z11;
        if (z11) {
            this.f42528v.setImageResource(R$drawable.market_selected_up_light);
        } else {
            this.f42528v.setImageResource(R$drawable.market_selected_down_light);
        }
        ((AssetIndexFragmentPresenterNew) yh()).F2(this.f42531y);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ji(View view) {
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new w(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        this.f42521o.i(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        e.a().d();
        yi();
        ((AssetIndexFragmentPresenterNew) yh()).B2(AssetAccountType.SPOT);
        ((AssetIndexFragmentPresenterNew) yh()).B2(AssetAccountType.MARGIN);
        ((AssetIndexFragmentPresenterNew) yh()).B2(AssetAccountType.OTC);
        ((AssetIndexFragmentPresenterNew) yh()).B2(AssetAccountType.WARRANT);
        x1();
        BaseModuleConfig.a().w("app_assets_hideSmallAssets_button_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        uh.b.b(view, getResources().getString(R$string.n_asset_hide_small_amount_tips), PixelUtils.a(100.0f));
        BaseModuleConfig.a().w("app_assets_hideSmallAssets_explanation_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        ui();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        ui();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void li(View view) {
        Bi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mi(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getResources().getString(R$string.n_option_delivery_tip), this.F, (String) null, getResources().getString(R$string.n_known), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, Void voidR) {
        vi(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void oi(View view) {
        p.v();
        boolean u11 = p.u();
        EventBus.d().k(new gh.b(u11));
        if (!u11) {
            gi.a.j();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void pi(View view) {
        ((AssetIndexFragmentPresenterNew) yh()).c2();
        Z2(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ri(String str) {
        xi(true);
        x1();
        ((AssetIndexFragmentPresenterNew) yh()).W1();
        gi.a.i(LegalCurrencyConfigUtil.O(str).toUpperCase(Locale.US));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void si() {
        AssetModuleConfig.a().E0(Boolean.TRUE);
        ((AssetIndexFragmentPresenterNew) yh()).c2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ti(View view) {
        new g7(getContext(), this, new u(this)).f();
        gi.a.a();
        gi.a.t();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A3(BalanceProfitLossData balanceProfitLossData) {
        this.f42520n.finishRefresh();
        this.f42519m.setData(balanceProfitLossData);
        this.I.setVisibility(0);
        this.I.setTag(balanceProfitLossData);
        if (this.E == null) {
            this.E = new r7(getContext());
        }
        String a11 = this.E.a(balanceProfitLossData.getProfitAccountBalanceList());
        this.F = a11;
        ViewUtil.m(this.D, !TextUtils.isEmpty(a11));
    }

    public void Ah() {
        super.Ah();
        this.G.setOnClickListener(new c0(this));
        this.H.setOnClickListener(new d0(this));
        this.f42523q.setOnClickListener(new e0(this));
        this.f42524r.setOnClickListener(new y(this));
        this.f42525s.setOnClickListener(new a0(this));
        this.f42520n.e0(new a());
        this.I.setOnClickListener(new q(this));
        this.f42529w.setOpenEyes(p.u());
        this.D.setOnClickListener(new wh.z(this));
        this.J.setOnClickListener(new b0(this));
        this.f42528v.setOnClickListener(new g0(this));
        this.f42518l.addOnScrollListener(new b());
    }

    public void Ai(boolean z11) {
        this.C = z11;
        ((AssetIndexFragmentPresenterNew) yh()).k2(this.C);
    }

    public final void Bi() {
        BalanceProfitLossData balanceProfitLossData = (BalanceProfitLossData) this.I.getTag();
        if (balanceProfitLossData != null) {
            AssetShareHelper.share(getContext(), AssetShareHelper.loadNewView(getContext(), balanceProfitLossData.getTodayProfitRate(), new c(balanceProfitLossData), 1));
        }
    }

    public final void Ci() {
        this.f42532z.i(4);
        this.f42518l.setLoadingView(this.f42532z);
    }

    public void Di() {
        AssetSummaryViewNew assetSummaryViewNew = this.f42519m;
        if (assetSummaryViewNew != null && assetSummaryViewNew.p()) {
            p0.n().E(this, this.L);
        }
    }

    public void H1(List<k> list, String str, boolean z11) {
        this.f42521o.h(list);
        this.f42521o.dismiss();
        if (!TextUtils.isEmpty(str)) {
            this.f42527u.setText(str);
        }
    }

    public void K1(AssetAccountType assetAccountType) {
        if (this.C && l.f().i()) {
            int e11 = l.f().e(assetAccountType);
            if (gi(assetAccountType) && e11 > 0) {
                this.f42518l.c(e11 - 1);
            }
            this.f42518l.d(e11, TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION);
        }
    }

    public void M1(int i11, int i12) {
        this.f42518l.e(i11, i12);
    }

    public void M2() {
        Boolean F2 = AssetModuleConfig.a().F();
        Boolean valueOf = Boolean.valueOf(F2 != null && F2.booleanValue());
        this.f42519m.setProfitOpen(valueOf.booleanValue());
        this.f42519m.setOpenProfitClickListener(new r(this));
        if (valueOf.booleanValue()) {
            Di();
        }
    }

    public void S2(List<BaseAssetPositionAccountData> list) {
        this.f42526t.setVisibility(0);
        this.f42518l.setData(list);
    }

    /* renamed from: Yh */
    public AssetIndexFragmentPresenterNew xh() {
        return new AssetIndexFragmentPresenterNew();
    }

    public void Z2(int i11) {
        if (CollectionsUtils.b(this.f42518l.getDataList()) || this.f42518l.getDataList().size() <= 1) {
            this.f42526t.setVisibility(8);
            if (i11 == 4) {
                Ci();
            } else if (i11 == 2) {
                this.f42532z.i(2);
                this.f42518l.setLoadingView(this.f42532z);
            } else if (i11 == 1) {
                this.f42532z.i(1);
                this.f42518l.setLoadingView(this.f42532z);
            } else if (i11 == 3) {
                this.f42532z.i(3);
                this.f42518l.setLoadingView(this.f42532z);
            }
        }
    }

    /* renamed from: Zh */
    public AssetIndexFragmentPresenterNew.h zh() {
        return this;
    }

    public void a3(int i11, int i12) {
        this.f42518l.f(i11, i12);
    }

    public final void ai() {
        AssetBanner assetBanner = (AssetBanner) this.f67460i.b(R$id.asset_banner);
        this.f42530x = assetBanner;
        assetBanner.d(this);
        ViewGroup.LayoutParams layoutParams = this.f42530x.getLayoutParams();
        layoutParams.height = (n.g(this.f42530x.getContext()) * 88) / 750;
        layoutParams.width = -1;
        this.f42530x.setLayoutParams(layoutParams);
        this.f42530x.h(zh());
    }

    public final void bi() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = (EasyAssetRecyclerView) this.f67460i.b(R$id.position_recycler_view);
        this.f42518l = easyAssetRecyclerView;
        easyAssetRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.f42526t.setVisibility(8);
        this.f42532z.i(1);
        this.f42518l.setLoadingView(this.f42532z);
    }

    public final void ci() {
        this.f42521o = new z(requireContext());
    }

    public final void di() {
        View b11 = this.f67460i.b(R$id.asset_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        b11.setLayoutParams(layoutParams);
    }

    public final void ei() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R$id.refresh_layout);
        this.f42520n = smartRefreshLayout;
        smartRefreshLayout.j0(new SmartRefreshHeader(getActivity()));
        this.f42520n.g(false);
        this.f42519m = (AssetSummaryViewNew) this.f67460i.b(R$id.asset_summary_view);
        xi(true);
    }

    public final void fi() {
        AutoSizeNumberAnimView autoSizeNumberAnimView = (AutoSizeNumberAnimView) this.f67460i.b(R$id.tv_total_asset);
        this.f42529w = autoSizeNumberAnimView;
        autoSizeNumberAnimView.setText("");
        this.f42529w.setOnClickListener(s.f61339b);
    }

    public void finishRefresh() {
        SmartRefreshLayout smartRefreshLayout = this.f42520n;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
    }

    public final boolean gi(AssetAccountType assetAccountType) {
        return assetAccountType == AssetAccountType.SPOT;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void hideAmountChange(gh.b bVar) {
        this.f42529w.setOpenEyes(p.u());
        x1();
    }

    public void initViews() {
        super.initViews();
        di();
        this.D = this.f67460i.b(R$id.iv_warning);
        this.I = (ImageView) this.f67460i.b(R$id.btn_share);
        this.f42526t = this.f67460i.b(R$id.asset_index_position_header);
        this.f42523q = (TextView) this.f67460i.b(R$id.position_header_verify_proposal);
        this.f42524r = (TextView) this.f67460i.b(R$id.position_header_verify_proposal_font_icon);
        this.G = (ImageView) this.f67460i.b(R$id.iv_ck_box);
        yi();
        this.H = (TextView) this.f67460i.b(R$id.tv_hide_small_amount);
        this.f42525s = this.f67460i.b(R$id.position_header_sort_title_layout);
        this.f42527u = (TextView) this.f67460i.b(R$id.position_header_sort_title);
        this.f42528v = (ImageView) this.f67460i.b(R$id.position_header_sort_icon);
        this.B = (FeatureEntranceBar) this.f67460i.b(R$id.feature_entrance_bar);
        this.f42532z = new AssetLoadingPositionViewData(new f0(this));
        this.J = (ViewGroup) this.f67460i.b(R$id.llyt_currency_method);
        this.K = (TextView) this.f67460i.b(R$id.iv_account_currency_method_text);
        this.L = (TextView) this.f67460i.b(R$id.tv_profit_analysis_2);
        this.M = this.f67460i.b(R$id.v_profit_analysis_dot);
        ei();
        ci();
        ai();
        bi();
        fi();
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
        this.f42529w.setOpenEyes(p.u());
        this.B.q(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (zh() != null && getActivity() != null && zh().isCanBeSeen()) {
            AssetModuleConfig.a().g(getActivity());
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_asset_index_new, viewGroup, false);
    }

    public void r3() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = this.f42518l;
        if (easyAssetRecyclerView != null && easyAssetRecyclerView.getScrollState() == 0) {
            this.f42518l.scrollToPosition(0);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            ((AssetIndexFragmentPresenterNew) yh()).G2();
            ((AssetIndexFragmentPresenterNew) yh()).z2();
            ((AssetIndexFragmentPresenterNew) yh()).W1();
            ((AssetIndexFragmentPresenterNew) yh()).c2();
            xi(false);
            if (p0.n().p()) {
                p0.n().y();
            }
            Di();
            zi(p0.n().k().displayGuideDot());
            return;
        }
        ((AssetIndexFragmentPresenterNew) yh()).A2();
        ((AssetIndexFragmentPresenterNew) yh()).s2();
    }

    public final void ui() {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R$string.balance_safety_hint)).i1(1).M0(Integer.valueOf(R$drawable.popups_safety_img)).P0(getContext().getString(R$string.contract_trade_i_know)).x0(false).y0(getContext().getString(R$string.contract_trigger_order_change_not_show)).q0(false).Q0(t.f61341a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public final void vi(View view) {
        x xVar = new x(requireContext());
        this.f42522p = xVar;
        xVar.l(new d(view));
        this.f42522p.m(view);
        gi.a.m();
    }

    public final void wi() {
        this.A = AssetModuleConfig.a().J();
        if (getContext() != null && (getContext() instanceof FragmentActivity)) {
            this.A.setOnCurrencyMethodChangeCallback(new v(this));
            this.A.show(getChildFragmentManager(), this.A.getClass().getName());
            gi.a.p();
        }
        gi.a.n();
    }

    public void x1() {
        EasyAssetRecyclerView<BaseAssetPositionAccountData> easyAssetRecyclerView = this.f42518l;
        if (easyAssetRecyclerView != null) {
            easyAssetRecyclerView.b();
        }
    }

    public final void xi(boolean z11) {
        if (z11) {
            this.f42519m.w();
        }
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(upperCase);
        }
        AssetSummaryViewNew assetSummaryViewNew = this.f42519m;
        if (assetSummaryViewNew != null) {
            assetSummaryViewNew.y(upperCase);
        }
    }

    public final void yi() {
        int i11;
        boolean b11 = e.a().b();
        ImageView imageView = this.G;
        if (b11) {
            i11 = R$drawable.asset_hide_ck_box_bg_selected;
        } else {
            i11 = R$drawable.asset_hide_ck_box_bg_unselected;
        }
        imageView.setImageResource(i11);
    }

    public void zi(boolean z11) {
        View view = this.M;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }
}
