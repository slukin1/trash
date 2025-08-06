package com.hbg.module.content.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.utls.g;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import lc.c0;
import nc.c;

public final class CoinTagViewV2 extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public c0 f17963b;

    public static final class a extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17965c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformationCoinTags f17966d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17969g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f17970h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CoinTagViewV2 f17971i;

        public a(String str, String str2, NewFlashInformationCoinTags newFlashInformationCoinTags, String str3, int i11, String str4, d10.a<Unit> aVar, CoinTagViewV2 coinTagViewV2) {
            this.f17964b = str;
            this.f17965c = str2;
            this.f17966d = newFlashInformationCoinTags;
            this.f17967e = str3;
            this.f17968f = i11;
            this.f17969g = str4;
            this.f17970h = aVar;
            this.f17971i = coinTagViewV2;
        }

        public void onViewClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("contentid", this.f17964b);
            hashMap.put("title", this.f17965c);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f17966d.getCoin());
            hashMap.put("style_type", "News");
            String str = this.f17967e;
            if (str != null) {
                hashMap.put("category", str);
            }
            hashMap.put("translate", Integer.valueOf(this.f17968f));
            String str2 = this.f17969g;
            switch (str2.hashCode()) {
                case 53:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC)) {
                        hashMap.put("currency_tag_state", "app_huobiNews_details");
                        break;
                    }
                    break;
                case 54:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                        hashMap.put("currency_tag_state", "app_favorites_news");
                        break;
                    }
                    break;
                case 55:
                    if (str2.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                        hashMap.put("currency_tag_state", "app_news_news");
                        break;
                    }
                    break;
                case 56:
                    if (str2.equals("8")) {
                        hashMap.put("currency_tag_state", "app_kline_news");
                        break;
                    }
                    break;
            }
            c.a("app_currency_tag_click", hashMap);
            d10.a<Unit> aVar = this.f17970h;
            if (aVar != null) {
                aVar.invoke();
            }
            g.f18913a.a(this.f17971i.getContext(), this.f17966d.getSymbol(), false, TradeType.PRO, this.f17969g);
        }
    }

    public CoinTagViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public CoinTagViewV2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c0 K = c0.K(LayoutInflater.from(context));
        this.f17963b = K;
        addView(K.getRoot());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, java.lang.String r22, d10.a<kotlin.Unit> r23, java.lang.String r24, int r25, boolean r26) {
        /*
            r16 = this;
            r9 = r16
            r0 = 1
            r1 = 0
            r2 = 1094713344(0x41400000, float:12.0)
            if (r26 == 0) goto L_0x0047
            int r3 = r24.length()
            if (r3 <= 0) goto L_0x0010
            r3 = r0
            goto L_0x0011
        L_0x0010:
            r3 = r1
        L_0x0011:
            if (r3 == 0) goto L_0x0047
            r3 = 1090519040(0x41000000, float:8.0)
            int r3 = com.hbg.module.libkt.base.ext.c.a(r3)
            int r2 = com.hbg.module.libkt.base.ext.c.a(r2)
            lc.c0 r4 = r9.f17963b
            android.widget.LinearLayout r4 = r4.C
            r4.setPadding(r2, r3, r2, r3)
            lc.c0 r2 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r2 = r2.D
            r3 = 1096810496(0x41600000, float:14.0)
            r2.setTextSize(r3)
            lc.c0 r2 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r2 = r2.E
            r2.setTextSize(r3)
            lc.c0 r2 = r9.f17963b
            androidx.appcompat.widget.AppCompatImageView r2 = r2.B
            r3 = r24
            r4 = r25
            com.hbg.module.libkt.base.ext.b.C(r2, r3, r4)
            lc.c0 r2 = r9.f17963b
            androidx.appcompat.widget.AppCompatImageView r2 = r2.B
            r2.setVisibility(r1)
            goto L_0x0071
        L_0x0047:
            r3 = 1086324736(0x40c00000, float:6.0)
            int r3 = com.hbg.module.libkt.base.ext.c.a(r3)
            r4 = 1092616192(0x41200000, float:10.0)
            int r4 = com.hbg.module.libkt.base.ext.c.a(r4)
            lc.c0 r5 = r9.f17963b
            android.widget.LinearLayout r5 = r5.C
            r5.setPadding(r4, r3, r4, r3)
            lc.c0 r3 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r3 = r3.D
            r3.setTextSize(r2)
            lc.c0 r3 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r3 = r3.E
            r3.setTextSize(r2)
            lc.c0 r2 = r9.f17963b
            androidx.appcompat.widget.AppCompatImageView r2 = r2.B
            r3 = 8
            r2.setVisibility(r3)
        L_0x0071:
            sl.f0 r2 = sl.f0.g()
            java.lang.String r3 = r17.getSymbol()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r2 = r2.h(r3)
            r3 = 0
            if (r2 == 0) goto L_0x0085
            java.lang.Double r4 = r2.getClose()
            goto L_0x0086
        L_0x0085:
            r4 = r3
        L_0x0086:
            r5 = 0
            if (r4 != 0) goto L_0x008c
            r7 = r5
            goto L_0x0090
        L_0x008c:
            double r7 = r4.doubleValue()
        L_0x0090:
            if (r2 == 0) goto L_0x0096
            java.lang.Double r3 = r2.getOpen()
        L_0x0096:
            if (r3 != 0) goto L_0x009a
            r2 = r5
            goto L_0x009e
        L_0x009a:
            double r2 = r3.doubleValue()
        L_0x009e:
            double r7 = r7 - r2
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r0 = r1
        L_0x00a5:
            java.lang.String r1 = "0.00%"
            if (r0 == 0) goto L_0x00ad
            r3 = r17
            r0 = r1
            goto L_0x00ba
        L_0x00ad:
            double r7 = r7 / r2
            java.lang.String r0 = ""
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.v(r0)
            java.lang.String r0 = i6.m.S(r7, r0)
            r3 = r17
        L_0x00ba:
            r3.setPercent(r0)
            lc.c0 r0 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r0 = r0.E
            java.lang.String r2 = r17.getPercent()
            r0.setText(r2)
            lc.c0 r0 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r0 = r0.D
            java.lang.String r2 = r17.getCoin()
            r0.setText(r2)
            java.lang.String r10 = r17.getPercent()
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            java.lang.String r11 = "--"
            int r0 = kotlin.text.StringsKt__StringsKt.g0(r10, r11, r12, r13, r14, r15)
            if (r0 == 0) goto L_0x0116
            java.lang.String r0 = r17.getPercent()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ee
            goto L_0x0116
        L_0x00ee:
            java.lang.String r10 = r17.getPercent()
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            java.lang.String r11 = "-"
            int r0 = kotlin.text.StringsKt__StringsKt.g0(r10, r11, r12, r13, r14, r15)
            if (r0 != 0) goto L_0x010a
            boolean r0 = com.hbg.lib.core.util.w.l()
            if (r0 == 0) goto L_0x0107
            int r0 = com.hbg.module.content.R$color.base_up_color
            goto L_0x0118
        L_0x0107:
            int r0 = com.hbg.module.content.R$color.base_down_color
            goto L_0x0118
        L_0x010a:
            boolean r0 = com.hbg.lib.core.util.w.l()
            if (r0 == 0) goto L_0x0113
            int r0 = com.hbg.module.content.R$color.base_down_color
            goto L_0x0118
        L_0x0113:
            int r0 = com.hbg.module.content.R$color.base_up_color
            goto L_0x0118
        L_0x0116:
            int r0 = com.hbg.module.content.R$color.baseColorDefaultPlaceholder
        L_0x0118:
            lc.c0 r1 = r9.f17963b
            androidx.appcompat.widget.AppCompatTextView r1 = r1.E
            android.content.res.Resources r2 = r16.getResources()
            int r0 = r2.getColor(r0)
            r1.setTextColor(r0)
            lc.c0 r0 = r9.f17963b
            android.widget.LinearLayout r10 = r0.C
            com.hbg.module.content.custom.CoinTagViewV2$a r11 = new com.hbg.module.content.custom.CoinTagViewV2$a
            r0 = r11
            r1 = r19
            r2 = r20
            r3 = r17
            r4 = r22
            r5 = r21
            r6 = r18
            r7 = r23
            r8 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.CoinTagViewV2.a(com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, d10.a, java.lang.String, int, boolean):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoinTagViewV2(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
