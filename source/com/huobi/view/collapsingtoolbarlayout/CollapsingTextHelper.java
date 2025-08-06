package com.huobi.view.collapsingtoolbarlayout;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.d0;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.f;
import androidx.core.view.h0;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$font;
import z0.d;
import z0.e;

final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final float HIGH_FRACTION = 0.38f;
    private static final boolean USE_SCALING_TEXTURE = (Build.VERSION.SDK_INT < 18);
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private ColorStateList mCollapsedTextColor;
    private int mCollapsedTextGravity = 16;
    private float mCollapsedTextSize = 15.0f;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private ColorStateList mExpandedTextColor;
    private int mExpandedTextGravity = 16;
    private float mExpandedTextSize = 15.0f;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private int[] mState;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;

    public CollapsingTextHelper(View view) {
        this.mView = view;
        this.mTextPaint = new TextPaint(129);
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    private static int blendColors(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((((float) Color.alpha(i11)) * f12) + (((float) Color.alpha(i12)) * f11)), (int) ((((float) Color.red(i11)) * f12) + (((float) Color.red(i12)) * f11)), (int) ((((float) Color.green(i11)) * f12) + (((float) Color.green(i12)) * f11)), (int) ((((float) Color.blue(i11)) * f12) + (((float) Color.blue(i12)) * f11)));
    }

    private void calculateBaseOffsets() {
        float f11 = this.mCurrentTextSize;
        calculateUsingTextSize(this.mCollapsedTextSize);
        CharSequence charSequence = this.mTextToDraw;
        float f12 = 0.0f;
        float measureText = charSequence != null ? this.mTextPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int b11 = f.b(this.mCollapsedTextGravity, this.mIsRtl ? 1 : 0);
        int i11 = b11 & 112;
        if (i11 == 48) {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.top) - this.mTextPaint.ascent();
        } else if (i11 != 80) {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.centerY()) + (((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent());
        } else {
            this.mCollapsedDrawY = (float) this.mCollapsedBounds.bottom;
        }
        int i12 = b11 & 8388615;
        if (i12 == 1) {
            this.mCollapsedDrawX = (((float) ViewUtil.f(this.mView.getContext())) - measureText) / 2.0f;
        } else if (i12 != 5) {
            this.mCollapsedDrawX = (float) this.mCollapsedBounds.left;
        } else {
            this.mCollapsedDrawX = ((float) this.mCollapsedBounds.right) - measureText;
        }
        calculateUsingTextSize(this.mExpandedTextSize);
        CharSequence charSequence2 = this.mTextToDraw;
        if (charSequence2 != null) {
            f12 = this.mTextPaint.measureText(charSequence2, 0, charSequence2.length());
        }
        int b12 = f.b(this.mExpandedTextGravity, this.mIsRtl ? 1 : 0);
        int i13 = b12 & 112;
        if (i13 == 48) {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.top) - this.mTextPaint.ascent();
        } else if (i13 != 80) {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.centerY()) + (((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent());
        } else {
            this.mExpandedDrawY = (float) this.mExpandedBounds.bottom;
        }
        int i14 = b12 & 8388615;
        if (i14 == 1) {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.centerX()) - (f12 / 2.0f);
        } else if (i14 != 5) {
            this.mExpandedDrawX = (float) this.mExpandedBounds.left;
        } else {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.right) - f12;
        }
        clearTexture();
        setInterpolatedTextSize(f11);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.mExpandedFraction);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        d dVar;
        boolean z11 = true;
        if (h0.F(this.mView) != 1) {
            z11 = false;
        }
        if (z11) {
            dVar = e.f16901d;
        } else {
            dVar = e.f16900c;
        }
        return dVar.a(charSequence, 0, charSequence.length());
    }

    private void calculateOffsets(float f11) {
        interpolateBounds(f11);
        this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f11, this.mPositionInterpolator);
        this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f11, this.mPositionInterpolator);
        setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f11, this.mTextSizeInterpolator));
        if (this.mCollapsedTextColor != this.mExpandedTextColor) {
            this.mTextPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f11));
        } else {
            this.mTextPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, f11, (Interpolator) null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, f11, (Interpolator) null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, f11, (Interpolator) null), blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, f11));
        h0.n0(this.mView);
    }

    private void calculateUsingTextSize(float f11) {
        float f12;
        boolean z11;
        boolean z12;
        if (this.mText != null) {
            float width = (float) this.mCollapsedBounds.width();
            float width2 = (float) this.mExpandedBounds.width();
            boolean z13 = true;
            if (isClose(f11, this.mCollapsedTextSize)) {
                f12 = this.mCollapsedTextSize;
                this.mScale = 1.0f;
                Typeface typeface = this.mCurrentTypeface;
                Typeface typeface2 = this.mCollapsedTypeface;
                if (typeface != typeface2) {
                    this.mCurrentTypeface = typeface2;
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                float f13 = this.mExpandedTextSize;
                Typeface typeface3 = this.mCurrentTypeface;
                Typeface typeface4 = this.mExpandedTypeface;
                if (typeface3 != typeface4) {
                    this.mCurrentTypeface = typeface4;
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (isClose(f11, f13)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f11 / this.mExpandedTextSize;
                }
                float f14 = this.mCollapsedTextSize / this.mExpandedTextSize;
                width = width2 * f14 > width ? Math.min(width / f14, width2) : width2;
                f12 = f13;
                z11 = z12;
            }
            if (width > 0.0f) {
                z11 = this.mCurrentTextSize != f12 || this.mBoundsChanged || z11;
                this.mCurrentTextSize = f12;
                this.mBoundsChanged = false;
            }
            if (this.mTextToDraw == null || z11) {
                this.mTextPaint.setTextSize(this.mCurrentTextSize);
                this.mTextPaint.setTypeface(this.mCurrentTypeface);
                TextPaint textPaint = this.mTextPaint;
                if (this.mScale == 1.0f) {
                    z13 = false;
                }
                textPaint.setLinearText(z13);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.mTextPaint, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.mTextToDraw)) {
                    this.mTextToDraw = ellipsize;
                    this.mIsRtl = calculateIsRtl(ellipsize);
                }
            }
        }
    }

    private void clearTexture() {
        Bitmap bitmap = this.mExpandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.mExpandedTitleTexture = null;
        }
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
            calculateOffsets(0.0f);
            this.mTextureAscent = this.mTextPaint.ascent();
            this.mTextureDescent = this.mTextPaint.descent();
            TextPaint textPaint = this.mTextPaint;
            CharSequence charSequence = this.mTextToDraw;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.mTextureDescent - this.mTextureAscent);
            if (round > 0 && round2 > 0) {
                this.mExpandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.mExpandedTitleTexture);
                CharSequence charSequence2 = this.mTextToDraw;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.mTextPaint.descent(), this.mTextPaint);
                if (this.mTexturePaint == null) {
                    this.mTexturePaint = new Paint(3);
                }
            }
        }
    }

    private int getCurrentCollapsedTextColor() {
        int[] iArr = this.mState;
        if (iArr != null) {
            return this.mCollapsedTextColor.getColorForState(iArr, 0);
        }
        return this.mCollapsedTextColor.getDefaultColor();
    }

    private int getCurrentExpandedTextColor() {
        int[] iArr = this.mState;
        if (iArr != null) {
            return this.mExpandedTextColor.getColorForState(iArr, 0);
        }
        return this.mExpandedTextColor.getDefaultColor();
    }

    private void interpolateBounds(float f11) {
        this.mCurrentBounds.left = lerp((float) this.mExpandedBounds.left, (float) this.mCollapsedBounds.left, f11, this.mPositionInterpolator);
        this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f11, this.mPositionInterpolator);
        this.mCurrentBounds.right = lerp((float) this.mExpandedBounds.right, (float) this.mCollapsedBounds.right, f11, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = lerp((float) this.mExpandedBounds.bottom, (float) this.mCollapsedBounds.bottom, f11, this.mPositionInterpolator);
    }

    private static boolean isClose(float f11, float f12) {
        return Math.abs(f11 - f12) < 0.001f;
    }

    private static float lerp(float f11, float f12, float f13, Interpolator interpolator) {
        if (interpolator != null) {
            f13 = interpolator.getInterpolation(f13);
        }
        return AnimationUtils.lerp(f11, f12, f13);
    }

    private Typeface readFontFamilyTypeface(int i11) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i11, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean rectEquals(Rect rect, int i11, int i12, int i13, int i14) {
        return rect.left == i11 && rect.top == i12 && rect.right == i13 && rect.bottom == i14;
    }

    private void setInterpolatedTextSize(float f11) {
        calculateUsingTextSize(f11);
        boolean z11 = USE_SCALING_TEXTURE && this.mScale != 1.0f;
        this.mUseTexture = z11;
        if (z11) {
            ensureExpandedTexture();
        }
        h0.n0(this.mView);
    }

    public void draw(Canvas canvas) {
        float f11;
        int save = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float f12 = this.mCurrentDrawX;
            float f13 = this.mCurrentDrawY;
            boolean z11 = this.mUseTexture && this.mExpandedTitleTexture != null;
            if (z11) {
                f11 = this.mTextureAscent * this.mScale;
            } else {
                f11 = this.mTextPaint.ascent() * this.mScale;
                this.mTextPaint.descent();
            }
            if (z11) {
                f13 += f11;
            }
            float f14 = f13;
            float f15 = this.mScale;
            if (f15 != 1.0f) {
                canvas.scale(f15, f15, f12, f14);
            }
            if (z11) {
                canvas.drawBitmap(this.mExpandedTitleTexture, f12, f14, this.mTexturePaint);
            } else if (f12 == this.mCollapsedDrawX && f14 == this.mCollapsedDrawY) {
                CharSequence charSequence = this.mTextToDraw;
                canvas.drawText(charSequence, 0, charSequence.length(), f12, f14, this.mTextPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    public ColorStateList getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    public float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.mCollapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public ColorStateList getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    public int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    public float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.mExpandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void initTitleTextView(TextView textView) {
        textView.setTextColor(this.mExpandedTextColor);
        textView.setTextSize((float) PixelUtils.h(this.mExpandedTextSize));
        textView.setTypeface(ResourcesCompat.h(textView.getContext(), R$font.roboto_medium));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.mExpandedTextColor;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.mCollapsedTextColor
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.mExpandedTextColor
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.collapsingtoolbarlayout.CollapsingTextHelper.isStateful():boolean");
    }

    public void onBoundsChanged() {
        this.mDrawTitle = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
    }

    public void recalculate() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.mCollapsedBounds, i11, i12, i13, i14)) {
            this.mCollapsedBounds.set(i11, i12, i13, i14);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setCollapsedTextAppearance(int i11) {
        d0 t11 = d0.t(this.mView.getContext(), i11, R$styleable.TextAppearance);
        int i12 = R$styleable.TextAppearance_android_textColor;
        if (t11.s(i12)) {
            this.mCollapsedTextColor = t11.c(i12);
        }
        int i13 = R$styleable.TextAppearance_android_textSize;
        if (t11.s(i13)) {
            this.mCollapsedTextSize = (float) t11.f(i13, (int) this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = t11.k(R$styleable.TextAppearance_android_shadowColor, 0);
        this.mCollapsedShadowDx = t11.i(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mCollapsedShadowDy = t11.i(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mCollapsedShadowRadius = t11.i(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        t11.w();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mCollapsedTypeface = readFontFamilyTypeface(i11);
        }
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.mCollapsedTextColor != colorStateList) {
            this.mCollapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i11) {
        if (this.mCollapsedTextGravity != i11) {
            this.mCollapsedTextGravity = i11;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f11) {
        if (this.mCollapsedTextSize != f11) {
            this.mCollapsedTextSize = f11;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (this.mCollapsedTypeface != typeface) {
            this.mCollapsedTypeface = typeface;
            recalculate();
        }
    }

    public void setExpandedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.mExpandedBounds, i11, i12, i13, i14)) {
            this.mExpandedBounds.set(i11, i12, i13, i14);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedTextAppearance(int i11) {
        d0 t11 = d0.t(this.mView.getContext(), i11, R$styleable.TextAppearance);
        int i12 = R$styleable.TextAppearance_android_textColor;
        if (t11.s(i12)) {
            this.mExpandedTextColor = t11.c(i12);
        }
        int i13 = R$styleable.TextAppearance_android_textSize;
        if (t11.s(i13)) {
            this.mExpandedTextSize = (float) t11.f(i13, (int) this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = t11.k(R$styleable.TextAppearance_android_shadowColor, 0);
        this.mExpandedShadowDx = t11.i(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mExpandedShadowDy = t11.i(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mExpandedShadowRadius = t11.i(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        t11.w();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mExpandedTypeface = readFontFamilyTypeface(i11);
        }
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.mExpandedTextColor != colorStateList) {
            this.mExpandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i11) {
        if (this.mExpandedTextGravity != i11) {
            this.mExpandedTextGravity = i11;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f11) {
        if (this.mExpandedTextSize != f11) {
            this.mExpandedTextSize = f11;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (this.mExpandedTypeface != typeface) {
            this.mExpandedTypeface = typeface;
            recalculate();
        }
    }

    public void setExpansionFraction(float f11) {
        float constrain = MathUtils.constrain(f11, 0.0f, 1.0f);
        if (constrain != this.mExpandedFraction) {
            this.mExpandedFraction = constrain;
            calculateCurrentOffsets();
        }
    }

    public void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        recalculate();
    }

    public final boolean setState(int[] iArr) {
        this.mState = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.mTextToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        recalculate();
    }
}
