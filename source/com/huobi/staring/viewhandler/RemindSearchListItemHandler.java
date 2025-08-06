package com.huobi.staring.viewhandler;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.recycler.holder.BaseViewHolder;
import com.huobi.staring.bean.RemindSearchListItem;
import com.huobi.staring.ui.StaringRemindActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

public class RemindSearchListItemHandler extends BaseViewHolder<RemindSearchListItem> implements View.OnClickListener {
    private RemindSearchListItem mData;
    private final TextView mTvCurrency;
    private final TextView mTvQuoteCurrency;

    public RemindSearchListItemHandler(Context context, View view) {
        super(context, view);
        this.mTvCurrency = (TextView) view.findViewById(R.id.tv_currency);
        this.mTvQuoteCurrency = (TextView) view.findViewById(R.id.tv_quote_currency);
        view.setOnClickListener(this);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        StaringRemindActivity.pj(view.getContext(), this.mData.getSymbol(), this.mData.getContractType(), this.mData.getBusinessType());
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", this.mData.isContract() ? "Derivatives" : "Spot");
        g.i("Alert_Add_Me_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void bind(RemindSearchListItem remindSearchListItem, int i11) {
        if (remindSearchListItem != null) {
            this.mData = remindSearchListItem;
            this.mTvCurrency.setText(remindSearchListItem.getShowTitle().toUpperCase());
            if (remindSearchListItem.isContract()) {
                this.mTvQuoteCurrency.setVisibility(8);
                return;
            }
            this.mTvQuoteCurrency.setVisibility(0);
            TextView textView = this.mTvQuoteCurrency;
            textView.setText("/" + remindSearchListItem.getShowSubTitle().toUpperCase());
        }
    }
}
