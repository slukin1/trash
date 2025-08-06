package com.huobi.finance.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.CurrencyDetailPresenter;
import com.huobi.finance.presenter.MineCurrencyDetailPresenter;
import com.huobi.utils.k0;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;

public class MineCurrencyDetailActivity extends BaseAssetDetailActivity {
    public View A;
    public View B;
    public View C;
    public TextView D;
    public TextView E;
    public TradeType F;
    public TextView G;
    public TextView H;
    public View I;
    public View J;
    public UnifyStableCurrencyExchangeDialog K;
    public View L;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46662s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46663t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f46664u;

    /* renamed from: v  reason: collision with root package name */
    public View f46665v;

    /* renamed from: w  reason: collision with root package name */
    public View f46666w;

    /* renamed from: x  reason: collision with root package name */
    public View f46667x;

    /* renamed from: y  reason: collision with root package name */
    public View f46668y;

    /* renamed from: z  reason: collision with root package name */
    public View f46669z;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ((CurrencyDetailPresenter) MineCurrencyDetailActivity.this.getPresenter()).T(false);
        }

        public void onDialogFragmentResume() {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        String t11 = this.f46394c != null ? a1.v().t(this.f46394c) : "";
        if (!TextUtils.isEmpty(t11)) {
            k0.O(this, t11, true);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Gh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        UnifyTransferActivity.Th(this, this.f46394c, "9");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        Fh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public MineCurrencyDetailPresenter createPresenter() {
        return new MineCurrencyDetailPresenter();
    }

    public final void Fh() {
        BaseAssetInfo Q = ((BaseAssetDetailPresenter) getPresenter()).Q();
        if ((Q instanceof BalanceDetailInfo) && DepositWithdrawController.n(((BalanceDetailInfo) Q).getStatus(), "", this, this.f46394c)) {
            UnifyDepositActivity.wh(this, this.f46394c);
        }
    }

    public final void Gh() {
        boolean z11;
        BaseAssetInfo Q = ((BaseAssetDetailPresenter) getPresenter()).Q();
        if (Q instanceof BalanceDetailInfo) {
            BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) Q;
            z11 = DepositWithdrawController.o(balanceDetailInfo.getStatus(), "", this, balanceDetailInfo.getCurrency());
        } else {
            z11 = false;
        }
        if (z11) {
            UnifyWithdrawActivity.Di(this, this.f46394c, this.F);
        }
    }

    public void Qg(int i11) {
        ((BaseAssetDetailPresenter) getPresenter()).V(i11 != 1 ? i11 != 2 ? FinanceRecordItem.TYPE_MINE_POOL_ALL : "mine-pool-transfer-out" : "mine-pool-transfer-in");
    }

    public void addEvent() {
        super.addEvent();
        this.f46667x.setClickable(true);
        this.f46667x.setOnClickListener(new r6(this));
        this.f46665v.setOnClickListener(new u6(this));
        this.f46666w.setOnClickListener(new s6(this));
        this.B.setOnClickListener(new t6(this));
        this.K.setDialogFragmentListener(new a());
    }

    public int getContentView() {
        return R.layout.activity_mine_currency_detail;
    }

    public void initView() {
        super.initView();
        removeWinBg();
        this.K = new UnifyStableCurrencyExchangeDialog();
        this.f46662s = (TextView) this.viewFinder.b(R.id.currency_detail_avaialbe_amount);
        this.f46663t = (TextView) this.viewFinder.b(R.id.currency_detail_onorders_amount);
        this.f46664u = (TextView) this.viewFinder.b(R.id.currency_detail_lock_amount);
        this.H = (TextView) this.viewFinder.b(R.id.currency_detail_estimate_amount);
        this.f46665v = this.viewFinder.b(R.id.currency_detail_deposit);
        this.I = this.viewFinder.b(R.id.currency_detail_deposit_layout);
        this.J = this.viewFinder.b(R.id.currency_detail_withdraw_layout);
        this.f46669z = this.viewFinder.b(R.id.currency_detail_convert);
        this.A = this.viewFinder.b(R.id.currency_detail_convert_layout);
        this.I = this.viewFinder.b(R.id.currency_detail_deposit_layout);
        this.J = this.viewFinder.b(R.id.currency_detail_withdraw_layout);
        this.f46666w = this.viewFinder.b(R.id.currency_detail_withdraw);
        this.D = (TextView) this.viewFinder.b(R.id.currency_detail_withdraw_txt_view);
        this.E = (TextView) this.viewFinder.b(R.id.currency_detail_deposit_txt_view);
        this.B = this.viewFinder.b(R.id.currency_detail_transfer);
        this.C = this.viewFinder.b(R.id.currency_detail_transfer_layout);
        this.L = this.viewFinder.b(R.id.currency_detail_bottom_layout);
        this.f46667x = this.viewFinder.b(R.id.currency_detail_trade);
        this.f46668y = this.viewFinder.b(R.id.currency_detail_trade_layout);
        TextView textView = (TextView) this.viewFinder.b(R.id.currency_detail_desc_estimate);
        this.G = textView;
        textView.setText(String.format(getResources().getString(R.string.n_balance_equivalent_ph), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.currency_history_type_transfer_in);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_history_type_transfer_out), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((BaseAssetDetailPresenter) getPresenter()).W();
        }
    }

    public void pb(BaseAssetInfo baseAssetInfo) {
        super.pb(baseAssetInfo);
        if (baseAssetInfo instanceof MineDetailInfo) {
            if ((getPresenter() instanceof MineCurrencyDetailPresenter) && this.L != null) {
                ViewUtil.m(this.L, ((MineCurrencyDetailPresenter) getPresenter()).q0());
            }
            MineDetailInfo mineDetailInfo = (MineDetailInfo) baseAssetInfo;
            this.F = mineDetailInfo.getTradeType();
            String u02 = m.u0(mineDetailInfo.getAvaialAble(), 12, 8);
            this.f46663t.setText(m.u0(m.a(mineDetailInfo.getOnOrders()).add(m.a(mineDetailInfo.getLock())).add(m.a(mineDetailInfo.getBank())).toPlainString(), 12, 8));
            m.u0(mineDetailInfo.getLock(), 12, 8);
            this.f46662s.setText(u02);
            this.f46664u.setVisibility(8);
            this.H.setText(mineDetailInfo.getEstimateAmount());
            if (!(getPresenter() instanceof CurrencyDetailPresenter) || !((BaseAssetDetailPresenter) getPresenter()).S()) {
                this.f46668y.setVisibility(8);
            } else {
                this.f46668y.setVisibility(0);
            }
        }
    }

    public boolean wh() {
        return false;
    }
}
