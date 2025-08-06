package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import d7.a1;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import yk.c;

public class MarginChooseCurrencyActivity extends TransferChooseCurrencyActivity<SymbolCurrencyEntity> {
    public static void Aj(Activity activity) {
        TransferChooseCurrencyActivity.startForResult(activity, new Intent(activity, MarginChooseCurrencyActivity.class), 100);
    }

    public static /* synthetic */ Observable zj(List list) {
        ArrayList arrayList = new ArrayList();
        List<SymbolBean> Z = a1.v().Z(TradeType.MARGIN);
        for (int i11 = 0; i11 < Z.size(); i11++) {
            SymbolBean symbolBean = Z.get(i11);
            if (symbolBean != null && !symbolBean.getBaseCurrency().equals("ht")) {
                SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
                symbolCurrencyEntity.setName(symbolBean.getSymbol());
                symbolCurrencyEntity.setBaseCurrency(symbolBean.getBaseCurrency());
                symbolCurrencyEntity.setQuoteCurrency(symbolBean.getQuoteCurrency());
                arrayList.add(symbolCurrencyEntity);
            }
        }
        return Observable.just(arrayList);
    }

    public String getAccount() {
        return "3";
    }

    public Observable<List<SymbolCurrencyEntity>> sj() {
        return a1.v().Y(true, false).flatMap(c.f61786b);
    }

    /* renamed from: yj */
    public String rj(SymbolCurrencyEntity symbolCurrencyEntity) {
        return a1.v().W(symbolCurrencyEntity.getName());
    }
}
