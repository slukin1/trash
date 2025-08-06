package com.huobi.search.viewhandler;

import a7.e;
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
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.search.bean.NewSearchItem;
import com.huobi.search.bean.SearchResultCategoryItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gr.i;
import gr.j;
import gs.g;
import i6.k;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import sn.f;
import sn.t;

public class SearchResultItemHandler implements c {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80795a;

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
                f80795a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f80795a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f80795a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f80795a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.search.viewhandler.SearchResultItemHandler.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(int i11, View view) {
        String str;
        SearchResultCategoryItem searchResultCategoryItem = (SearchResultCategoryItem) view.getTag();
        fr.a.d(searchResultCategoryItem.getBaseCoin());
        n(searchResultCategoryItem);
        g(view.getContext(), searchResultCategoryItem);
        if (searchResultCategoryItem.getResultType().equalsIgnoreCase("pro")) {
            str = "Spot";
        } else if (searchResultCategoryItem.getResultType().equalsIgnoreCase("margin")) {
            str = "Margin";
        } else if (searchResultCategoryItem.getResultType().equalsIgnoreCase("contract")) {
            str = "Futures";
        } else {
            searchResultCategoryItem.getResultType().equalsIgnoreCase(TtmlNode.COMBINE_ALL);
            str = "All";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Result_type", str);
        hashMap.put("Result_site", String.valueOf(i11 + 1));
        g.i("Search_Result_click", hashMap);
        k.o("NewSearch", "Search_Result_click:" + hashMap.toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void k(String str, CheckBox checkBox, String str2, boolean z11, Throwable th2) {
        if (z11) {
            t.l(str, checkBox.getContext(), str2).compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new j(checkBox)));
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(String str, String str2, View view) {
        SearchResultCategoryItem searchResultCategoryItem = (SearchResultCategoryItem) view.getTag();
        CheckBox checkBox = (CheckBox) view;
        if (t.w(str)) {
            t.o(str, new gr.k(str, checkBox, str2));
        } else {
            t.i(str, checkBox.getContext(), str2).compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new i(checkBox)));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void g(Context context, SearchResultCategoryItem searchResultCategoryItem) {
        TradeType tradeType = searchResultCategoryItem.getTradeType();
        TradeType tradeType2 = TradeType.SWAP;
        if (tradeType == tradeType2) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(searchResultCategoryItem.getContractShortType());
            us.j.f(c11.getSymbol(), context);
            f.I(context, c11.getSymbol(), c11.getContractCode(), c11, tradeType2);
            return;
        }
        TradeType tradeType3 = searchResultCategoryItem.getTradeType();
        TradeType tradeType4 = TradeType.PRO;
        if (tradeType3 == tradeType4) {
            f.C(context, searchResultCategoryItem.getSymbol(), false, tradeType4);
        } else if (searchResultCategoryItem.getTradeType() == TradeType.LINEAR_SWAP) {
            FutureContractInfo o11 = FutureContractInfoController.n().o(searchResultCategoryItem.getContractCode());
            e.l(context, o11.getSymbol(), StringUtils.i(o11.getQuoteCurrency()));
            f.G(context, o11);
        } else {
            TradeType tradeType5 = searchResultCategoryItem.getTradeType();
            TradeType tradeType6 = TradeType.CONTRACT;
            if (tradeType5 == tradeType6) {
                ContractCurrencyInfo b11 = ContractCurrencyUtils.b(searchResultCategoryItem.getContractShortType());
                ej.g.c(b11.getContractShortType());
                f.z(context, b11.getSymbol(), b11.getContractCode(), b11, tradeType6);
            }
        }
    }

    public int getResId() {
        return R.layout.item_search_list_result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x03ae  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r19, int r20, com.huobi.search.bean.SearchResultCategoryItem r21, android.view.ViewGroup r22) {
        /*
            r18 = this;
            r0 = r19
            r1 = r21
            i6.r r2 = r19.e()
            android.view.View r3 = r0.itemView
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131431323(0x7f0b0f9b, float:1.8484372E38)
            android.view.View r4 = r2.b(r4)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r5 = 2131431182(0x7f0b0f0e, float:1.8484086E38)
            android.view.View r5 = r2.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131431197(0x7f0b0f1d, float:1.8484116E38)
            android.view.View r6 = r2.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131431189(0x7f0b0f15, float:1.84841E38)
            android.view.View r7 = r2.b(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r8 = 2131431195(0x7f0b0f1b, float:1.8484112E38)
            android.view.View r8 = r2.b(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 2131431193(0x7f0b0f19, float:1.8484108E38)
            android.view.View r9 = r2.b(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r10 = 2131431336(0x7f0b0fa8, float:1.8484398E38)
            android.view.View r10 = r2.b(r10)
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            r11 = 2131431305(0x7f0b0f89, float:1.8484335E38)
            android.view.View r2 = r2.b(r11)
            android.widget.TextView r2 = (android.widget.TextView) r2
            com.hbg.lib.data.symbol.TradeType r11 = r21.getTradeType()
            com.hbg.lib.data.symbol.TradeType r12 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            r14 = -1
            r13 = 2131099907(0x7f060103, float:1.781218E38)
            if (r11 == r12) goto L_0x00e0
            com.hbg.lib.data.symbol.TradeType r11 = r21.getTradeType()
            com.hbg.lib.data.symbol.TradeType r12 = com.hbg.lib.data.symbol.TradeType.SWAP
            if (r11 == r12) goto L_0x00e0
            com.hbg.lib.data.symbol.TradeType r11 = r21.getTradeType()
            com.hbg.lib.data.symbol.TradeType r12 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            if (r11 != r12) goto L_0x0073
            goto L_0x00e0
        L_0x0073:
            java.lang.String r11 = r21.getSymbolName()
            java.lang.String r12 = "/"
            int r15 = r11.indexOf(r12)
            if (r14 == r15) goto L_0x0149
            java.lang.String r14 = " /"
            java.lang.String r11 = r11.replace(r12, r14)
            android.text.SpannableString r12 = new android.text.SpannableString
            r12.<init>(r11)
            android.text.style.ForegroundColorSpan r11 = new android.text.style.ForegroundColorSpan
            int r14 = r3.getColor(r13)
            r11.<init>(r14)
            r13 = 0
            r14 = 33
            r12.setSpan(r11, r13, r15, r14)
            int r11 = android.os.Build.VERSION.SDK_INT
            r13 = 28
            if (r11 < r13) goto L_0x00b8
            android.text.style.TypefaceSpan r11 = new android.text.style.TypefaceSpan
            android.view.View r13 = r0.itemView
            android.content.Context r13 = r13.getContext()
            r14 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r13 = androidx.core.content.res.ResourcesCompat.h(r13, r14)
            r11.<init>(r13)
            r13 = 33
            r14 = 0
            r12.setSpan(r11, r14, r15, r13)
            goto L_0x00ba
        L_0x00b8:
            r13 = r14
            r14 = 0
        L_0x00ba:
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r13 = 2131166387(0x7f0704b3, float:1.7947018E38)
            int r13 = r3.getDimensionPixelSize(r13)
            r11.<init>(r13)
            r13 = 33
            r12.setSpan(r11, r14, r15, r13)
            android.text.style.ForegroundColorSpan r11 = new android.text.style.ForegroundColorSpan
            r13 = 2131099907(0x7f060103, float:1.781218E38)
            int r3 = r3.getColor(r13)
            r11.<init>(r3)
            r3 = 33
            r12.setSpan(r11, r14, r15, r3)
            r5.setText(r12)
            goto L_0x0149
        L_0x00e0:
            java.lang.String r11 = r21.getSymbolName()
            java.lang.String r12 = " "
            int r12 = r11.indexOf(r12)
            if (r14 == r12) goto L_0x0149
            android.text.SpannableString r13 = new android.text.SpannableString
            r13.<init>(r11)
            android.text.style.ForegroundColorSpan r11 = new android.text.style.ForegroundColorSpan
            r14 = 2131099907(0x7f060103, float:1.781218E38)
            int r15 = r3.getColor(r14)
            r11.<init>(r15)
            r14 = 33
            r15 = 0
            r13.setSpan(r11, r15, r12, r14)
            int r11 = android.os.Build.VERSION.SDK_INT
            r14 = 28
            if (r11 < r14) goto L_0x0122
            android.text.style.TypefaceSpan r11 = new android.text.style.TypefaceSpan
            android.view.View r14 = r0.itemView
            android.content.Context r14 = r14.getContext()
            r15 = 2131296262(0x7f090006, float:1.8210436E38)
            android.graphics.Typeface r14 = androidx.core.content.res.ResourcesCompat.h(r14, r15)
            r11.<init>(r14)
            r14 = 33
            r15 = 0
            r13.setSpan(r11, r15, r12, r14)
            goto L_0x0124
        L_0x0122:
            r14 = 33
        L_0x0124:
            android.text.style.AbsoluteSizeSpan r11 = new android.text.style.AbsoluteSizeSpan
            r14 = 2131166387(0x7f0704b3, float:1.7947018E38)
            int r14 = r3.getDimensionPixelSize(r14)
            r11.<init>(r14)
            r14 = 33
            r13.setSpan(r11, r15, r12, r14)
            android.text.style.ForegroundColorSpan r11 = new android.text.style.ForegroundColorSpan
            r14 = 2131099907(0x7f060103, float:1.781218E38)
            int r3 = r3.getColor(r14)
            r11.<init>(r3)
            r3 = 33
            r13.setSpan(r11, r15, r12, r3)
            r5.setText(r13)
        L_0x0149:
            com.hbg.lib.data.symbol.TradeType r3 = r21.getTradeType()
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO
            r11 = 1
            if (r3 != r5) goto L_0x016f
            java.lang.Object[] r3 = new java.lang.Object[r11]
            java.lang.String r12 = r21.getQuoteCoin()
            java.util.Locale r13 = java.util.Locale.ROOT
            java.lang.String r12 = r12.toUpperCase(r13)
            r13 = 0
            r3[r13] = r12
            java.lang.String r12 = "/%s"
            java.lang.String r3 = java.lang.String.format(r12, r3)
            r6.setText(r3)
            r3 = 8
            r6.setVisibility(r3)
        L_0x016f:
            int[] r3 = com.huobi.search.viewhandler.SearchResultItemHandler.a.f80795a
            com.hbg.lib.data.symbol.TradeType r6 = r21.getTradeType()
            int r6 = r6.ordinal()
            r6 = r3[r6]
            java.lang.String r12 = ""
            r13 = 3
            r14 = 2
            java.lang.String r15 = "--"
            if (r6 == r11) goto L_0x0230
            if (r6 == r14) goto L_0x0202
            if (r6 == r13) goto L_0x01d4
            r11 = 4
            if (r6 == r11) goto L_0x018c
            goto L_0x025f
        L_0x018c:
            java.lang.Double r6 = r21.getClose()
            if (r6 == 0) goto L_0x01cf
            java.lang.String r6 = r21.getContractCode()
            java.lang.String r11 = r21.getContractShortType()
            int r6 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r6, r11, r12)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "marketUSDPrecision = "
            r11.append(r13)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            i6.d.b(r11)
            java.lang.Double r11 = r21.getClose()
            double r16 = r11.doubleValue()
            java.math.BigDecimal r11 = java.math.BigDecimal.valueOf(r16)
            java.math.BigDecimal r11 = r11.stripTrailingZeros()
            java.lang.String r11 = r11.toPlainString()
            java.lang.String r6 = i6.m.m(r11, r6)
            r8.setText(r6)
            goto L_0x025f
        L_0x01cf:
            r8.setText(r15)
            goto L_0x025f
        L_0x01d4:
            java.lang.Double r6 = r21.getClose()
            if (r6 == 0) goto L_0x01fe
            java.lang.String r6 = r21.getSymbol()
            int r6 = us.i.o(r6)
            java.lang.Double r11 = r21.getClose()
            double r16 = r11.doubleValue()
            java.math.BigDecimal r11 = java.math.BigDecimal.valueOf(r16)
            java.math.BigDecimal r11 = r11.stripTrailingZeros()
            java.lang.String r11 = r11.toPlainString()
            java.lang.String r6 = i6.m.m(r11, r6)
            r8.setText(r6)
            goto L_0x025f
        L_0x01fe:
            r8.setText(r15)
            goto L_0x025f
        L_0x0202:
            java.lang.Double r6 = r21.getClose()
            if (r6 == 0) goto L_0x022c
            java.lang.String r6 = r21.getContractCode()
            int r6 = ej.f.p(r6)
            java.lang.Double r11 = r21.getClose()
            double r16 = r11.doubleValue()
            java.math.BigDecimal r11 = java.math.BigDecimal.valueOf(r16)
            java.math.BigDecimal r11 = r11.stripTrailingZeros()
            java.lang.String r11 = r11.toPlainString()
            java.lang.String r6 = i6.m.m(r11, r6)
            r8.setText(r6)
            goto L_0x025f
        L_0x022c:
            r8.setText(r15)
            goto L_0x025f
        L_0x0230:
            java.lang.Double r6 = r21.getClose()
            if (r6 == 0) goto L_0x025b
            java.lang.String r6 = r21.getSymbol()
            java.lang.String r6 = com.hbg.lib.common.utils.StringUtils.g(r6)
            int r6 = com.hbg.lib.data.symbol.PrecisionUtil.x(r6)
            java.lang.Double r11 = r21.getClose()
            double r16 = r11.doubleValue()
            java.math.BigDecimal r11 = java.math.BigDecimal.valueOf(r16)
            java.math.BigDecimal r11 = r11.stripTrailingZeros()
            java.lang.String r11 = r11.toPlainString()
            java.lang.String r6 = i6.m.m(r11, r6)
            goto L_0x025c
        L_0x025b:
            r6 = r15
        L_0x025c:
            r8.setText(r6)
        L_0x025f:
            java.lang.Double r6 = r21.getClose()
            if (r6 == 0) goto L_0x0321
            java.lang.Double r6 = r21.getClose()
            r13 = r15
            double r14 = r6.doubleValue()
            r6 = r12
            r11 = 0
            int r14 = java.lang.Double.compare(r14, r11)
            if (r14 == 0) goto L_0x0322
            java.lang.Double r13 = r21.getIncrease()
            if (r13 == 0) goto L_0x02e3
            java.lang.Double r13 = r21.getIncrease()
            double r13 = r13.doubleValue()
            int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            r14 = 2131100372(0x7f0602d4, float:1.7813124E38)
            r15 = 2131100475(0x7f06033b, float:1.7813332E38)
            if (r13 <= 0) goto L_0x02ab
            boolean r13 = com.hbg.lib.core.util.w.l()
            if (r13 == 0) goto L_0x02a0
            android.view.View r0 = r0.itemView
            android.content.Context r0 = r0.getContext()
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r14)
            goto L_0x02e0
        L_0x02a0:
            android.view.View r0 = r0.itemView
            android.content.Context r0 = r0.getContext()
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r15)
            goto L_0x02e0
        L_0x02ab:
            java.lang.Double r13 = r21.getIncrease()
            double r16 = r13.doubleValue()
            int r13 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x02d3
            boolean r13 = com.hbg.lib.core.util.w.l()
            if (r13 == 0) goto L_0x02c8
            android.view.View r0 = r0.itemView
            android.content.Context r0 = r0.getContext()
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r15)
            goto L_0x02e0
        L_0x02c8:
            android.view.View r0 = r0.itemView
            android.content.Context r0 = r0.getContext()
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r14)
            goto L_0x02e0
        L_0x02d3:
            android.view.View r0 = r0.itemView
            android.content.Context r0 = r0.getContext()
            r13 = 2131100395(0x7f0602eb, float:1.781317E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r13)
        L_0x02e0:
            r9.setTextColor(r0)
        L_0x02e3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Double r13 = r21.getIncrease()
            double r13 = r13.doubleValue()
            int r11 = java.lang.Double.compare(r13, r11)
            if (r11 <= 0) goto L_0x02f9
            java.lang.String r12 = "+"
            goto L_0x02fa
        L_0x02f9:
            r12 = r6
        L_0x02fa:
            r0.append(r12)
            java.lang.Double r6 = r21.getIncrease()
            double r11 = r6.doubleValue()
            r13 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r11 = r11 * r13
            java.lang.String r6 = r21.getSymbol()
            int r6 = com.hbg.lib.data.symbol.PrecisionUtil.v(r6)
            java.lang.String r6 = i6.m.i(r11, r6)
            r0.append(r6)
            java.lang.String r6 = "%"
            r0.append(r6)
            java.lang.String r15 = r0.toString()
            goto L_0x0323
        L_0x0321:
            r13 = r15
        L_0x0322:
            r15 = r13
        L_0x0323:
            r9.setText(r15)
            java.lang.String r0 = r21.getLeverageRatio()
            if (r0 == 0) goto L_0x034d
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x0333
            goto L_0x034d
        L_0x0333:
            r6 = 0
            r7.setVisibility(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = "X"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r7.setText(r0)
            r0 = 4
            goto L_0x0351
        L_0x034d:
            r0 = 4
            r7.setVisibility(r0)
        L_0x0351:
            com.hbg.lib.data.symbol.TradeType r6 = r21.getTradeType()
            int r6 = r6.ordinal()
            r3 = r3[r6]
            r6 = 2
            if (r3 == r6) goto L_0x0378
            r6 = 3
            if (r3 == r6) goto L_0x0371
            if (r3 == r0) goto L_0x036a
            java.lang.String r0 = r21.getSymbol()
            java.lang.String r3 = "PRO"
            goto L_0x037e
        L_0x036a:
            java.lang.String r0 = r21.getContractShortType()
            java.lang.String r3 = "LINEAR_SWAP"
            goto L_0x037e
        L_0x0371:
            java.lang.String r0 = r21.getContractShortType()
            java.lang.String r3 = "CONTRACT_SWAP"
            goto L_0x037e
        L_0x0378:
            java.lang.String r0 = r21.getContractShortType()
            java.lang.String r3 = "CONTRACT"
        L_0x037e:
            com.hbg.lib.data.symbol.TradeType r6 = r21.getTradeType()
            if (r6 != r5) goto L_0x03ae
            java.lang.String r5 = r21.getState()
            if (r5 == 0) goto L_0x03ae
            java.lang.String r5 = r21.getState()
            java.lang.String r6 = "pre-online"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x03ae
            long r5 = r21.getTradeOpenAt()
            long r11 = com.hbg.lib.common.utils.DateTimeUtils.v()
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x03ae
            r5 = 1
            com.hbg.lib.common.utils.ViewUtil.m(r2, r5)
            r6 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r8, r6)
            com.hbg.lib.common.utils.ViewUtil.m(r9, r6)
            goto L_0x03b9
        L_0x03ae:
            r5 = 1
            r6 = 0
            com.hbg.lib.common.utils.ViewUtil.m(r8, r5)
            com.hbg.lib.common.utils.ViewUtil.m(r9, r5)
            com.hbg.lib.common.utils.ViewUtil.m(r2, r6)
        L_0x03b9:
            r4.setTag(r1)
            gr.g r2 = new gr.g
            r5 = r18
            r6 = r20
            r2.<init>(r5, r6)
            r4.setOnClickListener(r2)
            r10.setTag(r1)
            boolean r1 = sn.t.w(r0)
            r10.setChecked(r1)
            gr.h r1 = new gr.h
            r1.<init>(r0, r3)
            r10.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.search.viewhandler.SearchResultItemHandler.handleView(v9.c, int, com.huobi.search.bean.SearchResultCategoryItem, android.view.ViewGroup):void");
    }

    public final void n(NewSearchItem newSearchItem) {
        if (newSearchItem.getTradeType() == TradeType.SWAP) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractShortType());
        } else if (newSearchItem.getTradeType() == TradeType.PRO) {
            br.c.g(bh.j.c()).m("1", String.format("%s/%s", new Object[]{newSearchItem.getBaseCoin(), newSearchItem.getQuoteCoin()}));
        } else if (newSearchItem.getTradeType() == TradeType.LINEAR_SWAP) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractCode());
        } else if (newSearchItem.getTradeType() == TradeType.CONTRACT) {
            br.c.g(bh.j.c()).m("1", newSearchItem.getContractCode());
        }
    }
}
