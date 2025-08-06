package com.sumsub.sns.videoident.presentation;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sumsub.sns.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$onViewCreated$3$2$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$onViewCreated$3$2$1 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    public SNSVideoIdentFragment$onViewCreated$3$2$1(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.this$0 = sNSVideoIdentFragment;
    }

    public void onSlide(View view, float f11) {
        float f12 = 1.0f;
        if (f11 >= 0.7f) {
            f12 = RangesKt___RangesKt.i((1.0f - f11) - 0.05f, 0.0f, 1.0f);
        }
        FragmentActivity activity = this.this$0.getActivity();
        View findViewById = activity != null ? activity.findViewById(R.id.sns_toolbar) : null;
        if (findViewById != null) {
            findViewById.setAlpha(f12);
        }
    }

    public void onStateChanged(View view, int i11) {
    }
}
