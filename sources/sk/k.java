package sk;

import al.p;
import al.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.pro.core.bean.DefiBoxAsset;
import com.hbg.lib.network.pro.core.bean.ProjectItem;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$raw;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.defibox.DefiChainListProvider;
import com.huobi.finance.account.BaseAssetAccount;
import com.huobi.finance.address.AddrMgrDialog;
import com.huobi.finance.bean.OnChainDataTotal;
import com.huobi.finance.bean.PocketListItem;
import com.huobi.finance.bean.ProjectListItem;
import com.huobi.finance.presenter.BalanceAssetPresenter;
import com.huobi.finance.ui.BalanceAssetFragment;
import com.huobi.utils.x0;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public class k extends BaseAssetAccount<OnChainDataTotal> {
    public BalanceAssetFragment A;
    public TabItemLayoutIndicator B;
    public BalanceAssetPresenter C;
    public View D;
    public View E;
    public int F;
    public final Interpolator G = new DecelerateInterpolator();
    public boolean H = true;
    public AddrMgrDialog.e I = new c();
    public Animator.AnimatorListener J = new d();

    /* renamed from: b  reason: collision with root package name */
    public FragmentActivity f47819b;

    /* renamed from: c  reason: collision with root package name */
    public LoadingLayout f47820c;

    /* renamed from: d  reason: collision with root package name */
    public View f47821d;

    /* renamed from: e  reason: collision with root package name */
    public View f47822e;

    /* renamed from: f  reason: collision with root package name */
    public View f47823f;

    /* renamed from: g  reason: collision with root package name */
    public OnChainDataTotal f47824g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f47825h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47826i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47827j;

    /* renamed from: k  reason: collision with root package name */
    public View f47828k;

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView<PocketListItem> f47829l;

    /* renamed from: m  reason: collision with root package name */
    public EasyRecyclerView<ProjectListItem> f47830m;

    /* renamed from: n  reason: collision with root package name */
    public View f47831n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f47832o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f47833p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f47834q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f47835r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f47836s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f47837t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f47838u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f47839v;

    /* renamed from: w  reason: collision with root package name */
    public View f47840w;

    /* renamed from: x  reason: collision with root package name */
    public View f47841x;

    /* renamed from: y  reason: collision with root package name */
    public AddrMgrDialog f47842y = new AddrMgrDialog();

    /* renamed from: z  reason: collision with root package name */
    public SafeLottieView f47843z;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f47844b;

        public a(View.OnClickListener onClickListener) {
            this.f47844b = onClickListener;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            k.this.H(true);
            this.f47844b.onClick(view);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements BaseDialogFragment.c {
        public b() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            k.this.f47828k.animate().rotation(0.0f);
            UserAddrInfo Fh = k.this.f47842y.Fh();
            if (Fh != null && !Fh.equals(k.this.f47824g.getSelectedAddr())) {
                s.h(Fh);
                k.this.H(true);
                k.this.E();
            }
        }

        public void onDialogFragmentResume() {
            k.this.f47828k.animate().rotation(180.0f);
        }
    }

    public class c implements AddrMgrDialog.e {
        public c() {
        }

        public void a(UserAddrInfo userAddrInfo) {
            s.h(userAddrInfo);
            k.this.H(true);
            k.this.E();
        }

        public void onBindSuccess() {
            k.this.f47842y.showLoading();
            k.this.H(true);
            k.this.E();
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtil.m(k.this.D, k.this.H);
            ViewUtil.m(k.this.E, !k.this.H);
        }

        public void onAnimationStart(Animator animator) {
            ViewUtil.m(k.this.D, true);
            ViewUtil.m(k.this.E, true);
        }
    }

    public k(FragmentActivity fragmentActivity) {
        this.f47819b = fragmentActivity;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(View view) {
        G(true, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void B(View view) {
        AssetModuleConfig.a().h0(this.f47819b, "34873740766426");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void C(View view) {
        G(false, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(int i11) {
        boolean z11 = i11 == 0;
        this.H = z11;
        if (z11) {
            this.D.animate().setListener(this.J).setDuration(250).translationX(0.0f);
            this.E.animate().setListener(this.J).setDuration(250).translationX((float) this.F);
            return;
        }
        this.D.animate().setListener(this.J).setDuration(250).setInterpolator(this.G).translationX((float) (-this.F));
        this.E.animate().setListener(this.J).setDuration(250).setInterpolator(this.G).translationX(0.0f);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void z(View view, String str, View view2) {
        x0.c(view, str, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    public final void E() {
        this.C.I1();
    }

    public void F(BalanceAssetFragment balanceAssetFragment) {
        this.A = balanceAssetFragment;
        this.C = (BalanceAssetPresenter) balanceAssetFragment.yh();
    }

    public final void G(boolean z11, boolean z12) {
        this.f47842y.Mh(this.f47824g.getSelectedAddr());
        this.f47842y.tc(this.f47824g.getUserAddrInfoList());
        this.f47842y.Nh(z11);
        this.f47842y.Oh(z12);
        this.f47842y.setDialogFragmentListener(new b());
        this.f47842y.Lh(this.I);
        this.f47842y.show(this.f47819b.getSupportFragmentManager(), "AddrMgrDialog");
    }

    public final void H(boolean z11) {
        SafeLottieView safeLottieView = this.f47843z;
        if (safeLottieView != null && this.A != null) {
            ViewUtil.m(safeLottieView, z11);
            this.f47843z.playAnimation();
            this.A.ok(!z11);
        }
    }

    public void a() {
        b(this.f47824g);
    }

    public int c() {
        return R$string.n_on_chain_asset_tab_name;
    }

    public View d(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        int i11;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_asset_on_chain, viewGroup, false);
        this.f47840w = inflate;
        this.f47820c = (LoadingLayout) inflate.findViewById(R$id.loading_layout);
        this.f47821d = this.f47840w.findViewById(R$id.loading_layout_container);
        this.f47820c.setOnRetryClickListener(new a(onClickListener));
        this.f47822e = this.f47840w.findViewById(R$id.default_guide);
        this.f47823f = this.f47840w.findViewById(R$id.main_content);
        this.f47825h = (ImageView) this.f47840w.findViewById(R$id.iv_chain_logo);
        this.f47826i = (TextView) this.f47840w.findViewById(R$id.tv_chain_name);
        this.f47827j = (TextView) this.f47840w.findViewById(R$id.tv_chain_address);
        this.f47828k = this.f47840w.findViewById(R$id.iv_arrow_down);
        this.f47832o = (TextView) this.f47840w.findViewById(R$id.tv_total_amount);
        this.f47833p = (TextView) this.f47840w.findViewById(R$id.tv_total_legal);
        this.f47834q = (TextView) this.f47840w.findViewById(R$id.tv_balance_amount);
        this.f47835r = (TextView) this.f47840w.findViewById(R$id.tv_balance_legal);
        this.f47836s = (TextView) this.f47840w.findViewById(R$id.tv_mine_cost);
        this.f47837t = (TextView) this.f47840w.findViewById(R$id.tv_mine_income);
        this.f47838u = (TextView) this.f47840w.findViewById(R$id.tv_loan);
        this.f47839v = (TextView) this.f47840w.findViewById(R$id.tv_interest);
        this.f47841x = this.f47840w.findViewById(R$id.tv_total_i);
        SafeLottieView safeLottieView = (SafeLottieView) this.f47840w.findViewById(R$id.skeleton_anim);
        this.f47843z = safeLottieView;
        if (NightHelper.e().g()) {
            i11 = R$raw.skeleton_balance_heco_night;
        } else {
            i11 = R$raw.skeleton_balance_heco;
        }
        safeLottieView.setAnimation(i11);
        this.f47840w.findViewById(R$id.tv_bind_now).setOnClickListener(new h(this));
        this.f47840w.findViewById(R$id.tv_chain_instruction).setOnClickListener(new i(this));
        this.f47840w.findViewById(R$id.chain_address_area).setOnClickListener(new g(this));
        y(context, this.f47840w);
        t();
        return this.f47840w;
    }

    public final void t() {
        String string = this.f47840w.getResources().getString(R$string.n_on_chain_asset_profit_desc);
        View findViewById = this.f47840w.findViewById(R$id.tv_mine_income_i);
        f fVar = new f(findViewById, string);
        this.f47840w.findViewById(R$id.tv_mine_income_label).setOnClickListener(fVar);
        findViewById.setOnClickListener(fVar);
    }

    /* renamed from: u */
    public void b(OnChainDataTotal onChainDataTotal) {
        DefiBoxAsset defiBoxAsset;
        H(false);
        this.f47842y.Gh();
        if (!w(onChainDataTotal) && onChainDataTotal != null) {
            UserAddrInfo selectedAddr = onChainDataTotal.getSelectedAddr();
            boolean z11 = selectedAddr == null;
            ViewUtil.m(this.f47823f, !z11);
            ViewUtil.m(this.f47822e, z11);
            if (!z11 && (defiBoxAsset = onChainDataTotal.getDefiBoxAsset()) != null) {
                this.f47826i.setText(defiBoxAsset.getChain());
                this.f47827j.setText(s.i(defiBoxAsset.getAddress()));
                s.g(this.f47825h, DefiChainListProvider.c(selectedAddr.getChain()).getSelectIcon());
                v(defiBoxAsset);
                this.f47829l.setData(PocketListItem.buildList(defiBoxAsset.getWallets()));
                List<ProjectItem> projects = defiBoxAsset.getProjects();
                if (projects == null || projects.isEmpty()) {
                    ViewUtil.m(this.f47831n, true);
                } else {
                    ViewUtil.m(this.f47831n, false);
                    this.f47830m.setData(ProjectListItem.buildList(projects));
                }
                TabItemLayoutIndicator tabItemLayoutIndicator = this.B;
                tabItemLayoutIndicator.onItemClick(tabItemLayoutIndicator.getCheckPosition());
                AddrMgrDialog addrMgrDialog = this.f47842y;
                if (addrMgrDialog != null && addrMgrDialog.isVisible()) {
                    this.f47842y.Mh(this.f47824g.getSelectedAddr());
                    this.f47842y.tc(onChainDataTotal.getUserAddrInfoList());
                }
                s.j(this.f47840w);
            }
        }
    }

    public final void v(DefiBoxAsset defiBoxAsset) {
        String str = LegalCurrencyConfigUtil.w() + " ";
        String totalInBTC = defiBoxAsset.getTotalInBTC();
        String B2 = LegalCurrencyConfigUtil.B(defiBoxAsset.getTotal());
        p.e(this.f47832o, totalInBTC);
        p.g(this.f47833p, "≈ " + str, B2);
        String walletInBTC = defiBoxAsset.getWalletInBTC();
        String B3 = LegalCurrencyConfigUtil.B(defiBoxAsset.getWallet());
        p.e(this.f47834q, walletInBTC);
        p.g(this.f47835r, "≈ " + str, B3);
        p.g(this.f47836s, str, LegalCurrencyConfigUtil.B(defiBoxAsset.getFarmingCost()));
        String B4 = LegalCurrencyConfigUtil.B(defiBoxAsset.getFarmingIncome());
        p.g(this.f47837t, str, B4);
        boolean u11 = p.u();
        if (u11) {
            w.n(this.f47837t, B4);
        } else {
            this.f47837t.setTextColor(this.f47819b.getResources().getColor(R$color.baseColorPrimaryText));
        }
        p.g(this.f47838u, str, LegalCurrencyConfigUtil.B(defiBoxAsset.getLending()));
        String B5 = LegalCurrencyConfigUtil.B(defiBoxAsset.getOutLending());
        p.g(this.f47839v, str, B5);
        if (u11) {
            w.n(this.f47839v, B5);
        } else {
            this.f47839v.setTextColor(this.f47819b.getResources().getColor(R$color.baseColorPrimaryText));
        }
    }

    public final boolean w(OnChainDataTotal onChainDataTotal) {
        if (this.f47820c == null) {
            return true;
        }
        if (onChainDataTotal == null || !onChainDataTotal.isAvailable()) {
            this.f47821d.setVisibility(0);
            this.f47820c.k();
            View findViewById = this.f47820c.findViewById(R$id.error_img);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = PixelUtils.a(60.0f);
            findViewById.setLayoutParams(layoutParams);
            return true;
        }
        this.f47824g = onChainDataTotal;
        this.f47821d.setVisibility(8);
        this.f47820c.g();
        return false;
    }

    public void x() {
        AddrMgrDialog addrMgrDialog = this.f47842y;
        if (addrMgrDialog != null) {
            addrMgrDialog.dismiss();
        }
    }

    public final void y(Context context, View view) {
        this.B = (TabItemLayoutIndicator) view.findViewById(R$id.rect_tab_layout);
        ArrayList arrayList = new ArrayList();
        TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
        Resources resources = context.getResources();
        tabItemLayoutData.setMiddleTabText(resources.getString(R$string.n_on_chain_asset_pocket));
        tabItemLayoutData.setCheck(true);
        arrayList.add(tabItemLayoutData);
        TabItemLayoutData tabItemLayoutData2 = new TabItemLayoutData();
        tabItemLayoutData2.setMiddleTabText(resources.getString(R$string.n_on_chain_asset_projects));
        tabItemLayoutData2.setCheck(false);
        arrayList.add(tabItemLayoutData2);
        this.B.setTabItemLayoutData(arrayList);
        this.D = view.findViewById(R$id.id_asset_on_chain_list_pocket);
        this.E = view.findViewById(R$id.id_asset_on_chain_list_project);
        int i11 = view.getResources().getDisplayMetrics().widthPixels;
        this.F = i11;
        this.E.setTranslationX((float) i11);
        EasyRecyclerView<PocketListItem> easyRecyclerView = (EasyRecyclerView) this.D.findViewById(R$id.rcv_pocket);
        this.f47829l = easyRecyclerView;
        FragmentActivity fragmentActivity = this.f47819b;
        int i12 = R$color.baseColorPrimarySeparator;
        easyRecyclerView.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(fragmentActivity, i12), PixelUtils.a(0.5f), false, false));
        EasyRecyclerView<ProjectListItem> easyRecyclerView2 = (EasyRecyclerView) this.E.findViewById(R$id.rcv_project);
        this.f47830m = easyRecyclerView2;
        easyRecyclerView2.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this.f47819b, i12), PixelUtils.a(0.5f), false, false));
        this.f47831n = this.E.findViewById(R$id.project_default);
        this.B.setItemClickCallBack(new j(this));
    }
}
