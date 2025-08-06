package com.huobi.otc.handler;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.Ads;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import hp.e;
import hp.f;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import s9.d;
import v9.c;
import va.b;

public class AdsViewHandler implements d<Ads> {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f78695b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f78696c;

    /* renamed from: d  reason: collision with root package name */
    public View f78697d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78698e;

    @SensorsDataInstrumented
    public static /* synthetic */ void l(Ads ads, View view) {
        Activity e11 = ViewUtil.e(view);
        if (e11 != null) {
            OtcModuleConfig.b().K(e11, Long.valueOf(Long.valueOf(ads.getUid()).longValue()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void m(Ads ads, Void voidR) {
        if (ads.getListener() != null) {
            ads.getListener().d9(ads);
        }
    }

    public static /* synthetic */ void o(Ads ads, Void voidR) {
        if (ads.getListener() != null) {
            ads.getListener().qe(ads);
        }
    }

    public static /* synthetic */ void p(Ads ads, OtcTradeType otcTradeType, Void voidR) {
        if (ads.getListener() != null) {
            ads.getListener().aa(ads);
        }
        String g11 = StringUtils.g(b.g(ads.getCoinId()));
        HashMap hashMap = new HashMap(1);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, g11);
        OtcModuleConfig.a().b(!otcTradeType.isBuy() ? "5060" : "5061", hashMap);
    }

    public static /* synthetic */ void q(Ads ads, Void voidR) {
        if (ads.getListener() != null) {
            ads.getListener().q6(ads);
        }
    }

    public static /* synthetic */ void r(Ads ads, Void voidR) {
        if (!ads.isFollowed() && ads.getListener() != null) {
            ads.getListener().Ta(ads);
        }
    }

    public static /* synthetic */ void s(Ads ads, Void voidR) {
        if (ads.getListener() != null) {
            ads.getListener().l7(ads);
        }
    }

    public int getResId() {
        return R$layout.item_otc_public_ad;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0564  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x05e5  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0629  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0402  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r37, int r38, com.huobi.otc.bean.Ads r39, android.view.ViewGroup r40) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r39
            boolean r3 = r39.isShield()
            r4 = 1
            if (r3 == 0) goto L_0x0011
            r0.v(r1, r4)
            return
        L_0x0011:
            r3 = 0
            r0.v(r1, r3)
            r2.setShieldChange(r3)
            i6.r r5 = r37.e()
            android.view.View r6 = r1.itemView
            android.content.res.Resources r6 = r6.getResources()
            android.view.View r7 = r1.itemView
            android.content.Context r7 = r7.getContext()
            int r8 = r39.getCurrency()
            java.lang.String r8 = va.b.m(r8)
            int r9 = com.hbg.module.otc.R$id.privilegeMerchantNameContainer
            android.view.View r9 = r5.b(r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            int r10 = com.hbg.module.otc.R$id.privilegeMerchantName
            android.view.View r10 = r5.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.hbg.module.otc.R$id.merchantName
            android.view.View r11 = r5.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.hbg.module.otc.R$id.merchantLevel
            android.view.View r12 = r5.b(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            int r13 = com.hbg.module.otc.R$id.merchantThumbUp
            android.view.View r13 = r5.b(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            int r14 = com.hbg.module.otc.R$id.merchantDealNum
            android.view.View r14 = r5.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.hbg.module.otc.R$id.merchantDealRatio
            android.view.View r15 = r5.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r4 = com.hbg.module.otc.R$id.coinNumTitle
            android.view.View r4 = r5.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r3 = com.hbg.module.otc.R$id.coinNum
            android.view.View r3 = r5.b(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r1 = com.hbg.module.otc.R$id.coinUnit
            android.view.View r1 = r5.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = com.hbg.module.otc.R$id.limitTitle
            android.view.View r2 = r5.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r16 = r9
            int r9 = com.hbg.module.otc.R$id.rationedExchangeVol
            android.view.View r9 = r5.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r17 = r2
            int r2 = com.hbg.module.otc.R$id.unitPriceValue
            android.view.View r2 = r5.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r18 = r4
            int r4 = com.hbg.module.otc.R$id.unit_currency_symbol_tv
            android.view.View r4 = r5.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r19 = r9
            int r9 = com.hbg.module.otc.R$id.id_trust_iv
            android.view.View r9 = r5.b(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r20 = r8
            int r8 = com.hbg.module.otc.R$id.view_circle
            android.view.View r8 = r5.b(r8)
            boolean r21 = r39.isOnline()
            if (r21 == 0) goto L_0x00c1
            int r21 = com.hbg.module.otc.R$drawable.shape_ad_header_circle_bg
            goto L_0x00c3
        L_0x00c1:
            int r21 = com.hbg.module.otc.R$drawable.shape_ad_header_circle_off_bg
        L_0x00c3:
            r22 = r1
            r1 = r21
            r8.setBackgroundResource(r1)
            int r1 = com.hbg.module.otc.R$id.support_pay_container
            android.view.View r1 = r5.b(r1)
            com.huobi.otc.widget.PaymentGroupView r1 = (com.huobi.otc.widget.PaymentGroupView) r1
            r21 = r8
            int r8 = com.hbg.module.otc.R$id.id_trade
            android.view.View r8 = r5.b(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r23 = r3
            int r3 = com.hbg.module.otc.R$id.otc_item_more_iv
            android.view.View r3 = r5.b(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r24 = r3
            int r3 = com.hbg.module.otc.R$id.sea_view_flag
            android.view.View r3 = r5.b(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r25 = r3
            int r3 = com.hbg.module.otc.R$id.buy_or_sell_btn
            android.view.View r3 = r5.b(r3)
            com.hbg.lib.widgets.AutoSizeMinMaxTextView r3 = (com.hbg.lib.widgets.AutoSizeMinMaxTextView) r3
            r26 = r15
            android.content.res.Resources r15 = r3.getResources()
            r27 = r14
            int r14 = com.hbg.module.otc.R$dimen.global_text_size_14
            int r14 = r15.getDimensionPixelSize(r14)
            float r14 = (float) r14
            r15 = 0
            r3.setTextSize(r15, r14)
            int r14 = com.hbg.module.otc.R$id.id_receive_order_flag_tv
            android.view.View r14 = r5.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.hbg.module.otc.R$id.ll_time
            android.view.View r15 = r5.b(r15)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            r28 = r14
            int r14 = com.hbg.module.otc.R$id.id_time_tv
            android.view.View r14 = r5.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r29 = r15
            int r15 = com.hbg.module.otc.R$id.ll_verify_capital
            android.view.View r15 = r5.b(r15)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            r0.f78695b = r15
            int r15 = com.hbg.module.otc.R$id.id_verify_capital_title
            android.view.View r15 = r5.b(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r0.f78696c = r15
            int r15 = com.hbg.module.otc.R$id.id_verify_capital_underline
            android.view.View r15 = r5.b(r15)
            r0.f78697d = r15
            android.widget.LinearLayout r15 = r0.f78695b
            boolean r30 = r39.isVerifyCapitalEnabled()
            r31 = r3
            if (r30 == 0) goto L_0x015a
            int r3 = r39.getVerifyCapitalStatus()
            r32 = r6
            r6 = 2
            if (r3 == r6) goto L_0x015c
            r3 = 0
            goto L_0x015e
        L_0x015a:
            r32 = r6
        L_0x015c:
            r3 = 8
        L_0x015e:
            r15.setVisibility(r3)
            android.view.View r3 = r0.f78697d
            int r6 = r39.getVerifyCapitalStatus()
            r15 = 1
            if (r6 != r15) goto L_0x016c
            r6 = 0
            goto L_0x016e
        L_0x016c:
            r6 = 8
        L_0x016e:
            r3.setVisibility(r6)
            android.content.res.Resources r3 = r7.getResources()
            int r6 = com.hbg.module.otc.R$string.n_otc_advert_verify_capital_title
            java.lang.String r3 = r3.getString(r6)
            android.content.res.Resources r6 = r7.getResources()
            int r15 = com.hbg.module.otc.R$string.n_otc_advert_no_verify_capital_title
            java.lang.String r6 = r6.getString(r15)
            android.widget.TextView r15 = r0.f78696c
            r33 = r3
            int r3 = r39.getVerifyCapitalStatus()
            r34 = r6
            java.lang.String r6 = ""
            r35 = r1
            r1 = 1
            if (r3 != r1) goto L_0x0199
            r3 = r33
            goto L_0x01a3
        L_0x0199:
            int r1 = r39.getVerifyCapitalStatus()
            if (r1 != 0) goto L_0x01a2
            r3 = r34
            goto L_0x01a3
        L_0x01a2:
            r3 = r6
        L_0x01a3:
            r15.setText(r3)
            int r1 = com.hbg.module.otc.R$id.otc_advert_label
            android.view.View r1 = r5.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.f78698e = r1
            java.lang.String r1 = r39.getLabelName()
            int r3 = com.hbg.module.otc.R$id.otc_advert_label_container_bg
            android.view.View r3 = r5.b(r3)
            if (r1 == 0) goto L_0x01d3
            boolean r15 = r1.isEmpty()
            if (r15 != 0) goto L_0x01d3
            android.widget.TextView r6 = r0.f78698e
            r6.setText(r1)
            android.widget.TextView r1 = r0.f78698e
            r15 = 0
            r1.setVisibility(r15)
            int r1 = com.hbg.module.otc.R$drawable.otc_advert_label_container_bg
            r3.setBackgroundResource(r1)
            goto L_0x01e3
        L_0x01d3:
            r15 = 0
            android.widget.TextView r1 = r0.f78698e
            r1.setText(r6)
            android.widget.TextView r1 = r0.f78698e
            r6 = 8
            r1.setVisibility(r6)
            r3.setBackgroundResource(r15)
        L_0x01e3:
            android.content.res.Resources r1 = r14.getResources()
            int r3 = com.hbg.module.otc.R$string.n_otc_trade_limit_time
            java.lang.String r1 = r1.getString(r3)
            r3 = 1
            java.lang.CharSequence[] r6 = new java.lang.CharSequence[r3]
            int r3 = r39.getPayTerm()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r6[r15] = r3
            java.lang.String r1 = com.hbg.lib.common.utils.StringUtils.d(r1, r6)
            r14.setText(r1)
            java.lang.String r1 = r39.getUserName()
            r11.setText(r1)
            java.lang.String r1 = r39.getUserName()
            r10.setText(r1)
            android.content.res.Resources r1 = r2.getResources()
            int r3 = com.hbg.module.otc.R$color.baseColorPrimaryText
            int r1 = r1.getColor(r3)
            r4.setTextColor(r1)
            boolean r1 = r39.isBlueShieldMerchant()
            if (r1 == 0) goto L_0x0224
            r1 = 0
            goto L_0x0226
        L_0x0224:
            r1 = 8
        L_0x0226:
            r9.setVisibility(r1)
            android.content.res.Resources r1 = r7.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            java.util.Locale r1 = r1.locale
            java.lang.String r6 = r1.getLanguage()
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r14 = "zh"
            boolean r6 = r6.endsWith(r14)
            java.lang.String r15 = "hk"
            if (r6 == 0) goto L_0x0256
            java.lang.String r6 = r1.getCountry()
            java.lang.String r6 = r6.toLowerCase()
            boolean r6 = r6.endsWith(r15)
            if (r6 == 0) goto L_0x0256
            int r6 = com.hbg.module.otc.R$drawable.otc_trust_tw_icon
            goto L_0x0261
        L_0x0256:
            boolean r6 = com.hbg.lib.core.util.p.h(r7)
            if (r6 == 0) goto L_0x025f
            int r6 = com.hbg.module.otc.R$drawable.otc_trust_zh_icon
            goto L_0x0261
        L_0x025f:
            int r6 = com.hbg.module.otc.R$drawable.otc_trust_en_icon
        L_0x0261:
            r9.setImageResource(r6)
            int r6 = r39.getMerchantLevel()
            r9 = 1
            if (r6 != r9) goto L_0x026d
        L_0x026b:
            r6 = 0
            goto L_0x0280
        L_0x026d:
            int r6 = r39.getMerchantLevel()
            r9 = 2
            if (r6 != r9) goto L_0x0277
            int r6 = com.hbg.module.otc.R$drawable.otc_market_v_icon
            goto L_0x0280
        L_0x0277:
            int r6 = r39.getMerchantLevel()
            r9 = 3
            if (r6 != r9) goto L_0x026b
            int r6 = com.hbg.module.otc.R$drawable.otc_market_crown_icon
        L_0x0280:
            r12.setImageResource(r6)
            int r6 = r39.getThumbUp()
            r9 = 1
            if (r6 != r9) goto L_0x028f
            r6 = 0
            r13.setVisibility(r6)
            goto L_0x0294
        L_0x028f:
            r6 = 8
            r13.setVisibility(r6)
        L_0x0294:
            java.lang.String r6 = r1.getLanguage()
            java.lang.String r6 = r6.toLowerCase()
            boolean r6 = r6.endsWith(r14)
            if (r6 == 0) goto L_0x02b3
            java.lang.String r1 = r1.getCountry()
            java.lang.String r1 = r1.toLowerCase()
            boolean r1 = r1.endsWith(r15)
            if (r1 == 0) goto L_0x02b3
            int r1 = com.hbg.module.otc.R$drawable.label_traded_zh_hk
            goto L_0x02be
        L_0x02b3:
            boolean r1 = com.hbg.lib.core.util.p.h(r7)
            if (r1 == 0) goto L_0x02bc
            int r1 = com.hbg.module.otc.R$drawable.label_traded_zh_cn
            goto L_0x02be
        L_0x02bc:
            int r1 = com.hbg.module.otc.R$drawable.label_traded_en
        L_0x02be:
            r8.setImageResource(r1)
            boolean r1 = r39.isTrade()
            if (r1 == 0) goto L_0x02c9
            r1 = 0
            goto L_0x02cb
        L_0x02c9:
            r1 = 8
        L_0x02cb:
            r8.setVisibility(r1)
            java.util.List r1 = r39.getPayMethods()
            r6 = r35
            r6.setPaymentInfos(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r6 = com.hbg.module.otc.R$string.n_otc_ads_order_number
            r8 = r32
            java.lang.String r6 = r8.getString(r6)
            r1.append(r6)
            int r6 = r39.getTotalTradeOrderCount()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r14 = r27
            r14.setText(r1)
            r1 = 1
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r1 = r39.getOrderCompleteRate()
            r9 = 0
            r6[r9] = r1
            java.lang.String r1 = "%s%%"
            java.lang.String r1 = java.lang.String.format(r1, r6)
            r15 = r26
            r15.setText(r1)
            java.lang.String r1 = r39.getTradeCount()
            r6 = r23
            r6.setText(r1)
            int r1 = r39.getCoinId()
            java.lang.String r1 = va.b.g(r1)
            r9 = r22
            r9.setText(r1)
            uf.a r1 = com.hbg.module.otc.OtcModuleConfig.a()
            java.lang.String r12 = r39.getMinTradeLimit()
            java.lang.String r13 = r39.getMinTradeLimit()
            int r13 = i6.m.U(r13)
            java.lang.String r1 = r1.v(r12, r13)
            uf.a r12 = com.hbg.module.otc.OtcModuleConfig.a()
            java.lang.String r13 = r39.getMaxTradeLimit()
            java.lang.String r22 = r39.getMaxTradeLimit()
            int r0 = i6.m.U(r22)
            java.lang.String r0 = r12.v(r13, r0)
            int r12 = com.hbg.module.otc.R$string.otc_limit_range
            r22 = r5
            r13 = 2
            java.lang.Object[] r5 = new java.lang.Object[r13]
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r23 = r9
            r9 = r20
            r13.append(r9)
            boolean r20 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r26 = "--"
            if (r20 == 0) goto L_0x036b
            r1 = r26
        L_0x036b:
            r13.append(r1)
            java.lang.String r1 = r13.toString()
            r13 = 0
            r5[r13] = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            boolean r13 = android.text.TextUtils.isEmpty(r0)
            if (r13 == 0) goto L_0x0385
            r0 = r26
        L_0x0385:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            r5[r1] = r0
            java.lang.String r0 = r8.getString(r12, r5)
            r1 = r19
            r1.setText(r0)
            r4.setText(r9)
            uf.a r0 = com.hbg.module.otc.OtcModuleConfig.a()
            java.lang.String r5 = r39.getPrice()
            java.lang.String r9 = r39.getPrice()
            int r9 = i6.m.U(r9)
            java.lang.String r0 = r0.v(r5, r9)
            r2.setText(r0)
            android.content.res.Resources r0 = r2.getResources()
            int r0 = r0.getColor(r3)
            r2.setTextColor(r0)
            com.hbg.bean.OtcTradeType r0 = r39.getTradeType()
            boolean r5 = r7 instanceof com.huobi.otc.ui.OtcTradeActivity
            if (r5 == 0) goto L_0x03c8
            com.huobi.otc.ui.OtcTradeActivity r7 = (com.huobi.otc.ui.OtcTradeActivity) r7
            goto L_0x03da
        L_0x03c8:
            oa.a r5 = oa.a.g()
            java.lang.Class<com.huobi.otc.ui.OtcTradeActivity> r7 = com.huobi.otc.ui.OtcTradeActivity.class
            android.app.Activity r5 = r5.f(r7)
            if (r5 == 0) goto L_0x03da
            boolean r7 = r5 instanceof com.huobi.otc.ui.OtcTradeActivity
            if (r7 == 0) goto L_0x03da
            com.huobi.otc.ui.OtcTradeActivity r5 = (com.huobi.otc.ui.OtcTradeActivity) r5
        L_0x03da:
            boolean r5 = r39.isNeedKyc()
            r7 = 0
            if (r5 == 0) goto L_0x0402
            android.content.res.Resources r5 = r31.getResources()
            int r8 = com.hbg.module.otc.R$string.n_otc_advert_btn_kyc
            java.lang.String r5 = r5.getString(r8)
            r9 = r31
            r9.setText(r5)
            android.content.res.Resources r5 = r9.getResources()
            int r8 = com.hbg.module.otc.R$color.baseColorMajorTheme100
            int r5 = r5.getColor(r8)
            r9.setTextColor(r5)
            r9.setBackground(r7)
            goto L_0x0474
        L_0x0402:
            r9 = r31
            boolean r5 = r39.isNeedBindPhoneNum()
            if (r5 == 0) goto L_0x0420
            int r5 = com.hbg.module.otc.R$string.n_otc_advert_btn_bind_phone
            r9.setText(r5)
            android.content.res.Resources r5 = r9.getResources()
            int r8 = com.hbg.module.otc.R$color.baseColorMajorTheme100
            int r5 = r5.getColor(r8)
            r9.setTextColor(r5)
            r9.setBackground(r7)
            goto L_0x0474
        L_0x0420:
            boolean r5 = r39.isTradeLimit()
            if (r5 != 0) goto L_0x045f
            boolean r5 = r39.isNeedAdvancedKyc()
            if (r5 == 0) goto L_0x042d
            goto L_0x045f
        L_0x042d:
            android.content.res.Resources r5 = r9.getResources()
            int r7 = com.hbg.module.otc.R$color.white
            int r5 = r5.getColor(r7)
            r9.setTextColor(r5)
            boolean r5 = r0.isBuy()
            if (r5 != 0) goto L_0x0447
            int r5 = com.hbg.module.otc.R$string.n_otc_buy
            java.lang.String r5 = r8.getString(r5)
            goto L_0x044d
        L_0x0447:
            int r5 = com.hbg.module.otc.R$string.n_otc_sell
            java.lang.String r5 = r8.getString(r5)
        L_0x044d:
            r9.setText(r5)
            boolean r5 = r0.isSell()
            if (r5 == 0) goto L_0x0459
            int r5 = com.hbg.module.otc.R$drawable.btn_otc_merchant_ads_buy_new_header_bg
            goto L_0x045b
        L_0x0459:
            int r5 = com.hbg.module.otc.R$drawable.btn_otc_merchant_ads_sell_new_header_bg
        L_0x045b:
            r9.setBackgroundResource(r5)
            goto L_0x0474
        L_0x045f:
            int r5 = com.hbg.module.otc.R$string.n_otc_taker_limit_new
            r9.setText(r5)
            android.content.res.Resources r5 = r9.getResources()
            int r8 = com.hbg.module.otc.R$color.baseColorSecondaryTextNew
            int r5 = r5.getColor(r8)
            r9.setTextColor(r5)
            r9.setBackground(r7)
        L_0x0474:
            java.lang.String r5 = "#373228"
            int r5 = android.graphics.Color.parseColor(r5)
            r10.setTextColor(r5)
            android.content.res.Resources r5 = r11.getResources()
            int r5 = r5.getColor(r3)
            r11.setTextColor(r5)
            android.content.res.Resources r5 = r14.getResources()
            int r7 = com.hbg.module.otc.R$color.baseColorSecondaryTextNew
            int r5 = r5.getColor(r7)
            r14.setTextColor(r5)
            android.content.res.Resources r5 = r15.getResources()
            int r5 = r5.getColor(r7)
            r15.setTextColor(r5)
            android.content.res.Resources r5 = r4.getResources()
            int r5 = r5.getColor(r3)
            r4.setTextColor(r5)
            android.content.res.Resources r4 = r2.getResources()
            int r4 = r4.getColor(r3)
            r2.setTextColor(r4)
            android.content.res.Resources r2 = r18.getResources()
            int r4 = com.hbg.module.otc.R$color.baseColorSecondaryText
            int r2 = r2.getColor(r4)
            r5 = r18
            r5.setTextColor(r2)
            android.content.res.Resources r2 = r6.getResources()
            int r2 = r2.getColor(r3)
            r6.setTextColor(r2)
            android.content.res.Resources r2 = r23.getResources()
            int r2 = r2.getColor(r3)
            r5 = r23
            r5.setTextColor(r2)
            android.content.res.Resources r2 = r17.getResources()
            int r2 = r2.getColor(r4)
            r4 = r17
            r4.setTextColor(r2)
            android.content.res.Resources r2 = r1.getResources()
            int r2 = r2.getColor(r3)
            r1.setTextColor(r2)
            boolean r1 = r39.isChargeType()
            if (r1 == 0) goto L_0x0564
            r1 = r16
            r2 = 0
            r1.setVisibility(r2)
            r3 = 8
            r11.setVisibility(r3)
            android.graphics.drawable.Drawable r3 = r1.getBackground()
            if (r3 != 0) goto L_0x056f
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r4 = 1082130432(0x40800000, float:4.0)
            int r4 = com.hbg.lib.common.utils.PixelUtils.a(r4)
            float r4 = (float) r4
            r3.setCornerRadius(r4)
            r3.setGradientType(r2)
            android.graphics.drawable.GradientDrawable$Orientation r4 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r3.setOrientation(r4)
            r4 = 5
            int[] r5 = new int[r4]
            java.lang.String r6 = "#FFE786"
            int r6 = android.graphics.Color.parseColor(r6)
            r5[r2] = r6
            java.lang.String r2 = "#FFEABD"
            int r2 = android.graphics.Color.parseColor(r2)
            r6 = 1
            r5[r6] = r2
            java.lang.String r2 = "#FFF7D1"
            int r2 = android.graphics.Color.parseColor(r2)
            r6 = 2
            r5[r6] = r2
            java.lang.String r2 = "#FFE6B8"
            int r2 = android.graphics.Color.parseColor(r2)
            r6 = 3
            r5[r6] = r2
            r2 = 4
            java.lang.String r6 = "#F8CE80"
            int r6 = android.graphics.Color.parseColor(r6)
            r5[r2] = r6
            float[] r2 = new float[r4]
            r2 = {0, 1053008540, 1058194378, 1060512989, 1062616852} // fill-array
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r4 < r6) goto L_0x0560
            r3.setColors(r5, r2)
        L_0x0560:
            r1.setBackground(r3)
            goto L_0x056f
        L_0x0564:
            r1 = r16
            r2 = 8
            r1.setVisibility(r2)
            r1 = 0
            r11.setVisibility(r1)
        L_0x056f:
            int r1 = com.hbg.module.otc.R$id.maker_ads_title_ll
            r2 = r22
            android.view.View r1 = r2.b(r1)
            hp.b r3 = new hp.b
            r4 = r39
            r3.<init>(r4)
            r1.setOnClickListener(r3)
            rx.Observable r1 = dw.a.a(r29)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r5 = 500(0x1f4, double:2.47E-321)
            rx.Observable r1 = r1.throttleFirst(r5, r3)
            hp.d r7 = new hp.d
            r7.<init>(r4)
            r1.subscribe(r7)
            rx.Observable r1 = dw.a.a(r9)
            rx.Observable r1 = r1.throttleFirst(r5, r3)
            hp.i r7 = new hp.i
            r8 = r37
            r7.<init>(r8)
            r1.subscribe(r7)
            rx.Observable r1 = dw.a.a(r24)
            rx.Observable r1 = r1.throttleFirst(r5, r3)
            hp.g r7 = new hp.g
            r7.<init>(r4)
            r1.subscribe(r7)
            android.view.View r1 = r8.itemView
            rx.Observable r1 = dw.a.a(r1)
            rx.Observable r1 = r1.throttleFirst(r5, r3)
            hp.h r7 = new hp.h
            r7.<init>(r4, r0)
            r1.subscribe(r7)
            r0 = r36
            android.widget.LinearLayout r1 = r0.f78695b
            rx.Observable r1 = dw.a.a(r1)
            rx.Observable r1 = r1.throttleFirst(r5, r3)
            hp.c r3 = new hp.c
            r3.<init>(r4)
            r1.subscribe(r3)
            boolean r1 = r39.isAcceptOrder()
            r14 = r28
            if (r1 == 0) goto L_0x05e7
            r15 = 0
            goto L_0x05e9
        L_0x05e7:
            r15 = 8
        L_0x05e9:
            r14.setVisibility(r15)
            if (r1 == 0) goto L_0x05f3
            int r1 = com.hbg.module.otc.R$drawable.shape_otc_dialog_bg
            r14.setBackgroundResource(r1)
        L_0x05f3:
            int r1 = r39.getSeaViewRoomPosition()
            r3 = 1
            if (r1 != r3) goto L_0x05fd
            int r15 = com.hbg.module.otc.R$drawable.c2c_advert_sea_top1
            goto L_0x0612
        L_0x05fd:
            int r1 = r39.getSeaViewRoomPosition()
            r3 = 2
            if (r1 != r3) goto L_0x0607
            int r15 = com.hbg.module.otc.R$drawable.c2c_advert_sea_top2
            goto L_0x0612
        L_0x0607:
            int r1 = r39.getSeaViewRoomPosition()
            r3 = 3
            if (r1 != r3) goto L_0x0611
            int r15 = com.hbg.module.otc.R$drawable.c2c_advert_sea_top3
            goto L_0x0612
        L_0x0611:
            r15 = 0
        L_0x0612:
            int r1 = r39.getSeaViewRoomPosition()
            if (r1 == 0) goto L_0x0629
            r3 = r25
            r3.setImageResource(r15)
            r1 = 0
            r3.setVisibility(r1)
            r5 = r21
            r6 = 8
            r5.setVisibility(r6)
            goto L_0x0636
        L_0x0629:
            r5 = r21
            r3 = r25
            r1 = 0
            r6 = 8
            r3.setVisibility(r6)
            r5.setVisibility(r1)
        L_0x0636:
            jp.v1.d(r14)
            r0.t(r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.handler.AdsViewHandler.handleView(v9.c, int, com.huobi.otc.bean.Ads, android.view.ViewGroup):void");
    }

    /* renamed from: k */
    public void a(c cVar, int i11, Ads ads, ViewGroup viewGroup, List<Object> list) {
        r e11 = cVar.e();
        if (ads.isShieldChange()) {
            ads.setShieldChange(false);
            if (ads.isShield()) {
                v(cVar, true);
            } else {
                handleView(cVar, i11, ads, viewGroup);
            }
        } else {
            t(ads, e11);
        }
        ((TextView) e11.b(R$id.unitPriceValue)).setText(OtcModuleConfig.a().v(ads.getPrice(), m.U(ads.getPrice())));
    }

    public final void t(Ads ads, r rVar) {
        LinearLayout linearLayout = (LinearLayout) rVar.b(R$id.otc_item_more_ll);
        LinearLayout linearLayout2 = (LinearLayout) rVar.b(R$id.otc_ad_item_follow_ll);
        LinearLayout linearLayout3 = (LinearLayout) rVar.b(R$id.otc_ad_item_share_ll);
        View b11 = rVar.b(R$id.line);
        if (ads.isExpand()) {
            linearLayout.setVisibility(0);
            b11.setVisibility(8);
            u(ads, rVar);
            linearLayout3.setVisibility(8);
            Observable<Void> a11 = a.a(linearLayout2);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            a11.throttleFirst(500, timeUnit).subscribe(new f(ads));
            a.a(linearLayout3).throttleFirst(500, timeUnit).subscribe(new e(ads));
            return;
        }
        linearLayout.setVisibility(8);
        b11.setVisibility(0);
    }

    public final void u(Ads ads, r rVar) {
        String str;
        ((ImageView) rVar.b(R$id.id_merchant_followed)).setImageResource(ads.isFollowed() ? R$drawable.star_yellow_common : R$drawable.advert_follow);
        TextView textView = (TextView) rVar.b(R$id.id_follow_tv);
        if (ads.isFollowed()) {
            str = textView.getResources().getString(R$string.n_title_followed_merchant);
        } else {
            str = textView.getResources().getString(R$string.n_title_follow_merchant);
        }
        textView.setText(str);
    }

    public final void v(c cVar, boolean z11) {
        if (z11) {
            ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
            if (layoutParams.height != 0) {
                layoutParams.height = 0;
                cVar.itemView.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = cVar.itemView.getLayoutParams();
        if (layoutParams2.height == 0) {
            layoutParams2.height = -2;
            cVar.itemView.setLayoutParams(layoutParams2);
        }
    }
}
