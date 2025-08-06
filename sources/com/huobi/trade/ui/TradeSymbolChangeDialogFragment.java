package com.huobi.trade.ui;

import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.dialog.BaseListPopupDialog;
import com.hbg.lib.widgets.dialog.animation.TopRightAnimationAdapter;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.trade.bean.TradeSymbolChangeItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import dt.i2;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;

public class TradeSymbolChangeDialogFragment extends BaseListPopupDialog<TradeSymbolChangeItem> {

    /* renamed from: b  reason: collision with root package name */
    public TradeType f82451b;

    /* renamed from: c  reason: collision with root package name */
    public String f82452c;

    /* renamed from: d  reason: collision with root package name */
    public String f82453d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f82454e = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeSymbolChangeItem tradeSymbolChangeItem = (TradeSymbolChangeItem) view.getTag(R.id.item_data1);
            String d11 = i2.a().d(TradeSymbolChangeDialogFragment.this.f82451b);
            i2.a().h(TradeSymbolChangeDialogFragment.this.f82451b, tradeSymbolChangeItem.d());
            SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
            symbolChangeEvent.g(tradeSymbolChangeItem.d());
            symbolChangeEvent.i(d11);
            symbolChangeEvent.j(TradeSymbolChangeDialogFragment.this.f82451b);
            EventBus.d().k(symbolChangeEvent);
            TradeSymbolChangeDialogFragment.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void afterInit() {
        super.afterInit();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_5);
        this.mRecyclerView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.mRecyclerView.setBackgroundResource(R.drawable.shape_contract_trade_popwindow);
        customizeWindowDimAmount();
        setAnimatorAdapter(new TopRightAnimationAdapter());
    }

    public void bc(String str) {
        this.f82453d = str;
    }

    public List<TradeSymbolChangeItem> getDataList() {
        List<SymbolBean> Z;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f82452c) && (Z = a1.v().Z(this.f82451b)) != null && !Z.isEmpty()) {
            for (SymbolBean next : Z) {
                if (next.isCanTrade() && this.f82452c.equalsIgnoreCase(next.getBaseCurrency())) {
                    TradeSymbolChangeItem tradeSymbolChangeItem = new TradeSymbolChangeItem();
                    if (next.getSymbol().equals(this.f82453d)) {
                        tradeSymbolChangeItem.h(true);
                    }
                    tradeSymbolChangeItem.i(next.getSymbol());
                    tradeSymbolChangeItem.j(next.getSymbolName());
                    tradeSymbolChangeItem.g(this.f82454e);
                    arrayList.add(tradeSymbolChangeItem);
                }
            }
        }
        return arrayList;
    }

    public void setTradeType(TradeType tradeType) {
        this.f82451b = tradeType;
    }

    public void wh(String str) {
        this.f82452c = str;
    }
}
