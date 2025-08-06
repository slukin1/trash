package com.huobi.index.viewhandler;

import android.util.SparseArray;
import android.view.View;
import bh.j;
import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gs.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import s9.c;
import sn.f;
import yl.t;
import zl.a;

public class RankDynamicItemHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Object> f74417b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f74418c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, HashMap<Integer, String>> f74419d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, String> f74420e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public a f74421f;

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0509  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x06ab  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x06c7  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x06e9  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x06fa  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x020b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0248  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r33, int r34, com.huobi.index.bean.RankDynamicItem r35, android.view.ViewGroup r36) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r6 = r35
            if (r6 != 0) goto L_0x0010
            java.lang.String r1 = "RankDynamicItemHandler"
            java.lang.String r2 = "data is null"
            android.util.Log.d(r1, r2)
            return
        L_0x0010:
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            i6.r r3 = r33.e()
            r4 = 2131431321(0x7f0b0f99, float:1.8484368E38)
            android.view.View r4 = r3.b(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r5 = 2131431322(0x7f0b0f9a, float:1.848437E38)
            android.view.View r5 = r3.b(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r7 = r35.i()
            boolean r8 = r35.j()
            boolean r7 = yl.t.r(r7, r8)
            r8 = 8
            r9 = 0
            if (r7 == 0) goto L_0x005f
            r4.setVisibility(r8)
            r5.setVisibility(r9)
            com.huobi.index.viewhandler.IndexRankOptionalHolder r1 = new com.huobi.index.viewhandler.IndexRankOptionalHolder
            r1.<init>()
            java.util.Map<java.lang.String, java.util.HashMap<java.lang.Integer, java.lang.String>> r4 = r0.f74419d
            java.util.HashMap<java.lang.Integer, java.lang.String> r7 = r0.f74420e
            r1.d(r4, r7)
            zl.a r4 = r0.f74421f
            r1.e(r4)
            r4 = r5
            r5 = r34
            r6 = r35
            r7 = r36
            r1.c(r2, r3, r4, r5, r6, r7)
            return
        L_0x005f:
            r4.setVisibility(r9)
            r5.setVisibility(r8)
            android.view.View r5 = r1.itemView
            r5.setOnClickListener(r0)
            android.view.View r5 = r1.itemView
            r7 = 2131431238(0x7f0b0f46, float:1.84842E38)
            r5.setTag(r7, r6)
            android.view.View r5 = r1.itemView
            r7 = 2131431239(0x7f0b0f47, float:1.8484202E38)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r34)
            r5.setTag(r7, r10)
            r5 = 2131431187(0x7f0b0f13, float:1.8484096E38)
            android.widget.ImageView r5 = r3.c(r5)
            r7 = 2131431182(0x7f0b0f0e, float:1.8484086E38)
            android.widget.TextView r7 = r3.e(r7)
            r10 = 2131431197(0x7f0b0f1d, float:1.8484116E38)
            android.widget.TextView r10 = r3.e(r10)
            r11 = 2131431347(0x7f0b0fb3, float:1.848442E38)
            android.widget.TextView r11 = r3.e(r11)
            r12 = 2131431195(0x7f0b0f1b, float:1.8484112E38)
            android.widget.TextView r12 = r3.e(r12)
            r13 = 2131431193(0x7f0b0f19, float:1.8484108E38)
            android.widget.TextView r13 = r3.e(r13)
            r14 = 2131431184(0x7f0b0f10, float:1.848409E38)
            android.widget.TextView r14 = r3.e(r14)
            r15 = 2131431188(0x7f0b0f14, float:1.8484098E38)
            android.widget.TextView r15 = r3.e(r15)
            r9 = 2131431190(0x7f0b0f16, float:1.8484102E38)
            android.widget.TextView r9 = r3.e(r9)
            r8 = 2131431774(0x7f0b115e, float:1.8485287E38)
            android.view.View r8 = r3.b(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 8
            r14.setVisibility(r1)
            r9.setVisibility(r1)
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r16 = 1105199104(0x41e00000, float:28.0)
            int r6 = com.hbg.lib.common.utils.PixelUtils.a(r16)
            r1.height = r6
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r6 = yl.t.h()
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r16 = r35.g()
            if (r16 != 0) goto L_0x00e5
            return
        L_0x00e5:
            java.lang.String r16 = ""
            if (r6 == 0) goto L_0x00f0
            java.lang.String r6 = r6.getScreenValue()
            r34 = r8
            goto L_0x00f4
        L_0x00f0:
            r34 = r8
            r6 = r16
        L_0x00f4:
            int r8 = r35.i()
            r17 = r3
            r3 = 6
            r36 = r14
            r14 = 1
            if (r8 == r3) goto L_0x0109
            int r8 = r35.i()
            if (r8 != r14) goto L_0x0107
            goto L_0x0109
        L_0x0107:
            r8 = 0
            goto L_0x010a
        L_0x0109:
            r8 = r14
        L_0x010a:
            int r3 = r35.i()
            r14 = 4
            if (r3 != r14) goto L_0x0113
            r3 = 1
            goto L_0x0114
        L_0x0113:
            r3 = 0
        L_0x0114:
            int r14 = r35.i()
            r18 = r8
            r8 = 7
            if (r14 != r8) goto L_0x011f
            r14 = 1
            goto L_0x0120
        L_0x011f:
            r14 = 0
        L_0x0120:
            int r8 = r35.i()
            r19 = r2
            r2 = 8
            if (r8 != r2) goto L_0x012c
            r2 = 1
            goto L_0x012d
        L_0x012c:
            r2 = 0
        L_0x012d:
            int r8 = r35.i()
            r20 = r1
            r1 = 2
            if (r8 != r1) goto L_0x0138
            r8 = 1
            goto L_0x0139
        L_0x0138:
            r8 = 0
        L_0x0139:
            int r1 = r35.i()
            r21 = r3
            r3 = 5
            if (r1 != r3) goto L_0x0144
            r1 = 1
            goto L_0x0145
        L_0x0144:
            r1 = 0
        L_0x0145:
            int r3 = r35.i()
            r22 = r9
            r9 = 9
            if (r3 != r9) goto L_0x0151
            r3 = 1
            goto L_0x0152
        L_0x0151:
            r3 = 0
        L_0x0152:
            java.lang.String r9 = "usdtSwap"
            boolean r9 = r9.equals(r6)
            r23 = r15
            java.lang.String r15 = "symbolSwap"
            boolean r15 = r15.equals(r6)
            r24 = r13
            java.lang.String r13 = "future"
            boolean r13 = r13.equals(r6)
            if (r3 == 0) goto L_0x0173
            if (r9 != 0) goto L_0x0170
            if (r15 != 0) goto L_0x0170
            if (r13 == 0) goto L_0x0173
        L_0x0170:
            r25 = 1
            goto L_0x0175
        L_0x0173:
            r25 = 0
        L_0x0175:
            boolean r26 = r35.l()
            if (r26 == 0) goto L_0x01ed
            if (r25 == 0) goto L_0x0192
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r11 = r35.g()
            java.lang.String r11 = r11.getContractShowSymbol()
            r7.setText(r11)
            r11 = 8
            r10.setVisibility(r11)
            r27 = r1
            r26 = r3
            goto L_0x01cf
        L_0x0192:
            r26 = r3
            r3 = 8
            if (r14 != 0) goto L_0x01b8
            if (r2 == 0) goto L_0x019b
            goto L_0x01b8
        L_0x019b:
            java.lang.String r11 = r35.getBaseCurrencyDisplayName()
            r7.setText(r11)
            r11 = r1 | r8
            if (r11 == 0) goto L_0x01aa
            r10.setVisibility(r3)
            goto L_0x01b5
        L_0x01aa:
            r11 = 0
            r10.setVisibility(r11)
            java.lang.String r11 = r35.f()
            r10.setText(r11)
        L_0x01b5:
            r27 = r1
            goto L_0x01cf
        L_0x01b8:
            r27 = r1
            r1 = 0
            r7.setVisibility(r3)
            r10.setVisibility(r3)
            r11.setVisibility(r1)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.lang.String r1 = r1.getNftDid()
            r11.setText(r1)
        L_0x01cf:
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            if (r1 == 0) goto L_0x01de
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.lang.String r1 = r1.getBaseCurrency()
            goto L_0x0209
        L_0x01de:
            com.huobi.index.presenter.g$b r1 = r35.c()
            if (r1 == 0) goto L_0x0207
            com.huobi.index.presenter.g$b r1 = r35.c()
            java.lang.String r1 = r1.c()
            goto L_0x0209
        L_0x01ed:
            r27 = r1
            r26 = r3
            java.lang.String r1 = r35.getBaseCurrencyDisplayName()
            r7.setText(r1)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            if (r1 == 0) goto L_0x0207
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.lang.String r1 = r1.getCurrency()
            goto L_0x0209
        L_0x0207:
            r1 = r16
        L_0x0209:
            if (r14 != 0) goto L_0x021e
            if (r2 == 0) goto L_0x020e
            goto L_0x021e
        L_0x020e:
            f6.c r3 = f6.c.a()
            java.lang.String r1 = al.p.l(r1)
            int r11 = al.p.m()
            r3.f(r5, r1, r11)
            goto L_0x0231
        L_0x021e:
            f6.c r1 = f6.c.a()
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getNftImg()
            int r11 = al.p.n()
            r1.j(r5, r3, r11)
        L_0x0231:
            java.lang.String r1 = r35.e()
            boolean r1 = com.alibaba.android.arouter.utils.TextUtils.c(r1)
            java.lang.String r5 = "-"
            if (r1 == 0) goto L_0x0248
            java.lang.String r1 = "--"
            r12.setText(r1)
            r28 = r7
            r29 = r10
            goto L_0x037f
        L_0x0248:
            java.lang.String r1 = r35.e()
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r11 = r35.g()
            java.lang.String r11 = r11.getSymbol()
            boolean r11 = com.alibaba.android.arouter.utils.TextUtils.c(r11)
            if (r11 != 0) goto L_0x0263
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r11 = r35.g()
            java.lang.String r11 = r11.getSymbol()
            goto L_0x026b
        L_0x0263:
            int r11 = r33.hashCode()
            java.lang.String r11 = java.lang.String.valueOf(r11)
        L_0x026b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r28 = r7
            int r7 = r35.i()
            r3.append(r7)
            r3.append(r6)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            int r3 = r3.hashCode()
            boolean r6 = i6.m.a0(r1)
            if (r6 == 0) goto L_0x02c5
            double r6 = java.lang.Double.parseDouble(r1)
            android.util.SparseArray<java.lang.Object> r11 = r0.f74417b
            java.lang.Object r11 = r11.get(r3)
            r29 = r10
            r10 = 2131234854(0x7f081026, float:1.8085885E38)
            if (r11 == 0) goto L_0x02b5
            android.util.SparseArray<java.lang.Object> r11 = r0.f74417b
            java.lang.Object r11 = r11.get(r3)
            java.lang.Double r11 = (java.lang.Double) r11
            double r30 = r11.doubleValue()
            int r11 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
            if (r11 == 0) goto L_0x02b5
            r4.setBackgroundResource(r10)
            r4 = 1
            r0.f74418c = r4
            goto L_0x02bb
        L_0x02b5:
            r4.setBackgroundResource(r10)
            r4 = 0
            r0.f74418c = r4
        L_0x02bb:
            android.util.SparseArray<java.lang.Object> r4 = r0.f74417b
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r4.put(r3, r6)
            goto L_0x02c7
        L_0x02c5:
            r29 = r10
        L_0x02c7:
            if (r25 == 0) goto L_0x0333
            if (r9 != 0) goto L_0x0306
            if (r13 == 0) goto L_0x02de
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getQuoteCurrency()
            java.lang.String r4 = "USDT"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x02de
            goto L_0x0306
        L_0x02de:
            if (r15 != 0) goto L_0x02f7
            if (r13 == 0) goto L_0x02f3
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getQuoteCurrency()
            java.lang.String r4 = "USD"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x02f3
            goto L_0x02f7
        L_0x02f3:
            r4 = r16
            r3 = 2
            goto L_0x0314
        L_0x02f7:
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getBaseCurrency()
            int r3 = us.i.o(r3)
            java.lang.String r16 = "$"
            goto L_0x0312
        L_0x0306:
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getBaseCurrency()
            int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.c(r3)
        L_0x0312:
            r4 = r16
        L_0x0314:
            java.lang.String r1 = i6.m.y(r1, r3)
            java.lang.String r1 = i6.m.V(r1, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r1 = i6.m.c(r1, r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r12.setText(r1)
            goto L_0x037f
        L_0x0333:
            if (r14 == 0) goto L_0x0366
            r3 = 0
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.v(r3)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r3 = r35.g()
            java.lang.String r3 = r3.getTotalProfitRate()
            r4 = 1
            java.lang.String r1 = i6.m.Q(r3, r1, r4)
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r3 = r3.compareTo(r4)
            if (r3 > 0) goto L_0x0362
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x0362:
            r12.setText(r1)
            goto L_0x037f
        L_0x0366:
            if (r2 == 0) goto L_0x0378
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            int r1 = r1.getWinCount()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.setText(r1)
            goto L_0x037f
        L_0x0378:
            java.lang.String r1 = i6.m.c(r1, r1)
            r12.setText(r1)
        L_0x037f:
            android.graphics.drawable.Drawable r1 = r24.getBackground()
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            android.graphics.drawable.Drawable r3 = r23.getBackground()
            android.graphics.drawable.GradientDrawable r3 = (android.graphics.drawable.GradientDrawable) r3
            android.graphics.drawable.Drawable r4 = r22.getBackground()
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
            boolean r6 = r35.k()
            java.lang.String r10 = "0.00%"
            if (r6 == 0) goto L_0x04b2
            if (r21 == 0) goto L_0x0436
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r2 = r35.g()
            if (r2 == 0) goto L_0x042a
            r11 = 0
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.v(r11)
            double r30 = r2.getBeginTradeUpAndDown()
            java.lang.String r14 = java.lang.String.valueOf(r30)
            r7 = 1
            java.lang.String r11 = i6.m.Q(r14, r11, r7)
            java.math.BigDecimal r7 = i6.m.a(r14)
            java.math.BigDecimal r14 = java.math.BigDecimal.ZERO
            int r7 = r7.compareTo(r14)
            if (r7 <= 0) goto L_0x03d0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r14 = "+"
            r7.append(r14)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
        L_0x03d0:
            r7 = r24
            r7.setText(r11)
            r14 = 1101004800(0x41a00000, float:20.0)
            int r14 = com.hbg.lib.common.utils.PixelUtils.a(r14)
            r6 = r20
            r6.height = r14
            r6 = r19
            if (r1 == 0) goto L_0x03ed
            r14 = 2131102106(0x7f06099a, float:1.781664E38)
            int r14 = androidx.core.content.ContextCompat.getColor(r6, r14)
            r1.setColor(r14)
        L_0x03ed:
            boolean r1 = r11.equals(r10)
            if (r1 == 0) goto L_0x0401
            r1 = 2131100870(0x7f0604c6, float:1.7814134E38)
            int r11 = androidx.core.content.ContextCompat.getColor(r6, r1)
            r7.setTextColor(r11)
        L_0x03fd:
            r11 = r36
            r1 = 0
            goto L_0x040f
        L_0x0401:
            boolean r1 = r11.contains(r5)
            r11 = 1
            r1 = r1 ^ r11
            int r1 = com.huobi.trade.helper.f0.h(r6, r1)
            r7.setTextColor(r1)
            goto L_0x03fd
        L_0x040f:
            r11.setVisibility(r1)
            long r1 = r2.getBeginTradeDate()
            java.lang.String r14 = "yyyy-MM-dd"
            java.lang.String r1 = com.hbg.lib.common.utils.DateTimeUtils.h(r1, r14)
            r11.setText(r1)
            r1 = 2131100867(0x7f0604c3, float:1.7814128E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r1)
            r11.setTextColor(r1)
            goto L_0x0430
        L_0x042a:
            r11 = r36
            r6 = r19
            r7 = r24
        L_0x0430:
            r36 = r12
            r16 = r13
            goto L_0x04e8
        L_0x0436:
            r11 = r36
            r6 = r19
            r7 = r24
            if (r14 == 0) goto L_0x0465
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r2 = r35.g()
            if (r2 == 0) goto L_0x0430
            java.lang.String r2 = r2.getTotalProfitAmount()
            r14 = 4
            java.lang.String r2 = i6.m.e(r2, r14)
            r7.setText(r2)
            r2 = 1
            int r14 = com.huobi.trade.helper.f0.h(r6, r2)
            r7.setTextColor(r14)
            if (r1 == 0) goto L_0x0430
            r2 = 2131102106(0x7f06099a, float:1.781664E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r6, r2)
            r1.setColor(r2)
            goto L_0x0430
        L_0x0465:
            if (r2 == 0) goto L_0x048e
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r2 = r35.g()
            if (r2 == 0) goto L_0x0430
            java.lang.String r2 = r2.getNewProfitAmount()
            r14 = 4
            java.lang.String r2 = i6.m.e(r2, r14)
            r7.setText(r2)
            r2 = 1
            int r14 = com.huobi.trade.helper.f0.h(r6, r2)
            r7.setTextColor(r14)
            if (r1 == 0) goto L_0x0430
            r2 = 2131102106(0x7f06099a, float:1.781664E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r6, r2)
            r1.setColor(r2)
            goto L_0x0430
        L_0x048e:
            java.lang.String r2 = r35.d()
            r7.setText(r2)
            java.lang.String r2 = r35.d()
            int r2 = com.hbg.lib.core.util.w.k(r2)
            int r2 = androidx.core.content.ContextCompat.getColor(r6, r2)
            if (r1 == 0) goto L_0x04a6
            r1.setColor(r2)
        L_0x04a6:
            r1 = 2131099938(0x7f060122, float:1.7812243E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r1)
            r7.setTextColor(r1)
            goto L_0x0430
        L_0x04b2:
            r11 = r36
            r6 = r19
            r7 = r24
            r2 = 2131100868(0x7f0604c4, float:1.781413E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r6, r2)
            if (r1 == 0) goto L_0x04da
            int r14 = android.graphics.Color.red(r2)
            int r0 = android.graphics.Color.green(r2)
            r36 = r12
            int r12 = android.graphics.Color.blue(r2)
            r16 = r13
            r13 = 6
            int r0 = android.graphics.Color.argb(r13, r14, r0, r12)
            r1.setColor(r0)
            goto L_0x04de
        L_0x04da:
            r36 = r12
            r16 = r13
        L_0x04de:
            r7.setTextColor(r2)
            java.lang.String r0 = r35.d()
            r7.setText(r0)
        L_0x04e8:
            if (r21 == 0) goto L_0x04fb
            r0 = 8388613(0x800005, float:1.175495E-38)
            r7.setGravity(r0)
            r0 = 1077936128(0x40400000, float:3.0)
            int r0 = com.hbg.lib.common.utils.PixelUtils.a(r0)
            r1 = 0
            r11.setPadding(r0, r1, r1, r1)
            goto L_0x04fc
        L_0x04fb:
            r1 = 0
        L_0x04fc:
            com.huobi.index.presenter.g$b r0 = r35.c()
            if (r0 == 0) goto L_0x0509
            r0 = r23
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
            goto L_0x066a
        L_0x0509:
            r0 = r23
            d7.a1 r1 = d7.a1.v()
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r2 = r35.g()
            java.lang.String r2 = r2.getSymbol()
            com.hbg.lib.data.symbol.TradeType r11 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r1 = r1.J(r2, r11)
            if (r1 == 0) goto L_0x0569
            boolean r2 = r1.isEtpTag()
            if (r2 == 0) goto L_0x0569
            if (r21 != 0) goto L_0x0569
            if (r8 != 0) goto L_0x0569
            java.lang.String r2 = r1.getDirection()
            java.lang.String r3 = r1.getEtpLeverageRatio()
            java.lang.String r2 = com.huobi.trade.helper.f0.d(r6, r2, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0563
            r3 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r0, r3)
            r0.setText(r2)
            boolean r2 = r1.isEtpTag()
            java.lang.String r3 = r1.getDirection()
            int r2 = com.huobi.trade.helper.f0.g(r6, r2, r3)
            r0.setTextColor(r2)
            boolean r2 = r1.isEtpTag()
            java.lang.String r1 = r1.getDirection()
            int r1 = com.huobi.trade.helper.f0.e(r2, r1)
            r0.setBackgroundResource(r1)
            r1 = 0
            goto L_0x066a
        L_0x0563:
            r1 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
            goto L_0x066a
        L_0x0569:
            r1 = 0
            r2 = 2131100865(0x7f0604c1, float:1.7814124E38)
            r11 = 2131100866(0x7f0604c2, float:1.7814126E38)
            if (r21 == 0) goto L_0x0612
            r12 = r22
            com.hbg.lib.common.utils.ViewUtil.m(r12, r1)
            r8 = r29
            com.hbg.lib.common.utils.ViewUtil.m(r8, r1)
            java.lang.String r1 = r35.d()
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x0591
            r1 = 2131100870(0x7f0604c6, float:1.7814134E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r1)
            r12.setTextColor(r1)
            goto L_0x05a2
        L_0x0591:
            java.lang.String r1 = r35.d()
            boolean r1 = r1.contains(r5)
            r5 = 1
            r1 = r1 ^ r5
            int r1 = com.huobi.trade.helper.f0.h(r6, r1)
            r12.setTextColor(r1)
        L_0x05a2:
            java.lang.String r1 = r35.d()
            r12.setText(r1)
            java.lang.String r1 = r35.d()
            int r1 = com.hbg.lib.core.util.w.k(r1)
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r1)
            if (r4 == 0) goto L_0x05ba
            r4.setColor(r1)
        L_0x05ba:
            android.view.ViewGroup$LayoutParams r1 = r12.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            if (r9 != 0) goto L_0x05e3
            if (r15 == 0) goto L_0x05c5
            goto L_0x05e3
        L_0x05c5:
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            com.hbg.lib.common.utils.ViewUtil.m(r12, r4)
            r0 = 1086324736(0x40c00000, float:6.0)
            int r0 = com.hbg.lib.common.utils.PixelUtils.a(r0)
            r1.leftMargin = r0
            r12.setLayoutParams(r1)
            android.graphics.drawable.Drawable r0 = r12.getBackground()
            r1 = 25
            r0.setAlpha(r1)
            r1 = r4
            goto L_0x066a
        L_0x05e3:
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r4 = r35.g()
            java.lang.String r4 = r4.getContractBusinessTypeTag()
            r0.setText(r4)
            int r4 = androidx.core.content.ContextCompat.getColor(r6, r11)
            r0.setTextColor(r4)
            if (r3 == 0) goto L_0x0602
            int r0 = androidx.core.content.ContextCompat.getColor(r6, r2)
            r3.setColor(r0)
        L_0x0602:
            r0 = 0
            int r0 = com.hbg.lib.common.utils.PixelUtils.a(r0)
            r1.leftMargin = r0
            android.graphics.drawable.Drawable r0 = r12.getBackground()
            r1 = 0
            r0.setAlpha(r1)
            goto L_0x066a
        L_0x0612:
            if (r18 != 0) goto L_0x061f
            if (r8 != 0) goto L_0x061f
            if (r27 != 0) goto L_0x061f
            if (r26 == 0) goto L_0x061b
            goto L_0x061f
        L_0x061b:
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
            goto L_0x066a
        L_0x061f:
            if (r9 != 0) goto L_0x064b
            if (r15 == 0) goto L_0x0624
            goto L_0x064b
        L_0x0624:
            if (r16 == 0) goto L_0x0646
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.lang.String r1 = r1.getSymbol()
            java.lang.String r1 = yl.p.b(r1)
            boolean r4 = com.alibaba.android.arouter.utils.TextUtils.c(r1)
            if (r4 == 0) goto L_0x063d
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            goto L_0x065a
        L_0x063d:
            r4 = 0
            r5 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r0, r5)
            r0.setText(r1)
            goto L_0x065a
        L_0x0646:
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            goto L_0x065a
        L_0x064b:
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.lang.String r1 = r1.getContractBusinessTypeTag()
            r0.setText(r1)
        L_0x065a:
            int r1 = androidx.core.content.ContextCompat.getColor(r6, r11)
            r0.setTextColor(r1)
            if (r3 == 0) goto L_0x066a
            int r0 = androidx.core.content.ContextCompat.getColor(r6, r2)
            r3.setColor(r0)
        L_0x066a:
            r0 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r1 = androidx.core.content.res.ResourcesCompat.h(r6, r0)
            r2 = r28
            r2.setTypeface(r1)
            android.graphics.Typeface r1 = androidx.core.content.res.ResourcesCompat.h(r6, r0)
            r3 = r36
            r3.setTypeface(r1)
            android.graphics.Typeface r0 = androidx.core.content.res.ResourcesCompat.h(r6, r0)
            r7.setTypeface(r0)
            r0 = 2131430404(0x7f0b0c04, float:1.8482508E38)
            r1 = r17
            android.view.View r0 = r1.b(r0)
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.util.ArrayList r1 = r1.getTags()
            r3 = 1096810496(0x41600000, float:14.0)
            if (r1 == 0) goto L_0x06c7
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r1 = r35.g()
            java.util.ArrayList r1 = r1.getTags()
            java.lang.String r4 = "zerofee"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x06c7
            r1 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r0, r1)
            java.lang.CharSequence r0 = r2.getText()
            if (r0 == 0) goto L_0x06c2
            java.lang.CharSequence r0 = r2.getText()
            int r0 = r0.length()
            r4 = 7
            if (r0 <= r4) goto L_0x06c2
            r3 = 1094713344(0x41400000, float:12.0)
        L_0x06c2:
            r2.setTextSize(r1, r3)
            r4 = 0
            goto L_0x06cf
        L_0x06c7:
            r1 = 1
            r4 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r0, r4)
            r2.setTextSize(r1, r3)
        L_0x06cf:
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r0 = r35.g()
            if (r0 == 0) goto L_0x06fa
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r0 = r35.g()
            int r0 = r0.getFlag()
            if (r0 != 0) goto L_0x06fa
            java.lang.String r0 = r35.h()
            boolean r0 = android.webkit.URLUtil.isValidUrl(r0)
            if (r0 == 0) goto L_0x06fa
            r8 = r34
            r8.setVisibility(r4)
            f6.c r0 = f6.c.a()
            java.lang.String r1 = r35.h()
            r0.f(r8, r1, r4)
            goto L_0x0701
        L_0x06fa:
            r8 = r34
            r0 = 8
            r8.setVisibility(r0)
        L_0x0701:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.viewhandler.RankDynamicItemHandler.handleView(v9.c, int, com.huobi.index.bean.RankDynamicItem, android.view.ViewGroup):void");
    }

    public void c(a aVar) {
        this.f74421f = aVar;
    }

    public int getResId() {
        return R.layout.index_rankling_list_item_container;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        TradeType tradeType;
        View view2 = view;
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(j.c(), R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        RankDynamicItem rankDynamicItem = (RankDynamicItem) view2.getTag(R.id.item_data);
        boolean z11 = rankDynamicItem.i() == 6 || rankDynamicItem.i() == 1;
        boolean z12 = rankDynamicItem.i() == 4;
        boolean z13 = rankDynamicItem.i() == 7;
        boolean z14 = rankDynamicItem.i() == 8;
        boolean z15 = rankDynamicItem.i() == 2;
        boolean z16 = rankDynamicItem.i() == 5;
        boolean z17 = rankDynamicItem.i() == 9;
        RankScreenBean h11 = t.h();
        String str5 = "";
        String screenValue = h11 != null ? h11.getScreenValue() : str5;
        boolean equals = RankScreenBean.SCREEN_VALUE_USDT_SWAP.equals(screenValue);
        boolean equals2 = RankScreenBean.SCREEN_VALUE_SYMBOL_SWAP.equals(screenValue);
        boolean equals3 = RankScreenBean.SCREEN_VALUE_FUTURE.equals(screenValue);
        if (rankDynamicItem.c() != null) {
            rankDynamicItem.c().getOnItemClickListener().onClick(view2);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        RankListItemBean g11 = rankDynamicItem.g();
        if (rankDynamicItem.l()) {
            str4 = g11.getSymbol();
            str3 = g11.getBaseCurrency();
            str = screenValue;
            str2 = g11.getSymbol();
        } else {
            StringBuilder sb2 = new StringBuilder();
            str = screenValue;
            sb2.append(g11.getCurrency().toLowerCase(Locale.US));
            sb2.append("ht");
            str4 = sb2.toString();
            str3 = g11.getCurrency();
            str2 = a1.v().K(str3);
        }
        if (a1.v().S(str4)) {
            k0.O(view.getContext(), str4, true);
        } else if (z13 || z14) {
            HBBaseWebActivity.showWebView(view.getContext(), g11.getJumpUrl(), str5, str5, false);
        } else if (!TextUtils.c(str2)) {
            if (z11 || z12 || z15 || z16 || z17) {
                TradeType tradeTypeBySymbol = TradeType.getTradeTypeBySymbol(g11.getSymbol());
                if (equals || (equals3 && tradeTypeBySymbol == TradeType.LINEAR_SWAP)) {
                    LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(g11.getSymbol());
                    if (n11 != null) {
                        FutureContractInfo futureContractInfo = new FutureContractInfo();
                        futureContractInfo.setSymbol(rankDynamicItem.getBaseCurrencyDisplayName());
                        futureContractInfo.setQuoteCurrency(rankDynamicItem.g().getQuoteCurrency());
                        futureContractInfo.setContractShortType(n11.getContractShortType());
                        futureContractInfo.setContractFace(n11.getContractFace());
                        futureContractInfo.setContractCode(n11.getContractCode());
                        futureContractInfo.setContractType(n11.getContractType());
                        f.G(view.getContext(), futureContractInfo);
                    } else {
                        f.E(view.getContext(), g11.getSymbol(), false, false, TradeType.LINEAR_SWAP);
                    }
                } else if (equals2 || (equals3 && tradeTypeBySymbol == TradeType.SWAP)) {
                    SwapCurrencyInfo h12 = SwapCurrencyInfoController.k().h(rankDynamicItem.getBaseCurrencyDisplayName());
                    if (h12 != null) {
                        h12.setSymbol(rankDynamicItem.getBaseCurrencyDisplayName());
                        h12.setContractShortType(g11.getSymbol());
                        f.I(view.getContext(), g11.getSymbol(), g11.getSymbol(), h12, TradeType.SWAP);
                    } else {
                        f.E(view.getContext(), g11.getSymbol(), false, false, TradeType.SWAP);
                    }
                } else if (!equals3 || tradeTypeBySymbol != (tradeType = TradeType.CONTRACT)) {
                    f.C(view.getContext(), str2, false, TradeType.PRO);
                } else {
                    ContractCurrencyInfo contractCurrencyInfo = new ContractCurrencyInfo();
                    contractCurrencyInfo.setSymbol(rankDynamicItem.getBaseCurrencyDisplayName());
                    contractCurrencyInfo.setContractCode(g11.getSymbol());
                    contractCurrencyInfo.setContractShortType(g11.getSymbol());
                    ContractCurrencyInfo b11 = ContractCurrencyUtils.b(g11.getSymbol());
                    if (b11 != null) {
                        contractCurrencyInfo.setContractFace(b11.getContractFace());
                        contractCurrencyInfo.setContractCode(b11.getContractCode());
                    }
                    MarketModuleConfig.a().a0(view.getContext(), contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo, tradeType);
                }
            } else {
                f.C(view.getContext(), str2, false, TradeType.PRO);
            }
        }
        HashMap hashMap = new HashMap();
        if (rankDynamicItem.l()) {
            if (str2 == null) {
                str2 = str5;
            }
            hashMap.put("token", str2);
        } else {
            if (str3 == null) {
                str3 = str5;
            }
            hashMap.put("token", str3);
        }
        hashMap.put("list_type", Integer.valueOf(rankDynamicItem.i()));
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        if (t.i()) {
            if (!TextUtils.c(str)) {
                str5 = str;
            }
            hashMap.put("select_type", str5);
        } else {
            hashMap.put("select_type", str5);
        }
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_token_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
