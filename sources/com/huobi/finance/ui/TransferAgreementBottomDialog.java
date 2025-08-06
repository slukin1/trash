package com.huobi.finance.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.otc.dialog.BaseFullBottomSheetFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class TransferAgreementBottomDialog extends BaseFullBottomSheetFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f46798b;

    /* renamed from: c  reason: collision with root package name */
    public View f46799c;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getPeekHeight() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 4);
    }

    public final void initView(View view) {
        this.f46798b = view.findViewById(R.id.close);
        this.f46799c = view.findViewById(R.id.confirm);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_transfer_agreement, viewGroup, false);
        initView(inflate);
        rh();
        return inflate;
    }

    public final void rh() {
        this.f46798b.setOnClickListener(new t7(this));
        this.f46799c.setOnClickListener(new s7(this));
    }
}
