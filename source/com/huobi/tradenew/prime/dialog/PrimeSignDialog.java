package com.huobi.tradenew.prime.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import tt.c;

public class PrimeSignDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Button f83016b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83017c;

    /* renamed from: d  reason: collision with root package name */
    public String f83018d;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f83016b.setOnClickListener(new c(this));
    }

    public void afterInit() {
        this.f83017c.setText(this.f83018d);
    }

    public int getContentViewResId() {
        return R.layout.prime_sign_number_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f83016b = (Button) rVar.b(R.id.dialog_confirm_btn);
        this.f83017c = (TextView) rVar.b(R.id.dialog_content);
    }

    public boolean isTransparent() {
        return false;
    }

    public void th(String str) {
        this.f83018d = str;
    }
}
