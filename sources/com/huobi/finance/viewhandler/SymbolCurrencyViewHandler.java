package com.huobi.finance.viewhandler;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.c3;
import com.hbg.lib.common.utils.StringUtils;
import com.huobi.finance.bean.SymbolChooseEvent;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import s9.c;

public class SymbolCurrencyViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(SymbolCurrencyEntity symbolCurrencyEntity, View view) {
        if (view.getContext() instanceof Activity) {
            if (symbolCurrencyEntity.getLayoutType() == 1) {
                Activity activity = (Activity) view.getContext();
                Intent intent = new Intent();
                intent.putExtra("coin", symbolCurrencyEntity);
                intent.putExtra(Constants.FLAG_ACCOUNT, "3");
                activity.setResult(-1, intent);
                activity.finish();
            } else {
                SymbolChooseEvent symbolChooseEvent = new SymbolChooseEvent();
                symbolChooseEvent.f45390a = symbolCurrencyEntity;
                EventBus.d().k(symbolChooseEvent);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, SymbolCurrencyEntity symbolCurrencyEntity, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.symbol_name);
        textView.setText(StringUtils.i(symbolCurrencyEntity.getBaseCurrency()) + "/" + StringUtils.i(symbolCurrencyEntity.getQuoteCurrency()));
        textView.setOnClickListener(new c3(symbolCurrencyEntity));
    }

    public int getResId() {
        return R.layout.item_symbol_choose;
    }
}
