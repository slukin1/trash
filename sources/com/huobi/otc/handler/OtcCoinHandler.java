package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.event.OtcCoinTransferClickEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import s9.c;

public class OtcCoinHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketCoin.Coin coin, ViewGroup viewGroup) {
        Button button = (Button) cVar.e().b(R$id.base_currency);
        button.setText(coin.getShortName() != null ? coin.getShortName().toUpperCase(Locale.US) : "--");
        button.setTag(coin);
        button.setOnClickListener(this);
        if (coin.isSelected()) {
            button.setTextColor(ContextCompat.getColor(button.getContext(), R$color.transfer_select_text_color));
            button.setBackgroundResource(R$drawable.transfer_select_gradient_bg);
            return;
        }
        button.setTextColor(ContextCompat.getColor(button.getContext(), R$color.transfer_un_select_text_color));
        button.setBackgroundResource(R$drawable.transfer_button_bg);
    }

    public int getResId() {
        return R$layout.item_coin_otc_transfer;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getTag() instanceof MarketCoin.Coin) {
            OtcCoinTransferClickEvent otcCoinTransferClickEvent = new OtcCoinTransferClickEvent();
            otcCoinTransferClickEvent.coin = (MarketCoin.Coin) view.getTag();
            EventBus.d().k(otcCoinTransferClickEvent);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
