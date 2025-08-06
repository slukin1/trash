package com.huobi.search.viewhandler;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.search.bean.NewSearchItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gr.d;
import gr.e;
import gr.f;
import gs.g;
import i6.k;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import s9.c;
import sn.t;
import us.j;

public class SearchRecommendItemHandler implements c {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80794a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f80794a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f80794a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f80794a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f80794a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.search.viewhandler.SearchRecommendItemHandler.a.<clinit>():void");
        }
    }

    public static /* synthetic */ void j(Context context, NewSearchItem newSearchItem, Object obj) {
        HuobiToastUtil.v(context.getString(R.string.market_delete_collection_success));
        EventBus.d().k(newSearchItem);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(String str, int i11, View view) {
        NewSearchItem newSearchItem = (NewSearchItem) view.getTag();
        fr.a.d(newSearchItem.getBaseCoin());
        o(newSearchItem);
        h(view.getContext(), newSearchItem);
        String str2 = "Top_Searches";
        if (!newSearchItem.getRecommendType().equalsIgnoreCase(NewSearchItem.RECOMMEND_SEARCH)) {
            if (newSearchItem.getRecommendType().equalsIgnoreCase(NewSearchItem.RECOMMEND_BUY)) {
                str2 = "Top_Purchase";
            } else if (newSearchItem.getRecommendType().equalsIgnoreCase(NewSearchItem.RECOMMEND_CURRENCY)) {
                str2 = "Top_New_coins";
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("List_type", str2);
        hashMap.put("Token", str);
        hashMap.put("Token_site", String.valueOf(i11 + 1));
        g.i("Search_List_token_click", hashMap);
        k.o("NewSearch", "Search_List_token_click:" + hashMap.toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(String str, CheckBox checkBox, String str2, NewSearchItem newSearchItem, boolean z11, Throwable th2) {
        if (z11) {
            g(str, checkBox.getContext(), str2, newSearchItem);
        }
    }

    public static /* synthetic */ void m(CheckBox checkBox, NewSearchItem newSearchItem, Object obj) {
        HuobiToastUtil.v(checkBox.getContext().getString(R.string.market_add_collection_success));
        EventBus.d().k(newSearchItem);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(String str, String str2, View view) {
        NewSearchItem newSearchItem = (NewSearchItem) view.getTag();
        CheckBox checkBox = (CheckBox) view;
        if (t.w(str)) {
            t.o(str, new f(this, str, checkBox, str2, newSearchItem));
        } else {
            t.i(str, checkBox.getContext(), str2).compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new e(checkBox, newSearchItem)));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void g(String str, Context context, String str2, NewSearchItem newSearchItem) {
        t.l(str, context, str2).compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new d(context, newSearchItem)));
    }

    public int getResId() {
        return R.layout.item_search_list_recommend;
    }

    public final void h(Context context, NewSearchItem newSearchItem) {
        TradeType tradeType = newSearchItem.getTradeType();
        TradeType tradeType2 = TradeType.SWAP;
        if (tradeType == tradeType2) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(newSearchItem.getContractShortType());
            j.f(c11.getSymbol(), context);
            sn.f.I(context, c11.getSymbol(), c11.getContractCode(), c11, tradeType2);
            return;
        }
        TradeType tradeType3 = newSearchItem.getTradeType();
        TradeType tradeType4 = TradeType.PRO;
        if (tradeType3 == tradeType4) {
            sn.f.C(context, newSearchItem.getSymbol(), false, tradeType4);
        } else if (newSearchItem.getTradeType() == TradeType.LINEAR_SWAP) {
            FutureContractInfo o11 = FutureContractInfoController.n().o(newSearchItem.getContractCode());
            a7.e.l(context, o11.getSymbol(), StringUtils.i(o11.getQuoteCurrency()));
            sn.f.G(context, o11);
        } else {
            TradeType tradeType5 = newSearchItem.getTradeType();
            TradeType tradeType6 = TradeType.CONTRACT;
            if (tradeType5 == tradeType6) {
                ContractCurrencyInfo b11 = ContractCurrencyUtils.b(newSearchItem.getContractShortType());
                ej.g.c(b11.getContractShortType());
                sn.f.z(context, b11.getSymbol(), b11.getContractCode(), b11, tradeType6);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0434  */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r20, int r21, com.huobi.search.bean.NewSearchItem r22, android.view.ViewGroup r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            i6.r r4 = r20.e()
            android.view.View r5 = r1.itemView
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131431324(0x7f0b0f9c, float:1.8484374E38)
            android.view.View r6 = r4.b(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r6 = 2131431323(0x7f0b0f9b, float:1.8484372E38)
            android.view.View r6 = r4.b(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r7 = 2131431182(0x7f0b0f0e, float:1.8484086E38)
            android.view.View r7 = r4.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131431191(0x7f0b0f17, float:1.8484104E38)
            android.view.View r8 = r4.b(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r9 = 2131431192(0x7f0b0f18, float:1.8484106E38)
            android.view.View r9 = r4.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131431197(0x7f0b0f1d, float:1.8484116E38)
            android.view.View r10 = r4.b(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r11 = 2131431189(0x7f0b0f15, float:1.84841E38)
            android.view.View r11 = r4.b(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r12 = 2131431195(0x7f0b0f1b, float:1.8484112E38)
            android.view.View r12 = r4.b(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r13 = 2131431193(0x7f0b0f19, float:1.8484108E38)
            android.view.View r13 = r4.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131431336(0x7f0b0fa8, float:1.8484398E38)
            android.view.View r14 = r4.b(r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            r15 = 2131431305(0x7f0b0f89, float:1.8484335E38)
            android.view.View r4 = r4.b(r15)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r15 = r2 + 1
            java.lang.String r15 = java.lang.String.valueOf(r15)
            r9.setText(r15)
            r15 = 0
            if (r2 != 0) goto L_0x0092
            r17 = r14
            r14 = 2131234763(0x7f080fcb, float:1.80857E38)
            r8.setImageResource(r14)
            r8.setVisibility(r15)
            r14 = 8
            r9.setVisibility(r14)
            goto L_0x00c0
        L_0x0092:
            r17 = r14
            r14 = 1
            if (r2 != r14) goto L_0x00a6
            r14 = 2131234764(0x7f080fcc, float:1.8085703E38)
            r8.setImageResource(r14)
            r8.setVisibility(r15)
            r14 = 8
            r9.setVisibility(r14)
            goto L_0x00c0
        L_0x00a6:
            r14 = 2
            if (r2 != r14) goto L_0x00b8
            r14 = 2131234765(0x7f080fcd, float:1.8085705E38)
            r8.setImageResource(r14)
            r8.setVisibility(r15)
            r14 = 8
            r9.setVisibility(r14)
            goto L_0x00c0
        L_0x00b8:
            r14 = 8
            r8.setVisibility(r14)
            r9.setVisibility(r15)
        L_0x00c0:
            com.hbg.lib.data.symbol.TradeType r8 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r9 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            java.lang.String r14 = ""
            if (r8 != r9) goto L_0x0142
            java.lang.String r8 = r22.getSymbolName()
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x013b
            java.lang.String r8 = r22.getSymbolName()
            int r15 = r8.length()
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r8)
            android.text.style.ForegroundColorSpan r8 = new android.text.style.ForegroundColorSpan
            r2 = 2131099907(0x7f060103, float:1.781218E38)
            int r3 = r5.getColor(r2)
            r8.<init>(r3)
            r2 = 33
            r3 = 0
            r0.setSpan(r8, r3, r15, r2)
            int r8 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r8 < r2) goto L_0x0112
            android.text.style.TypefaceSpan r2 = new android.text.style.TypefaceSpan
            android.view.View r8 = r1.itemView
            android.content.Context r8 = r8.getContext()
            r3 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r3 = androidx.core.content.res.ResourcesCompat.h(r8, r3)
            r2.<init>(r3)
            r3 = 33
            r8 = 0
            r0.setSpan(r2, r8, r15, r3)
            goto L_0x0115
        L_0x0112:
            r8 = r3
            r3 = 33
        L_0x0115:
            android.text.style.AbsoluteSizeSpan r2 = new android.text.style.AbsoluteSizeSpan
            r3 = 2131166387(0x7f0704b3, float:1.7947018E38)
            int r3 = r5.getDimensionPixelSize(r3)
            r2.<init>(r3)
            r3 = 33
            r0.setSpan(r2, r8, r15, r3)
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            r3 = 2131099907(0x7f060103, float:1.781218E38)
            int r3 = r5.getColor(r3)
            r2.<init>(r3)
            r3 = 33
            r0.setSpan(r2, r8, r15, r3)
            r7.setText(r0)
            goto L_0x013e
        L_0x013b:
            r7.setText(r14)
        L_0x013e:
            r18 = r6
            goto L_0x023a
        L_0x0142:
            com.hbg.lib.data.symbol.TradeType r0 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.SWAP
            if (r0 == r2) goto L_0x01c5
            com.hbg.lib.data.symbol.TradeType r0 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            if (r0 != r2) goto L_0x0153
            goto L_0x01c5
        L_0x0153:
            java.lang.String r0 = r22.getSymbolName()
            java.lang.String r2 = "/"
            int r3 = r0.indexOf(r2)
            r8 = -1
            if (r8 == r3) goto L_0x013e
            java.lang.String r8 = " /"
            java.lang.String r0 = r0.replace(r2, r8)
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            r8 = 2131099907(0x7f060103, float:1.781218E38)
            int r15 = r5.getColor(r8)
            r0.<init>(r15)
            r8 = 33
            r15 = 0
            r2.setSpan(r0, r15, r3, r8)
            int r0 = android.os.Build.VERSION.SDK_INT
            r8 = 28
            if (r0 < r8) goto L_0x019c
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            android.view.View r8 = r1.itemView
            android.content.Context r8 = r8.getContext()
            r15 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r8 = androidx.core.content.res.ResourcesCompat.h(r8, r15)
            r0.<init>(r8)
            r8 = 33
            r15 = 0
            r2.setSpan(r0, r15, r3, r8)
            goto L_0x019e
        L_0x019c:
            r8 = 33
        L_0x019e:
            android.text.style.AbsoluteSizeSpan r0 = new android.text.style.AbsoluteSizeSpan
            r8 = 2131166387(0x7f0704b3, float:1.7947018E38)
            int r8 = r5.getDimensionPixelSize(r8)
            r0.<init>(r8)
            r8 = 33
            r2.setSpan(r0, r15, r3, r8)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            r8 = 2131099907(0x7f060103, float:1.781218E38)
            int r5 = r5.getColor(r8)
            r0.<init>(r5)
            r5 = 33
            r2.setSpan(r0, r15, r3, r5)
            r7.setText(r2)
            goto L_0x013e
        L_0x01c5:
            r15 = 0
            r0 = 2132023186(0x7f141792, float:1.9684813E38)
            java.lang.String r0 = r5.getString(r0)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r2 = r22.getSymbol()
            java.util.Locale r8 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toUpperCase(r8)
            r3[r15] = r2
            java.lang.String r0 = java.lang.String.format(r0, r3)
            int r2 = r0.length()
            android.text.SpannableString r3 = new android.text.SpannableString
            r3.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            r18 = r6
            r8 = 2131099907(0x7f060103, float:1.781218E38)
            int r6 = r5.getColor(r8)
            r0.<init>(r6)
            r6 = 33
            r3.setSpan(r0, r15, r2, r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r8 = 28
            if (r0 < r8) goto L_0x0219
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            android.view.View r8 = r1.itemView
            android.content.Context r8 = r8.getContext()
            r6 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r6 = androidx.core.content.res.ResourcesCompat.h(r8, r6)
            r0.<init>(r6)
            r6 = 33
            r3.setSpan(r0, r15, r2, r6)
        L_0x0219:
            android.text.style.AbsoluteSizeSpan r0 = new android.text.style.AbsoluteSizeSpan
            r8 = 2131166387(0x7f0704b3, float:1.7947018E38)
            int r8 = r5.getDimensionPixelSize(r8)
            r0.<init>(r8)
            r3.setSpan(r0, r15, r2, r6)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            r8 = 2131099907(0x7f060103, float:1.781218E38)
            int r5 = r5.getColor(r8)
            r0.<init>(r5)
            r3.setSpan(r0, r15, r2, r6)
            r7.setText(r3)
        L_0x023a:
            com.hbg.lib.data.symbol.TradeType r0 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.SWAP
            r3 = 4
            if (r0 != r2) goto L_0x0249
            java.lang.String r0 = "USD"
            r10.setText(r0)
            goto L_0x0260
        L_0x0249:
            com.hbg.lib.data.symbol.TradeType r0 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            if (r0 != r2) goto L_0x0257
            java.lang.String r0 = "USDT"
            r10.setText(r0)
            goto L_0x0260
        L_0x0257:
            com.hbg.lib.data.symbol.TradeType r0 = r22.getTradeType()
            if (r0 != r9) goto L_0x0260
            r10.setVisibility(r3)
        L_0x0260:
            int[] r0 = com.huobi.search.viewhandler.SearchRecommendItemHandler.a.f80794a
            com.hbg.lib.data.symbol.TradeType r2 = r22.getTradeType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r5 = 3
            java.lang.String r6 = "--"
            r7 = 1
            if (r2 == r7) goto L_0x031f
            r7 = 2
            if (r2 == r7) goto L_0x02f1
            if (r2 == r5) goto L_0x02c3
            if (r2 == r3) goto L_0x027b
            goto L_0x034e
        L_0x027b:
            java.lang.Double r2 = r22.getClose()
            if (r2 == 0) goto L_0x02be
            java.lang.String r2 = r22.getContractCode()
            java.lang.String r7 = r22.getContractShortType()
            int r2 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r2, r7, r14)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "marketUSDPrecision = "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            i6.d.b(r7)
            java.lang.Double r7 = r22.getClose()
            double r7 = r7.doubleValue()
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r7)
            java.math.BigDecimal r7 = r7.stripTrailingZeros()
            java.lang.String r7 = r7.toPlainString()
            java.lang.String r2 = i6.m.m(r7, r2)
            r12.setText(r2)
            goto L_0x034e
        L_0x02be:
            r12.setText(r6)
            goto L_0x034e
        L_0x02c3:
            java.lang.Double r2 = r22.getClose()
            if (r2 == 0) goto L_0x02ed
            java.lang.String r2 = r22.getSymbol()
            int r2 = us.i.o(r2)
            java.lang.Double r7 = r22.getClose()
            double r7 = r7.doubleValue()
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r7)
            java.math.BigDecimal r7 = r7.stripTrailingZeros()
            java.lang.String r7 = r7.toPlainString()
            java.lang.String r2 = i6.m.m(r7, r2)
            r12.setText(r2)
            goto L_0x034e
        L_0x02ed:
            r12.setText(r6)
            goto L_0x034e
        L_0x02f1:
            java.lang.Double r2 = r22.getClose()
            if (r2 == 0) goto L_0x031b
            java.lang.String r2 = r22.getContractCode()
            int r2 = ej.f.p(r2)
            java.lang.Double r7 = r22.getClose()
            double r7 = r7.doubleValue()
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r7)
            java.math.BigDecimal r7 = r7.stripTrailingZeros()
            java.lang.String r7 = r7.toPlainString()
            java.lang.String r2 = i6.m.m(r7, r2)
            r12.setText(r2)
            goto L_0x034e
        L_0x031b:
            r12.setText(r6)
            goto L_0x034e
        L_0x031f:
            java.lang.Double r2 = r22.getClose()
            if (r2 == 0) goto L_0x034a
            java.lang.String r2 = r22.getSymbol()
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.g(r2)
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.x(r2)
            java.lang.Double r7 = r22.getClose()
            double r7 = r7.doubleValue()
            java.math.BigDecimal r7 = java.math.BigDecimal.valueOf(r7)
            java.math.BigDecimal r7 = r7.stripTrailingZeros()
            java.lang.String r7 = r7.toPlainString()
            java.lang.String r2 = i6.m.m(r7, r2)
            goto L_0x034b
        L_0x034a:
            r2 = r6
        L_0x034b:
            r12.setText(r2)
        L_0x034e:
            java.lang.Double r2 = r22.getClose()
            if (r2 == 0) goto L_0x040b
            java.lang.Double r2 = r22.getClose()
            double r7 = r2.doubleValue()
            r9 = 0
            int r2 = java.lang.Double.compare(r7, r9)
            if (r2 == 0) goto L_0x040b
            java.lang.Double r2 = r22.getIncrease()
            if (r2 == 0) goto L_0x03d0
            java.lang.Double r2 = r22.getIncrease()
            double r6 = r2.doubleValue()
            int r2 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            r6 = 2131100372(0x7f0602d4, float:1.7813124E38)
            r7 = 2131100475(0x7f06033b, float:1.7813332E38)
            if (r2 <= 0) goto L_0x0398
            boolean r2 = com.hbg.lib.core.util.w.l()
            if (r2 == 0) goto L_0x038d
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r6)
            goto L_0x03cd
        L_0x038d:
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
            goto L_0x03cd
        L_0x0398:
            java.lang.Double r2 = r22.getIncrease()
            double r15 = r2.doubleValue()
            int r2 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x03c0
            boolean r2 = com.hbg.lib.core.util.w.l()
            if (r2 == 0) goto L_0x03b5
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r7)
            goto L_0x03cd
        L_0x03b5:
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r6)
            goto L_0x03cd
        L_0x03c0:
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            r2 = 2131100395(0x7f0602eb, float:1.781317E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
        L_0x03cd:
            r13.setTextColor(r1)
        L_0x03d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Double r2 = r22.getIncrease()
            double r6 = r2.doubleValue()
            int r2 = java.lang.Double.compare(r6, r9)
            if (r2 <= 0) goto L_0x03e5
            java.lang.String r14 = "+"
        L_0x03e5:
            r1.append(r14)
            java.lang.Double r2 = r22.getIncrease()
            double r6 = r2.doubleValue()
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r6 * r8
            java.lang.String r2 = r22.getSymbol()
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r2 = i6.m.i(r6, r2)
            r1.append(r2)
            java.lang.String r2 = "%"
            r1.append(r2)
            java.lang.String r6 = r1.toString()
        L_0x040b:
            r13.setText(r6)
            java.lang.String r1 = r22.getLeverageRatio()
            if (r1 == 0) goto L_0x0434
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x041b
            goto L_0x0434
        L_0x041b:
            r2 = 0
            r11.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "X"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r11.setText(r1)
            goto L_0x0437
        L_0x0434:
            r11.setVisibility(r3)
        L_0x0437:
            com.hbg.lib.data.symbol.TradeType r1 = r22.getTradeType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            if (r0 == r1) goto L_0x045d
            if (r0 == r5) goto L_0x0456
            if (r0 == r3) goto L_0x044f
            java.lang.String r0 = r22.getSymbol()
            java.lang.String r1 = "PRO"
            goto L_0x0463
        L_0x044f:
            java.lang.String r0 = r22.getContractShortType()
            java.lang.String r1 = "LINEAR_SWAP"
            goto L_0x0463
        L_0x0456:
            java.lang.String r0 = r22.getContractShortType()
            java.lang.String r1 = "CONTRACT_SWAP"
            goto L_0x0463
        L_0x045d:
            java.lang.String r0 = r22.getContractShortType()
            java.lang.String r1 = "CONTRACT"
        L_0x0463:
            com.hbg.lib.data.symbol.TradeType r2 = r22.getTradeType()
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO
            if (r2 != r3) goto L_0x0495
            java.lang.String r2 = r22.getState()
            if (r2 == 0) goto L_0x0495
            java.lang.String r2 = r22.getState()
            java.lang.String r3 = "pre-online"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0495
            long r2 = r22.getTradeOpenAt()
            long r5 = com.hbg.lib.common.utils.DateTimeUtils.v()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0495
            r2 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r4, r2)
            r3 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r12, r3)
            com.hbg.lib.common.utils.ViewUtil.m(r13, r3)
            goto L_0x04a0
        L_0x0495:
            r2 = 1
            r3 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r12, r2)
            com.hbg.lib.common.utils.ViewUtil.m(r13, r2)
            com.hbg.lib.common.utils.ViewUtil.m(r4, r3)
        L_0x04a0:
            r2 = r22
            r6 = r18
            r6.setTag(r2)
            gr.b r3 = new gr.b
            r4 = r19
            r5 = r21
            r3.<init>(r4, r0, r5)
            r6.setOnClickListener(r3)
            r14 = r17
            r14.setTag(r2)
            boolean r2 = sn.t.w(r0)
            r14.setChecked(r2)
            gr.c r2 = new gr.c
            r2.<init>(r4, r0, r1)
            r14.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.search.viewhandler.SearchRecommendItemHandler.handleView(v9.c, int, com.huobi.search.bean.NewSearchItem, android.view.ViewGroup):void");
    }

    public final void o(NewSearchItem newSearchItem) {
        if (newSearchItem.getTradeType() == TradeType.SWAP) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractShortType());
        } else if (newSearchItem.getTradeType() == TradeType.PRO) {
            br.c.g(bh.j.c()).m("1", String.format("%s/%s", new Object[]{newSearchItem.getBaseCoin(), newSearchItem.getQuoteCoin()}));
        } else if (newSearchItem.getTradeType() == TradeType.LINEAR_SWAP) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractShortType());
        } else if (newSearchItem.getTradeType() == TradeType.CONTRACT) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractShortType());
        }
    }
}
