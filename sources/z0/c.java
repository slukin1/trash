package z0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.b;

public class c implements Spannable {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f16885e = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Spannable f16886b;

    /* renamed from: c  reason: collision with root package name */
    public final a f16887c;

    /* renamed from: d  reason: collision with root package name */
    public final PrecomputedText f16888d;

    public a a() {
        return this.f16887c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f16886b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i11) {
        return this.f16886b.charAt(i11);
    }

    public int getSpanEnd(Object obj) {
        return this.f16886b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f16886b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f16886b.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f16888d.getSpans(i11, i12, cls);
        }
        return this.f16886b.getSpans(i11, i12, cls);
    }

    public int length() {
        return this.f16886b.length();
    }

    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f16886b.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f16888d.removeSpan(obj);
        } else {
            this.f16886b.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f16888d.setSpan(obj, i11, i12, i13);
        } else {
            this.f16886b.setSpan(obj, i11, i12, i13);
        }
    }

    public CharSequence subSequence(int i11, int i12) {
        return this.f16886b.subSequence(i11, i12);
    }

    public String toString() {
        return this.f16886b.toString();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f16889a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f16890b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16891c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16892d;

        /* renamed from: e  reason: collision with root package name */
        public final PrecomputedText.Params f16893e;

        /* renamed from: z0.c$a$a  reason: collision with other inner class name */
        public static class C0117a {

            /* renamed from: a  reason: collision with root package name */
            public final TextPaint f16894a;

            /* renamed from: b  reason: collision with root package name */
            public TextDirectionHeuristic f16895b;

            /* renamed from: c  reason: collision with root package name */
            public int f16896c;

            /* renamed from: d  reason: collision with root package name */
            public int f16897d;

            public C0117a(TextPaint textPaint) {
                this.f16894a = textPaint;
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 23) {
                    this.f16896c = 1;
                    this.f16897d = 1;
                } else {
                    this.f16897d = 0;
                    this.f16896c = 0;
                }
                if (i11 >= 18) {
                    this.f16895b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f16895b = null;
                }
            }

            public a a() {
                return new a(this.f16894a, this.f16895b, this.f16896c, this.f16897d);
            }

            public C0117a b(int i11) {
                this.f16896c = i11;
                return this;
            }

            public C0117a c(int i11) {
                this.f16897d = i11;
                return this;
            }

            public C0117a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f16895b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f16893e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i11).setHyphenationFrequency(i12).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f16893e = null;
            }
            this.f16889a = textPaint;
            this.f16890b = textDirectionHeuristic;
            this.f16891c = i11;
            this.f16892d = i12;
        }

        public boolean a(a aVar) {
            int i11 = Build.VERSION.SDK_INT;
            if ((i11 >= 23 && (this.f16891c != aVar.b() || this.f16892d != aVar.c())) || this.f16889a.getTextSize() != aVar.e().getTextSize() || this.f16889a.getTextScaleX() != aVar.e().getTextScaleX() || this.f16889a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i11 >= 21 && (this.f16889a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f16889a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f16889a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i11 >= 24) {
                if (!this.f16889a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i11 >= 17 && !this.f16889a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f16889a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f16889a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f16891c;
        }

        public int c() {
            return this.f16892d;
        }

        public TextDirectionHeuristic d() {
            return this.f16890b;
        }

        public TextPaint e() {
            return this.f16889a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f16890b == aVar.d();
        }

        public int hashCode() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                return b.b(Float.valueOf(this.f16889a.getTextSize()), Float.valueOf(this.f16889a.getTextScaleX()), Float.valueOf(this.f16889a.getTextSkewX()), Float.valueOf(this.f16889a.getLetterSpacing()), Integer.valueOf(this.f16889a.getFlags()), this.f16889a.getTextLocales(), this.f16889a.getTypeface(), Boolean.valueOf(this.f16889a.isElegantTextHeight()), this.f16890b, Integer.valueOf(this.f16891c), Integer.valueOf(this.f16892d));
            } else if (i11 >= 21) {
                return b.b(Float.valueOf(this.f16889a.getTextSize()), Float.valueOf(this.f16889a.getTextScaleX()), Float.valueOf(this.f16889a.getTextSkewX()), Float.valueOf(this.f16889a.getLetterSpacing()), Integer.valueOf(this.f16889a.getFlags()), this.f16889a.getTextLocale(), this.f16889a.getTypeface(), Boolean.valueOf(this.f16889a.isElegantTextHeight()), this.f16890b, Integer.valueOf(this.f16891c), Integer.valueOf(this.f16892d));
            } else if (i11 >= 18) {
                return b.b(Float.valueOf(this.f16889a.getTextSize()), Float.valueOf(this.f16889a.getTextScaleX()), Float.valueOf(this.f16889a.getTextSkewX()), Integer.valueOf(this.f16889a.getFlags()), this.f16889a.getTextLocale(), this.f16889a.getTypeface(), this.f16890b, Integer.valueOf(this.f16891c), Integer.valueOf(this.f16892d));
            } else if (i11 >= 17) {
                return b.b(Float.valueOf(this.f16889a.getTextSize()), Float.valueOf(this.f16889a.getTextScaleX()), Float.valueOf(this.f16889a.getTextSkewX()), Integer.valueOf(this.f16889a.getFlags()), this.f16889a.getTextLocale(), this.f16889a.getTypeface(), this.f16890b, Integer.valueOf(this.f16891c), Integer.valueOf(this.f16892d));
            } else {
                return b.b(Float.valueOf(this.f16889a.getTextSize()), Float.valueOf(this.f16889a.getTextScaleX()), Float.valueOf(this.f16889a.getTextSkewX()), Integer.valueOf(this.f16889a.getFlags()), this.f16889a.getTypeface(), this.f16890b, Integer.valueOf(this.f16891c), Integer.valueOf(this.f16892d));
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f16889a.getTextSize());
            sb2.append(", textScaleX=" + this.f16889a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f16889a.getTextSkewX());
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 21) {
                sb2.append(", letterSpacing=" + this.f16889a.getLetterSpacing());
                sb2.append(", elegantTextHeight=" + this.f16889a.isElegantTextHeight());
            }
            if (i11 >= 24) {
                sb2.append(", textLocale=" + this.f16889a.getTextLocales());
            } else if (i11 >= 17) {
                sb2.append(", textLocale=" + this.f16889a.getTextLocale());
            }
            sb2.append(", typeface=" + this.f16889a.getTypeface());
            if (i11 >= 26) {
                sb2.append(", variationSettings=" + this.f16889a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f16890b);
            sb2.append(", breakStrategy=" + this.f16891c);
            sb2.append(", hyphenationFrequency=" + this.f16892d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f16889a = params.getTextPaint();
            this.f16890b = params.getTextDirection();
            this.f16891c = params.getBreakStrategy();
            this.f16892d = params.getHyphenationFrequency();
            this.f16893e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
