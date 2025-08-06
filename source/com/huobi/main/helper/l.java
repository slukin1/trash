package com.huobi.main.helper;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import bh.j;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import pro.huobi.R;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public SymbolSelectionFragment f77740a;

    /* renamed from: b  reason: collision with root package name */
    public SymbolSelectionFragment.f f77741b;

    /* renamed from: c  reason: collision with root package name */
    public BaseActivity f77742c;

    /* renamed from: d  reason: collision with root package name */
    public HuobiKeyboardHelper f77743d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77744a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77744a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f77744a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f77744a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f77744a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f77744a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f77744a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.helper.l.a.<clinit>():void");
        }
    }

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static l f77745a = new l((a) null);
    }

    public /* synthetic */ l(a aVar) {
        this();
    }

    public static l c() {
        return b.f77745a;
    }

    public static void f(String str, String str2, TradeType tradeType, boolean z11) {
        String str3 = "";
        switch (a.f77744a[tradeType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                String j11 = SP.j("exchang_and_margin", MD5Utils.a("lastData"), str3);
                JSONObject jSONObject = null;
                long j12 = -1;
                if (tradeType == TradeType.MARGIN) {
                    str3 = j.c().getString(R.string.n_contract_trade_margin);
                } else if (tradeType == TradeType.SUPERMARGIN) {
                    str3 = j.c().getString(R.string.n_contract_super_margin);
                }
                try {
                    jSONObject = JSON.parseObject(j11);
                    if (jSONObject == null || !TextUtils.equals(str, jSONObject.getString("symbol"))) {
                        long longValue = jSONObject.getLong("partitionId").longValue();
                        if (TextUtils.equals(str, jSONObject.getString("symbol")) && !TextUtils.isEmpty(str2) && str2.toUpperCase().equals(jSONObject.getString("selTitle"))) {
                            try {
                                str3 = jSONObject.getString("marginType");
                            } catch (Throwable unused) {
                            }
                            j12 = longValue;
                        }
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("symbol", (Object) str);
                        jSONObject.put("selTitle", (Object) str2);
                        jSONObject.put("partitionId", (Object) Long.valueOf(j12));
                        jSONObject.put("marginType", (Object) str3);
                        SP.w("exchang_and_margin", MD5Utils.a("lastData"), jSONObject.toJSONString());
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                }
                break;
            case 4:
                JSONObject parseObject = JSON.parseObject(SP.j("symbolMenu_contract_linearSwap", MD5Utils.a("contract_lastSel"), str3));
                if (parseObject == null || !TextUtils.equals(str, parseObject.getString("selSymbol"))) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("selSymbol", (Object) str);
                    SP.w("symbolMenu_contract_linearSwap", MD5Utils.a("contract_lastSel"), jSONObject2.toJSONString());
                    return;
                }
                return;
            case 5:
            case 6:
                try {
                    JSONObject parseObject2 = JSON.parseObject(SP.j("symbolMenu_contract_futuresAndCoinSwap", MD5Utils.a("contract_lastSel"), str3));
                    if (parseObject2 == null || !TextUtils.equals(str, parseObject2.getString("selSymbol"))) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("selSymbol", (Object) str);
                        SP.w("symbolMenu_contract_futuresAndCoinSwap", MD5Utils.a("contract_lastSel"), jSONObject3.toJSONString());
                        return;
                    }
                    return;
                } catch (Throwable unused3) {
                }
            default:
                return;
        }
    }

    public void a() {
        this.f77740a = null;
    }

    public void b() {
        SymbolSelectionFragment symbolSelectionFragment = this.f77740a;
        if (symbolSelectionFragment != null && symbolSelectionFragment.isAdded()) {
            this.f77740a.dismiss();
        }
        this.f77740a = null;
    }

    public boolean d() {
        SymbolSelectionFragment symbolSelectionFragment = this.f77740a;
        return symbolSelectionFragment != null && symbolSelectionFragment.isAdded();
    }

    public void e(BaseActivity baseActivity, SymbolSelectionFragment.f fVar) {
        this.f77742c = baseActivity;
        this.f77741b = fVar;
        this.f77743d = new HuobiKeyboardHelper().attach(this.f77742c);
    }

    public void g(TradeType tradeType, s9.a aVar) {
        String str;
        this.f77743d.getBoardView().hideKeyboardLayout();
        SoftInputUtils.f(this.f77742c);
        if (aVar instanceof ContractCurrencyInfoDrawerItem) {
            str = ((ContractCurrencyInfoDrawerItem) aVar).d().getContractShortType();
        } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
            str = ((SwapCurrencyInfoDrawerItem) aVar).d().getContractShortType();
        } else if (aVar instanceof LinearSwapCurrencyInfoDrawerItem) {
            str = ((LinearSwapCurrencyInfoDrawerItem) aVar).e().getContractShortType();
        } else {
            str = "";
        }
        f(str, "", tradeType, false);
        SymbolSelectionFragment symbolSelectionFragment = new SymbolSelectionFragment();
        this.f77740a = symbolSelectionFragment;
        symbolSelectionFragment.Kh(this.f77741b);
        this.f77740a.Oh(this.f77742c.getSupportFragmentManager(), "trade", tradeType);
    }

    public void h(TradeType tradeType, String str, String str2) {
        this.f77743d.getBoardView().hideKeyboardLayout();
        SoftInputUtils.f(this.f77742c);
        f(str, str2, tradeType, false);
        SymbolSelectionFragment symbolSelectionFragment = new SymbolSelectionFragment();
        this.f77740a = symbolSelectionFragment;
        symbolSelectionFragment.Kh(this.f77741b);
        this.f77740a.Oh(this.f77742c.getSupportFragmentManager(), "trade", tradeType);
    }

    public l() {
    }
}
