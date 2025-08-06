package com.huobi.linearswap.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bj.p0;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.contract.entity.PriceProtectionItem;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import en.b;
import en.d;
import i6.r;
import java.util.Locale;
import oa.a;
import pro.huobi.R;
import s9.c;

public class PriceProtectionItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(PriceProtectionItem priceProtectionItem, View view) {
        ContractPriceProtectionHelper.f((FragmentActivity) a.g().b(), priceProtectionItem.getTradeType(), priceProtectionItem.getSymbol(), priceProtectionItem.getContractCode(), priceProtectionItem.getContractShortType());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(CommonSwitchButton commonSwitchButton, View view) {
        ContractPriceProtectionHelper.d(!p0.e(), new d(commonSwitchButton));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, PriceProtectionItem priceProtectionItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.id_content);
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) e11.b(R.id.id_switch_button);
        ((TextView) e11.b(R.id.id_title)).setOnClickListener(new en.c(priceProtectionItem));
        String c11 = ContractPriceProtectionHelper.c(priceProtectionItem.getContractCode());
        if (TextUtils.isEmpty(c11)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.format(Locale.US, cVar.itemView.getContext().getString(R.string.n_contract_gap_large_cancel_tpsl_order), new Object[]{c11}));
        }
        commonSwitchButton.setChecked(p0.e());
        commonSwitchButton.setOnClickListener(new b(commonSwitchButton));
    }

    public int getResId() {
        return R.layout.item_order_confirm_dialog_price_protection;
    }
}
