package com.huobi.finance.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.util.v;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.controller.CTAccountController;
import com.huobi.finance.presenter.AccountChoosePresenter;
import com.huobi.finance.transfer.ui.C2cMarginChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.ContractChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.LinearSwapChooseCurrencyActivityNew;
import com.huobi.finance.transfer.ui.MarginChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.OtcChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.OtcOptionChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.SuperMarginChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.SwapChooseCurrencyActivity;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import dn.d;
import i8.s;
import io.flutter.Log;
import java.util.ArrayList;
import java.util.List;
import m9.z;
import pro.huobi.R;
import qk.m;
import tg.r;
import us.h;

public class AccountChooseActivity extends BaseActivity<AccountChoosePresenter, AccountChoosePresenter.c> implements AccountChoosePresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f46239b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46240c;

    /* renamed from: d  reason: collision with root package name */
    public ExpandableListView f46241d;

    /* renamed from: e  reason: collision with root package name */
    public List<vk.a> f46242e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<List<vk.a>> f46243f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public tk.a f46244g;

    /* renamed from: h  reason: collision with root package name */
    public AccountChooseActivity f46245h;

    /* renamed from: i  reason: collision with root package name */
    public String f46246i;

    /* renamed from: j  reason: collision with root package name */
    public String f46247j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f46248k = false;

    /* renamed from: l  reason: collision with root package name */
    public vk.a f46249l = new vk.a(R.string.n_transfer_account_usdt_m, new a(), !d.f().m());

    /* renamed from: m  reason: collision with root package name */
    public final vk.a f46250m = new vk.a((int) R.string.n_transfer_account_copy_trading, (View.OnClickListener) new k0(this));

    /* renamed from: n  reason: collision with root package name */
    public Integer[] f46251n = {Integer.valueOf(R.string.n_assets_transfer_spot), Integer.valueOf(R.string.n_assets_transfer_fiat), Integer.valueOf(R.string.n_transfer_account_usdt_m), Integer.valueOf(R.string.n_transfer_account_coin_m_p), Integer.valueOf(R.string.n_transfer_account_coin_m_d), Integer.valueOf(R.string.n_transfer_account_copy_trading), Integer.valueOf(R.string.n_transfer_account_c_m), Integer.valueOf(R.string.n_transfer_account_i_m), Integer.valueOf(R.string.n_assets_transfer_options)};

    /* renamed from: o  reason: collision with root package name */
    public String[] f46252o = {"1", "2", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, "3", CouponReturn.TYPE_EXPERIENCE};

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (s.d().f() == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (!s.d().h()) {
                m.c(AccountChooseActivity.this.f46245h, TradeType.LINEAR_SWAP);
            } else if (d.f().m()) {
                AccountChooseActivity.this.Uh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            } else if ((!AccountChooseActivity.this.f46239b || !AccountChooseActivity.this.f46247j.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) && (AccountChooseActivity.this.f46239b || !AccountChooseActivity.this.f46246i.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT))) {
                LinearSwapChooseCurrencyActivityNew.Aj(AccountChooseActivity.this.f46245h);
            } else {
                AccountChooseActivity.this.Uh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractUserInfo.UserBean o11 = ContractUserInfoProvider.i().o();
            if (o11 == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (o11.getActiveState() == 1) {
                ContractChooseCurrencyActivity.zj(AccountChooseActivity.this.f46245h, false);
            } else {
                ej.c.c(AccountChooseActivity.this.f46245h);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (z.f().h() == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (z.f().k()) {
                SwapChooseCurrencyActivity.Bj(AccountChooseActivity.this.f46245h, false);
            } else {
                h.c(AccountChooseActivity.this.f46245h);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        SuperMarginChooseCurrencyActivity.Aj(this.f46245h, this.f46239b);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hh(View view) {
        MarginChooseCurrencyActivity.Aj(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        C2cMarginChooseCurrencyActivity.Aj(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        OtcOptionChooseCurrencyActivity.Bj(this.f46245h, this.f46239b);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        OtcOptionChooseCurrencyActivity.Bj(this.f46245h, this.f46239b);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean Lh(ExpandableListView expandableListView, View view, int i11, long j11) {
        Log.d("AccountChooseActivity", "onGroupClick --> groupPosition:" + i11);
        if (this.f46242e.get(i11).d() == R.string.n_assets_transfer_fiat) {
            SensorsDataAutoTrackHelper.trackExpandableListViewOnGroupClick(expandableListView, view, i11);
            return true;
        } else if (!AppLanguageHelper.getInstance().isChineseLanguage() || this.f46242e.get(i11).d() != R.string.n_assets_transfer_options) {
            SensorsDataAutoTrackHelper.trackExpandableListViewOnGroupClick(expandableListView, view, i11);
            return false;
        } else {
            SensorsDataAutoTrackHelper.trackExpandableListViewOnGroupClick(expandableListView, view, i11);
            return true;
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ boolean Mh(ExpandableListView expandableListView, View view, int i11, int i12, long j11) {
        Log.d("AccountChooseActivity", "onGroupClick --> groupPosition:" + i11 + " childPosition:" + i12);
        SensorsDataAutoTrackHelper.trackExpandableListViewOnChildClick(expandableListView, view, i11, i12);
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_ACCOUNT, "1");
        intent.putExtra("IS_FROM", this.f46239b);
        setResult(-1, intent);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_ACCOUNT, "1");
        intent.putExtra("IS_FROM", this.f46239b);
        setResult(-1, intent);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ph(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_ACCOUNT, "1");
        intent.putExtra("IS_FROM", this.f46239b);
        setResult(-1, intent);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_ACCOUNT, "1");
        intent.putExtra("IS_FROM", this.f46239b);
        setResult(-1, intent);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rh(View view) {
        OtcChooseCurrencyActivity.yj(this.f46245h);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Sh(View view) {
        Uh(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ah() {
        Boolean first = v.e().g(true).toBlocking().first();
        Log.d("AccountChooseActivity", "visible:" + first);
        if (first.booleanValue()) {
            ArrayList arrayList = new ArrayList();
            if (this.f46240c) {
                arrayList.add(new vk.a((int) R.string.n_assets_transfer_c2cm, (View.OnClickListener) new j0(this)));
            }
            arrayList.add(new vk.a((int) R.string.n_assets_transfer_options, (View.OnClickListener) new m0(this)));
            this.f46243f.add(arrayList);
            this.f46242e.addAll(arrayList);
        }
    }

    public final void Bh() {
        if (v.e().g(true).toBlocking().first().booleanValue()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new vk.a((int) R.string.n_assets_transfer_options, (View.OnClickListener) new b0(this)));
            this.f46243f.add(arrayList);
            this.f46242e.addAll(arrayList);
        }
    }

    /* renamed from: Ch */
    public AccountChoosePresenter createPresenter() {
        return new AccountChoosePresenter();
    }

    public final void Dh() {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.f46251n.length; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= this.f46242e.size()) {
                    z11 = true;
                    break;
                } else if (this.f46242e.get(i12).d() == this.f46251n[i11].intValue()) {
                    z11 = false;
                    break;
                } else {
                    i12++;
                }
            }
            if (z11) {
                arrayList.add(new vk.a(this.f46251n[i11].intValue(), true));
            }
        }
        if (!arrayList.isEmpty()) {
            this.f46242e.add(new vk.a((int) R.string.n_transfer_unavailable_tips, 1));
            this.f46242e.addAll(arrayList);
        }
        String str = this.f46239b ? this.f46246i : this.f46247j;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            String[] strArr = this.f46252o;
            if (i13 >= strArr.length) {
                break;
            }
            if (strArr[i13].equals(str)) {
                i14 = this.f46251n[i13].intValue();
            }
            i13++;
        }
        for (int i15 = 0; i15 < this.f46242e.size(); i15++) {
            vk.a aVar = this.f46242e.get(i15);
            if (aVar.d() == i14) {
                aVar.i(true);
            } else {
                aVar.i(false);
            }
        }
    }

    /* renamed from: Eh */
    public AccountChoosePresenter.c getUI() {
        return this;
    }

    public void Fh(Window window) {
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            window.setLayout(displayMetrics.widthPixels, com.hbg.module.libkt.utils.m.a(590));
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    public final void Th() {
        this.f46242e.clear();
        if (this.f46239b) {
            if (this.f46247j.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                this.f46242e.add(new vk.a((int) R.string.n_assets_transfer_spot, (View.OnClickListener) new h0(this)));
                if (!d.f().m()) {
                    this.f46242e.add(this.f46249l);
                    if (this.f46248k) {
                        this.f46242e.add(this.f46250m);
                    }
                } else {
                    this.f46242e.add(this.f46250m);
                }
                Dh();
                tk.a aVar = new tk.a(this, this.f46242e, this.f46243f);
                this.f46244g = aVar;
                this.f46241d.setAdapter(aVar);
                return;
            } else if (this.f46247j.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
                this.f46242e.add(new vk.a((int) R.string.n_assets_transfer_spot, (View.OnClickListener) new g0(this)));
                this.f46242e.add(this.f46249l);
                Dh();
                tk.a aVar2 = new tk.a(this, this.f46242e, this.f46243f);
                this.f46244g = aVar2;
                this.f46241d.setAdapter(aVar2);
                return;
            }
        } else if (this.f46246i.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
            this.f46242e.add(new vk.a((int) R.string.n_assets_transfer_spot, (View.OnClickListener) new f0(this)));
            if (!d.f().m()) {
                this.f46242e.add(this.f46249l);
                if (this.f46248k) {
                    this.f46242e.add(this.f46250m);
                }
            } else {
                this.f46242e.add(this.f46250m);
            }
            Dh();
            tk.a aVar3 = new tk.a(this, this.f46242e, this.f46243f);
            this.f46244g = aVar3;
            this.f46241d.setAdapter(aVar3);
            return;
        } else if (this.f46246i.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
            this.f46242e.add(new vk.a((int) R.string.n_assets_transfer_spot, (View.OnClickListener) new l0(this)));
            this.f46242e.add(this.f46249l);
            Dh();
            tk.a aVar4 = new tk.a(this, this.f46242e, this.f46243f);
            this.f46244g = aVar4;
            this.f46241d.setAdapter(aVar4);
            return;
        }
        if (!r.x().X()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new vk.a((int) R.string.n_assets_transfer_fiat, (View.OnClickListener) new i0(this)));
            this.f46242e.addAll(arrayList);
        }
        yh();
        zh();
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            Bh();
        } else {
            Ah();
        }
        Dh();
        tk.a aVar5 = new tk.a(this, this.f46242e, this.f46243f);
        this.f46244g = aVar5;
        this.f46241d.setAdapter(aVar5);
    }

    public final void Uh(String str) {
        Intent intent = new Intent();
        SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
        symbolCurrencyEntity.setBaseCurrency("USDT");
        symbolCurrencyEntity.setQuoteCurrency("USDT");
        intent.putExtra("coin", symbolCurrencyEntity);
        intent.putExtra(Constants.FLAG_ACCOUNT, str);
        intent.putExtra("IS_FROM", getIntent().getBooleanExtra("IS_FROM", false));
        setResult(-1, intent);
        finish();
    }

    public void addEvent() {
    }

    public void afterInit() {
        super.afterInit();
        this.f46245h = this;
        this.f46239b = getIntent().getBooleanExtra("IS_FROM", true);
        this.f46246i = getIntent().getStringExtra("FROM_ACCOUNT");
        this.f46247j = getIntent().getStringExtra("TO_ACCOUNT");
        this.f46248k = getIntent().getBooleanExtra("IS_CROSS_MARGIN", false);
        d.f().o(false);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_anim_exit_from_bottom);
    }

    public int getContentView() {
        return R.layout.activity_account_choose;
    }

    public void initView() {
        hideStatusBar();
        Fh(getWindow());
        ((HbTitleBar) this.viewFinder.b(R.id.htb)).setTitleSize(R.dimen.dimen_16);
        ExpandableListView expandableListView = (ExpandableListView) this.viewFinder.b(R.id.expandableListView);
        this.f46241d = expandableListView;
        expandableListView.setGroupIndicator((Drawable) null);
        this.f46241d.setOnGroupClickListener(new d0(this));
        this.f46241d.setOnChildClickListener(c0.f47065a);
    }

    public void od(boolean z11) {
        this.f46240c = z11;
        Th();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_anim_enter_from_bottom, 0);
    }

    public final void yh() {
        if (gj.d.n().E() && o.h()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f46249l);
            arrayList.add(new vk.a((int) R.string.n_transfer_account_coin_m_d, (View.OnClickListener) new b()));
            arrayList.add(new vk.a((int) R.string.n_transfer_account_coin_m_p, (View.OnClickListener) new c()));
            CTAccountController.f45408b.a().b();
            arrayList.add(this.f46250m);
            this.f46242e.addAll(arrayList);
        }
    }

    public final void zh() {
        if (gj.d.n().G()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new vk.a((int) R.string.n_transfer_account_c_m, (View.OnClickListener) new e0(this)));
            arrayList.add(new vk.a((int) R.string.n_transfer_account_i_m, (View.OnClickListener) new a0(this)));
            this.f46242e.addAll(arrayList);
        }
    }
}
