package com.huobi.trade.prime.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gt.d;
import i6.r;
import pro.huobi.R;

public class PrimeSignDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public Button f82203b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82204c;

    /* renamed from: d  reason: collision with root package name */
    public String f82205d;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f82203b.setOnClickListener(new d(this));
    }

    public void afterInit() {
        this.f82204c.setText(this.f82205d);
    }

    public int getContentViewResId() {
        return R.layout.prime_sign_number_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f82203b = (Button) rVar.b(R.id.dialog_confirm_btn);
        this.f82204c = (TextView) rVar.b(R.id.dialog_content);
    }

    public boolean isTransparent() {
        return false;
    }

    public void th(String str) {
        this.f82205d = str;
    }
}
