package com.huobi.finance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.presenter.CurrencyOrderDetailPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import pro.huobi.R;
import q6.d;
import tq.p;

public class CurrencyDetailOrderActivity extends BaseActivity<CurrencyOrderDetailPresenter, CurrencyOrderDetailPresenter.b> implements CurrencyOrderDetailPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f46473b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46474c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46475d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46476e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46477f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46478g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46479h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46480i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46481j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46482k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46483l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f46484m;

    /* renamed from: n  reason: collision with root package name */
    public Button f46485n;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f46486o;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f46487p;

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f46488q;

    /* renamed from: r  reason: collision with root package name */
    public RelativeLayout f46489r;

    /* renamed from: s  reason: collision with root package name */
    public Toolbar f46490s;

    /* renamed from: t  reason: collision with root package name */
    public CoordinatorLayout f46491t;

    /* renamed from: u  reason: collision with root package name */
    public Button f46492u;

    /* renamed from: v  reason: collision with root package name */
    public long f46493v;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ClipboardManager clipboardManager;
            if (!TextUtils.isEmpty(CurrencyDetailOrderActivity.this.f46482k.getText()) && (clipboardManager = (ClipboardManager) CurrencyDetailOrderActivity.this.getSystemService("clipboard")) != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(CurrencyDetailOrderActivity.this.f46482k.getText(), CurrencyDetailOrderActivity.this.f46482k.getText()));
                HuobiToastUtil.s(R.string.security_ga_key_already_copy);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FinanceRecordItem f46495b;

        public b(FinanceRecordItem financeRecordItem) {
            this.f46495b = financeRecordItem;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            view.getContext().startActivity(UnifyRiskActivity.Ch(view.getContext(), this.f46495b.getTransactionId(), 1));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        DialogUtils.c0(this, getResources().getString(R.string.withdraw_cancel_confirm), (String) null, getResources().getString(R.string.currency_detail_notice_dialog_cancel), getResources().getString(R.string.currency_detail_notice_dialog_confirm), j4.f47183a, new i4(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh(Object obj) {
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((FinanceService) p.W(FinanceService.class)).withdrawCancel(this.f46493v).compose(p.a0()).compose(RxJavaHelper.t(getUI())).subscribe(d.c(getUI(), new l4(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(FinanceRecordItem financeRecordItem, String str, String str2) {
        if (this.f46473b == null) {
            return;
        }
        if (financeRecordItem.getTradeType() == TradeType.MINE) {
            CollapsingToolbarLayout collapsingToolbarLayout = this.f46473b;
            collapsingToolbarLayout.setTitle(str + str2 + " " + StringUtils.i(financeRecordItem.getCurrency()));
            return;
        }
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.f46473b;
        collapsingToolbarLayout2.setTitle(str + str2 + " " + k.C().z(financeRecordItem.getCurrency()));
    }

    public final void Pg(FinanceRecordItem financeRecordItem) {
        String state = financeRecordItem.getState();
        state.hashCode();
        char c11 = 65535;
        switch (state.hashCode()) {
            case -1973793199:
                if (state.equals("pre-submitted")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1961320569:
                if (state.equals(FinanceRecordItem.STATE_ORPHAN_CONFIRMING)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1314742011:
                if (state.equals(FinanceRecordItem.STATE_RISK_DELAY)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1284171314:
                if (state.equals(FinanceRecordItem.STATE_REEXAMINE)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1196781354:
                if (state.equals(FinanceRecordItem.STATE_ROLLBACK_SAFE)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1008410488:
                if (state.equals(FinanceRecordItem.STATE_ORPHAN)) {
                    c11 = 5;
                    break;
                }
                break;
            case -934710369:
                if (state.equals(FinanceRecordItem.STATE_REJECT)) {
                    c11 = 6;
                    break;
                }
                break;
            case -853033797:
                if (state.equals(FinanceRecordItem.STATE_CONFIRM_ERROR)) {
                    c11 = 7;
                    break;
                }
                break;
            case -810471509:
                if (state.equals(FinanceRecordItem.STATE_ROLLBACK_CONFIRMING)) {
                    c11 = 8;
                    break;
                }
                break;
            case -804109473:
                if (state.equals("confirmed")) {
                    c11 = 9;
                    break;
                }
                break;
            case -436788878:
                if (state.equals(FinanceRecordItem.STATE_REPEALED)) {
                    c11 = 10;
                    break;
                }
                break;
            case -123173735:
                if (state.equals("canceled")) {
                    c11 = 11;
                    break;
                }
                break;
            case 3433489:
                if (state.equals(FinanceRecordItem.STATE_PASS)) {
                    c11 = 12;
                    break;
                }
                break;
            case 3522445:
                if (state.equals(FinanceRecordItem.STATE_SAFE)) {
                    c11 = 13;
                    break;
                }
                break;
            case 69357375:
                if (state.equals(FinanceRecordItem.STATE_WALLET_TRANSFER)) {
                    c11 = 14;
                    break;
                }
                break;
            case 111972348:
                if (state.equals(FinanceRecordItem.STATE_VALID)) {
                    c11 = 15;
                    break;
                }
                break;
            case 189047877:
                if (state.equals(FinanceRecordItem.STATE_WAITING_TINY_AMOUNT)) {
                    c11 = 16;
                    break;
                }
                break;
            case 216860606:
                if (state.equals(FinanceRecordItem.STATE_LARGE_AMOUNT_EXAMINE)) {
                    c11 = 17;
                    break;
                }
                break;
            case 308097193:
                if (state.equals(FinanceRecordItem.STATE_VERIFYING)) {
                    c11 = 18;
                    break;
                }
                break;
            case 348678395:
                if (state.equals("submitted")) {
                    c11 = 19;
                    break;
                }
                break;
            case 768015450:
                if (state.equals(FinanceRecordItem.STATE_ORPHAN_CONFIRMED)) {
                    c11 = 20;
                    break;
                }
                break;
            case 842414370:
                if (state.equals(FinanceRecordItem.STATE_CONFIRMING)) {
                    c11 = 21;
                    break;
                }
                break;
            case 845841297:
                if (state.equals(FinanceRecordItem.STATE_ROLLBACK_ORPHAN)) {
                    c11 = 22;
                    break;
                }
                break;
            case 854201778:
                if (state.equals(FinanceRecordItem.STATE_ORPHAN_SAFE)) {
                    c11 = 23;
                    break;
                }
                break;
            case 1316540403:
                if (state.equals(FinanceRecordItem.STATE_WALLET_REJECT)) {
                    c11 = 24;
                    break;
                }
                break;
            case 1636423606:
                if (state.equals(FinanceRecordItem.STATE_ROLLBACK_CONFIRMED)) {
                    c11 = 25;
                    break;
                }
                break;
            case 1760153557:
                if (state.equals(FinanceRecordItem.STATE_PRE_TRANSFER)) {
                    c11 = 26;
                    break;
                }
                break;
            case 2096857181:
                if (state.equals("Failed")) {
                    c11 = 27;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 3:
            case 19:
                this.f46477f.setText(R.string.currency_detail_status_needcheck);
                this.f46485n.setVisibility(0);
                return;
            case 1:
            case 8:
            case 20:
            case 21:
            case 25:
                this.f46477f.setText(R.string.currency_detail_status_confirming);
                return;
            case 2:
                this.f46477f.setText(R.string.currency_detail_status_to_be_credited);
                return;
            case 4:
            case 13:
            case 15:
            case 23:
                this.f46477f.setText(R.string.currency_detail_status_completed);
                return;
            case 5:
            case 22:
                this.f46477f.setText(R.string.currency_detail_status_orphan);
                return;
            case 6:
                this.f46477f.setText(R.string.currency_detail_status_verification_failed);
                this.f46480i.setVisibility(0);
                this.f46480i.setText(financeRecordItem.getErrorMsg());
                return;
            case 7:
            case 24:
                this.f46477f.setText(R.string.currency_detail_status_failed);
                return;
            case 9:
                if (financeRecordItem.getType().contains("withdraw")) {
                    this.f46477f.setText(R.string.currency_detail_status_completed);
                    return;
                } else if (financeRecordItem.getType().contains("deposit")) {
                    this.f46477f.setText(R.string.currency_detail_status_confirming);
                    return;
                } else {
                    return;
                }
            case 10:
            case 11:
                this.f46477f.setText(R.string.currency_detail_status_cancelled);
                return;
            case 12:
            case 26:
                this.f46477f.setText(R.string.currency_detail_status_processing);
                return;
            case 14:
                this.f46477f.setText(R.string.currency_detail_status_sended);
                return;
            case 16:
                this.f46477f.setText(R.string.currency_detail_status_waiting_tiny_amount);
                return;
            case 17:
                this.f46477f.setText(R.string.currency_detail_status_needcheck);
                return;
            case 18:
                this.f46477f.setText(R.string.currency_detail_status_verifying);
                this.f46485n.setBackgroundResource(R.color.global_button_enable_false);
                this.f46485n.setVisibility(0);
                this.f46492u.setVisibility(0);
                this.f46492u.setOnClickListener(new b(financeRecordItem));
                return;
            case 27:
                this.f46477f.setText(R.string.currency_detail_status_verifying_failed);
                return;
            default:
                this.f46477f.setText(R.string.currency_detail_status_unknow);
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04a3, code lost:
        if (r3.equals(com.huobi.finance.bean.FinanceRecordItem.TYPE_POINT_REFUND) == false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Qg(com.huobi.finance.bean.FinanceRecordItem r11) {
        /*
            r10 = this;
            r11.getCurrency()
            java.lang.String r0 = r11.getType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0bea
            com.hbg.lib.data.symbol.TradeType r0 = r11.getTradeType()
            if (r0 != 0) goto L_0x0016
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            goto L_0x0019
        L_0x0016:
            r11.getTradeType()
        L_0x0019:
            java.lang.String r0 = r11.getAmount()
            r1 = 12
            r2 = 8
            java.lang.String r0 = i6.m.u0(r0, r1, r2)
            java.lang.String r3 = r11.getType()
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 0
            switch(r5) {
                case -2084295844: goto L_0x0532;
                case -2079162029: goto L_0x0526;
                case -2016699684: goto L_0x051a;
                case -2008443584: goto L_0x050e;
                case -1936523770: goto L_0x0502;
                case -1923746100: goto L_0x04f6;
                case -1878752176: goto L_0x04ea;
                case -1816318536: goto L_0x04de;
                case -1655215789: goto L_0x04d1;
                case -1633968851: goto L_0x04c3;
                case -1605601539: goto L_0x04b5;
                case -1592102762: goto L_0x04a7;
                case -1559140840: goto L_0x049d;
                case -1528095678: goto L_0x048f;
                case -1457541922: goto L_0x0481;
                case -1425513535: goto L_0x0473;
                case -1391285118: goto L_0x0465;
                case -1285931775: goto L_0x0457;
                case -1167865889: goto L_0x0449;
                case -1105909470: goto L_0x043b;
                case -929832390: goto L_0x042d;
                case -896970345: goto L_0x041f;
                case -864804824: goto L_0x0411;
                case -825179062: goto L_0x0403;
                case -772118412: goto L_0x03f5;
                case -766102330: goto L_0x03e7;
                case -709692792: goto L_0x03d9;
                case -671379322: goto L_0x03cb;
                case -663964420: goto L_0x03bd;
                case -597593057: goto L_0x03af;
                case -545721176: goto L_0x03a1;
                case -478623571: goto L_0x0393;
                case -433414350: goto L_0x0385;
                case -429939310: goto L_0x0377;
                case -420924858: goto L_0x0369;
                case -250493783: goto L_0x035b;
                case -188655625: goto L_0x034d;
                case -53128555: goto L_0x033f;
                case -28934724: goto L_0x0331;
                case 8774420: goto L_0x0323;
                case 48157262: goto L_0x0315;
                case 141853772: goto L_0x0307;
                case 165300204: goto L_0x02f9;
                case 167228554: goto L_0x02eb;
                case 188394184: goto L_0x02dd;
                case 253340294: goto L_0x02cf;
                case 253947942: goto L_0x02c1;
                case 262518827: goto L_0x02b3;
                case 302999464: goto L_0x02a5;
                case 319813722: goto L_0x0297;
                case 334388582: goto L_0x0289;
                case 390628210: goto L_0x027b;
                case 418662377: goto L_0x026d;
                case 482632520: goto L_0x025f;
                case 560021501: goto L_0x0251;
                case 629985299: goto L_0x0243;
                case 676836316: goto L_0x0235;
                case 697553140: goto L_0x0227;
                case 721918332: goto L_0x0219;
                case 777811748: goto L_0x020b;
                case 789673736: goto L_0x01fd;
                case 874751196: goto L_0x01ef;
                case 909017142: goto L_0x01e1;
                case 961513413: goto L_0x01d3;
                case 968552854: goto L_0x01c5;
                case 972518781: goto L_0x01b7;
                case 1058530832: goto L_0x01a9;
                case 1105767574: goto L_0x019b;
                case 1118541859: goto L_0x018d;
                case 1152528151: goto L_0x017f;
                case 1216834384: goto L_0x0171;
                case 1239973081: goto L_0x0163;
                case 1284839057: goto L_0x0155;
                case 1294859906: goto L_0x0147;
                case 1304850771: goto L_0x0139;
                case 1334328007: goto L_0x012b;
                case 1410804545: goto L_0x011d;
                case 1416716765: goto L_0x010f;
                case 1422660065: goto L_0x0101;
                case 1551416293: goto L_0x00f3;
                case 1602985450: goto L_0x00e5;
                case 1617873683: goto L_0x00d7;
                case 1619173256: goto L_0x00c9;
                case 1637906551: goto L_0x00bb;
                case 1705735148: goto L_0x00ad;
                case 1753443826: goto L_0x00a0;
                case 1780582803: goto L_0x0093;
                case 1789000756: goto L_0x0086;
                case 1827832829: goto L_0x0079;
                case 1885649442: goto L_0x006c;
                case 1888230787: goto L_0x005f;
                case 1930102716: goto L_0x0052;
                case 1997100608: goto L_0x0045;
                case 2062744665: goto L_0x0038;
                default: goto L_0x0035;
            }
        L_0x0035:
            r1 = r4
            goto L_0x053d
        L_0x0038:
            java.lang.String r1 = "pool-savings-asset-management-spot-to-interest"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0041
            goto L_0x0035
        L_0x0041:
            r1 = 93
            goto L_0x053d
        L_0x0045:
            java.lang.String r1 = "grid-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x004e
            goto L_0x0035
        L_0x004e:
            r1 = 92
            goto L_0x053d
        L_0x0052:
            java.lang.String r1 = "option-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x005b
            goto L_0x0035
        L_0x005b:
            r1 = 91
            goto L_0x053d
        L_0x005f:
            java.lang.String r1 = "mine-pool-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0068
            goto L_0x0035
        L_0x0068:
            r1 = 90
            goto L_0x053d
        L_0x006c:
            java.lang.String r1 = "deposit-earning-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0075
            goto L_0x0035
        L_0x0075:
            r1 = 89
            goto L_0x053d
        L_0x0079:
            java.lang.String r1 = "fund-rise-system-to-institution-investor"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0082
            goto L_0x0035
        L_0x0082:
            r1 = 88
            goto L_0x053d
        L_0x0086:
            java.lang.String r1 = "spot-to-deposit-earning"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x008f
            goto L_0x0035
        L_0x008f:
            r1 = 87
            goto L_0x053d
        L_0x0093:
            java.lang.String r1 = "grid-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x009c
            goto L_0x0035
        L_0x009c:
            r1 = 86
            goto L_0x053d
        L_0x00a0:
            java.lang.String r1 = "airdrop-user-spot-oneside-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00a9
            goto L_0x0035
        L_0x00a9:
            r1 = 85
            goto L_0x053d
        L_0x00ad:
            java.lang.String r1 = "finance-project-system-to-brand"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00b7
            goto L_0x0035
        L_0x00b7:
            r1 = 84
            goto L_0x053d
        L_0x00bb:
            java.lang.String r1 = "finance-project-system-to-market"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00c5
            goto L_0x0035
        L_0x00c5:
            r1 = 83
            goto L_0x053d
        L_0x00c9:
            java.lang.String r1 = "fund-rise-system-to-investor"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00d3
            goto L_0x0035
        L_0x00d3:
            r1 = 82
            goto L_0x053d
        L_0x00d7:
            java.lang.String r1 = "point-transfer-expense"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00e1
            goto L_0x0035
        L_0x00e1:
            r1 = 81
            goto L_0x053d
        L_0x00e5:
            java.lang.String r1 = "otc-to-pro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00ef
            goto L_0x0035
        L_0x00ef:
            r1 = 80
            goto L_0x053d
        L_0x00f3:
            java.lang.String r1 = "ibox-spot-to-sys-benefit"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00fd
            goto L_0x0035
        L_0x00fd:
            r1 = 79
            goto L_0x053d
        L_0x0101:
            java.lang.String r1 = "point-purchased-pay"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x010b
            goto L_0x0035
        L_0x010b:
            r1 = 78
            goto L_0x053d
        L_0x010f:
            java.lang.String r1 = "stable-currency-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0119
            goto L_0x0035
        L_0x0119:
            r1 = 77
            goto L_0x053d
        L_0x011d:
            java.lang.String r1 = "dm-pro-to-swap"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0127
            goto L_0x0035
        L_0x0127:
            r1 = 76
            goto L_0x053d
        L_0x012b:
            java.lang.String r1 = "earn-sys-commission-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0135
            goto L_0x0035
        L_0x0135:
            r1 = 75
            goto L_0x053d
        L_0x0139:
            java.lang.String r1 = "global-spot-to-sys-overseas-activity"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0143
            goto L_0x0035
        L_0x0143:
            r1 = 74
            goto L_0x053d
        L_0x0147:
            java.lang.String r1 = "global-force-system-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0151
            goto L_0x0035
        L_0x0151:
            r1 = 73
            goto L_0x053d
        L_0x0155:
            java.lang.String r1 = "dm-swap-to-pro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x015f
            goto L_0x0035
        L_0x015f:
            r1 = 72
            goto L_0x053d
        L_0x0163:
            java.lang.String r1 = "sub-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x016d
            goto L_0x0035
        L_0x016d:
            r1 = 71
            goto L_0x053d
        L_0x0171:
            java.lang.String r1 = "futures-brokerage-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x017b
            goto L_0x0035
        L_0x017b:
            r1 = 70
            goto L_0x053d
        L_0x017f:
            java.lang.String r1 = "point-purchased-gift"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0189
            goto L_0x0035
        L_0x0189:
            r1 = 69
            goto L_0x053d
        L_0x018d:
            java.lang.String r1 = "pool-savings-asset-management-spot-to-ops"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0197
            goto L_0x0035
        L_0x0197:
            r1 = 68
            goto L_0x053d
        L_0x019b:
            java.lang.String r1 = "pool-savings-interest-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01a5
            goto L_0x0035
        L_0x01a5:
            r1 = 67
            goto L_0x053d
        L_0x01a9:
            java.lang.String r1 = "institution-to-pro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01b3
            goto L_0x0035
        L_0x01b3:
            r1 = 66
            goto L_0x053d
        L_0x01b7:
            java.lang.String r1 = "rebate-account-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01c1
            goto L_0x0035
        L_0x01c1:
            r1 = 65
            goto L_0x053d
        L_0x01c5:
            java.lang.String r1 = "stable-currency-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01cf
            goto L_0x0035
        L_0x01cf:
            r1 = 64
            goto L_0x053d
        L_0x01d3:
            java.lang.String r1 = "point-transfer-earning"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01dd
            goto L_0x0035
        L_0x01dd:
            r1 = 63
            goto L_0x053d
        L_0x01e1:
            java.lang.String r1 = "otc-options-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01eb
            goto L_0x0035
        L_0x01eb:
            r1 = 62
            goto L_0x053d
        L_0x01ef:
            java.lang.String r1 = "finance-project-system-to-kol-market"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x01f9
            goto L_0x0035
        L_0x01f9:
            r1 = 61
            goto L_0x053d
        L_0x01fd:
            java.lang.String r1 = "investor-to-fund-rise-system"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0207
            goto L_0x0035
        L_0x0207:
            r1 = 60
            goto L_0x053d
        L_0x020b:
            java.lang.String r1 = "etp-shares-merge-spot-to-sys"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0215
            goto L_0x0035
        L_0x0215:
            r1 = 59
            goto L_0x053d
        L_0x0219:
            java.lang.String r1 = "earn-sys-rate-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0223
            goto L_0x0035
        L_0x0223:
            r1 = 58
            goto L_0x053d
        L_0x0227:
            java.lang.String r1 = "oldhuobi-to-bitexpro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0231
            goto L_0x0035
        L_0x0231:
            r1 = 57
            goto L_0x053d
        L_0x0235:
            java.lang.String r1 = "finance-project-system-to-relations"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x023f
            goto L_0x0035
        L_0x023f:
            r1 = 56
            goto L_0x053d
        L_0x0243:
            java.lang.String r1 = "api-brokerage-brokerage-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x024d
            goto L_0x0035
        L_0x024d:
            r1 = 55
            goto L_0x053d
        L_0x0251:
            java.lang.String r1 = "pool-savings-ops-to-asset-management-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x025b
            goto L_0x0035
        L_0x025b:
            r1 = 54
            goto L_0x053d
        L_0x025f:
            java.lang.String r1 = "withdraw-virtual"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0269
            goto L_0x0035
        L_0x0269:
            r1 = 53
            goto L_0x053d
        L_0x026d:
            java.lang.String r1 = "global-mining-system-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0277
            goto L_0x0035
        L_0x0277:
            r1 = 52
            goto L_0x053d
        L_0x027b:
            java.lang.String r1 = "bitex-to-bitexpro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0285
            goto L_0x0035
        L_0x0285:
            r1 = 51
            goto L_0x053d
        L_0x0289:
            java.lang.String r1 = "etp-pepel-sys-to-user"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0293
            goto L_0x0035
        L_0x0293:
            r1 = 50
            goto L_0x053d
        L_0x0297:
            java.lang.String r1 = "global-rebate-brokerage-to-spot-cashback"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02a1
            goto L_0x0035
        L_0x02a1:
            r1 = 49
            goto L_0x053d
        L_0x02a5:
            java.lang.String r1 = "global-rebate-brokerage-to-spot-2nd"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02af
            goto L_0x0035
        L_0x02af:
            r1 = 48
            goto L_0x053d
        L_0x02b3:
            java.lang.String r1 = "margin-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02bd
            goto L_0x0035
        L_0x02bd:
            r1 = 47
            goto L_0x053d
        L_0x02c1:
            java.lang.String r1 = "project-airdrop-user-spot-oneside-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02cb
            goto L_0x0035
        L_0x02cb:
            r1 = 46
            goto L_0x053d
        L_0x02cf:
            java.lang.String r1 = "pool-savings-spot-to-clct"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02d9
            goto L_0x0035
        L_0x02d9:
            r1 = 45
            goto L_0x053d
        L_0x02dd:
            java.lang.String r1 = "spot-to-otc-options"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02e7
            goto L_0x0035
        L_0x02e7:
            r1 = 44
            goto L_0x053d
        L_0x02eb:
            java.lang.String r1 = "finance-project-system-to-activity"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x02f5
            goto L_0x0035
        L_0x02f5:
            r1 = 43
            goto L_0x053d
        L_0x02f9:
            java.lang.String r1 = "pro-to-otc"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0303
            goto L_0x0035
        L_0x0303:
            r1 = 42
            goto L_0x053d
        L_0x0307:
            java.lang.String r1 = "fund-org-to-fund-rise-system"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0311
            goto L_0x0035
        L_0x0311:
            r1 = 41
            goto L_0x053d
        L_0x0315:
            java.lang.String r1 = "bitexpro-to-bitex"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x031f
            goto L_0x0035
        L_0x031f:
            r1 = 40
            goto L_0x053d
        L_0x0323:
            java.lang.String r1 = "spot-to-linear-swap"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x032d
            goto L_0x0035
        L_0x032d:
            r1 = 39
            goto L_0x053d
        L_0x0331:
            java.lang.String r1 = "fork-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x033b
            goto L_0x0035
        L_0x033b:
            r1 = 38
            goto L_0x053d
        L_0x033f:
            java.lang.String r1 = "deposit-virtual-mgt-special"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0349
            goto L_0x0035
        L_0x0349:
            r1 = 37
            goto L_0x053d
        L_0x034d:
            java.lang.String r1 = "master-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0357
            goto L_0x0035
        L_0x0357:
            r1 = 36
            goto L_0x053d
        L_0x035b:
            java.lang.String r1 = "api-brokerage-auto-brokerage-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0365
            goto L_0x0035
        L_0x0365:
            r1 = 35
            goto L_0x053d
        L_0x0369:
            java.lang.String r1 = "user-to-etp-pepel-sys"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0373
            goto L_0x0035
        L_0x0373:
            r1 = 34
            goto L_0x053d
        L_0x0377:
            java.lang.String r1 = "etp-shares-merge-sys-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0381
            goto L_0x0035
        L_0x0381:
            r1 = 33
            goto L_0x053d
        L_0x0385:
            java.lang.String r1 = "pro-to-super-margin"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x038f
            goto L_0x0035
        L_0x038f:
            r1 = 32
            goto L_0x053d
        L_0x0393:
            java.lang.String r1 = "deposit-virtual-fast"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x039d
            goto L_0x0035
        L_0x039d:
            r1 = 31
            goto L_0x053d
        L_0x03a1:
            java.lang.String r1 = "margin-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03ab
            goto L_0x0035
        L_0x03ab:
            r1 = 30
            goto L_0x053d
        L_0x03af:
            java.lang.String r1 = "reward-activity-system-to-user"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03b9
            goto L_0x0035
        L_0x03b9:
            r1 = 29
            goto L_0x053d
        L_0x03bd:
            java.lang.String r1 = "spot-to-option"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03c7
            goto L_0x0035
        L_0x03c7:
            r1 = 28
            goto L_0x053d
        L_0x03cb:
            java.lang.String r1 = "pro-to-institution"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03d5
            goto L_0x0035
        L_0x03d5:
            r1 = 27
            goto L_0x053d
        L_0x03d9:
            java.lang.String r1 = "super-margin-to-pro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03e3
            goto L_0x0035
        L_0x03e3:
            r1 = 26
            goto L_0x053d
        L_0x03e7:
            java.lang.String r1 = "global-rebate-brokerage-to-spot-brokerage"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03f1
            goto L_0x0035
        L_0x03f1:
            r1 = 25
            goto L_0x053d
        L_0x03f5:
            java.lang.String r1 = "bitexpro-to-oldhuobi"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x03ff
            goto L_0x0035
        L_0x03ff:
            r1 = 24
            goto L_0x053d
        L_0x0403:
            java.lang.String r1 = "pool-savings-expend-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x040d
            goto L_0x0035
        L_0x040d:
            r1 = 23
            goto L_0x053d
        L_0x0411:
            java.lang.String r1 = "finance-project-system-to-channel"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x041b
            goto L_0x0035
        L_0x041b:
            r1 = 22
            goto L_0x053d
        L_0x041f:
            java.lang.String r1 = "fork-transfer-out"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0429
            goto L_0x0035
        L_0x0429:
            r1 = 21
            goto L_0x053d
        L_0x042d:
            java.lang.String r1 = "sub-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0437
            goto L_0x0035
        L_0x0437:
            r1 = 20
            goto L_0x053d
        L_0x043b:
            java.lang.String r1 = "fund-rise-system-to-funder"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0445
            goto L_0x0035
        L_0x0445:
            r1 = 19
            goto L_0x053d
        L_0x0449:
            java.lang.String r1 = "etp-operations-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0453
            goto L_0x0035
        L_0x0453:
            r1 = 18
            goto L_0x053d
        L_0x0457:
            java.lang.String r1 = "global-sys-overseas-activity-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0461
            goto L_0x0035
        L_0x0461:
            r1 = 17
            goto L_0x053d
        L_0x0465:
            java.lang.String r1 = "linear-swap-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x046f
            goto L_0x0035
        L_0x046f:
            r1 = 16
            goto L_0x053d
        L_0x0473:
            java.lang.String r1 = "withdraw-virtual-fast"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x047d
            goto L_0x0035
        L_0x047d:
            r1 = 15
            goto L_0x053d
        L_0x0481:
            java.lang.String r1 = "pro-to-futures"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x048b
            goto L_0x0035
        L_0x048b:
            r1 = 14
            goto L_0x053d
        L_0x048f:
            java.lang.String r1 = "api-matching-fee-brokerage"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0499
            goto L_0x0035
        L_0x0499:
            r1 = 13
            goto L_0x053d
        L_0x049d:
            java.lang.String r5 = "point-buy-back-system-to-spot"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x053d
            goto L_0x0035
        L_0x04a7:
            java.lang.String r1 = "api-brokerage-futures-brokerage-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04b1
            goto L_0x0035
        L_0x04b1:
            r1 = 11
            goto L_0x053d
        L_0x04b5:
            java.lang.String r1 = "institution-investor-to-fund-rise-system"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04bf
            goto L_0x0035
        L_0x04bf:
            r1 = 10
            goto L_0x053d
        L_0x04c3:
            java.lang.String r1 = "finance-project-system-to-kol"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04cd
            goto L_0x0035
        L_0x04cd:
            r1 = 9
            goto L_0x053d
        L_0x04d1:
            java.lang.String r1 = "ibox-sys-benefit-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04db
            goto L_0x0035
        L_0x04db:
            r1 = r2
            goto L_0x053d
        L_0x04de:
            java.lang.String r1 = "futures-to-pro"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04e8
            goto L_0x0035
        L_0x04e8:
            r1 = 7
            goto L_0x053d
        L_0x04ea:
            java.lang.String r1 = "mine-pool-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x04f4
            goto L_0x0035
        L_0x04f4:
            r1 = 6
            goto L_0x053d
        L_0x04f6:
            java.lang.String r1 = "fund-rise-system-to-fund-org"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0500
            goto L_0x0035
        L_0x0500:
            r1 = 5
            goto L_0x053d
        L_0x0502:
            java.lang.String r1 = "api-brokerage-futures-auto-brokerage-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x050c
            goto L_0x0035
        L_0x050c:
            r1 = 4
            goto L_0x053d
        L_0x050e:
            java.lang.String r1 = "global-activity-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0518
            goto L_0x0035
        L_0x0518:
            r1 = 3
            goto L_0x053d
        L_0x051a:
            java.lang.String r1 = "deposit-virtual"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0524
            goto L_0x0035
        L_0x0524:
            r1 = 2
            goto L_0x053d
        L_0x0526:
            java.lang.String r1 = "global-coupon-system-to-spot"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0530
            goto L_0x0035
        L_0x0530:
            r1 = 1
            goto L_0x053d
        L_0x0532:
            java.lang.String r1 = "master-transfer-in"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x053c
            goto L_0x0035
        L_0x053c:
            r1 = r6
        L_0x053d:
            r3 = 2132021835(0x7f14124b, float:1.9682073E38)
            r4 = 2132023245(0x7f1417cd, float:1.9684932E38)
            r5 = 2132018442(0x7f14050a, float:1.967519E38)
            r7 = 2132018441(0x7f140509, float:1.9675189E38)
            r8 = 2132017520(0x7f140170, float:1.967332E38)
            r9 = 2132020122(0x7f140b9a, float:1.9678598E38)
            switch(r1) {
                case 0: goto L_0x0b7d;
                case 1: goto L_0x0b65;
                case 2: goto L_0x0b5a;
                case 3: goto L_0x0b45;
                case 4: goto L_0x0b2d;
                case 5: goto L_0x0b15;
                case 6: goto L_0x0afc;
                case 7: goto L_0x0adb;
                case 8: goto L_0x0ac2;
                case 9: goto L_0x0aa9;
                case 10: goto L_0x0a90;
                case 11: goto L_0x0b2d;
                case 12: goto L_0x0a77;
                case 13: goto L_0x0b2d;
                case 14: goto L_0x0a56;
                case 15: goto L_0x0a45;
                case 16: goto L_0x0a2c;
                case 17: goto L_0x0a13;
                case 18: goto L_0x09fd;
                case 19: goto L_0x0b15;
                case 20: goto L_0x09df;
                case 21: goto L_0x09be;
                case 22: goto L_0x0aa9;
                case 23: goto L_0x09a8;
                case 24: goto L_0x0987;
                case 25: goto L_0x0b2d;
                case 26: goto L_0x0966;
                case 27: goto L_0x0945;
                case 28: goto L_0x092c;
                case 29: goto L_0x0913;
                case 30: goto L_0x08f2;
                case 31: goto L_0x08e6;
                case 32: goto L_0x08c5;
                case 33: goto L_0x08ac;
                case 34: goto L_0x0893;
                case 35: goto L_0x0b2d;
                case 36: goto L_0x0875;
                case 37: goto L_0x0b5a;
                case 38: goto L_0x0987;
                case 39: goto L_0x085c;
                case 40: goto L_0x0987;
                case 41: goto L_0x0a90;
                case 42: goto L_0x083b;
                case 43: goto L_0x0aa9;
                case 44: goto L_0x0822;
                case 45: goto L_0x0809;
                case 46: goto L_0x0b15;
                case 47: goto L_0x07e8;
                case 48: goto L_0x0b2d;
                case 49: goto L_0x0b2d;
                case 50: goto L_0x07d2;
                case 51: goto L_0x09be;
                case 52: goto L_0x07bc;
                case 53: goto L_0x07ab;
                case 54: goto L_0x0aa9;
                case 55: goto L_0x0b2d;
                case 56: goto L_0x0aa9;
                case 57: goto L_0x09be;
                case 58: goto L_0x0795;
                case 59: goto L_0x077c;
                case 60: goto L_0x0a90;
                case 61: goto L_0x0aa9;
                case 62: goto L_0x0763;
                case 63: goto L_0x0757;
                case 64: goto L_0x0746;
                case 65: goto L_0x09be;
                case 66: goto L_0x0725;
                case 67: goto L_0x09a8;
                case 68: goto L_0x070c;
                case 69: goto L_0x0757;
                case 70: goto L_0x0b2d;
                case 71: goto L_0x06ee;
                case 72: goto L_0x06cd;
                case 73: goto L_0x06b7;
                case 74: goto L_0x069e;
                case 75: goto L_0x0685;
                case 76: goto L_0x0664;
                case 77: goto L_0x0653;
                case 78: goto L_0x0757;
                case 79: goto L_0x063a;
                case 80: goto L_0x0619;
                case 81: goto L_0x0757;
                case 82: goto L_0x0b15;
                case 83: goto L_0x0aa9;
                case 84: goto L_0x0aa9;
                case 85: goto L_0x0600;
                case 86: goto L_0x05e7;
                case 87: goto L_0x05ce;
                case 88: goto L_0x0b15;
                case 89: goto L_0x05b5;
                case 90: goto L_0x059c;
                case 91: goto L_0x0583;
                case 92: goto L_0x056a;
                case 93: goto L_0x070c;
                default: goto L_0x0552;
            }
        L_0x0552:
            android.widget.TextView r1 = r10.f46484m
            java.lang.String r3 = "--"
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x056a:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132022228(0x7f1413d4, float:1.968287E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0583:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020182(0x7f140bd6, float:1.967872E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x059c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132025237(0x7f141f95, float:1.9688973E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x05b5:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020216(0x7f140bf8, float:1.9678789E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x05ce:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020210(0x7f140bf2, float:1.9678777E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x05e7:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132022229(0x7f1413d5, float:1.9682872E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0600:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132018399(0x7f1404df, float:1.9675104E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0619:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025238(0x7f141f96, float:1.9688975E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x063a:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020411(0x7f140cbb, float:1.9679184E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0653:
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0664:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132020211(0x7f140bf3, float:1.9678779E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0685:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020131(0x7f140ba3, float:1.9678616E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x069e:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132019697(0x7f1409f1, float:1.9677736E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x06b7:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r9)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x06cd:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132020227(0x7f140c03, float:1.9678811E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x06ee:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            java.lang.String r3 = r3.getString(r5)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x070c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132023240(0x7f1417c8, float:1.9684922E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0725:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025234(0x7f141f92, float:1.9688967E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0746:
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0757:
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0763:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020186(0x7f140bda, float:1.9678728E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x077c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132021836(0x7f14124c, float:1.9682075E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0795:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r4)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x07ab:
            android.widget.TextView r1 = r10.f46481j
            r1.setText(r8)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r6)
            goto L_0x0b99
        L_0x07bc:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r9)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x07d2:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x07e8:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025235(0x7f141f93, float:1.9688969E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0809:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132023246(0x7f1417ce, float:1.9684934E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0822:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020209(0x7f140bf1, float:1.9678775E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x083b:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025263(0x7f141faf, float:1.9689025E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x085c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020206(0x7f140bee, float:1.9678769E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0875:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            java.lang.String r3 = r3.getString(r7)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0893:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132021834(0x7f14124a, float:1.968207E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x08ac:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132021837(0x7f14124d, float:1.9682077E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x08c5:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025264(0x7f141fb0, float:1.9689027E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x08e6:
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x08f2:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025260(0x7f141fac, float:1.968902E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0913:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132024051(0x7f141af3, float:1.9686567E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x092c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020207(0x7f140bef, float:1.967877E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0945:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025259(0x7f141fab, float:1.9689017E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0966:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132025239(0x7f141f97, float:1.9688977E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0987:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132018445(0x7f14050d, float:1.9675197E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x09a8:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r4)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x09be:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132018456(0x7f140518, float:1.967522E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x09df:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            java.lang.String r3 = r3.getString(r7)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x09fd:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0a13:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132019698(0x7f1409f2, float:1.9677738E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0a2c:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020157(0x7f140bbd, float:1.967867E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0a45:
            android.widget.TextView r1 = r10.f46481j
            r1.setText(r8)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r6)
            goto L_0x0b99
        L_0x0a56:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132020203(0x7f140beb, float:1.9678763E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0a77:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132024022(0x7f141ad6, float:1.9686508E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0a90:
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132018423(0x7f1404f7, float:1.9675152E38)
            r1.setText(r3)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0aa9:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132023239(0x7f1417c7, float:1.968492E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0ac2:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020405(0x7f140cb5, float:1.9679172E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0adb:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            r4 = 2132020117(0x7f140b95, float:1.9678588E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0afc:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132025262(0x7f141fae, float:1.9689023E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b15:
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132018422(0x7f1404f6, float:1.967515E38)
            r1.setText(r3)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b2d:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132025312(0x7f141fe0, float:1.9689125E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b45:
            android.widget.TextView r1 = r10.f46484m
            r1.setText(r9)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b5a:
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b65:
            android.widget.TextView r1 = r10.f46484m
            r3 = 2132020096(0x7f140b80, float:1.9678545E38)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            goto L_0x0b99
        L_0x0b7d:
            android.widget.TextView r1 = r10.f46484m
            android.content.res.Resources r3 = r10.getResources()
            java.lang.String r3 = r3.getString(r5)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f46484m
            r1.setVisibility(r6)
            android.widget.RelativeLayout r1 = r10.f46486o
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r10.f46487p
            r1.setVisibility(r2)
        L_0x0b99:
            java.lang.String r1 = r11.getType()
            java.lang.String r2 = r11.getDirection()
            com.hbg.lib.data.symbol.TradeType r3 = r11.getTradeType()
            java.lang.String r1 = al.x.a(r1, r2, r3, r10)
            android.widget.TextView r2 = r10.f46474c
            r2.setText(r1)
            r2 = 2132024004(0x7f141ac4, float:1.9686472E38)
            java.lang.String r2 = r10.getString(r2)
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0bbe
            java.lang.String r1 = ""
            goto L_0x0be0
        L_0x0bbe:
            java.lang.String r1 = r11.getDirection()
            java.lang.String r2 = "out"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0bd3
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.data.symbol.TradeType r2 = r11.getTradeType()
            if (r1 != r2) goto L_0x0bdb
            goto L_0x0bde
        L_0x0bd3:
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.data.symbol.TradeType r2 = r11.getTradeType()
            if (r1 != r2) goto L_0x0bde
        L_0x0bdb:
            java.lang.String r1 = "+"
            goto L_0x0be0
        L_0x0bde:
            java.lang.String r1 = "-"
        L_0x0be0:
            com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout r2 = r10.f46473b
            com.huobi.finance.ui.k4 r3 = new com.huobi.finance.ui.k4
            r3.<init>(r10, r11, r1, r0)
            r2.post(r3)
        L_0x0bea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.CurrencyDetailOrderActivity.Qg(com.huobi.finance.bean.FinanceRecordItem):void");
    }

    public void Y9(FinanceRecordItem financeRecordItem) {
        if (financeRecordItem != null) {
            this.f46493v = financeRecordItem.getTransactionId();
            this.f46483l.setText(DateTimeUtils.h(financeRecordItem.getUpdatedAt(), "HH:mm:ss MM/dd/yyyy "));
            this.f46484m.setVisibility(8);
            Qg(financeRecordItem);
            this.f46485n.setVisibility(8);
            Pg(financeRecordItem);
            this.f46476e.setText(financeRecordItem.getToAddress());
            this.f46482k.setText(financeRecordItem.getTxHash());
            this.f46488q.setVisibility(!TextUtils.isEmpty(financeRecordItem.getTxHash()) ? 0 : 8);
            String m11 = m.m(financeRecordItem.getFees(), 8);
            TextView textView = this.f46478g;
            textView.setText(m11 + " " + k.C().z(financeRecordItem.getCurrency()));
            if (TextUtils.isEmpty(financeRecordItem.getToAddrTag())) {
                this.f46489r.setVisibility(8);
                return;
            }
            this.f46489r.setVisibility(0);
            this.f46479h.setText(financeRecordItem.getToAddrTag());
        }
    }

    public void addEvent() {
        this.f46488q.setOnClickListener(new a());
        this.f46485n.setOnClickListener(new h4(this));
    }

    public void e8(boolean z11, String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f46476e.getLayoutParams();
        if (z11) {
            this.f46475d.setText(str);
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.dimen_11);
            this.f46475d.setVisibility(0);
        } else {
            this.f46475d.setVisibility(8);
            layoutParams.topMargin = 0;
        }
        this.f46476e.setLayoutParams(layoutParams);
    }

    public int getContentView() {
        return R.layout.activity_currency_order_detail;
    }

    public void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        this.f46473b = collapsingToolbarLayout;
        collapsingToolbarLayout.setDrawCollapsingMiddleTitle(false);
        this.f46474c = (TextView) this.viewFinder.b(R.id.currency_order_type);
        this.f46475d = (TextView) this.viewFinder.b(R.id.currency_order_address_name);
        this.f46476e = (TextView) this.viewFinder.b(R.id.currency_order_digital_address);
        this.f46477f = (TextView) this.viewFinder.b(R.id.currency_order_status);
        this.f46480i = (TextView) this.viewFinder.b(R.id.currency_order_status_message);
        this.f46478g = (TextView) this.viewFinder.b(R.id.currency_order_fee);
        this.f46482k = (TextView) this.viewFinder.b(R.id.currency_order_txid);
        this.f46483l = (TextView) this.viewFinder.b(R.id.currency_order_date);
        this.f46485n = (Button) this.viewFinder.b(R.id.currency_order_cancel);
        this.f46492u = (Button) this.viewFinder.b(R.id.currency_goto_verify);
        this.f46481j = (TextView) this.viewFinder.b(R.id.currency_order_address_title_name);
        this.f46486o = (RelativeLayout) this.viewFinder.b(R.id.currency_order_address_layout);
        this.f46487p = (RelativeLayout) this.viewFinder.b(R.id.currency_order_fee_layout);
        this.f46488q = (RelativeLayout) this.viewFinder.b(R.id.currency_order_txid_layout);
        this.f46484m = (TextView) this.viewFinder.b(R.id.currency_transfer_indicator);
        this.f46490s = (Toolbar) this.viewFinder.b(R.id.currency_order_detail_toolbar);
        this.f46489r = (RelativeLayout) this.viewFinder.b(R.id.currency_order_tag_layout);
        this.f46479h = (TextView) this.viewFinder.b(R.id.currency_order_tag);
        this.f46490s.setTitle((CharSequence) getResources().getString(R.string.currency_order_detail));
        setToolBar(this.f46490s, "", true);
        this.f46491t = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
    }

    /* renamed from: oh */
    public CurrencyOrderDetailPresenter createPresenter() {
        return new CurrencyOrderDetailPresenter();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 4096 && intent != null) {
            this.f46475d.setText(intent.getStringExtra("virtual_address_ino"));
        }
    }

    /* renamed from: ph */
    public CurrencyOrderDetailPresenter.b getUI() {
        return this;
    }
}
