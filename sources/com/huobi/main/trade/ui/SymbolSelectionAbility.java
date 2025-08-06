package com.huobi.main.trade.ui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.main.helper.k;
import java.util.List;

public class SymbolSelectionAbility extends AbstractAbility {

    public class a implements k.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f77788a;

        public a(AbilityFunction.a aVar) {
            this.f77788a = aVar;
        }

        public void a() {
            this.f77788a.a(false, "getSearchHistory error!");
        }

        public void b(List<String> list) {
            this.f77788a.a(true, JSON.toJSON(list).toString());
        }

        public void onSuccess() {
        }
    }

    public class b implements k.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f77790a;

        public b(AbilityFunction.a aVar) {
            this.f77790a = aVar;
        }

        public void a() {
            this.f77790a.a(false, (Object) null);
        }

        public void b(List<String> list) {
        }

        public void onSuccess() {
            this.f77790a.a(true, (Object) null);
        }
    }

    public static /* synthetic */ void e(JSONObject jSONObject, SymbolSelectionFragment symbolSelectionFragment, String str, boolean z11, String str2) {
        if (jSONObject.containsKey("category")) {
            int intValue = jSONObject.getInteger("category").intValue();
            if (intValue == 1) {
                symbolSelectionFragment.zh(str, TradeType.SUPERMARGIN, "", z11);
            } else if (intValue == 2) {
                symbolSelectionFragment.zh(str, TradeType.MARGIN, "", z11);
            } else {
                symbolSelectionFragment.Ah(str, str2, z11);
            }
        } else {
            symbolSelectionFragment.Ah(str, str2, z11);
        }
        symbolSelectionFragment.dismiss();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r14 = new com.alibaba.fastjson.JSONObject();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r13, java.lang.Object r14, com.huobi.edgeengine.ability.AbilityFunction.a r15) {
        /*
            r12 = this;
            java.lang.String r0 = "isSwap"
            java.lang.String r1 = "action"
            java.lang.String r2 = "Console"
            java.lang.String r3 = "call SymbolSelectionAbility error"
            r4 = 0
            if (r15 == 0) goto L_0x010c
            if (r14 == 0) goto L_0x010c
            if (r13 != 0) goto L_0x0011
            goto L_0x010c
        L_0x0011:
            com.eclipsesource.v8.V8Object r14 = (com.eclipsesource.v8.V8Object) r14     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = ""
            boolean r6 = r14.contains(r1)     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x001f
            java.lang.String r5 = r14.getString(r1)     // Catch:{ all -> 0x00fd }
        L_0x001f:
            java.lang.String r1 = "params"
            java.lang.String r14 = r14.getString(r1)     // Catch:{ all -> 0x002a }
            com.alibaba.fastjson.JSONObject r14 = com.alibaba.fastjson.JSON.parseObject(r14)     // Catch:{ all -> 0x002a }
            goto L_0x002f
        L_0x002a:
            com.alibaba.fastjson.JSONObject r14 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x00fd }
            r14.<init>()     // Catch:{ all -> 0x00fd }
        L_0x002f:
            r7 = r14
            r14 = -1
            int r1 = r5.hashCode()     // Catch:{ all -> 0x00fd }
            r6 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r1) {
                case -2143137072: goto L_0x0065;
                case -221796916: goto L_0x005b;
                case 502811539: goto L_0x0051;
                case 903120263: goto L_0x0047;
                case 1125623318: goto L_0x003d;
                default: goto L_0x003c;
            }     // Catch:{ all -> 0x00fd }
        L_0x003c:
            goto L_0x006e
        L_0x003d:
            java.lang.String r1 = "getSearchHistory"
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x006e
            r14 = r4
            goto L_0x006e
        L_0x0047:
            java.lang.String r1 = "clearHistory"
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x006e
            r14 = r10
            goto L_0x006e
        L_0x0051:
            java.lang.String r1 = "insertSearchHistory"
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x006e
            r14 = r8
            goto L_0x006e
        L_0x005b:
            java.lang.String r1 = "currencySelected"
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x006e
            r14 = r9
            goto L_0x006e
        L_0x0065:
            java.lang.String r1 = "getFavoriteList"
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x006e
            r14 = r6
        L_0x006e:
            if (r14 == 0) goto L_0x00ec
            if (r14 == r10) goto L_0x00db
            java.lang.String r1 = "symbol"
            if (r14 == r9) goto L_0x00a1
            if (r14 == r8) goto L_0x008d
            if (r14 == r6) goto L_0x007c
            goto L_0x010b
        L_0x007c:
            java.util.List r13 = sn.t.r()     // Catch:{ all -> 0x00fd }
            java.lang.Object r13 = com.alibaba.fastjson.JSON.toJSON(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00fd }
            r15.a(r10, r13)     // Catch:{ all -> 0x00fd }
            goto L_0x010b
        L_0x008d:
            com.huobi.main.helper.k r13 = com.huobi.main.helper.k.b()     // Catch:{ all -> 0x00fd }
            java.lang.String r14 = r12.d(r7)     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = r7.getString(r1)     // Catch:{ all -> 0x00fd }
            r13.c(r14, r0)     // Catch:{ all -> 0x00fd }
            r13 = 0
            r15.a(r10, r13)     // Catch:{ all -> 0x00fd }
            goto L_0x010b
        L_0x00a1:
            java.lang.String r14 = "fragment"
            java.lang.Object r13 = r13.h(r14)     // Catch:{ all -> 0x00fd }
            java.lang.ref.WeakReference r13 = (java.lang.ref.WeakReference) r13     // Catch:{ all -> 0x00fd }
            java.lang.Object r13 = r13.get()     // Catch:{ all -> 0x00fd }
            r8 = r13
            com.huobi.main.trade.ui.SymbolSelectionFragment r8 = (com.huobi.main.trade.ui.SymbolSelectionFragment) r8     // Catch:{ all -> 0x00fd }
            if (r8 == 0) goto L_0x010b
            java.lang.String r9 = r7.getString(r1)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = "contractShortType"
            java.lang.String r11 = r7.getString(r13)     // Catch:{ all -> 0x00fd }
            boolean r13 = r7.containsKey(r0)     // Catch:{ all -> 0x00fd }
            if (r13 == 0) goto L_0x00cc
            java.lang.Boolean r13 = r7.getBoolean(r0)     // Catch:{ all -> 0x00fd }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x00fd }
            r10 = r13
            goto L_0x00cd
        L_0x00cc:
            r10 = r4
        L_0x00cd:
            i6.i r13 = i6.i.b()     // Catch:{ all -> 0x00fd }
            eo.a r14 = new eo.a     // Catch:{ all -> 0x00fd }
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00fd }
            r13.f(r14)     // Catch:{ all -> 0x00fd }
            goto L_0x010b
        L_0x00db:
            com.huobi.main.helper.k r13 = com.huobi.main.helper.k.b()     // Catch:{ all -> 0x00fd }
            java.lang.String r14 = r12.d(r7)     // Catch:{ all -> 0x00fd }
            com.huobi.main.trade.ui.SymbolSelectionAbility$b r0 = new com.huobi.main.trade.ui.SymbolSelectionAbility$b     // Catch:{ all -> 0x00fd }
            r0.<init>(r15)     // Catch:{ all -> 0x00fd }
            r13.a(r14, r0)     // Catch:{ all -> 0x00fd }
            goto L_0x010b
        L_0x00ec:
            com.huobi.main.helper.k r13 = com.huobi.main.helper.k.b()     // Catch:{ all -> 0x00fd }
            java.lang.String r14 = r12.d(r7)     // Catch:{ all -> 0x00fd }
            com.huobi.main.trade.ui.SymbolSelectionAbility$a r0 = new com.huobi.main.trade.ui.SymbolSelectionAbility$a     // Catch:{ all -> 0x00fd }
            r0.<init>(r15)     // Catch:{ all -> 0x00fd }
            r13.d(r14, r0)     // Catch:{ all -> 0x00fd }
            goto L_0x010b
        L_0x00fd:
            r13 = move-exception
            android.util.Log.d(r2, r3)
            r13.printStackTrace()
            java.lang.String r13 = r13.getMessage()
            r15.a(r4, r13)
        L_0x010b:
            return
        L_0x010c:
            android.util.Log.d(r2, r3)
            r15.a(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.ui.SymbolSelectionAbility.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public boolean b() {
        return false;
    }

    public String d(JSONObject jSONObject) {
        int intValue = jSONObject.getInteger("type").intValue();
        return (intValue == 1 || intValue == 2) ? "s_gradually" : "t_symbol";
    }
}
