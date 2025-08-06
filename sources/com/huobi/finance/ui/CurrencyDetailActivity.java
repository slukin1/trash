package com.huobi.finance.ui;

import al.p;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.MaxRateMiningProject;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.CurrencyIntroBean;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.presenter.CurrencyDetailPresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.view.CurrencyIntroWebActivity;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.button.StatusButton;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import gs.g;
import i6.d;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;
import va.b;
import yl.x;

public class CurrencyDetailActivity extends BaseAssetDetailActivity implements CurrencyDetailPresenter.d {
    public View A;
    public EasyRecyclerView<CurrencyIntroBean.TradeItem> B;
    public View C;
    public View D;
    public TextView E;
    public TextView F;
    public View G;
    public View H;
    public View I;
    public View J;
    public boolean K;
    public HbTitleBar L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public View W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f46458a0;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f46459b0;

    /* renamed from: c0  reason: collision with root package name */
    public View f46460c0;

    /* renamed from: d0  reason: collision with root package name */
    public View f46461d0;

    /* renamed from: e0  reason: collision with root package name */
    public HorizontalScrollView f46462e0;

    /* renamed from: f0  reason: collision with root package name */
    public HorizontalScrollView f46463f0;

    /* renamed from: s  reason: collision with root package name */
    public StatusButton f46464s;

    /* renamed from: t  reason: collision with root package name */
    public View f46465t;

    /* renamed from: u  reason: collision with root package name */
    public View f46466u;

    /* renamed from: v  reason: collision with root package name */
    public View f46467v;

    /* renamed from: w  reason: collision with root package name */
    public TradeType f46468w;

    /* renamed from: x  reason: collision with root package name */
    public UnifyStableCurrencyExchangeDialog f46469x;

    /* renamed from: y  reason: collision with root package name */
    public View f46470y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46471z;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            CurrencyDetailActivity.this.getPresenter().T(false);
        }

        public void onDialogFragmentResume() {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bi(View view) {
        Yh(true);
        ni("buy");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        Yh(false);
        ni("sale");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(View view) {
        Th();
        ni("withdraw");
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_Exchange_details_withdraw_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ Boolean ei(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Boolean bool) {
        Vh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(APIStatusErrorException aPIStatusErrorException) {
        Vh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(Throwable th2) {
        Vh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(APIStatusErrorException aPIStatusErrorException) {
        Zh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ji(Throwable th2) {
        Zh();
    }

    public static /* synthetic */ Boolean ki(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        f.W(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        Wh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.K) {
            getPresenter().J0(this, false);
        } else {
            Sh();
            ni("recharge");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(Boolean bool) {
        Zh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mi(MaxRateMiningProject maxRateMiningProject, View view) {
        Locale locale = Locale.US;
        String format = String.format(locale, a0.j() + "%s" + maxRateMiningProject.getUrl(), new Object[]{"/" + f.s().replace("/", "")});
        d.j("CurrencyDetailTradeIntroHelper", "OPEN EARN, " + format);
        HBBaseWebActivity.showWebView(this, format, (String) null, (String) null, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        CurrencyIntroWebActivity.start(this, getPresenter().Q().getCurrency());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Qg(int i11) {
        String str;
        switch (i11) {
            case 1:
                str = FinanceRecordItem.TYPE_WITHDRAW_VIRTUAL_COMMON_FAST;
                break;
            case 2:
                str = FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL_COMMON_FAST;
                break;
            case 3:
                str = FinanceRecordItem.TYPE_SYSTEM_TYPES;
                break;
            case 4:
                str = FinanceRecordItem.TYPE_POINTS_TYPES;
                break;
            case 5:
                str = FinanceRecordItem.TYPE_TRANSFER_IN_TYPES;
                break;
            case 6:
                str = FinanceRecordItem.TYPE_TRANSFER_OUT_TYPES;
                break;
            default:
                str = "";
                break;
        }
        getPresenter().V(str);
    }

    public final boolean Qh(HorizontalScrollView horizontalScrollView) {
        View childAt = horizontalScrollView.getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (horizontalScrollView.getWidth() < childAt.getWidth() + horizontalScrollView.getPaddingLeft() + horizontalScrollView.getPaddingRight()) {
            return true;
        }
        return false;
    }

    /* renamed from: Rh */
    public CurrencyDetailPresenter createPresenter() {
        return new CurrencyDetailPresenter();
    }

    public final void Sh() {
        DepositWithdrawController.l(this, this.f46394c).compose(RxJavaHelper.t(this)).filter(x3.f47392b).subscribe(EasySubscriber.create(new s3(this), new r3(this), new u3(this)));
    }

    public final void Th() {
        DepositWithdrawController.m(this, this.f46394c).compose(RxJavaHelper.t(this)).filter(w3.f47375b).subscribe(EasySubscriber.create(new t3(this), new g4(this), new v3(this)));
    }

    /* renamed from: Uh */
    public CurrencyDetailPresenter getPresenter() {
        return (CurrencyDetailPresenter) super.getPresenter();
    }

    public final void Vh() {
        UnifyDepositActivity.wh(this, this.f46394c);
    }

    public final void Wh() {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f46394c);
        is.a.i("5856", hashMap);
        g.i("app_assets_Exchange_details_low_click", (HashMap) null);
        Intent v11 = f.v(this);
        if (!r.x().F0()) {
            c.i().d(this, new JumpTarget(v11, k0.h(this)));
        } else if (!NetworkStatus.c(this)) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            startActivity(v11);
        }
    }

    public final void Xh() {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f46394c);
        is.a.i("5750", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_Exchange_details_zero_click", hashMap2);
        jp.k0.p(this, this.f46394c);
    }

    public void Y6(CurrencyIntroBean currencyIntroBean) {
        ViewUtil.m(this.J, currencyIntroBean.e() && currencyIntroBean.f());
        ViewUtil.m(this.D, currencyIntroBean.e());
        MaxRateMiningProject c11 = currencyIntroBean.c();
        if (c11 != null) {
            this.F.setText(k.C().z(c11.getCurrency()));
            this.E.setTextColor(getResources().getColor(w.h()));
            this.E.setText(m.Q(c11.getMaxViewYearRate(), 2, 1));
            this.G.setOnClickListener(new f4(this, c11));
        }
        ViewUtil.m(this.C, currencyIntroBean.f());
        List<CurrencyIntroBean.TradeItem> d11 = currencyIntroBean.d();
        if (d11 != null) {
            this.B.setData(d11);
        }
    }

    public final void Yh(boolean z11) {
        String t11 = a1.v().t(this.f46394c);
        if (nq.a.d(t11)) {
            nq.a.h(this, getSupportFragmentManager(), t11, z11);
        } else {
            k0.O(this, t11, z11);
        }
    }

    public final void Zh() {
        UnifyWithdrawActivity.Di(this, this.f46394c, this.f46468w);
    }

    public void addEvent() {
        super.addEvent();
        this.viewFinder.b(R.id.earn_entrance).setOnClickListener(new e4(this));
        this.L.setOnClickActionListener(new d4(this));
        this.f46470y.setOnClickListener(new y3(this));
        this.A.setOnClickListener(new c4(this));
        this.f46464s.setOnClickListener(new z3(this));
        this.f46466u.setOnClickListener(new b4(this));
        this.f46465t.setOnClickListener(new q3(this));
        this.f46467v.setOnClickListener(new a4(this));
        this.f46469x.setDialogFragmentListener(new a());
    }

    public final boolean ai() {
        MarketCoin.Coin h11;
        if (!r.x().X() && (h11 = OtcMarketPriceConfigUtil.h(b.e(this.f46394c))) != null && (h11.getCurrencyStatus() & 1) == 0) {
            return true;
        }
        return false;
    }

    public int getContentView() {
        return R.layout.activity_currency_detail;
    }

    public void initView() {
        BalanceDetailInfo balanceDetailInfo;
        super.initView();
        removeWinBg();
        this.f46469x = new UnifyStableCurrencyExchangeDialog();
        this.f46464s = (StatusButton) this.viewFinder.b(R.id.currency_detail_deposit);
        this.f46466u = this.viewFinder.b(R.id.currency_detail_buy);
        this.f46465t = this.viewFinder.b(R.id.currency_detail_sell);
        this.f46467v = this.viewFinder.b(R.id.currency_detail_withdraw);
        this.f46470y = this.viewFinder.b(R.id.otc_entry);
        this.f46471z = (TextView) this.viewFinder.b(R.id.tv_zero_fee_otc);
        this.A = this.viewFinder.b(R.id.ht_deduct_entrance);
        EasyRecyclerView<CurrencyIntroBean.TradeItem> easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R.id.rcv_market);
        this.B = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        this.B.addItemDecoration(new ea.a(this, PixelUtils.a(10.0f)));
        this.C = this.viewFinder.b(R.id.trade_layout);
        this.D = this.viewFinder.b(R.id.ll_go_earn);
        this.E = (TextView) this.viewFinder.b(R.id.tv_annualized_earn_rate);
        this.F = (TextView) this.viewFinder.b(R.id.tv_earn_title);
        this.G = this.viewFinder.b(R.id.earn_card);
        this.H = this.viewFinder.b(R.id.intro_layout);
        this.I = this.viewFinder.b(R.id.divider_intro);
        this.J = this.viewFinder.b(R.id.intro_trade_divider);
        this.L = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.M = (TextView) this.viewFinder.b(R.id.spot_position_value_tv);
        this.N = (TextView) this.viewFinder.b(R.id.spot_available_value_tv);
        this.O = (TextView) this.viewFinder.b(R.id.spot_frozen_value_tv);
        this.P = (TextView) this.viewFinder.b(R.id.spot_lock_value_tv);
        this.Q = (TextView) this.viewFinder.b(R.id.spot_position_equivalent_value_tv);
        this.R = (TextView) this.viewFinder.b(R.id.spot_available_equivalent_value_tv);
        this.S = (TextView) this.viewFinder.b(R.id.spot_frozen_equivalent_value_tv);
        this.T = (TextView) this.viewFinder.b(R.id.spot_lock_equivalent_value_tv);
        this.U = (TextView) this.viewFinder.b(R.id.ybb_value_tv);
        this.V = (TextView) this.viewFinder.b(R.id.yesterday_income_value_tv);
        this.W = this.viewFinder.b(R.id.ybb_layout);
        this.X = (TextView) this.viewFinder.b(R.id.ybb_equivalent_value_tv);
        this.Y = (TextView) this.viewFinder.b(R.id.yesterday_income_equivalent_value_tv);
        this.Z = (TextView) this.viewFinder.b(R.id.currency_detail_total_label_tv);
        this.f46458a0 = (TextView) this.viewFinder.b(R.id.currency_detail_total_value_tv);
        this.f46459b0 = (TextView) this.viewFinder.b(R.id.currency_detail_total_equivalent_tv);
        this.f46460c0 = this.viewFinder.b(R.id.coin_mask_view);
        this.f46461d0 = this.viewFinder.b(R.id.ybb_mask_view);
        this.f46462e0 = (HorizontalScrollView) this.viewFinder.b(R.id.coin_scroll_view_layout);
        this.f46463f0 = (HorizontalScrollView) this.viewFinder.b(R.id.ybb_scroll_view_layout);
        this.K = x.n().q();
        Intent intent = getIntent();
        if (!(intent == null || (balanceDetailInfo = (BalanceDetailInfo) intent.getSerializableExtra("currency_detail_info")) == null)) {
            if (TextUtils.isEmpty(a1.v().t(balanceDetailInfo.getCurrency()))) {
                this.f46465t.setVisibility(8);
                this.f46466u.setVisibility(8);
            } else {
                this.f46465t.setVisibility(0);
                this.f46466u.setVisibility(0);
            }
        }
        g.i("app_spot_currency_all_exposure", (HashMap) null);
    }

    public final void ni(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_spot_currency_detail_button", str);
        g.i("app_spot_currency_bottom_button_exposure", hashMap);
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.currency_history_type_withdraw);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_deposit), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_system), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_points), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_transfer_in), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_transfer_out), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public final void oi() {
        boolean Qh = Qh(this.f46462e0);
        boolean Qh2 = Qh(this.f46463f0);
        ViewUtil.n(this.f46460c0, Qh);
        ViewUtil.n(this.f46461d0, Qh2);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            getPresenter().W();
        }
    }

    public void onStart() {
        super.onStart();
        oi();
    }

    public void uh(boolean z11) {
    }

    public void wd(BaseAssetInfo baseAssetInfo, YbbUserAssetInfoData ybbUserAssetInfoData, List<String> list) {
        String str;
        List<YbbUserAssetInfoData.DetailsDTO> details;
        BaseAssetInfo baseAssetInfo2 = baseAssetInfo;
        List<String> list2 = list;
        super.pb(baseAssetInfo);
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", baseAssetInfo.getDisplayName());
        g.i("app_assets_Exchange_details_view", hashMap);
        if (baseAssetInfo2 instanceof BalanceDetailInfo) {
            String currency = getPresenter().Q().getCurrency();
            boolean z11 = !x7.f.c(currency) && !x.n().p();
            BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) baseAssetInfo2;
            this.f46468w = balanceDetailInfo.getTradeType();
            String lock = balanceDetailInfo.getLock();
            if (TextUtils.isEmpty(lock)) {
                lock = "0";
            }
            YbbUserAssetInfoData.DetailsDTO detailsDTO = null;
            if (!(ybbUserAssetInfoData == null || (details = ybbUserAssetInfoData.getDetails()) == null || details.isEmpty())) {
                detailsDTO = details.get(0);
            }
            if (detailsDTO != null) {
                str = m.a(balanceDetailInfo.getNetBalance()).add(m.a(detailsDTO.getDigitalAssetTotalAmount())).toPlainString();
            } else {
                str = balanceDetailInfo.getNetBalance();
            }
            String j11 = p.j(balanceDetailInfo.getOnOrders(), currency);
            TextView textView = this.Z;
            textView.setText(StringUtils.i(currency) + " " + getString(R.string.n_all_asset_title));
            this.f46458a0.setText(p.j(str, currency));
            this.N.setText(p.j(balanceDetailInfo.getAvaialAble(), currency));
            this.O.setText(j11);
            this.P.setText(p.j(lock, currency));
            this.M.setText(p.j(balanceDetailInfo.getNetBalance(), currency));
            this.f46459b0.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(str, currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            this.Q.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(balanceDetailInfo.getNetBalance(), currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            this.R.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(balanceDetailInfo.getAvaialAble(), currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            this.S.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(j11, currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            this.T.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(lock, currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            ViewUtil.m(this.f46470y, ai());
            ViewUtil.m(this.A, !r.x().X() && "ht".equalsIgnoreCase(currency));
            this.f46471z.setText(getString(R.string.n_balance_detail_zero_buy, new Object[]{baseAssetInfo.getDisplayName()}));
            CurrencyBean s11 = k.C().s(currency);
            ViewUtil.m(this.L.getTvAction(), s11 != null && !s11.isEtpTag() && !s11.isFiatTag());
            boolean z12 = x.n().m(currency) && this.K;
            this.K = z12;
            if (z12) {
                this.f46464s.setButtonText(getString(R.string.n_balance_asset_disposal));
            }
            if (this.K) {
                ViewUtil.m(this.f46464s, true);
            } else {
                ViewUtil.m(this.f46464s, z11);
            }
            if (detailsDTO != null) {
                this.W.setVisibility(0);
                this.U.setText(p.j(detailsDTO.getDigitalAssetTotalAmount(), currency));
                this.V.setText(p.j(detailsDTO.getDigitalIncomeYesterdayAmount(), currency));
                this.X.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(detailsDTO.getDigitalAssetTotalAmount(), currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
                this.Y.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G(detailsDTO.getDigitalIncomeYesterdayAmount(), currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            } else if (list2 == null || !list2.contains(StringUtils.i(currency))) {
                this.W.setVisibility(8);
            } else {
                this.W.setVisibility(0);
                this.U.setText(p.j("0", currency));
                this.V.setText(p.j("0", currency));
                this.X.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G("0", currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
                this.Y.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.G("0", currency, this.f46468w), StringUtils.i(LegalCurrencyConfigUtil.y())}));
            }
            oi();
        }
    }

    public void yh(String str) {
        this.L.setTitle(str);
    }
}
