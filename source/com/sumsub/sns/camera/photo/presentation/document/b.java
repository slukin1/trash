package com.sumsub.sns.camera.photo.presentation.document;

import com.sumsub.sns.camera.photo.presentation.document.SNSFrameViewWithBackground;
import com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel;
import kotlin.NoWhenBranchMatchedException;

public final class b {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30688a;

        static {
            int[] iArr = new int[SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.values().length];
            iArr[SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.DEFAULT.ordinal()] = 1;
            iArr[SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INVALID.ordinal()] = 2;
            iArr[SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INTERMEDIATE.ordinal()] = 3;
            iArr[SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.OK.ordinal()] = 4;
            f30688a = iArr;
        }
    }

    public static final SNSFrameViewWithBackground.State b(SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State state) {
        int i11 = a.f30688a[state.ordinal()];
        if (i11 == 1) {
            return SNSFrameViewWithBackground.State.DEFAULT;
        }
        if (i11 == 2) {
            return SNSFrameViewWithBackground.State.RED;
        }
        if (i11 == 3) {
            return SNSFrameViewWithBackground.State.YELLOW;
        }
        if (i11 == 4) {
            return SNSFrameViewWithBackground.State.GREEN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
