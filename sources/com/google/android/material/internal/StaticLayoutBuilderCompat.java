package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.h;
import java.lang.reflect.Constructor;

final class StaticLayoutBuilderCompat {
    public static final int DEFAULT_HYPHENATION_FREQUENCY = (Build.VERSION.SDK_INT >= 23 ? 1 : 0);
    public static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    public static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    private static Object textDirection;
    private Layout.Alignment alignment;
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start = 0;
    private final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i11;
        this.end = charSequence.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        Class cls;
        if (!initialized) {
            try {
                boolean z11 = this.isRtl && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    textDirection = z11 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                    String str = this.isRtl ? TEXT_DIR_CLASS_RTL : TEXT_DIR_CLASS_LTR;
                    Class<?> loadClass = classLoader.loadClass(TEXT_DIR_CLASS);
                    Class<?> loadClass2 = classLoader.loadClass(TEXT_DIRS_CLASS);
                    textDirection = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2});
                constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
                initialized = true;
            } catch (Exception e11) {
                throw new StaticLayoutBuilderCompatException(e11);
            }
        }
    }

    public static StaticLayoutBuilderCompat obtain(CharSequence charSequence, TextPaint textPaint, int i11) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i11);
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, (float) max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.isRtl && this.maxLines == 1) {
                this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
            obtain.setAlignment(this.alignment);
            obtain.setIncludePad(this.includePad);
            obtain.setTextDirection(this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.maxLines);
            float f11 = this.lineSpacingAdd;
            if (!(f11 == 0.0f && this.lineSpacingMultiplier == 1.0f)) {
                obtain.setLineSpacing(f11, this.lineSpacingMultiplier);
            }
            if (this.maxLines > 1) {
                obtain.setHyphenationFrequency(this.hyphenationFrequency);
            }
            return obtain.build();
        }
        createConstructorWithReflection();
        try {
            return (StaticLayout) ((Constructor) h.g(constructor)).newInstance(new Object[]{charSequence, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(max), this.alignment, h.g(textDirection), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines)});
        } catch (Exception e11) {
            throw new StaticLayoutBuilderCompatException(e11);
        }
    }

    public StaticLayoutBuilderCompat setAlignment(Layout.Alignment alignment2) {
        this.alignment = alignment2;
        return this;
    }

    public StaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat setEnd(int i11) {
        this.end = i11;
        return this;
    }

    public StaticLayoutBuilderCompat setHyphenationFrequency(int i11) {
        this.hyphenationFrequency = i11;
        return this;
    }

    public StaticLayoutBuilderCompat setIncludePad(boolean z11) {
        this.includePad = z11;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z11) {
        this.isRtl = z11;
        return this;
    }

    public StaticLayoutBuilderCompat setLineSpacing(float f11, float f12) {
        this.lineSpacingAdd = f11;
        this.lineSpacingMultiplier = f12;
        return this;
    }

    public StaticLayoutBuilderCompat setMaxLines(int i11) {
        this.maxLines = i11;
        return this;
    }

    public StaticLayoutBuilderCompat setStart(int i11) {
        this.start = i11;
        return this;
    }
}
