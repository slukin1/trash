package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import com.google.android.exoplayer2.util.Assertions;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.4028235E38f;
    public static final Cue EMPTY = new Builder().setText("").build();
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public static final int VERTICAL_TYPE_LR = 2;
    public static final int VERTICAL_TYPE_RL = 1;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final Layout.Alignment multiRowAlignment;
    public final float position;
    public final int positionAnchor;
    public final float shearDegrees;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    public static final class Builder {
        private Bitmap bitmap;
        private float bitmapHeight;
        private float line;
        private int lineAnchor;
        private int lineType;
        private Layout.Alignment multiRowAlignment;
        private float position;
        private int positionAnchor;
        private float shearDegrees;
        private float size;
        private CharSequence text;
        private Layout.Alignment textAlignment;
        private float textSize;
        private int textSizeType;
        private int verticalType;
        private int windowColor;
        private boolean windowColorSet;

        public Cue build() {
            return new Cue(this.text, this.textAlignment, this.multiRowAlignment, this.bitmap, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.textSizeType, this.textSize, this.size, this.bitmapHeight, this.windowColorSet, this.windowColor, this.verticalType, this.shearDegrees);
        }

        public Builder clearWindowColor() {
            this.windowColorSet = false;
            return this;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public float getBitmapHeight() {
            return this.bitmapHeight;
        }

        public float getLine() {
            return this.line;
        }

        public int getLineAnchor() {
            return this.lineAnchor;
        }

        public int getLineType() {
            return this.lineType;
        }

        public float getPosition() {
            return this.position;
        }

        public int getPositionAnchor() {
            return this.positionAnchor;
        }

        public float getSize() {
            return this.size;
        }

        public CharSequence getText() {
            return this.text;
        }

        public Layout.Alignment getTextAlignment() {
            return this.textAlignment;
        }

        public float getTextSize() {
            return this.textSize;
        }

        public int getTextSizeType() {
            return this.textSizeType;
        }

        public int getVerticalType() {
            return this.verticalType;
        }

        public int getWindowColor() {
            return this.windowColor;
        }

        public boolean isWindowColorSet() {
            return this.windowColorSet;
        }

        public Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public Builder setBitmapHeight(float f11) {
            this.bitmapHeight = f11;
            return this;
        }

        public Builder setLine(float f11, int i11) {
            this.line = f11;
            this.lineType = i11;
            return this;
        }

        public Builder setLineAnchor(int i11) {
            this.lineAnchor = i11;
            return this;
        }

        public Builder setMultiRowAlignment(Layout.Alignment alignment) {
            this.multiRowAlignment = alignment;
            return this;
        }

        public Builder setPosition(float f11) {
            this.position = f11;
            return this;
        }

        public Builder setPositionAnchor(int i11) {
            this.positionAnchor = i11;
            return this;
        }

        public Builder setShearDegrees(float f11) {
            this.shearDegrees = f11;
            return this;
        }

        public Builder setSize(float f11) {
            this.size = f11;
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public Builder setTextAlignment(Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public Builder setTextSize(float f11, int i11) {
            this.textSize = f11;
            this.textSizeType = i11;
            return this;
        }

        public Builder setVerticalType(int i11) {
            this.verticalType = i11;
            return this;
        }

        public Builder setWindowColor(int i11) {
            this.windowColor = i11;
            this.windowColorSet = true;
            return this;
        }

        public Builder() {
            this.text = null;
            this.bitmap = null;
            this.textAlignment = null;
            this.multiRowAlignment = null;
            this.line = -3.4028235E38f;
            this.lineType = Integer.MIN_VALUE;
            this.lineAnchor = Integer.MIN_VALUE;
            this.position = -3.4028235E38f;
            this.positionAnchor = Integer.MIN_VALUE;
            this.textSizeType = Integer.MIN_VALUE;
            this.textSize = -3.4028235E38f;
            this.size = -3.4028235E38f;
            this.bitmapHeight = -3.4028235E38f;
            this.windowColorSet = false;
            this.windowColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
            this.verticalType = Integer.MIN_VALUE;
        }

        private Builder(Cue cue) {
            this.text = cue.text;
            this.bitmap = cue.bitmap;
            this.textAlignment = cue.textAlignment;
            this.multiRowAlignment = cue.multiRowAlignment;
            this.line = cue.line;
            this.lineType = cue.lineType;
            this.lineAnchor = cue.lineAnchor;
            this.position = cue.position;
            this.positionAnchor = cue.positionAnchor;
            this.textSizeType = cue.textSizeType;
            this.textSize = cue.textSize;
            this.size = cue.size;
            this.bitmapHeight = cue.bitmapHeight;
            this.windowColorSet = cue.windowColorSet;
            this.windowColor = cue.windowColor;
            this.verticalType = cue.verticalType;
            this.shearDegrees = cue.shearDegrees;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Deprecated
    public Cue(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13) {
        this(charSequence, alignment, f11, i11, i12, f12, i13, f13, false, (int) RoundedDrawable.DEFAULT_BORDER_COLOR);
    }

    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, int i14, float f14) {
        this(charSequence, alignment, (Layout.Alignment) null, (Bitmap) null, f11, i11, i12, f12, i13, i14, f14, f13, -3.4028235E38f, false, RoundedDrawable.DEFAULT_BORDER_COLOR, Integer.MIN_VALUE, 0.0f);
    }

    @Deprecated
    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14) {
        this(charSequence, alignment, (Layout.Alignment) null, (Bitmap) null, f11, i11, i12, f12, i13, Integer.MIN_VALUE, -3.4028235E38f, f13, -3.4028235E38f, z11, i14, Integer.MIN_VALUE, 0.0f);
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap2, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z11, int i15, int i16, float f16) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap3 = bitmap2;
        if (charSequence2 == null) {
            Assertions.checkNotNull(bitmap2);
        } else {
            Assertions.checkArgument(bitmap3 == null);
        }
        if (charSequence2 instanceof Spanned) {
            this.text = SpannedString.valueOf(charSequence);
        } else if (charSequence2 != null) {
            this.text = charSequence.toString();
        } else {
            this.text = null;
        }
        this.textAlignment = alignment;
        this.multiRowAlignment = alignment2;
        this.bitmap = bitmap3;
        this.line = f11;
        this.lineType = i11;
        this.lineAnchor = i12;
        this.position = f12;
        this.positionAnchor = i13;
        this.size = f14;
        this.bitmapHeight = f15;
        this.windowColorSet = z11;
        this.windowColor = i15;
        this.textSizeType = i14;
        this.textSize = f13;
        this.verticalType = i16;
        this.shearDegrees = f16;
    }
}
