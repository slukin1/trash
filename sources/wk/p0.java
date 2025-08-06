package wk;

import android.content.res.Resources;
import android.widget.TextView;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import d7.a1;
import i6.m;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class p0 {
    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:240)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        */
    public static java.util.Map<java.lang.String, java.math.BigDecimal> c(java.lang.String r12, java.util.Map<java.lang.String, com.hbg.lib.network.pro.socket.bean.SymbolPrice> r13) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            if (r13 == 0) goto L_0x0019
            r2.putAll(r13)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r13 = move-exception
            r13.printStackTrace()
        L_0x0019:
            if (r12 == 0) goto L_0x0020
            java.math.BigDecimal r13 = java.math.BigDecimal.ONE
            r0.put(r12, r13)
        L_0x0020:
            java.util.Set r13 = r2.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0028:
            boolean r2 = r13.hasNext()
            r3 = 32
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x00f6
            java.lang.Object r2 = r13.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            d7.a1 r6 = d7.a1.v()
            java.lang.Object r7 = r2.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r6 = r6.n(r7)
            d7.a1 r7 = d7.a1.v()
            java.lang.Object r8 = r2.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r7 = r7.D(r8)
            boolean r8 = r0.containsKey(r7)
            boolean r9 = r0.containsKey(r6)
            boolean r10 = r6.equalsIgnoreCase(r12)
            if (r10 == 0) goto L_0x009c
            if (r8 != 0) goto L_0x009c
            java.lang.Object r6 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r6 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r6
            if (r6 == 0) goto L_0x0092
            java.lang.Double r8 = r6.getClose()
            if (r8 != 0) goto L_0x0073
            goto L_0x0092
        L_0x0073:
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.Double r6 = r6.getClose()
            java.lang.String r6 = r6.toString()
            r2.<init>(r6)
            java.math.BigDecimal r6 = java.math.BigDecimal.ZERO
            int r6 = r2.compareTo(r6)
            if (r6 == 0) goto L_0x008e
            java.math.BigDecimal r5 = java.math.BigDecimal.ONE
            java.math.BigDecimal r5 = r5.divide(r2, r3, r4)
        L_0x008e:
            r0.put(r7, r5)
            goto L_0x0028
        L_0x0092:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x009c:
            boolean r3 = r7.equalsIgnoreCase(r12)
            if (r3 == 0) goto L_0x00d0
            if (r9 != 0) goto L_0x00d0
            java.lang.Object r3 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r3
            if (r3 == 0) goto L_0x00c5
            java.lang.Double r4 = r3.getClose()
            if (r4 != 0) goto L_0x00b3
            goto L_0x00c5
        L_0x00b3:
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.Double r3 = r3.getClose()
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.put(r6, r2)
            goto L_0x0028
        L_0x00c5:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x00d0:
            java.lang.Object r3 = r2.getValue()
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r3 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r3
            if (r3 == 0) goto L_0x00eb
            java.lang.Double r4 = r3.getClose()
            if (r4 == 0) goto L_0x00eb
            java.math.BigDecimal r5 = new java.math.BigDecimal
            java.lang.Double r3 = r3.getClose()
            java.lang.String r3 = r3.toString()
            r5.<init>(r3)
        L_0x00eb:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r1.put(r2, r5)
            goto L_0x0028
        L_0x00f6:
            int r13 = r1.size()
        L_0x00fa:
            if (r13 <= 0) goto L_0x018f
            if (r5 != 0) goto L_0x0113
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.Set r5 = r1.entrySet()
            r2.<init>(r5)
            java.lang.String r5 = "usdt"
            boolean r5 = r5.equalsIgnoreCase(r12)
            if (r5 == 0) goto L_0x0112
            k(r2)
        L_0x0112:
            r5 = r2
        L_0x0113:
            java.util.Iterator r2 = r5.iterator()
            r6 = 0
        L_0x0118:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x018d
            java.lang.Object r7 = r2.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            if (r8 != 0) goto L_0x012b
            goto L_0x0118
        L_0x012b:
            d7.a1 r8 = d7.a1.v()
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r8 = r8.n(r9)
            d7.a1 r9 = d7.a1.v()
            java.lang.Object r10 = r7.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r9 = r9.D(r10)
            java.lang.Object r10 = r0.get(r9)
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10
            java.lang.Object r11 = r0.get(r8)
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11
            if (r11 == 0) goto L_0x0179
            if (r10 != 0) goto L_0x0179
            java.lang.Object r8 = r7.getValue()
            java.math.BigDecimal r8 = (java.math.BigDecimal) r8
            java.math.BigDecimal r10 = java.math.BigDecimal.ZERO
            int r8 = r8.compareTo(r10)
            if (r8 == 0) goto L_0x0118
            java.math.BigDecimal r8 = java.math.BigDecimal.ONE
            java.lang.Object r7 = r7.getValue()
            java.math.BigDecimal r7 = (java.math.BigDecimal) r7
            java.math.BigDecimal r7 = r8.divide(r7, r3, r4)
            java.math.BigDecimal r7 = r7.multiply(r11)
            r0.put(r9, r7)
            goto L_0x018a
        L_0x0179:
            if (r11 != 0) goto L_0x0118
            if (r10 == 0) goto L_0x0118
            java.lang.Object r7 = r7.getValue()
            java.math.BigDecimal r7 = (java.math.BigDecimal) r7
            java.math.BigDecimal r7 = r10.multiply(r7)
            r0.put(r8, r7)
        L_0x018a:
            int r6 = r6 + 1
            goto L_0x0118
        L_0x018d:
            if (r6 != 0) goto L_0x00fa
        L_0x018f:
            java.util.List r13 = com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil.d()
            com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil.b(r12, r0, r13)
            d7.k r12 = d7.k.C()
            java.util.List r12 = r12.w()
            java.util.Iterator r12 = r12.iterator()
        L_0x01a2:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01f5
            java.lang.Object r13 = r12.next()
            com.hbg.lib.network.pro.core.bean.CurrencyBean r13 = (com.hbg.lib.network.pro.core.bean.CurrencyBean) r13
            if (r13 == 0) goto L_0x01a2
            boolean r1 = r13.isFiatTag()
            if (r1 == 0) goto L_0x01a2
            java.lang.String r13 = r13.getName()
            java.lang.Object r1 = r0.get(r13)
            java.math.BigDecimal r1 = (java.math.BigDecimal) r1
            if (r1 != 0) goto L_0x01a2
            java.lang.String r1 = com.hbg.lib.common.utils.StringUtils.g(r13)
            java.lang.String r2 = "usd"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x01d1
            java.lang.String r1 = "1"
            goto L_0x01d5
        L_0x01d1:
            java.lang.String r1 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.s(r13)
        L_0x01d5:
            java.lang.String r2 = "husd"
            java.lang.Object r2 = r0.get(r2)
            java.math.BigDecimal r2 = (java.math.BigDecimal) r2
            java.math.BigDecimal r1 = i6.m.a(r1)
            if (r2 == 0) goto L_0x01a2
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r4 = r1.compareTo(r4)
            if (r4 == 0) goto L_0x01a2
            java.math.RoundingMode r4 = java.math.RoundingMode.DOWN
            java.math.BigDecimal r1 = r2.divide(r1, r3, r4)
            r0.put(r13, r1)
            goto L_0x01a2
        L_0x01f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wk.p0.c(java.lang.String, java.util.Map):java.util.Map");
    }

    public static String d(double d11, int i11) {
        return m.i(d11, i11);
    }

    public static String e(SymbolPrice symbolPrice) {
        if (symbolPrice == null) {
            return null;
        }
        Double close = symbolPrice.getClose();
        return m.i(close.doubleValue(), PrecisionUtil.x(symbolPrice.getSymbol()));
    }

    public static String f(SymbolPrice symbolPrice, int i11) {
        if (symbolPrice != null) {
            return m.i(symbolPrice.getClose().doubleValue(), i11);
        }
        return null;
    }

    public static Observable<Map<String, BigDecimal>> g(String str, boolean z11) {
        return LegalCurrencyConfigUtil.S(TradeType.PRO, z11).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)).map(new o0(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (((java.lang.String) r8.getKey()).contains("eth") != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        if (((java.lang.String) r8.getKey()).contains("eth") != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        if (((java.lang.String) r9.getKey()).contains("eth") != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (((java.lang.String) r9.getKey()).contains("eth") != false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (((java.lang.String) r9.getKey()).contains("eth") != false) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int i(java.util.Map.Entry r8, java.util.Map.Entry r9) {
        /*
            r0 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r1 = "usdt"
            r2 = 0
            r3 = 2147483646(0x7ffffffe, float:NaN)
            java.lang.String r4 = "btc"
            r5 = 2147483645(0x7ffffffd, float:NaN)
            java.lang.String r6 = "eth"
            if (r8 == 0) goto L_0x0068
            java.lang.Object r7 = r8.getKey()
            if (r7 == 0) goto L_0x0068
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto L_0x0041
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x0032
        L_0x0030:
            r8 = r3
            goto L_0x0069
        L_0x0032:
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x003f
            goto L_0x0066
        L_0x003f:
            r8 = r0
            goto L_0x0069
        L_0x0041:
            java.lang.Object r7 = r8.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r7 = r7.contains(r4)
            if (r7 == 0) goto L_0x005a
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0030
            goto L_0x0066
        L_0x005a:
            java.lang.Object r8 = r8.getKey()
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.contains(r6)
            if (r8 == 0) goto L_0x0068
        L_0x0066:
            r8 = r5
            goto L_0x0069
        L_0x0068:
            r8 = r2
        L_0x0069:
            if (r9 == 0) goto L_0x00bf
            java.lang.Object r7 = r9.getKey()
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r9.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r9.getKey()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x008b
        L_0x0089:
            r0 = r3
            goto L_0x00c0
        L_0x008b:
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x00c0
            goto L_0x00bd
        L_0x0098:
            java.lang.Object r0 = r9.getKey()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x0089
            goto L_0x00bd
        L_0x00b1:
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r9 = r9.contains(r6)
            if (r9 == 0) goto L_0x00bf
        L_0x00bd:
            r0 = r5
            goto L_0x00c0
        L_0x00bf:
            r0 = r2
        L_0x00c0:
            int r0 = r0 - r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wk.p0.i(java.util.Map$Entry, java.util.Map$Entry):int");
    }

    public static void j(TextView textView, SymbolPrice symbolPrice) {
        if (symbolPrice != null) {
            String symbol = symbolPrice.getSymbol();
            Double open = symbolPrice.getOpen();
            double doubleValue = symbolPrice.getClose().doubleValue() - open.doubleValue();
            String i11 = m.i((doubleValue / open.doubleValue()) * 100.0d, PrecisionUtil.v(symbol));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
            sb2.append(i11);
            sb2.append("%");
            textView.setText(sb2.toString());
            Resources resources = textView.getResources();
            int color = resources.getColor(w.h());
            int color2 = resources.getColor(w.d());
            int color3 = resources.getColor(w.e());
            if (Double.compare(doubleValue, 0.0d) > 0) {
                textView.setTextColor(color);
            } else if (Double.compare(doubleValue, 0.0d) < 0) {
                textView.setTextColor(color2);
            } else {
                textView.setTextColor(color3);
            }
        }
    }

    public static void k(List<Map.Entry<String, BigDecimal>> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, n0.f61404b);
        }
    }
}
