package com.huobi.otc.handler.entity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.ui.OtcSeaViewRoomActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.HashMap;
import java.util.List;
import s9.d;
import uf.c;
import va.b;

public class SeaViewRoomHandler implements d<Ads> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ads f78785b;

        public a(Ads ads) {
            this.f78785b = ads;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, OtcSeaViewRoomActivity.class);
            intent.putExtra("coinId", this.f78785b.getCoinId());
            Bundle bundle = new Bundle();
            bundle.putSerializable("TradeType", this.f78785b.getTradeType());
            intent.putExtra("tradeBundle", bundle);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, OtcSeaViewRoomActivity.f79533g);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "otc_p2p_thumbsUp_click");
            c.b().h("otc_p2p_adlist", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r58, int r59, com.huobi.otc.bean.Ads r60, android.view.ViewGroup r61) {
        /*
            r57 = this;
            r15 = r57
            r0 = r58
            java.util.List r1 = r60.getExtraData()
            boolean r2 = com.hbg.lib.core.util.CollectionsUtils.b(r1)
            r14 = 1
            r3 = 0
            if (r2 != 0) goto L_0x0029
            r2 = r3
        L_0x0011:
            int r4 = r1.size()
            if (r2 >= r4) goto L_0x0027
            java.lang.Object r4 = r1.get(r2)
            com.huobi.otc.bean.Ads r4 = (com.huobi.otc.bean.Ads) r4
            boolean r4 = r4.isShield()
            if (r4 != 0) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0027:
            r1 = r14
            goto L_0x002a
        L_0x0029:
            r1 = r3
        L_0x002a:
            if (r1 == 0) goto L_0x0030
            r15.g(r0, r14)
            return
        L_0x0030:
            r15.g(r0, r3)
            android.view.View r1 = r0.itemView
            android.content.res.Resources r16 = r1.getResources()
            i6.r r0 = r58.e()
            int r1 = com.hbg.module.otc.R$id.sea_view_container
            android.view.View r1 = r0.b(r1)
            r13 = r1
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_name_1
            android.view.View r1 = r0.b(r1)
            r17 = r1
            android.widget.TextView r17 = (android.widget.TextView) r17
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_name_2
            android.view.View r1 = r0.b(r1)
            r18 = r1
            android.widget.TextView r18 = (android.widget.TextView) r18
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_name_3
            android.view.View r1 = r0.b(r1)
            r19 = r1
            android.widget.TextView r19 = (android.widget.TextView) r19
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_trades_1
            android.view.View r1 = r0.b(r1)
            r20 = r1
            android.widget.TextView r20 = (android.widget.TextView) r20
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_trades_2
            android.view.View r1 = r0.b(r1)
            r21 = r1
            android.widget.TextView r21 = (android.widget.TextView) r21
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_trades_3
            android.view.View r1 = r0.b(r1)
            r22 = r1
            android.widget.TextView r22 = (android.widget.TextView) r22
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_percent_1
            android.view.View r1 = r0.b(r1)
            r23 = r1
            android.widget.TextView r23 = (android.widget.TextView) r23
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_percent_2
            android.view.View r1 = r0.b(r1)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r1 = com.hbg.module.otc.R$id.sea_view_entrace_percent_3
            android.view.View r1 = r0.b(r1)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r1 = com.hbg.module.otc.R$id.unit_currency_symbol_tv1
            android.view.View r1 = r0.b(r1)
            r24 = r1
            android.widget.TextView r24 = (android.widget.TextView) r24
            int r1 = com.hbg.module.otc.R$id.unit_currency_symbol_tv2
            android.view.View r1 = r0.b(r1)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r1 = com.hbg.module.otc.R$id.unit_currency_symbol_tv3
            android.view.View r1 = r0.b(r1)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r1 = com.hbg.module.otc.R$id.unitPriceValue1
            android.view.View r1 = r0.b(r1)
            r25 = r1
            android.widget.TextView r25 = (android.widget.TextView) r25
            int r1 = com.hbg.module.otc.R$id.unitPriceValue2
            android.view.View r1 = r0.b(r1)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r1 = com.hbg.module.otc.R$id.unitPriceValue3
            android.view.View r1 = r0.b(r1)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r1 = com.hbg.module.otc.R$id.view_divide_1
            android.view.View r26 = r0.b(r1)
            int r1 = com.hbg.module.otc.R$id.view_divide_2
            android.view.View r6 = r0.b(r1)
            int r1 = com.hbg.module.otc.R$id.view_divide_3
            android.view.View r5 = r0.b(r1)
            int r1 = com.hbg.module.otc.R$id.merchantLevel_container1
            android.view.View r1 = r0.b(r1)
            r27 = r1
            android.widget.LinearLayout r27 = (android.widget.LinearLayout) r27
            int r1 = com.hbg.module.otc.R$id.merchantLevel_container2
            android.view.View r1 = r0.b(r1)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            int r1 = com.hbg.module.otc.R$id.merchantLevel_container3
            android.view.View r1 = r0.b(r1)
            r2 = r1
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            int r1 = com.hbg.module.otc.R$id.id_merchantLevel1_followed
            android.view.View r1 = r0.b(r1)
            r28 = r1
            android.widget.ImageView r28 = (android.widget.ImageView) r28
            int r1 = com.hbg.module.otc.R$id.id_merchantLevel2_followed
            android.view.View r1 = r0.b(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r14 = com.hbg.module.otc.R$id.id_merchantLevel3_followed
            android.view.View r14 = r0.b(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            int r3 = com.hbg.module.otc.R$id.merchantLevel1
            android.view.View r3 = r0.b(r3)
            r29 = r3
            android.widget.ImageView r29 = (android.widget.ImageView) r29
            int r3 = com.hbg.module.otc.R$id.merchantThumbUp1
            android.view.View r3 = r0.b(r3)
            r30 = r3
            android.widget.ImageView r30 = (android.widget.ImageView) r30
            int r3 = com.hbg.module.otc.R$id.blue_shield_service_tv1
            android.view.View r3 = r0.b(r3)
            r31 = r3
            android.widget.ImageView r31 = (android.widget.ImageView) r31
            int r3 = com.hbg.module.otc.R$id.id_receive_order_flag_tv1
            android.view.View r3 = r0.b(r3)
            r32 = r3
            android.widget.TextView r32 = (android.widget.TextView) r32
            int r3 = com.hbg.module.otc.R$id.merchantLevel2
            android.view.View r3 = r0.b(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r58 = r13
            int r13 = com.hbg.module.otc.R$id.merchantThumbUp2
            android.view.View r13 = r0.b(r13)
            r33 = r13
            android.widget.ImageView r33 = (android.widget.ImageView) r33
            int r13 = com.hbg.module.otc.R$id.blue_shield_service_tv2
            android.view.View r13 = r0.b(r13)
            r34 = r13
            android.widget.ImageView r34 = (android.widget.ImageView) r34
            int r13 = com.hbg.module.otc.R$id.id_receive_order_flag_tv2
            android.view.View r13 = r0.b(r13)
            r35 = r13
            android.widget.TextView r35 = (android.widget.TextView) r35
            int r13 = com.hbg.module.otc.R$id.merchantLevel3
            android.view.View r13 = r0.b(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            int r15 = com.hbg.module.otc.R$id.merchantThumbUp3
            android.view.View r15 = r0.b(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            r36 = r15
            int r15 = com.hbg.module.otc.R$id.blue_shield_service_tv3
            android.view.View r15 = r0.b(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            r37 = r15
            int r15 = com.hbg.module.otc.R$id.id_receive_order_flag_tv3
            android.view.View r0 = r0.b(r15)
            r15 = r0
            android.widget.TextView r15 = (android.widget.TextView) r15
            r0 = 0
            r10.setVisibility(r0)
            r9.setVisibility(r0)
            r8.setVisibility(r0)
            r7.setVisibility(r0)
            r12.setVisibility(r0)
            r11.setVisibility(r0)
            r3.setVisibility(r0)
            r13.setVisibility(r0)
            r1.setVisibility(r0)
            r14.setVisibility(r0)
            r0 = 4
            r4.setVisibility(r0)
            r2.setVisibility(r0)
            java.util.List r0 = r60.getExtraData()
            r38 = r1
            r1 = 0
            r6.setVisibility(r1)
            r5.setVisibility(r1)
            boolean r39 = com.hbg.lib.core.util.CollectionsUtils.b(r0)
            if (r39 != 0) goto L_0x032f
            r39 = r1
            r61 = r2
        L_0x01d0:
            int r2 = r0.size()
            r40 = r14
            if (r1 >= r2) goto L_0x02db
            java.lang.Object r2 = r0.get(r1)
            com.huobi.otc.bean.Ads r2 = (com.huobi.otc.bean.Ads) r2
            if (r2 == 0) goto L_0x0297
            boolean r41 = r2.isShield()
            if (r41 != 0) goto L_0x0297
            r41 = r15
            int r15 = r39 + 1
            r14 = 1
            if (r15 != r14) goto L_0x022c
            r43 = r0
            r0 = r57
            r42 = r1
            r1 = r2
            r44 = r61
            r2 = r17
            r45 = r3
            r3 = r20
            r46 = r4
            r4 = r16
            r47 = r5
            r5 = r23
            r48 = r6
            r6 = r24
            r49 = r7
            r7 = r25
            r50 = r8
            r8 = r28
            r51 = r9
            r9 = r29
            r52 = r10
            r10 = r30
            r53 = r11
            r11 = r31
            r54 = r12
            r12 = r32
            r55 = r58
            r56 = r13
            r13 = r27
            r14 = r26
            r0.h(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x026d
        L_0x022c:
            r55 = r58
            r44 = r61
            r43 = r0
            r42 = r1
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r49 = r7
            r50 = r8
            r51 = r9
            r52 = r10
            r53 = r11
            r54 = r12
            r56 = r13
            r14 = 2
            if (r15 != r14) goto L_0x0270
            r0 = r57
            r1 = r2
            r2 = r18
            r3 = r21
            r4 = r16
            r5 = r54
            r6 = r52
            r7 = r50
            r8 = r38
            r9 = r45
            r10 = r33
            r11 = r34
            r12 = r35
            r13 = r46
            r14 = r48
            r0.h(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x026d:
            r39 = r15
            goto L_0x02b7
        L_0x0270:
            r0 = r57
            r1 = r2
            r2 = r19
            r3 = r22
            r4 = r16
            r5 = r53
            r6 = r51
            r7 = r49
            r8 = r40
            r9 = r56
            r10 = r36
            r11 = r37
            r12 = r41
            r13 = r44
            r58 = r15
            r15 = r14
            r14 = r47
            r0.h(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r58
            goto L_0x02f4
        L_0x0297:
            r55 = r58
            r44 = r61
            r43 = r0
            r42 = r1
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r49 = r7
            r50 = r8
            r51 = r9
            r52 = r10
            r53 = r11
            r54 = r12
            r56 = r13
            r41 = r15
        L_0x02b7:
            int r1 = r42 + 1
            r14 = r40
            r15 = r41
            r0 = r43
            r61 = r44
            r3 = r45
            r4 = r46
            r5 = r47
            r6 = r48
            r7 = r49
            r8 = r50
            r9 = r51
            r10 = r52
            r11 = r53
            r12 = r54
            r58 = r55
            r13 = r56
            goto L_0x01d0
        L_0x02db:
            r55 = r58
            r44 = r61
            r46 = r4
            r47 = r5
            r48 = r6
            r49 = r7
            r50 = r8
            r51 = r9
            r52 = r10
            r53 = r11
            r54 = r12
            r15 = 2
            r0 = r39
        L_0x02f4:
            r1 = 1
            if (r0 != r1) goto L_0x0319
            r0 = r57
            r1 = r52
            r2 = r51
            r3 = r50
            r4 = r49
            r5 = r47
            r6 = r48
            r7 = r54
            r8 = r53
            r9 = r21
            r10 = r22
            r11 = r18
            r12 = r19
            r13 = r44
            r14 = r46
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0362
        L_0x0319:
            if (r0 != r15) goto L_0x0362
            r0 = r57
            r1 = r47
            r2 = r51
            r3 = r49
            r4 = r53
            r5 = r22
            r6 = r19
            r7 = r44
            r0.e(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0362
        L_0x032f:
            r55 = r58
            r44 = r2
            r46 = r4
            r47 = r5
            r48 = r6
            r49 = r7
            r50 = r8
            r51 = r9
            r52 = r10
            r53 = r11
            r54 = r12
            r0 = r57
            r1 = r52
            r2 = r51
            r3 = r50
            r4 = r49
            r7 = r54
            r8 = r53
            r9 = r21
            r10 = r22
            r11 = r18
            r12 = r19
            r13 = r44
            r14 = r46
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x0362:
            com.huobi.otc.handler.entity.SeaViewRoomHandler$a r0 = new com.huobi.otc.handler.entity.SeaViewRoomHandler$a
            r1 = r57
            r2 = r60
            r0.<init>(r2)
            r2 = r55
            r2.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.handler.entity.SeaViewRoomHandler.handleView(v9.c, int, com.huobi.otc.bean.Ads, android.view.ViewGroup):void");
    }

    /* renamed from: c */
    public void a(v9.c cVar, int i11, Ads ads, ViewGroup viewGroup, List<Object> list) {
        handleView(cVar, i11, ads, viewGroup);
    }

    public final void d(TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout, LinearLayout linearLayout2) {
        e(view2, textView, textView3, textView5, textView7, textView9, linearLayout2);
        e(view, textView2, textView4, textView6, textView8, textView10, linearLayout);
    }

    public final void e(View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout) {
        view.setVisibility(8);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
        textView4.setText(textView4.getResources().getString(R$string.n_otc_advert_thumbsUp_wait_stay));
        textView5.setText("--");
        linearLayout.setVisibility(4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(com.huobi.otc.bean.Ads r6, android.widget.ImageView r7, android.widget.ImageView r8, android.widget.ImageView r9, android.widget.TextView r10, android.widget.LinearLayout r11, android.widget.ImageView r12) {
        /*
            r5 = this;
            int r0 = r6.getMerchantLevel()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x000a
        L_0x0008:
            r0 = r2
            goto L_0x001d
        L_0x000a:
            int r0 = r6.getMerchantLevel()
            r3 = 2
            if (r0 != r3) goto L_0x0014
            int r0 = com.hbg.module.otc.R$drawable.otc_market_v_icon
            goto L_0x001d
        L_0x0014:
            int r0 = r6.getMerchantLevel()
            r3 = 3
            if (r0 != r3) goto L_0x0008
            int r0 = com.hbg.module.otc.R$drawable.otc_market_crown_icon
        L_0x001d:
            int r3 = r6.getMerchantLevel()
            if (r3 == r1) goto L_0x002b
            int r3 = r6.getMerchantLevel()
            if (r3 == 0) goto L_0x002b
            r3 = r1
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            r7.setImageResource(r0)
            r0 = 8
            if (r3 == 0) goto L_0x0037
            r7.setVisibility(r2)
            goto L_0x003a
        L_0x0037:
            r7.setVisibility(r0)
        L_0x003a:
            int r7 = r6.getThumbUp()
            if (r7 != r1) goto L_0x0045
            r8.setVisibility(r2)
            r3 = r1
            goto L_0x0048
        L_0x0045:
            r8.setVisibility(r0)
        L_0x0048:
            boolean r7 = r6.isBlueShieldMerchant()
            if (r7 == 0) goto L_0x004f
            r3 = r1
        L_0x004f:
            boolean r7 = r6.isBlueShieldMerchant()
            if (r7 == 0) goto L_0x0057
            r7 = r2
            goto L_0x0058
        L_0x0057:
            r7 = r0
        L_0x0058:
            r9.setVisibility(r7)
            android.content.Context r7 = r9.getContext()
            android.content.res.Resources r7 = r7.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.String r8 = r7.getLanguage()
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r4 = "zh"
            boolean r8 = r8.endsWith(r4)
            if (r8 == 0) goto L_0x008c
            java.lang.String r7 = r7.getCountry()
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r8 = "hk"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x008c
            int r7 = com.hbg.module.otc.R$drawable.otc_trust_tw_icon
            goto L_0x009b
        L_0x008c:
            android.content.Context r7 = r9.getContext()
            boolean r7 = com.hbg.lib.core.util.p.h(r7)
            if (r7 == 0) goto L_0x0099
            int r7 = com.hbg.module.otc.R$drawable.otc_trust_zh_icon
            goto L_0x009b
        L_0x0099:
            int r7 = com.hbg.module.otc.R$drawable.otc_trust_en_icon
        L_0x009b:
            r9.setImageResource(r7)
            boolean r7 = r6.isAcceptOrder()
            if (r7 == 0) goto L_0x00a5
            r0 = r2
        L_0x00a5:
            r10.setVisibility(r0)
            if (r7 == 0) goto L_0x00ab
            r3 = r1
        L_0x00ab:
            if (r7 == 0) goto L_0x00b2
            int r7 = com.hbg.module.otc.R$drawable.shape_otc_dialog_bg
            r10.setBackgroundResource(r7)
        L_0x00b2:
            boolean r7 = r6.isFollowed()
            if (r7 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r1 = r3
        L_0x00ba:
            if (r1 == 0) goto L_0x00c0
            r11.setVisibility(r2)
            goto L_0x00c4
        L_0x00c0:
            r7 = 4
            r11.setVisibility(r7)
        L_0x00c4:
            boolean r6 = r6.isFollowed()
            com.hbg.lib.common.utils.ViewUtil.m(r12, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.handler.entity.SeaViewRoomHandler.f(com.huobi.otc.bean.Ads, android.widget.ImageView, android.widget.ImageView, android.widget.ImageView, android.widget.TextView, android.widget.LinearLayout, android.widget.ImageView):void");
    }

    public final void g(v9.c cVar, boolean z11) {
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

    public int getResId() {
        return R$layout.item_otc_sea_view_room;
    }

    public final void h(Ads ads, TextView textView, TextView textView2, Resources resources, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView6, LinearLayout linearLayout, View view) {
        TextView textView7 = textView3;
        TextView textView8 = textView4;
        TextView textView9 = textView5;
        view.setVisibility(0);
        textView8.setVisibility(0);
        textView9.setVisibility(0);
        textView7.setVisibility(0);
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setVisibility(0);
        String m11 = b.m(ads.getCurrency());
        TextView textView10 = textView;
        textView.setText(ads.getUserName());
        String format = String.format(resources.getString(R$string.n_otc_advert_ordercount), new Object[]{String.valueOf(ads.getTotalTradeOrderCount())});
        TextView textView11 = textView2;
        textView2.setText(format);
        textView7.setText(String.format("%s%%", new Object[]{ads.getOrderCompleteRate()}));
        textView8.setText(m11 + " ");
        textView9.setText(OtcModuleConfig.a().v(ads.getPrice(), m.U(ads.getPrice())));
        ViewUtil.m(imageView, ads.isFollowed());
        f(ads, imageView2, imageView3, imageView4, textView6, linearLayout2, imageView);
    }
}
