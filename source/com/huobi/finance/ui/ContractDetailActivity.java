package com.huobi.finance.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import bj.d;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.presenter.BaseAssetDetailPresenter;
import com.huobi.finance.presenter.ContractDetailPresenter;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;

public class ContractDetailActivity extends BaseAssetDetailActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public View H;
    public View I;
    public TextView J;
    public CoordinatorLayout K;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46412s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f46413t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f46414u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f46415v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f46416w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f46417x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f46418y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f46419z;

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(HBDialogFragment hBDialogFragment) {
        Fh();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_derivatives_details_transfer_click", hashMap);
        UnifyTransferActivity.Th(this, this.f46394c, "4");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        DialogUtils.b.d dVar = new DialogUtils.b.d(this);
        dVar.c1(getString(R.string.my_points_description));
        dVar.C0(getString(R.string.n_balance_contract_available_margin_hint));
        dVar.Y0(getString(R.string.prime_see_detail));
        dVar.a1(new i3(this));
        dVar.P0(getString(R.string.allow_access_dialog_positive_btn));
        dVar.Q0(j3.f47182a);
        dVar.k0().show(getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", k.C().z(this.f46394c));
        g.i("app_assets_derivatives_details_contract_trade_click", hashMap);
        if (getPresenter() instanceof ContractDetailPresenter) {
            ((ContractDetailPresenter) getPresenter()).f0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public ContractDetailPresenter createPresenter() {
        return new ContractDetailPresenter();
    }

    public final void Fh() {
        HBBaseWebActivity.showWebView(this, String.format(c1.a(), new Object[]{d1.h()}), "", "", false);
    }

    public void Qg(int i11) {
        String str;
        BaseAssetDetailPresenter baseAssetDetailPresenter = (BaseAssetDetailPresenter) getPresenter();
        if (i11 == 0) {
            str = null;
        } else {
            str = d.k(i11);
        }
        baseAssetDetailPresenter.V(str);
    }

    public void addEvent() {
        super.addEvent();
        this.H.setOnClickListener(new g3(this));
        this.I.setOnClickListener(new f3(this));
        this.f46415v.setOnClickListener(new h3(this));
    }

    public int getContentView() {
        return R.layout.activity_contract_detail;
    }

    public void initView() {
        super.initView();
        removeWinBg();
        this.f46412s = (TextView) this.viewFinder.b(R.id.currency_detail_account_equity);
        this.f46413t = (TextView) this.viewFinder.b(R.id.currency_detail_price_estimate);
        this.f46414u = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_rate);
        this.f46415v = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_avail);
        this.f46416w = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_maintain);
        this.f46417x = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_onorder);
        this.f46418y = (TextView) this.viewFinder.b(R.id.currency_detail_profit_loss_norealize);
        this.f46419z = (TextView) this.viewFinder.b(R.id.currency_detail_profit_loss_realize);
        this.A = (TextView) this.viewFinder.b(R.id.currency_detail_account_equity_title);
        TextView textView = (TextView) this.viewFinder.b(R.id.currency_detail_price_estimate_title);
        this.B = textView;
        textView.setText(String.format(getResources().getString(R.string.n_linear_swap_prediction_of_strong_parity), new Object[]{"(USD)"}));
        this.C = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_avail_title);
        this.D = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_maintain_title);
        this.E = (TextView) this.viewFinder.b(R.id.currency_detail_burrow_onorder_title);
        this.F = (TextView) this.viewFinder.b(R.id.currency_detail_profit_loss_norealize_title);
        this.G = (TextView) this.viewFinder.b(R.id.currency_detail_profit_loss_realize_title);
        this.H = this.viewFinder.b(R.id.currency_detail_transfer);
        this.I = this.viewFinder.b(R.id.currency_detail_contract);
        this.J = (TextView) this.viewFinder.b(R.id.currency_detail_contract_trade_tv);
        this.K = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
    }

    public List<MenuItem> oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MenuItem("", getString(R.string.otc_balance_detail_history_type_all), MenuItem.MenuItemStyle.STRESS, this.f46408q));
        String string = getString(R.string.currency_detail_contract_status_open);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        arrayList.add(new MenuItem("", string, menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_flat), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_force_flat), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_settle), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_transfer_out), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_transfer_in), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_fee), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_contract_status_reward), menuItemStyle, this.f46408q));
        arrayList.add(new MenuItem("", getString(R.string.currency_detail_system), menuItemStyle, this.f46408q));
        return arrayList;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((BaseAssetDetailPresenter) getPresenter()).W();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pb(com.huobi.finance.bean.BaseAssetInfo r12) {
        /*
            r11 = this;
            super.pb(r12)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            d7.k r1 = d7.k.C()
            java.lang.String r2 = r11.f46394c
            java.lang.String r1 = r1.z(r2)
            java.lang.String r2 = "currency_name"
            r0.put(r2, r1)
            java.lang.String r1 = "app_assets_derivatives_details_view"
            gs.g.i(r1, r0)
            boolean r0 = r12 instanceof com.huobi.contract.entity.ContractAccountInfo
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            com.huobi.contract.entity.ContractAccountInfo r12 = (com.huobi.contract.entity.ContractAccountInfo) r12
            java.lang.String r0 = r12.getSymbol()
            r11.f46394c = r0
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r0 = r0.toUpperCase(r1)
            r11.yh(r0)
            android.widget.TextView r0 = r11.A
            android.content.res.Resources r1 = r11.getResources()
            r2 = 2132017731(0x7f140243, float:1.9673749E38)
            java.lang.String r1 = r1.getString(r2)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r11.f46394c
            r5 = 0
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.setText(r1)
            android.widget.TextView r0 = r11.A
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.res.Resources r3 = r11.getResources()
            r4 = 2132019845(0x7f140a85, float:1.9678036E38)
            java.lang.String r3 = r3.getString(r4)
            r1.append(r3)
            java.lang.String r3 = "("
            r1.append(r3)
            java.lang.String r3 = r11.f46394c
            r1.append(r3)
            java.lang.String r3 = ")"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            android.widget.TextView r0 = r11.C
            android.content.res.Resources r1 = r11.getResources()
            r3 = 2132017732(0x7f140244, float:1.967375E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r11.f46394c
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.setText(r1)
            android.widget.TextView r0 = r11.D
            android.content.res.Resources r1 = r11.getResources()
            r3 = 2132017733(0x7f140245, float:1.9673753E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r11.f46394c
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.setText(r1)
            android.widget.TextView r0 = r11.E
            android.content.res.Resources r1 = r11.getResources()
            r3 = 2132017734(0x7f140246, float:1.9673755E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r11.f46394c
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.setText(r1)
            android.widget.TextView r0 = r11.F
            android.content.res.Resources r1 = r11.getResources()
            r3 = 2132017737(0x7f140249, float:1.967376E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r11.f46394c
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r0.setText(r1)
            android.widget.TextView r0 = r11.G
            android.content.res.Resources r1 = r11.getResources()
            r3 = 2132017738(0x7f14024a, float:1.9673763E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r11.f46394c
            r2[r5] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.setText(r1)
            java.lang.String r0 = r12.getMarginBalance()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "--"
            if (r0 == 0) goto L_0x0109
            r0 = r1
            goto L_0x0117
        L_0x0109:
            java.lang.String r0 = r12.getMarginBalance()
            java.lang.String r2 = r11.f46394c
            int r2 = ej.f.j(r2)
            java.lang.String r0 = com.huobi.finance.utils.AssetNumberUtil.a(r0, r2)
        L_0x0117:
            java.lang.String r2 = r11.f46394c
            int r2 = ej.f.d(r2)
            java.lang.String r3 = r12.getMarginPosition()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0129
            r3 = r1
            goto L_0x0131
        L_0x0129:
            java.lang.String r3 = r12.getMarginPosition()
            java.lang.String r3 = com.huobi.finance.utils.AssetNumberUtil.a(r3, r2)
        L_0x0131:
            java.lang.String r4 = r12.getMarginFrozen()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x013d
            r4 = r1
            goto L_0x0145
        L_0x013d:
            java.lang.String r4 = r12.getMarginFrozen()
            java.lang.String r4 = com.huobi.finance.utils.AssetNumberUtil.a(r4, r2)
        L_0x0145:
            java.lang.String r6 = r12.getMarginAvailable()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0151
            r2 = r1
            goto L_0x0159
        L_0x0151:
            java.lang.String r6 = r12.getMarginAvailable()
            java.lang.String r2 = com.huobi.finance.utils.AssetNumberUtil.a(r6, r2)
        L_0x0159:
            java.lang.String r6 = r11.f46394c
            int r6 = ej.f.h(r6)
            java.lang.String r7 = r12.getProfitReal()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x016b
            r7 = r1
            goto L_0x0173
        L_0x016b:
            java.lang.String r7 = r12.getProfitReal()
            java.lang.String r7 = com.huobi.finance.utils.AssetNumberUtil.a(r7, r6)
        L_0x0173:
            java.lang.String r8 = r12.getProfitUnreal()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x017f
            r6 = r1
            goto L_0x0187
        L_0x017f:
            java.lang.String r8 = r12.getProfitUnreal()
            java.lang.String r6 = com.huobi.finance.utils.AssetNumberUtil.a(r8, r6)
        L_0x0187:
            java.lang.String r8 = r12.getLiquidationPrice()
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x01a2
            java.lang.String r9 = r11.f46394c     // Catch:{ Exception -> 0x019e }
            r10 = 8
            int r9 = ej.f.b(r9, r10)     // Catch:{ Exception -> 0x019e }
            java.lang.String r8 = com.huobi.finance.utils.AssetNumberUtil.a(r8, r9)     // Catch:{ Exception -> 0x019e }
            goto L_0x01a3
        L_0x019e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x01a2:
            r8 = r1
        L_0x01a3:
            android.widget.TextView r9 = r11.f46412s
            r9.setText(r0)
            android.widget.TextView r0 = r11.f46413t
            r0.setText(r8)
            android.widget.TextView r0 = r11.f46415v
            r0.setText(r2)
            android.widget.TextView r0 = r11.f46417x
            r0.setText(r4)
            android.widget.TextView r0 = r11.f46419z
            r0.setText(r7)
            android.widget.TextView r0 = r11.f46418y
            r0.setText(r6)
            android.widget.TextView r0 = r11.f46416w
            r0.setText(r3)
            java.lang.String r0 = r12.getRiskRate()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01fd
            java.math.BigDecimal r0 = i6.m.a(r0)
            android.widget.TextView r1 = r11.f46414u
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.math.BigDecimal r3 = i6.m.f68179a
            java.math.BigDecimal r0 = r0.multiply(r3)
            java.lang.String r12 = r12.getSymbol()
            int r12 = ej.f.k(r12)
            java.lang.String r12 = i6.m.q(r0, r12)
            r2.append(r12)
            java.lang.String r12 = "%"
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r1.setText(r12)
            goto L_0x0202
        L_0x01fd:
            android.widget.TextView r12 = r11.f46414u
            r12.setText(r1)
        L_0x0202:
            java.util.List r12 = com.huobi.contract.helper.ContractCurrencyUtils.d()
            if (r12 == 0) goto L_0x023b
            java.util.Iterator r12 = r12.iterator()
        L_0x020c:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x023b
            java.lang.Object r0 = r12.next()
            com.huobi.contract.entity.ContractCoinInfo r0 = (com.huobi.contract.entity.ContractCoinInfo) r0
            java.lang.String r1 = r11.f46394c
            java.lang.String r2 = r0.getSymbol()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x020c
            int r0 = r0.getIsTrade()
            if (r0 != 0) goto L_0x020c
            android.view.View r12 = r11.I
            r12.setEnabled(r5)
            android.widget.TextView r12 = r11.J
            r0 = 2131099934(0x7f06011e, float:1.7812235E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r11, r0)
            r12.setTextColor(r0)
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.ContractDetailActivity.pb(com.huobi.finance.bean.BaseAssetInfo):void");
    }

    public int ph() {
        return R.string.currency_detail_contract_finance_title;
    }

    public boolean wh() {
        return false;
    }
}
