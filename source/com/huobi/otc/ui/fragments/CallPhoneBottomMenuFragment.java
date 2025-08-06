package com.huobi.otc.ui.fragments;

import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import tp.c;

public class CallPhoneBottomMenuFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79618b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f79619c;

    /* renamed from: d  reason: collision with root package name */
    public View f79620d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79621e;

    /* renamed from: f  reason: collision with root package name */
    public b f79622f;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            CallPhoneBottomMenuFragment.this.zh(charSequence);
        }
    }

    public interface b {
        void e(String str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        b bVar;
        String trim = this.f79619c.getText().toString().trim();
        if (xh(trim) && (bVar = this.f79622f) != null) {
            bVar.e(trim);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(View view, boolean z11) {
        this.f79620d.setBackgroundResource(z11 ? R$color.global_button_end_color : R$color.global_divider_color);
    }

    public void Ah(b bVar) {
        this.f79622f = bVar;
    }

    public void addEvent(r rVar) {
        this.f79618b.setOnClickListener(new tp.b(this));
        this.f79619c.addTextChangedListener(new a());
        this.f79619c.setOnFocusChangeListener(new c(this));
        this.f79621e.setOnClickListener(new tp.a(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.fragment_otc_callphone_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f79618b = (TextView) rVar.b(R$id.tv_cancel);
        this.f79619c = (ClearEditText) rVar.b(R$id.otc_order_detail_phonenum_et);
        this.f79620d = rVar.b(R$id.otc_order_callphone_divider);
        this.f79621e = (TextView) rVar.b(R$id.otc_order_detail_pb);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        wh();
    }

    public boolean useWindowBg() {
        return false;
    }

    public void wh() {
        if (!TextUtils.isEmpty(this.f79619c.getText().toString())) {
            this.f79619c.setText("");
        }
    }

    public final boolean xh(String str) {
        if (str.startsWith("1") && str.length() == 11) {
            return true;
        }
        HuobiToastUtil.i(getString(R$string.otc_order_dialog_input_phone_toast_text));
        return false;
    }

    public final void zh(CharSequence charSequence) {
        this.f79621e.setEnabled(charSequence.length() > 0);
    }
}
