package com.sumsub.sns.core.widget.applicantData;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/sumsub/sns/core/widget/applicantData/SNSApplicantDataSelectionCountryFieldView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSApplicantDataSelectionCountryFieldView$gestureDetector$1 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView this$0;

    public SNSApplicantDataSelectionCountryFieldView$gestureDetector$1(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView) {
        this.this$0 = sNSApplicantDataSelectionCountryFieldView;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.this$0.openSelector();
        return super.onSingleTapUp(motionEvent);
    }
}
