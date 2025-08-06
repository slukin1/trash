package com.google.android.exoplayer2.text.span;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class TextEmphasisSpan implements LanguageFeatureSpan {
    public static final int MARK_FILL_FILLED = 1;
    public static final int MARK_FILL_OPEN = 2;
    public static final int MARK_FILL_UNKNOWN = 0;
    public static final int MARK_SHAPE_CIRCLE = 1;
    public static final int MARK_SHAPE_DOT = 2;
    public static final int MARK_SHAPE_NONE = 0;
    public static final int MARK_SHAPE_SESAME = 3;
    public int markFill;
    public int markShape;
    public final int position;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkFill {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkShape {
    }

    public TextEmphasisSpan(int i11, int i12, int i13) {
        this.markShape = i11;
        this.markFill = i12;
        this.position = i13;
    }
}
