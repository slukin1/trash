package com.huobi.otc.handler;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.MarketAppeal;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;

public class OtcComplainHandler implements c, View.OnClickListener {

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketAppeal.Appeal f78762b;

        public a(MarketAppeal.Appeal appeal) {
            this.f78762b = appeal;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f78762b.setExtraReason(charSequence.toString());
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketAppeal.Appeal f78764b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommonCheckBox f78765c;

        public b(MarketAppeal.Appeal appeal, CommonCheckBox commonCheckBox) {
            this.f78764b = appeal;
            this.f78765c = commonCheckBox;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78764b.setChecked(!this.f78765c.isChecked());
            CommonCheckBox commonCheckBox = this.f78765c;
            commonCheckBox.setChecked(!commonCheckBox.isChecked());
            this.f78764b.getCallBackSetResult().a(this.f78764b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketAppeal.Appeal appeal, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) cVar.e().b(R$id.complain_relay);
        EditText editText = (EditText) cVar.e().b(R$id.order_complain_edit_reason);
        CommonCheckBox commonCheckBox = (CommonCheckBox) cVar.e().b(R$id.checkbox);
        commonCheckBox.setChecked(appeal.isChecked());
        ((TextView) cVar.e().b(R$id.complain_text)).setText(appeal.getName());
        editText.setHint(appeal.getExtra());
        if (!appeal.isExtra() || !appeal.isChecked()) {
            editText.setVisibility(8);
        } else {
            editText.setVisibility(0);
            if (!TextUtils.isEmpty(appeal.getExtraReason())) {
                editText.setText(appeal.getExtraReason());
            }
        }
        editText.addTextChangedListener(new a(appeal));
        relativeLayout.setOnClickListener(new b(appeal, commonCheckBox));
    }

    public int getResId() {
        return R$layout.item_otc_complain;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
