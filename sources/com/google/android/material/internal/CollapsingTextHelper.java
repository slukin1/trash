package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.util.h;
import androidx.core.view.f;
import androidx.core.view.h0;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import x0.a;
import z0.e;

public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE = (Build.VERSION.SDK_INT < 18);
    private boolean boundsChanged;
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity = 16;
    private float collapsedTextSize = 15.0f;
    private Typeface collapsedTypeface;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private int currentOffsetY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int maxLines = 1;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private StaticLayout textLayout;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        TextPaint textPaint2 = new TextPaint(129);
        this.textPaint = textPaint2;
        this.tmpPaint = new TextPaint(textPaint2);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    private static int blendColors(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((((float) Color.alpha(i11)) * f12) + (((float) Color.alpha(i12)) * f11)), (int) ((((float) Color.red(i11)) * f12) + (((float) Color.red(i12)) * f11)), (int) ((((float) Color.green(i11)) * f12) + (((float) Color.green(i12)) * f11)), (int) ((((float) Color.blue(i11)) * f12) + (((float) Color.blue(i12)) * f11)));
    }

    private void calculateBaseOffsets(boolean z11) {
        StaticLayout staticLayout;
        float f11 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize, z11);
        CharSequence charSequence = this.textToDraw;
        if (!(charSequence == null || (staticLayout = this.textLayout) == null)) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f12 = 0.0f;
        float measureText = charSequence2 != null ? this.textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int b11 = f.b(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i11 = b11 & 112;
        if (i11 == 48) {
            this.collapsedDrawY = (float) this.collapsedBounds.top;
        } else if (i11 != 80) {
            this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = ((float) this.collapsedBounds.bottom) + this.textPaint.ascent();
        }
        int i12 = b11 & 8388615;
        if (i12 == 1) {
            this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (measureText / 2.0f);
        } else if (i12 != 5) {
            this.collapsedDrawX = (float) this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = ((float) this.collapsedBounds.right) - measureText;
        }
        calculateUsingTextSize(this.expandedTextSize, z11);
        StaticLayout staticLayout2 = this.textLayout;
        float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.textToDraw;
        float measureText2 = charSequence3 != null ? this.textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 != null && this.maxLines > 1) {
            measureText2 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.textLayout;
        if (staticLayout4 != null) {
            f12 = this.maxLines > 1 ? (float) staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.expandedFirstLineDrawX = f12;
        int b12 = f.b(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i13 = b12 & 112;
        if (i13 == 48) {
            this.expandedDrawY = (float) this.expandedBounds.top;
        } else if (i13 != 80) {
            this.expandedDrawY = ((float) this.expandedBounds.centerY()) - (height / 2.0f);
        } else {
            this.expandedDrawY = (((float) this.expandedBounds.bottom) - height) + this.textPaint.descent();
        }
        int i14 = b12 & 8388615;
        if (i14 == 1) {
            this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (measureText2 / 2.0f);
        } else if (i14 != 5) {
            this.expandedDrawX = (float) this.expandedBounds.left;
        } else {
            this.expandedDrawX = ((float) this.expandedBounds.right) - measureText2;
        }
        clearTexture();
        setInterpolatedTextSize(f11);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(float f11) {
        float f12 = this.fadeModeThresholdFraction;
        if (f11 <= f12) {
            return AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f12, f11);
        }
        return AnimationUtils.lerp(0.0f, 1.0f, f12, 1.0f, f11);
    }

    private float calculateFadeModeThresholdFraction() {
        float f11 = this.fadeModeStartFraction;
        return f11 + ((1.0f - f11) * 0.5f);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        return this.isRtlTextDirectionHeuristicsEnabled ? isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl) : isDefaultIsRtl;
    }

    private void calculateOffsets(float f11) {
        float f12;
        interpolateBounds(f11);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f11, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f11, this.positionInterpolator);
            setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f11, this.textSizeInterpolator));
            f12 = f11;
        } else if (f11 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(this.expandedTextSize);
            f12 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - ((float) Math.max(0, this.currentOffsetY));
            setInterpolatedTextSize(this.collapsedTextSize);
            f12 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f11, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f11, timeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f12));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f13 = this.collapsedLetterSpacing;
            float f14 = this.expandedLetterSpacing;
            if (f13 != f14) {
                this.textPaint.setLetterSpacing(lerp(f14, f13, f11, timeInterpolator));
            } else {
                this.textPaint.setLetterSpacing(f13);
            }
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f11, (TimeInterpolator) null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f11, (TimeInterpolator) null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f11, (TimeInterpolator) null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f11));
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f11) * 255.0f));
        }
        h0.n0(this.view);
    }

    private void calculateUsingTextSize(float f11) {
        calculateUsingTextSize(f11, false);
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int i11, float f11, boolean z11) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f11).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z11).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i11).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e11) {
            Log.e(TAG, e11.getCause().getMessage(), e11);
            staticLayout = null;
        }
        return (StaticLayout) h.g(staticLayout);
    }

    private void drawMultilineTransition(Canvas canvas, float f11, float f12) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f11, f12);
        float f13 = (float) alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f13));
        this.textLayout.draw(canvas);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f13));
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f14 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f14, this.textPaint);
        if (!this.fadeModeEnabled) {
            String trim = this.textToDrawCollapsed.toString().trim();
            if (trim.endsWith(ELLIPSIS_NORMAL)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.textPaint.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f14, this.textPaint);
        }
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            int width = this.textLayout.getWidth();
            int height = this.textLayout.getHeight();
            if (width > 0 && height > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
    }

    private float getCollapsedTextLeftBound(int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (((float) i11) / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i12 & 8388613) == 8388613 || (i12 & 5) == 5) ? this.isRtl ? (float) this.collapsedBounds.left : ((float) this.collapsedBounds.right) - calculateCollapsedTextWidth() : this.isRtl ? ((float) this.collapsedBounds.right) - calculateCollapsedTextWidth() : (float) this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(RectF rectF, int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (((float) i11) / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i12 & 8388613) == 8388613 || (i12 & 5) == 5) ? this.isRtl ? rectF.left + calculateCollapsedTextWidth() : (float) this.collapsedBounds.right : this.isRtl ? (float) this.collapsedBounds.right : rectF.left + calculateCollapsedTextWidth();
    }

    private int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private void getTextPaintCollapsed(TextPaint textPaint2) {
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
        }
    }

    private void getTextPaintExpanded(TextPaint textPaint2) {
        textPaint2.setTextSize(this.expandedTextSize);
        textPaint2.setTypeface(this.expandedTypeface);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint2.setLetterSpacing(this.expandedLetterSpacing);
        }
    }

    private void interpolateBounds(float f11) {
        if (this.fadeModeEnabled) {
            this.currentBounds.set(f11 < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds);
            return;
        }
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f11, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f11, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f11, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f11, this.positionInterpolator);
    }

    private static boolean isClose(float f11, float f12) {
        return Math.abs(f11 - f12) < 0.001f;
    }

    private boolean isDefaultIsRtl() {
        return h0.F(this.view) == 1;
    }

    private boolean isTextDirectionHeuristicsIsRtl(CharSequence charSequence, boolean z11) {
        return (z11 ? e.f16901d : e.f16900c).a(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f11, float f12, float f13, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f13 = timeInterpolator.getInterpolation(f13);
        }
        return AnimationUtils.lerp(f11, f12, f13);
    }

    private static boolean rectEquals(Rect rect, int i11, int i12, int i13, int i14) {
        return rect.left == i11 && rect.top == i12 && rect.right == i13 && rect.bottom == i14;
    }

    private void setCollapsedTextBlend(float f11) {
        this.collapsedTextBlend = f11;
        h0.n0(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypeface == typeface) {
            return false;
        }
        this.collapsedTypeface = typeface;
        return true;
    }

    private void setExpandedTextBlend(float f11) {
        this.expandedTextBlend = f11;
        h0.n0(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypeface == typeface) {
            return false;
        }
        this.expandedTypeface = typeface;
        return true;
    }

    private void setInterpolatedTextSize(float f11) {
        calculateUsingTextSize(f11);
        boolean z11 = USE_SCALING_TEXTURE && this.scale != 1.0f;
        this.useTexture = z11;
        if (z11) {
            ensureExpandedTexture();
        }
        h0.n0(this.view);
    }

    private boolean shouldDrawMultiline() {
        return this.maxLines > 1 && (!this.isRtl || this.fadeModeEnabled) && !this.useTexture;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return 0.0f;
        }
        getTextPaintCollapsed(this.tmpPaint);
        TextPaint textPaint2 = this.tmpPaint;
        CharSequence charSequence = this.text;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            boolean z11 = true;
            float lineStart = (this.currentDrawX + (this.maxLines > 1 ? (float) this.textLayout.getLineStart(0) : this.textLayout.getLineLeft(0))) - (this.expandedFirstLineDrawX * 2.0f);
            this.textPaint.setTextSize(this.currentTextSize);
            float f11 = this.currentDrawX;
            float f12 = this.currentDrawY;
            if (!this.useTexture || this.expandedTitleTexture == null) {
                z11 = false;
            }
            float f13 = this.scale;
            if (f13 != 1.0f && !this.fadeModeEnabled) {
                canvas.scale(f13, f13, f11, f12);
            }
            if (z11) {
                canvas.drawBitmap(this.expandedTitleTexture, f11, f12, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (!shouldDrawMultiline() || (this.fadeModeEnabled && this.expandedFraction <= this.fadeModeThresholdFraction)) {
                canvas.translate(f11, f12);
                this.textLayout.draw(canvas);
            } else {
                drawMultilineTransition(canvas, lineStart, f12);
            }
            canvas.restoreToCount(save);
        }
    }

    public void getCollapsedTextActualBounds(RectF rectF, int i11, int i12) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i11, i12);
        rectF.top = (float) this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i11, i12);
        rectF.bottom = ((float) this.collapsedBounds.top) + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return (-this.tmpPaint.ascent()) + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.expandedTextColor;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.collapsedTextColor
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.expandedTextColor
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.CollapsingTextHelper.isStateful():boolean");
    }

    public void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.collapsedBounds, i11, i12, i13, i14)) {
            this.collapsedBounds.set(i11, i12, i13, i14);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setCollapsedTextAppearance(int i11) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i11);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.collapsedTextColor = colorStateList;
        }
        float f11 = textAppearance.textSize;
        if (f11 != 0.0f) {
            this.collapsedTextSize = f11;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.collapsedShadowColor = colorStateList2;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i11) {
        if (this.collapsedTextGravity != i11) {
            this.collapsedTextGravity = i11;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f11) {
        if (this.collapsedTextSize != f11) {
            this.collapsedTextSize = f11;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i11) {
        this.currentOffsetY = i11;
    }

    public void setExpandedBounds(int i11, int i12, int i13, int i14) {
        if (!rectEquals(this.expandedBounds, i11, i12, i13, i14)) {
            this.expandedBounds.set(i11, i12, i13, i14);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedTextAppearance(int i11) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i11);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.expandedTextColor = colorStateList;
        }
        float f11 = textAppearance.textSize;
        if (f11 != 0.0f) {
            this.expandedTextSize = f11;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.expandedShadowColor = colorStateList2;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i11) {
        if (this.expandedTextGravity != i11) {
            this.expandedTextGravity = i11;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f11) {
        if (this.expandedTextSize != f11) {
            this.expandedTextSize = f11;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f11) {
        float b11 = a.b(f11, 0.0f, 1.0f);
        if (b11 != this.expandedFraction) {
            this.expandedFraction = b11;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z11) {
        this.fadeModeEnabled = z11;
    }

    public void setFadeModeStartFraction(float f11) {
        this.fadeModeStartFraction = f11;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    public void setHyphenationFrequency(int i11) {
        this.hyphenationFrequency = i11;
    }

    public void setLineSpacingAdd(float f11) {
        this.lineSpacingAdd = f11;
    }

    public void setLineSpacingMultiplier(float f11) {
        this.lineSpacingMultiplier = f11;
    }

    public void setMaxLines(int i11) {
        if (i11 != this.maxLines) {
            this.maxLines = i11;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z11) {
        this.isRtlTextDirectionHeuristicsEnabled = z11;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private void calculateUsingTextSize(float f11, boolean z11) {
        boolean z12;
        float f12;
        boolean z13;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            boolean z14 = false;
            int i11 = 1;
            if (isClose(f11, this.collapsedTextSize)) {
                f12 = this.collapsedTextSize;
                this.scale = 1.0f;
                Typeface typeface = this.currentTypeface;
                Typeface typeface2 = this.collapsedTypeface;
                if (typeface != typeface2) {
                    this.currentTypeface = typeface2;
                    z12 = true;
                } else {
                    z12 = false;
                }
            } else {
                float f13 = this.expandedTextSize;
                Typeface typeface3 = this.currentTypeface;
                Typeface typeface4 = this.expandedTypeface;
                if (typeface3 != typeface4) {
                    this.currentTypeface = typeface4;
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (isClose(f11, f13)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f11 / this.expandedTextSize;
                }
                float f14 = this.collapsedTextSize / this.expandedTextSize;
                float f15 = width2 * f14;
                if (!z11 && f15 > width) {
                    width = Math.min(width / f14, width2);
                } else {
                    width = width2;
                }
                f12 = f13;
                z12 = z13;
            }
            if (width > 0.0f) {
                z12 = this.currentTextSize != f12 || this.boundsChanged || z12;
                this.currentTextSize = f12;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z12) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                TextPaint textPaint2 = this.textPaint;
                if (this.scale != 1.0f) {
                    z14 = true;
                }
                textPaint2.setLinearText(z14);
                this.isRtl = calculateIsRtl(this.text);
                if (shouldDrawMultiline()) {
                    i11 = this.maxLines;
                }
                StaticLayout createStaticLayout = createStaticLayout(i11, width, this.isRtl);
                this.textLayout = createStaticLayout;
                this.textToDraw = createStaticLayout.getText();
            }
        }
    }

    public void recalculate(boolean z11) {
        if ((this.view.getHeight() > 0 && this.view.getWidth() > 0) || z11) {
            calculateBaseOffsets(z11);
            calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
