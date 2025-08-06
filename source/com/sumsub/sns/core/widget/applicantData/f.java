package com.sumsub.sns.core.widget.applicantData;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class f implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f31216b;

    public /* synthetic */ f(GestureDetector gestureDetector) {
        this.f31216b = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SNSApplicantDataSelectionCountryFieldView.m41_init_$lambda5(this.f31216b, view, motionEvent);
    }
}
