package com.huobi.view.pickerview;

import com.huobi.view.pickerview.listener.ISelectTimeCallback;

public final /* synthetic */ class f implements ISelectTimeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f19094a;

    public /* synthetic */ f(TimePickerView timePickerView) {
        this.f19094a = timePickerView;
    }

    public final void onTimeSelectChanged() {
        this.f19094a.lambda$initWheelTime$0();
    }
}
