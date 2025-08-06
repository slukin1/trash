package com.sumsub.sns.core.widget;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/sumsub/sns/core/widget/SNSErrorBottomSheetView$3$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSErrorBottomSheetView$3$1 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ SNSErrorBottomSheetView this$0;

    public SNSErrorBottomSheetView$3$1(SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        this.this$0 = sNSErrorBottomSheetView;
    }

    public void onSlide(View view, float f11) {
        this.this$0.backgroundDrawable.setAlpha((int) (((float) 128) * (f11 + 1.0f)));
    }

    public void onStateChanged(View view, int i11) {
        SNSErrorBottomSheetView sNSErrorBottomSheetView = this.this$0;
        int i12 = 0;
        if (i11 == 5) {
            i12 = 8;
        }
        sNSErrorBottomSheetView.setVisibility(i12);
    }
}
