package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.network.hbg.c2c.C2CSymbolsProvider;
import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import d7.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import yk.a;

public class C2cMarginChooseCurrencyActivity extends TransferChooseCurrencyActivity<SymbolCurrencyEntity> {
    public static void Aj(Activity activity) {
        TransferChooseCurrencyActivity.startForResult(activity, new Intent(activity, C2cMarginChooseCurrencyActivity.class), 100);
    }

    public static /* synthetic */ List zj(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C2CSymbolBean c2CSymbolBean = (C2CSymbolBean) it2.next();
            if (c2CSymbolBean != null) {
                SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
                symbolCurrencyEntity.setBaseCurrency(c2CSymbolBean.getBaseCurrency());
                symbolCurrencyEntity.setQuoteCurrency(c2CSymbolBean.getQuoteCurrency());
                symbolCurrencyEntity.setName(c2CSymbolBean.getBaseCurrency() + c2CSymbolBean.getQuoteCurrency());
                arrayList.add(symbolCurrencyEntity);
            }
        }
        return arrayList;
    }

    public String getAccount() {
        return "8";
    }

    public Observable<List<SymbolCurrencyEntity>> sj() {
        return C2CSymbolsProvider.c(true).map(a.f61784b);
    }

    /* renamed from: yj */
    public String rj(SymbolCurrencyEntity symbolCurrencyEntity) {
        return a1.v().W(symbolCurrencyEntity.getName());
    }
}
