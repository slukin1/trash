package com.sumsub.sns.core.widget.applicantData;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class k implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f31222b;

    public /* synthetic */ k(GestureDetector gestureDetector) {
        this.f31222b = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SNSApplicantDataSelectionFieldView.m44_init_$lambda0(this.f31222b, view, motionEvent);
    }
}
