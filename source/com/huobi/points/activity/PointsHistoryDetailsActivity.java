package com.huobi.points.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.presenter.PointsHistoryDetailsPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.j;
import pro.huobi.R;

public class PointsHistoryDetailsActivity extends BaseActivity<PointsHistoryDetailsPresenter, PointsHistoryDetailsPresenter.a> implements PointsHistoryDetailsPresenter.a {
    public LinearLayout A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public View F;
    public TextView G;

    /* renamed from: b  reason: collision with root package name */
    public TextView f80390b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80391c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f80392d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80393e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80394f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f80395g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80396h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f80397i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f80398j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f80399k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f80400l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f80401m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f80402n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f80403o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f80404p;

    /* renamed from: q  reason: collision with root package name */
    public LinearLayout f80405q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f80406r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f80407s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f80408t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f80409u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f80410v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f80411w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f80412x;

    /* renamed from: y  reason: collision with root package name */
    public LinearLayout f80413y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f80414z;

    public static void fg(Context context, PointsAction pointsAction) {
        Intent intent = new Intent(context, PointsHistoryDetailsActivity.class);
        intent.putExtra("points_pack", pointsAction);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Yf */
    public PointsHistoryDetailsPresenter createPresenter() {
        return new PointsHistoryDetailsPresenter();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0773, code lost:
        if (com.huobi.points.entity.PointsAction.TYPE_TRANSFER_IN.equals(r19.getType()) == false) goto L_0x077d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0775, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_he_cancel);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x077d, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_canceled);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0785, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_finished);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0795, code lost:
        if (com.huobi.points.entity.PointsAction.TYPE_TRANSFER_IN.equals(r19.getType()) == false) goto L_0x079f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0797, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_i_rejecct);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x079f, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_reject);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x07a7, code lost:
        r3 = r19.getType();
        r4 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x07b2, code lost:
        if (r4 == -2144670100) goto L_0x07cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x07b7, code lost:
        if (r4 == -2008845753) goto L_0x07c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x07bc, code lost:
        if (r4 == 1743324417) goto L_0x07bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x07c3, code lost:
        if (r3.equals("purchase") == false) goto L_0x07d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x07c5, code lost:
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x07cb, code lost:
        if (r3.equals(com.huobi.points.entity.PointsAction.TYPE_TRANSFER_IN) == false) goto L_0x07d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x07cd, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x07d3, code lost:
        if (r3.equals(com.huobi.points.entity.PointsAction.TYPE_TRANSFER_OUT) == false) goto L_0x07d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x07d5, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x07d7, code lost:
        r7 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x07d8, code lost:
        if (r7 == 0) goto L_0x07f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x07db, code lost:
        if (r7 == 1) goto L_0x07ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x07dd, code lost:
        r0.E.setText(getString(pro.huobi.R.string.transfer_to_me_title));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x07ea, code lost:
        r0.E.setText(getString(pro.huobi.R.string.points_action_type_purchase));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x07f7, code lost:
        r0.E.setText(getString(pro.huobi.R.string.my_transfer_title));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0803, code lost:
        r0.f80391c.setText(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0808, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0277, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x037d, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0483, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0714, code lost:
        r1 = r19.getState();
        r1.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x071f, code lost:
        switch(r1.hashCode()) {
            case -1335395429: goto L_0x0743;
            case -673660814: goto L_0x0738;
            case -123173735: goto L_0x072f;
            case 348678395: goto L_0x0724;
            default: goto L_0x0722;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0722, code lost:
        r15 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x072a, code lost:
        if (r1.equals("submitted") != false) goto L_0x072d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x072d, code lost:
        r15 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0733, code lost:
        if (r1.equals("canceled") != false) goto L_0x0736;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0736, code lost:
        r15 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x073e, code lost:
        if (r1.equals(r17) != false) goto L_0x0741;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0741, code lost:
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0747, code lost:
        if (r1.equals(com.huobi.points.entity.Points.STATE_DENIED) != false) goto L_0x074a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x074a, code lost:
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x074b, code lost:
        switch(r15) {
            case 0: goto L_0x078d;
            case 1: goto L_0x0785;
            case 2: goto L_0x076b;
            case 3: goto L_0x0751;
            default: goto L_0x074e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x074e, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0759, code lost:
        if (com.huobi.points.entity.PointsAction.TYPE_TRANSFER_IN.equals(r19.getType()) == false) goto L_0x0763;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x075b, code lost:
        r16 = getString(pro.huobi.R.string.my_transfer_item_waiting_receive);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0763, code lost:
        r16 = getString(pro.huobi.R.string.points_transfer_order_status_waiting);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Z6(com.huobi.points.entity.Points r19, com.huobi.points.entity.PointsAction r20) {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = r20.getDirection()
            java.lang.String r2 = "in"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x001c
            android.content.res.Resources r1 = r18.getResources()
            r2 = 2131099897(0x7f0600f9, float:1.781216E38)
            int r1 = r1.getColor(r2)
            java.lang.String r2 = "+"
            goto L_0x0029
        L_0x001c:
            android.content.res.Resources r1 = r18.getResources()
            r2 = 2131099907(0x7f060103, float:1.781218E38)
            int r1 = r1.getColor(r2)
            java.lang.String r2 = "-"
        L_0x0029:
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>(r2)
            android.text.style.AbsoluteSizeSpan r2 = new android.text.style.AbsoluteSizeSpan
            r4 = 30
            r5 = 1
            r2.<init>(r4, r5)
            int r6 = r3.length()
            r7 = 0
            r8 = 33
            r3.setSpan(r2, r7, r6, r8)
            android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
            java.lang.String r6 = r19.getTotalPoints()
            r9 = 12
            r10 = 8
            java.lang.String r6 = i6.m.u0(r6, r9, r10)
            java.lang.String r6 = i6.m.p0(r6)
            r2.<init>(r6)
            android.text.style.AbsoluteSizeSpan r6 = new android.text.style.AbsoluteSizeSpan
            r6.<init>(r4, r5)
            int r4 = r2.length()
            r2.setSpan(r6, r7, r4, r8)
            android.text.SpannableStringBuilder r2 = r3.append(r2)
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r5)
            int r4 = r2.length()
            r2.setSpan(r3, r7, r4, r8)
            android.widget.TextView r3 = r0.C
            java.lang.String r2 = r2.toString()
            r3.setText(r2)
            android.widget.TextView r2 = r0.C
            r2.setTextColor(r1)
            android.widget.TextView r2 = r0.D
            r2.setTextColor(r1)
            r1 = 2132026054(0x7f1422c6, float:1.969063E38)
            java.lang.String r2 = r0.getString(r1)
            java.lang.String r3 = r19.getState()
            r3.hashCode()
            int r4 = r3.hashCode()
            java.lang.String r6 = "canceled"
            java.lang.String r8 = "finished"
            java.lang.String r9 = "denied"
            switch(r4) {
                case -1335395429: goto L_0x00b3;
                case -673660814: goto L_0x00aa;
                case -123173735: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            r3 = -1
            goto L_0x00bb
        L_0x00a1:
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x00a8
            goto L_0x009f
        L_0x00a8:
            r3 = 2
            goto L_0x00bb
        L_0x00aa:
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x00b1
            goto L_0x009f
        L_0x00b1:
            r3 = r5
            goto L_0x00bb
        L_0x00b3:
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L_0x00ba
            goto L_0x009f
        L_0x00ba:
            r3 = r7
        L_0x00bb:
            r4 = 2132026049(0x7f1422c1, float:1.969062E38)
            r13 = 2132026053(0x7f1422c5, float:1.9690628E38)
            switch(r3) {
                case 0: goto L_0x00d2;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c5;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            goto L_0x00d6
        L_0x00c5:
            java.lang.String r2 = r0.getString(r4)
            goto L_0x00d6
        L_0x00ca:
            r2 = 2132026050(0x7f1422c2, float:1.9690622E38)
            java.lang.String r2 = r0.getString(r2)
            goto L_0x00d6
        L_0x00d2:
            java.lang.String r2 = r0.getString(r13)
        L_0x00d6:
            android.widget.TextView r3 = r0.G
            r3.setText(r2)
            java.lang.String r2 = r20.getType()
            r2.hashCode()
            int r3 = r2.hashCode()
            java.lang.String r14 = "purchase"
            java.lang.String r11 = "transfer-out"
            java.lang.String r12 = "transfer-in"
            switch(r3) {
                case -2144670100: goto L_0x0161;
                case -2008845753: goto L_0x0158;
                case -1537147903: goto L_0x014d;
                case -1331214714: goto L_0x0142;
                case -374103039: goto L_0x0137;
                case 166516447: goto L_0x012c;
                case 507502302: goto L_0x0121;
                case 867048660: goto L_0x0116;
                case 1075992713: goto L_0x010a;
                case 1186323377: goto L_0x00fd;
                case 1743324417: goto L_0x00f2;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            r2 = -1
            goto L_0x0169
        L_0x00f2:
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x00f9
            goto L_0x00ef
        L_0x00f9:
            r2 = 10
            goto L_0x0169
        L_0x00fd:
            java.lang.String r3 = "mine-pool-pay"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0106
            goto L_0x00ef
        L_0x0106:
            r2 = 9
            goto L_0x0169
        L_0x010a:
            java.lang.String r3 = "activity-transfer-in"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0113
            goto L_0x00ef
        L_0x0113:
            r2 = r10
            goto L_0x0169
        L_0x0116:
            java.lang.String r3 = "master-point-transfer-out"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x011f
            goto L_0x00ef
        L_0x011f:
            r2 = 7
            goto L_0x0169
        L_0x0121:
            java.lang.String r3 = "fee-deduction"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x012a
            goto L_0x00ef
        L_0x012a:
            r2 = 6
            goto L_0x0169
        L_0x012c:
            java.lang.String r3 = "master-point-transfer-in"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0135
            goto L_0x00ef
        L_0x0135:
            r2 = 5
            goto L_0x0169
        L_0x0137:
            java.lang.String r3 = "super-margin-interest-deduct-repay"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0140
            goto L_0x00ef
        L_0x0140:
            r2 = 4
            goto L_0x0169
        L_0x0142:
            java.lang.String r3 = "brokerage"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x014b
            goto L_0x00ef
        L_0x014b:
            r2 = 3
            goto L_0x0169
        L_0x014d:
            java.lang.String r3 = "margin-interest-deduction"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0156
            goto L_0x00ef
        L_0x0156:
            r2 = 2
            goto L_0x0169
        L_0x0158:
            boolean r2 = r2.equals(r12)
            if (r2 != 0) goto L_0x015f
            goto L_0x00ef
        L_0x015f:
            r2 = r5
            goto L_0x0169
        L_0x0161:
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x0168
            goto L_0x00ef
        L_0x0168:
            r2 = r7
        L_0x0169:
            java.lang.String r3 = "/"
            java.lang.String r16 = ""
            r15 = 2132026031(0x7f1422af, float:1.9690583E38)
            java.lang.String r5 = "HH:mm:ss MM/dd/yyyy "
            java.lang.String r13 = " "
            switch(r2) {
                case 0: goto L_0x0610;
                case 1: goto L_0x04d1;
                case 2: goto L_0x04b2;
                case 3: goto L_0x0486;
                case 4: goto L_0x04b2;
                case 5: goto L_0x039e;
                case 6: goto L_0x0380;
                case 7: goto L_0x0298;
                case 8: goto L_0x027a;
                case 9: goto L_0x025a;
                case 10: goto L_0x017c;
                default: goto L_0x0177;
            }
        L_0x0177:
            r2 = r7
            r17 = r8
            goto L_0x0714
        L_0x017c:
            android.widget.TextView r2 = r0.f80390b
            r3 = 2132026010(0x7f14229a, float:1.969054E38)
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80392d
            r2.setVisibility(r7)
            android.widget.TextView r2 = r0.f80393e
            r17 = r8
            long r7 = r19.getUpdatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r7, r5)
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80395g
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80396h
            long r7 = r19.getId()
            java.lang.String r5 = java.lang.String.valueOf(r7)
            r2.setText(r5)
            android.widget.LinearLayout r2 = r0.f80397i
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80398j
            java.lang.String r5 = r19.getName()
            r2.setText(r5)
            android.widget.LinearLayout r2 = r0.f80399k
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80400l
            int r3 = r19.getQuantity()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.setText(r3)
            java.lang.String r2 = r19.getTotalGift()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x021c
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.String r3 = r19.getTotalGift()
            r2.<init>(r3)
            java.math.BigDecimal r3 = java.math.BigDecimal.ZERO
            int r2 = r2.compareTo(r3)
            if (r2 == 0) goto L_0x021c
            android.widget.LinearLayout r2 = r0.A
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.B
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r19.getTotalGift()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r8 = r19.getGiftCurrency()
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r5 = i6.m.m(r5, r7)
            r3.append(r5)
            java.lang.String r5 = r19.getGiftCurrency()
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r5 = r5.toUpperCase(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.setText(r3)
        L_0x021c:
            android.widget.LinearLayout r2 = r0.f80401m
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80402n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r19.getTotalAmount()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r8 = r19.getCurrency()
            java.util.Locale r10 = java.util.Locale.US
            java.lang.String r8 = r8.toLowerCase(r10)
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r5 = i6.m.m(r5, r7)
            r3.append(r5)
            r3.append(r13)
            java.lang.String r5 = r19.getCurrency()
            java.lang.String r5 = r5.toUpperCase(r10)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.setText(r3)
            goto L_0x0277
        L_0x025a:
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r3 = 2132026015(0x7f14229f, float:1.969055E38)
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80392d
            r7 = 0
            r2.setVisibility(r7)
            android.widget.TextView r2 = r0.f80393e
            long r7 = r19.getUpdatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r7, r5)
            r2.setText(r3)
        L_0x0277:
            r2 = 0
            goto L_0x0714
        L_0x027a:
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r3 = 2132026008(0x7f142298, float:1.9690536E38)
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80392d
            r7 = 0
            r2.setVisibility(r7)
            android.widget.TextView r2 = r0.f80393e
            long r7 = r19.getUpdatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r7, r5)
            r2.setText(r3)
            goto L_0x0277
        L_0x0298:
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r5 = 2132026014(0x7f14229e, float:1.9690549E38)
            r2.setText(r5)
            android.widget.TextView r2 = r0.f80394f
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.f80394f
            r7 = 2132025991(0x7f142287, float:1.9690502E38)
            r2.setText(r7)
            android.widget.LinearLayout r2 = r0.f80403o
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.f80404p
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r19.getTotalPoints()
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.c(r16)
            java.lang.String r7 = i6.m.m(r7, r8)
            r5.append(r7)
            r5.append(r13)
            java.lang.String r7 = r0.getString(r15)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2.setText(r5)
            android.widget.LinearLayout r2 = r0.f80413y
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.f80414z
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r19.getTotalAmount()
            com.hbg.lib.data.symbol.TradeType r8 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r10 = r19.getCurrency()
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r4)
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r8, r10)
            java.lang.String r7 = i6.m.m(r7, r10)
            r5.append(r7)
            r5.append(r13)
            java.lang.String r7 = r19.getCurrency()
            java.lang.String r7 = r7.toUpperCase(r4)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2.setText(r5)
            android.widget.LinearLayout r2 = r0.f80407s
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.f80408t
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r19.getPrice()
            java.lang.String r10 = r19.getCurrency()
            java.lang.String r10 = r10.toLowerCase(r4)
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.a(r8, r10)
            java.lang.String r7 = i6.m.m(r7, r8)
            java.lang.String r7 = i6.m.p0(r7)
            r5.append(r7)
            r5.append(r13)
            java.lang.String r7 = r19.getCurrency()
            java.lang.String r4 = r7.toUpperCase(r4)
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = r0.getString(r15)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80409u
            r4 = 0
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80410v
            java.lang.String r3 = r19.getAccount()
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80411w
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80412x
            java.lang.String r3 = r19.getUid()
            r2.setText(r3)
        L_0x037d:
            r2 = r4
            goto L_0x0714
        L_0x0380:
            r4 = r7
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r3 = 2132026016(0x7f1422a0, float:1.9690553E38)
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80392d
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80393e
            long r7 = r19.getUpdatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r7, r5)
            r2.setText(r3)
            goto L_0x037d
        L_0x039e:
            r4 = r7
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r5 = 2132026014(0x7f14229e, float:1.9690549E38)
            r2.setText(r5)
            android.widget.TextView r2 = r0.f80394f
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80394f
            r5 = 2132025992(0x7f142288, float:1.9690504E38)
            r2.setText(r5)
            android.widget.LinearLayout r2 = r0.f80403o
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80404p
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r19.getTotalPoints()
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.c(r16)
            java.lang.String r5 = i6.m.m(r5, r7)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = r0.getString(r15)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80413y
            r4 = 0
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80414z
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r19.getTotalAmount()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r8 = r19.getCurrency()
            java.util.Locale r10 = java.util.Locale.US
            java.lang.String r8 = r8.toLowerCase(r10)
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r5 = i6.m.m(r5, r8)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = r19.getCurrency()
            java.lang.String r5 = r5.toUpperCase(r10)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80407s
            r4 = 0
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80408t
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r19.getPrice()
            java.lang.String r8 = r19.getCurrency()
            java.lang.String r8 = r8.toLowerCase(r10)
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r5 = i6.m.m(r5, r7)
            java.lang.String r5 = i6.m.p0(r5)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = r19.getCurrency()
            java.lang.String r5 = r5.toUpperCase(r10)
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r0.getString(r15)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80409u
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80410v
            java.lang.String r4 = r19.getAccount()
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80411w
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80412x
            java.lang.String r4 = r19.getUid()
            r2.setText(r4)
        L_0x0483:
            r2 = r3
            goto L_0x0714
        L_0x0486:
            r3 = r7
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r4 = 2132026011(0x7f14229b, float:1.9690543E38)
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80392d
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80393e
            long r7 = r19.getUpdatedAt()
            java.lang.String r4 = com.hbg.lib.common.utils.DateTimeUtils.h(r7, r5)
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80411w
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80412x
            java.lang.String r4 = r19.getUid()
            r2.setText(r4)
            goto L_0x0483
        L_0x04b2:
            r3 = r7
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r4 = 2132026012(0x7f14229c, float:1.9690545E38)
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80392d
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80393e
            long r3 = r19.getUpdatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r3, r5)
            r2.setText(r3)
            goto L_0x0277
        L_0x04d1:
            r17 = r8
            android.widget.TextView r2 = r0.f80390b
            r4 = 2132026013(0x7f14229d, float:1.9690547E38)
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80403o
            r2.setVisibility(r10)
            android.widget.TextView r2 = r0.f80404p
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r19.getTotalPoints()
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.c(r16)
            java.lang.String r7 = i6.m.m(r7, r8)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r7 = r0.getString(r15)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80413y
            r2.setVisibility(r10)
            android.widget.LinearLayout r2 = r0.f80405q
            r4 = 0
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80414z
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r19.getTotalAmount()
            com.hbg.lib.data.symbol.TradeType r8 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r10 = r19.getCurrency()
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r1)
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r8, r10)
            java.lang.String r7 = i6.m.m(r7, r10)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r7 = r19.getCurrency()
            java.lang.String r7 = r7.toUpperCase(r1)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r2.setText(r4)
            android.widget.LinearLayout r2 = r0.f80407s
            r4 = 0
            r2.setVisibility(r4)
            android.widget.TextView r2 = r0.f80408t
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r19.getPrice()
            java.lang.String r10 = r19.getCurrency()
            java.lang.String r10 = r10.toLowerCase(r1)
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r8, r10)
            java.lang.String r7 = i6.m.m(r7, r10)
            java.lang.String r7 = i6.m.p0(r7)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r7 = r19.getCurrency()
            java.lang.String r7 = r7.toUpperCase(r1)
            r4.append(r7)
            r4.append(r3)
            java.lang.String r3 = r0.getString(r15)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.setText(r3)
            android.widget.LinearLayout r2 = r0.f80409u
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.f80410v
            java.lang.String r3 = r19.getAccount()
            r2.setText(r3)
            android.widget.TextView r2 = r0.f80406r
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r19.getTotalAmount()
            java.lang.String r7 = r19.getCurrency()
            java.lang.String r7 = r7.toLowerCase(r1)
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.a(r8, r7)
            java.lang.String r4 = i6.m.m(r4, r7)
            java.lang.String r4 = i6.m.p0(r4)
            r3.append(r4)
            r3.append(r13)
            java.lang.String r4 = r19.getCurrency()
            java.lang.String r1 = r4.toUpperCase(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.setText(r1)
            android.widget.LinearLayout r1 = r0.f80411w
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80412x
            java.lang.String r3 = r19.getUid()
            r1.setText(r3)
            android.widget.LinearLayout r1 = r0.f80392d
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80393e
            long r3 = r19.getCreatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r3, r5)
            r1.setText(r3)
            android.widget.TextView r1 = r0.f80396h
            long r3 = r19.getId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.setText(r3)
            android.widget.LinearLayout r1 = r0.f80395g
            r1.setVisibility(r2)
            android.view.View r1 = r0.F
            r1.setVisibility(r2)
            goto L_0x0714
        L_0x0610:
            r17 = r8
            android.widget.TextView r1 = r0.f80390b
            r2 = 2132026013(0x7f14229d, float:1.9690547E38)
            r1.setText(r2)
            android.widget.LinearLayout r1 = r0.f80403o
            r1.setVisibility(r10)
            android.widget.TextView r1 = r0.f80404p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r19.getTotalPoints()
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.c(r16)
            java.lang.String r4 = i6.m.m(r4, r7)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r4 = r0.getString(r15)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.LinearLayout r1 = r0.f80405q
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80406r
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r19.getTotalAmount()
            com.hbg.lib.data.symbol.TradeType r7 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r8 = r19.getCurrency()
            java.util.Locale r10 = java.util.Locale.US
            java.lang.String r8 = r8.toLowerCase(r10)
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r4 = i6.m.m(r4, r8)
            java.lang.String r4 = i6.m.p0(r4)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r4 = r19.getCurrency()
            java.lang.String r4 = r4.toUpperCase(r10)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.LinearLayout r1 = r0.f80407s
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80408t
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r19.getPrice()
            java.lang.String r8 = r19.getCurrency()
            java.lang.String r8 = r8.toLowerCase(r10)
            int r7 = com.hbg.lib.data.symbol.PrecisionUtil.a(r7, r8)
            java.lang.String r4 = i6.m.m(r4, r7)
            java.lang.String r4 = i6.m.p0(r4)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r4 = r19.getCurrency()
            java.lang.String r4 = r4.toUpperCase(r10)
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = r0.getString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.LinearLayout r1 = r0.f80409u
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80410v
            java.lang.String r3 = r19.getAccount()
            r1.setText(r3)
            android.widget.LinearLayout r1 = r0.f80411w
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80412x
            java.lang.String r3 = r19.getUid()
            r1.setText(r3)
            android.widget.LinearLayout r1 = r0.f80392d
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f80393e
            long r3 = r19.getCreatedAt()
            java.lang.String r3 = com.hbg.lib.common.utils.DateTimeUtils.h(r3, r5)
            r1.setText(r3)
            android.widget.TextView r1 = r0.f80396h
            long r3 = r19.getId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.setText(r3)
            android.widget.LinearLayout r1 = r0.f80395g
            r1.setVisibility(r2)
            android.view.View r1 = r0.F
            r1.setVisibility(r2)
        L_0x0714:
            java.lang.String r1 = r19.getState()
            r1.hashCode()
            int r3 = r1.hashCode()
            switch(r3) {
                case -1335395429: goto L_0x0743;
                case -673660814: goto L_0x0738;
                case -123173735: goto L_0x072f;
                case 348678395: goto L_0x0724;
                default: goto L_0x0722;
            }
        L_0x0722:
            r15 = -1
            goto L_0x074b
        L_0x0724:
            java.lang.String r3 = "submitted"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x072d
            goto L_0x0722
        L_0x072d:
            r15 = 3
            goto L_0x074b
        L_0x072f:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0736
            goto L_0x0722
        L_0x0736:
            r15 = 2
            goto L_0x074b
        L_0x0738:
            r3 = r17
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0741
            goto L_0x0722
        L_0x0741:
            r15 = 1
            goto L_0x074b
        L_0x0743:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x074a
            goto L_0x0722
        L_0x074a:
            r15 = r2
        L_0x074b:
            switch(r15) {
                case 0: goto L_0x078d;
                case 1: goto L_0x0785;
                case 2: goto L_0x076b;
                case 3: goto L_0x0751;
                default: goto L_0x074e;
            }
        L_0x074e:
            r1 = r16
            goto L_0x07a7
        L_0x0751:
            java.lang.String r1 = r19.getType()
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x0763
            r1 = 2132019682(0x7f1409e2, float:1.9677706E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x0763:
            r1 = 2132026054(0x7f1422c6, float:1.969063E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x076b:
            java.lang.String r1 = r19.getType()
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x077d
            r1 = 2132026051(0x7f1422c3, float:1.9690624E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x077d:
            r1 = 2132026049(0x7f1422c1, float:1.969062E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x0785:
            r1 = 2132026050(0x7f1422c2, float:1.9690622E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x078d:
            java.lang.String r1 = r19.getType()
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x079f
            r1 = 2132026052(0x7f1422c4, float:1.9690626E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x079f:
            r1 = 2132026053(0x7f1422c5, float:1.9690628E38)
            java.lang.String r16 = r0.getString(r1)
            goto L_0x074e
        L_0x07a7:
            java.lang.String r3 = r19.getType()
            int r4 = r3.hashCode()
            r5 = -2144670100(0xffffffff802aee6c, float:-3.94262E-39)
            if (r4 == r5) goto L_0x07cf
            r2 = -2008845753(0xffffffff88437247, float:-5.881501E-34)
            if (r4 == r2) goto L_0x07c7
            r2 = 1743324417(0x67e90501, float:2.2008074E24)
            if (r4 == r2) goto L_0x07bf
            goto L_0x07d7
        L_0x07bf:
            boolean r2 = r3.equals(r14)
            if (r2 == 0) goto L_0x07d7
            r7 = 1
            goto L_0x07d8
        L_0x07c7:
            boolean r2 = r3.equals(r12)
            if (r2 == 0) goto L_0x07d7
            r7 = 2
            goto L_0x07d8
        L_0x07cf:
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x07d7
            r7 = r2
            goto L_0x07d8
        L_0x07d7:
            r7 = -1
        L_0x07d8:
            if (r7 == 0) goto L_0x07f7
            r2 = 1
            if (r7 == r2) goto L_0x07ea
            android.widget.TextView r2 = r0.E
            r3 = 2132027291(0x7f14279b, float:1.9693139E38)
            java.lang.String r3 = r0.getString(r3)
            r2.setText(r3)
            goto L_0x0803
        L_0x07ea:
            android.widget.TextView r2 = r0.E
            r3 = 2132025954(0x7f142262, float:1.9690427E38)
            java.lang.String r3 = r0.getString(r3)
            r2.setText(r3)
            goto L_0x0803
        L_0x07f7:
            android.widget.TextView r2 = r0.E
            r3 = 2132019684(0x7f1409e4, float:1.967771E38)
            java.lang.String r3 = r0.getString(r3)
            r2.setText(r3)
        L_0x0803:
            android.widget.TextView r2 = r0.f80391c
            r2.setText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.points.activity.PointsHistoryDetailsActivity.Z6(com.huobi.points.entity.Points, com.huobi.points.entity.PointsAction):void");
    }

    /* renamed from: Zf */
    public PointsHistoryDetailsPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
    }

    public int getContentView() {
        return R.layout.activity_points_history_details;
    }

    public void initView() {
        this.viewFinder.b(R.id.id_back).setOnClickListener(new j(this));
        this.f80390b = (TextView) this.viewFinder.b(R.id.details_type_tv);
        this.f80394f = (TextView) this.viewFinder.b(R.id.details_type_tv_info);
        this.f80391c = (TextView) this.viewFinder.b(R.id.details_state_tv);
        this.f80392d = (LinearLayout) this.viewFinder.b(R.id.detail_date_ll);
        this.f80393e = (TextView) this.viewFinder.b(R.id.detail_date_tv);
        this.F = this.viewFinder.b(R.id.details_state_ll);
        this.G = (TextView) this.viewFinder.b(R.id.details_state_tv);
        this.f80395g = (LinearLayout) this.viewFinder.b(R.id.detail_points_id_ll);
        this.f80396h = (TextView) this.viewFinder.b(R.id.detail_points_id_tv);
        this.f80397i = (LinearLayout) this.viewFinder.b(R.id.detail_points_name_ll);
        this.f80398j = (TextView) this.viewFinder.b(R.id.detail_points_name_tv);
        this.f80399k = (LinearLayout) this.viewFinder.b(R.id.detail_points_buy_number_ll);
        this.f80400l = (TextView) this.viewFinder.b(R.id.detail_points_buy_number_tv);
        this.f80401m = (LinearLayout) this.viewFinder.b(R.id.detail_total_asset_ll);
        this.f80402n = (TextView) this.viewFinder.b(R.id.detail_total_asset_tv);
        this.f80403o = (LinearLayout) this.viewFinder.b(R.id.details_points_number_ll);
        this.f80404p = (TextView) this.viewFinder.b(R.id.details_points_number_tv);
        this.f80405q = (LinearLayout) this.viewFinder.b(R.id.details_my_price_ll);
        this.f80406r = (TextView) this.viewFinder.b(R.id.details_my_price_tv);
        this.f80407s = (LinearLayout) this.viewFinder.b(R.id.per_points_ll);
        this.f80408t = (TextView) this.viewFinder.b(R.id.per_points_tv);
        this.f80409u = (LinearLayout) this.viewFinder.b(R.id.other_account_ll);
        this.f80410v = (TextView) this.viewFinder.b(R.id.other_account_tv);
        this.f80411w = (LinearLayout) this.viewFinder.b(R.id.other_uid_ll);
        this.f80412x = (TextView) this.viewFinder.b(R.id.other_uid_tv);
        this.f80413y = (LinearLayout) this.viewFinder.b(R.id.details_ohter_price_ll);
        this.f80414z = (TextView) this.viewFinder.b(R.id.details_other_price_tv);
        this.C = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount);
        this.D = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount_unit);
        this.E = (TextView) this.viewFinder.b(R.id.id_points_history_details_title);
        this.A = (LinearLayout) this.viewFinder.b(R.id.detail_points_gift_ll);
        this.B = (TextView) this.viewFinder.b(R.id.detail_points_gift_tv);
    }
}
