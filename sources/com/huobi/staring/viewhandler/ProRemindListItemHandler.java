package com.huobi.staring.viewhandler;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.recycler.holder.BaseViewHolder;
import com.huobi.staring.bean.ProRemindListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import es.i;
import es.j;
import pro.huobi.R;

public class ProRemindListItemHandler extends BaseViewHolder<ProRemindListItem> implements View.OnClickListener {
    private CommonCheckBox mCheckbox;
    private ProRemindListItem mData;
    private CommonSwitchButton mSwitchButton;
    private View mSwitchButtonParent;
    private final TextView mTvCurrency;
    private final TextView mTvQuoteCurrency;

    public ProRemindListItemHandler(Context context, View view) {
        super(context, view);
        this.mTvCurrency = (TextView) view.findViewById(R.id.tv_currency);
        this.mTvQuoteCurrency = (TextView) view.findViewById(R.id.tv_quote_currency);
        this.mSwitchButton = (CommonSwitchButton) view.findViewById(R.id.id_remind_setting_list_item_switchButton);
        this.mSwitchButtonParent = view.findViewById(R.id.id_remind_setting_list_item_switchButton_parent);
        this.mCheckbox = (CommonCheckBox) view.findViewById(R.id.id_all_remind_list_item_checkbox);
        view.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$0(ProRemindListItem proRemindListItem, int i11, View view) {
        if (proRemindListItem.getCallback() != null) {
            proRemindListItem.getCallback().b(proRemindListItem, i11, this.mSwitchButton);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$1(ProRemindListItem proRemindListItem, View view) {
        if (proRemindListItem.getCallback() != null) {
            proRemindListItem.getCallback().c(this.mCheckbox.isChecked(), proRemindListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.mData.getCallback() != null) {
            this.mData.getCallback().d(this.mData);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void bind(ProRemindListItem proRemindListItem, int i11) {
        if (proRemindListItem != null) {
            this.mData = proRemindListItem;
            this.mTvCurrency.setText(proRemindListItem.getBaseCurrency());
            this.mTvQuoteCurrency.setText("/" + proRemindListItem.getQuoteCurrency());
            boolean z11 = true;
            this.mSwitchButton.setChecked(proRemindListItem.getStatus() > 0);
            this.mSwitchButtonParent.setOnClickListener(new j(this, proRemindListItem, i11));
            if (proRemindListItem.getCallback() == null || !proRemindListItem.getCallback().a()) {
                ViewUtil.m(this.mCheckbox, false);
                ViewUtil.m(this.mSwitchButtonParent, true);
            } else {
                ViewUtil.m(this.mCheckbox, true);
                ViewUtil.m(this.mSwitchButtonParent, false);
            }
            CommonCheckBox commonCheckBox = this.mCheckbox;
            if (proRemindListItem.getCallback() == null || !proRemindListItem.getCallback().e(proRemindListItem)) {
                z11 = false;
            }
            commonCheckBox.setChecked(z11);
            this.mCheckbox.setOnClickListener(new i(this, proRemindListItem));
        }
    }
}
