package com.hbg.lite.wallet.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.base.LiteBaseFragment;
import com.hbg.lite.record.ui.AllCurrencyRecordActivity;
import com.hbg.lite.view.LiteBalanceView;
import com.hbg.lite.wallet.bean.LegalDataTotal;
import com.hbg.lite.wallet.presenter.WalletPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.Map;
import ky.j;
import ny.d;
import ub.e;
import ub.f;
import ub.g;
import ub.h;

public class WalletFragment extends LiteBaseFragment<WalletPresenter, WalletPresenter.b> implements WalletPresenter.b {

    /* renamed from: l  reason: collision with root package name */
    public ImageView f77627l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f77628m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f77629n;

    /* renamed from: o  reason: collision with root package name */
    public LiteBalanceView f77630o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView f77631p;

    /* renamed from: q  reason: collision with root package name */
    public LoadingLayout f77632q;

    /* renamed from: r  reason: collision with root package name */
    public String f77633r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f77634s;

    /* renamed from: t  reason: collision with root package name */
    public MyNestedScrollView f77635t;

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f77636u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f77637v;

    /* renamed from: w  reason: collision with root package name */
    public SmartRefreshLayout f77638w;

    /* renamed from: x  reason: collision with root package name */
    public View f77639x;

    /* renamed from: y  reason: collision with root package name */
    public SmartRefreshHeader f77640y;

    public class a implements LiteBalanceView.b {
        public a() {
        }

        public String a(String str) {
            return str;
        }

        public String b(String str) {
            if (!m.a0(str)) {
                return str;
            }
            String n11 = va.b.n(sa.a.c());
            return String.format(WalletFragment.this.getString(R$string.two_label_with_space_with_space_abount), new Object[]{n11, str});
        }
    }

    public class b implements MyNestedScrollView.b {
        public b() {
        }

        public void onStartNestedScroll() {
            ra.c.c().g(WalletFragment.this.f77635t, true);
        }

        public void onStateChanged(int i11) {
        }

        public void onStopNestedScroll() {
            ra.c.c().g(WalletFragment.this.f77635t, false);
        }
    }

    public class c implements d {
        public c() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (WalletFragment.this.zh().isCanBeSeen()) {
                ((WalletPresenter) WalletFragment.this.yh()).m0();
            } else {
                WalletFragment.this.Z1(true);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        new DialogUtils.b.d(getActivity()).c1(getString(R$string.setting_quickly_withdraw_dialog_title)).C0(getString(R$string.wallet_balance_description)).P0(getString(R$string.setting_quickly_withdraw_dialog_know)).q0(false).Q0(h.f60563a).j0().show(getActivity().getSupportFragmentManager(), "");
        ra.c.c().l("245", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        showLoading();
        ((WalletPresenter) yh()).m0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        boolean z11 = !this.f77634s;
        this.f77634s = z11;
        Nh(z11, ra.c.c().getUid());
        if (this.f77634s) {
            this.f77627l.setImageResource(R$drawable.lite_balance_btn_visible);
        } else {
            this.f77627l.setImageResource(R$drawable.lite_balance_btn_invisible);
        }
        ((WalletPresenter) yh()).k0(this.f77634s);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        AllCurrencyRecordActivity.yh(getActivity());
        ra.c.c().l("184", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        this.f77636u.setVisibility(8);
        ConfigPreferences.n("user_config", "LITE_ASSETS_HINT", false);
        RecyclerView.Adapter adapter = this.f77631p.getAdapter();
        if (adapter.getItemCount() > 0) {
            adapter.notifyItemChanged(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f77629n.setOnClickListener(new f(this));
        this.f77632q.setOnRetryClickListener(new e(this));
        this.f77627l.setOnClickListener(new ub.c(this));
        this.f77628m.setOnClickListener(new ub.d(this));
        this.f77630o.setCallBack(new a());
        this.f77635t.setScrollStateListener(new b());
        this.f77637v.setOnClickListener(new g(this));
    }

    public void F0() {
        this.f77635t.setBackground((Drawable) null);
        this.f77632q.setVisibility(8);
    }

    /* renamed from: Jh */
    public WalletPresenter xh() {
        return new WalletPresenter();
    }

    public boolean Kh(String str) {
        return ConfigPreferences.c("lite_user_config_filename", str + "_" + "config_lite_app_asset_show", true);
    }

    /* renamed from: Lh */
    public WalletPresenter.b zh() {
        return this;
    }

    public void Nh(boolean z11, String str) {
        ConfigPreferences.n("lite_user_config_filename", str + "_" + "config_lite_app_asset_show", z11);
    }

    public boolean O6() {
        return this.f77634s;
    }

    public final void Oh(int i11) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setStatusBarColor(i11);
        }
    }

    public void Ph() {
        this.f77638w.i(true);
        this.f77638w.g(false);
        this.f77638w.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.f77640y = smartRefreshHeader;
        this.f77638w.j0(smartRefreshHeader);
        this.f77638w.e0(new c());
    }

    public void Z1(boolean z11) {
        if (z11) {
            this.f77638w.finishRefresh();
            this.f77638w.setNoMoreData(false);
            return;
        }
        this.f77638w.w();
    }

    public void b(v9.a<s9.a> aVar) {
        this.f77631p.setAdapter(aVar);
    }

    public void initViews() {
        super.initViews();
        this.f77627l = (ImageView) this.f67460i.b(R$id.balance_hide_iv);
        this.f77628m = (ImageView) this.f67460i.b(R$id.balance_history_tv);
        this.f77629n = (TextView) this.f67460i.b(R$id.my_balance_title_tv);
        this.f77630o = (LiteBalanceView) this.f67460i.b(R$id.total_balance_tv);
        this.f77631p = (RecyclerView) this.f67460i.b(R$id.wallet_rv);
        this.f77638w = (SmartRefreshLayout) this.f67460i.b(R$id.lite_wallet_refresh_layout);
        this.f77639x = this.f67460i.b(R$id.top_radius_view);
        this.f77631p.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f77631p.addItemDecoration(new ub.b(ContextCompat.getDrawable(getActivity(), R$color.baseColorDeepestBackground), ContextCompat.getDrawable(getActivity(), R$drawable.shape_wallet_item_divider), PixelUtils.a(10.0f), PixelUtils.a(0.5f)));
        this.f77632q = (LoadingLayout) this.f67460i.b(R$id.wallet_loading_layout);
        boolean Kh = Kh(ra.c.c().getUid());
        this.f77634s = Kh;
        if (Kh) {
            this.f77627l.setImageResource(R$drawable.lite_balance_btn_visible);
        } else {
            this.f77627l.setImageResource(R$drawable.lite_balance_btn_invisible);
        }
        this.f77635t = (MyNestedScrollView) this.f67460i.b(R$id.wallet_sv);
        this.f77633r = getResources().getString(R$string.balance_hide_star);
        this.f77636u = (RelativeLayout) this.f67460i.b(R$id.rl_assets_hint);
        this.f77636u.setVisibility(ConfigPreferences.c("user_config", "LITE_ASSETS_HINT", true) ? 0 : 8);
        this.f77637v = (ImageView) this.f67460i.b(R$id.iv_assets_hint);
        Ph();
    }

    public void m0() {
        this.f77635t.setBackground((Drawable) null);
        this.f77632q.k();
        this.f77632q.setVisibility(0);
    }

    public void n6(LegalDataTotal legalDataTotal) {
        if (legalDataTotal == null) {
            this.f77630o.setBalanceText("--");
            this.f77630o.setConvertText("--");
            this.f77630o.i();
        } else if (legalDataTotal.isShow()) {
            this.f77630o.setBalance(m.u0(legalDataTotal.getNetAssetToBtc(), 12, wa.a.b("btc")));
            this.f77630o.setConvert(m.m(legalDataTotal.getNetAssetLegal(), 2));
            this.f77630o.h();
        } else {
            this.f77630o.setBalanceText(this.f77633r);
            this.f77630o.setConvertText(this.f77633r);
            this.f77630o.i();
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_lite_wallet, viewGroup, false);
    }

    public void showLoading() {
        this.f77635t.setBackgroundResource(R$color.loading_bg_color);
        this.f77632q.p();
        this.f77632q.setVisibility(0);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (getActivity() != null && isAdded()) {
            if (!z11) {
                Oh(ContextCompat.getColor(getActivity(), R$color.baseColorContentBackground));
            } else {
                Oh(ContextCompat.getColor(getActivity(), R$color.balance_otc));
            }
        }
    }
}
