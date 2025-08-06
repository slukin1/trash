package com.huobi.contract;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.kline.ui.CurrencyIntroWebActivity;
import com.huobi.contract.dialog.ContractOrderTipDialog;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
import com.huobi.contract.ui.ContractTradeDetailActivity;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import dn.d;
import gs.g;
import java.util.HashMap;
import qk.o0;
import qk.t;
import sc.a;
import sn.f;
import tg.r;

public class ContractModuleConfigImpl implements a {
    public boolean a() {
        return r.x().F0();
    }

    public boolean b() {
        return d.f().m();
    }

    public void c(String str, HashMap hashMap) {
        g.i(str, hashMap);
    }

    public boolean d() {
        return o0.b();
    }

    public void e(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        FutureLimitOrderEditDialogHelper.q(fragmentActivity, (FutureLimitOrderEditDialogHelper.c) null, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void f(FragmentActivity fragmentActivity, ContractHistoryOrderInfo contractHistoryOrderInfo) {
        ContractOrderTipDialog contractOrderTipDialog = new ContractOrderTipDialog();
        contractOrderTipDialog.zh(contractHistoryOrderInfo);
        contractOrderTipDialog.show(fragmentActivity.getSupportFragmentManager(), "contract_history_order");
    }

    public String g(TradeType tradeType) {
        return is.a.f(tradeType);
    }

    public void h(TradeType tradeType, Context context) {
        f.f(tradeType, context);
    }

    public void i(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        FutureLimitOrderEditDialogHelper.r(fragmentActivity, (FutureLimitOrderEditDialogHelper.c) null, str, str2, str3, str4, str5, str6, str7, str8, str9, (String) null);
    }

    public void j(Context context) {
        CurrencyIntroWebActivity.startWebView(context, f.l("44892511689070"), (String) null, false);
    }

    public void k() {
        t.c(10);
    }

    public void l(Context context, ContractHistoryOrderInfo contractHistoryOrderInfo) {
        ContractTradeDetailActivity.rh(context, contractHistoryOrderInfo);
    }
}
