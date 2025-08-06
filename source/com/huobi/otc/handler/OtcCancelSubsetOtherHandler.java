package com.huobi.otc.handler;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import v9.c;

public class OtcCancelSubsetOtherHandler extends OtcCancelNoSubsetHandler {

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f78726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f78727c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType f78728d;

        public a(EditText editText, TextView textView, OtcCancelReasonDataType otcCancelReasonDataType) {
            this.f78726b = editText;
            this.f78727c = textView;
            this.f78728d = otcCancelReasonDataType;
        }

        public void afterTextChanged(Editable editable) {
            String str;
            int length = editable.length();
            if (length > 500) {
                this.f78726b.setText(editable.subSequence(0, 500));
                this.f78726b.setSelection(500);
                HuobiToastUtil.k(this.f78726b.getContext(), R$string.n_otc_order_detail_input_overstep_limits);
                length = 500;
            }
            this.f78727c.setText(length + "/" + 500);
            OtcCancelReasonDataType.OnReasonClickListener onReasonClickListener = this.f78728d.getOnReasonClickListener();
            if (this.f78726b.getText() == null) {
                str = "";
            } else {
                str = this.f78726b.getText().toString();
            }
            onReasonClickListener.onTextChange(str);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup) {
        super.handleView(cVar, i11, otcCancelReasonDataType, viewGroup);
        OtcCancelReasonBean dataBean = otcCancelReasonDataType.getDataBean();
        View b11 = cVar.e().b(R$id.cl_other);
        EditText editText = (EditText) cVar.e().b(R$id.et_other);
        TextView textView = (TextView) cVar.e().b(R$id.tv_num);
        if (dataBean.isChecked()) {
            if (b11.getVisibility() != 0) {
                editText.setText("");
                b11.setVisibility(0);
            }
            String proofHint = dataBean.getProofHint();
            if (!TextUtils.isEmpty(proofHint)) {
                editText.setHint(proofHint);
            } else {
                editText.setHint("");
            }
            editText.addTextChangedListener(new a(editText, textView, otcCancelReasonDataType));
            return;
        }
        editText.setText("");
        b11.setVisibility(8);
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
    }

    public boolean d() {
        return true;
    }

    public int getResId() {
        return R$layout.item_cancel_subset_other;
    }
}
