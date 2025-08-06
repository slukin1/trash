package androidx.camera.core;

import com.google.auto.value.AutoValue;

final class ImageReaderFormatRecommender {

    @AutoValue
    public static abstract class FormatCombo {
        public static FormatCombo create(int i11, int i12) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i11, i12);
        }

        public abstract int imageAnalysisFormat();

        public abstract int imageCaptureFormat();
    }

    private ImageReaderFormatRecommender() {
    }

    public static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }
}
