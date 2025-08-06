package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class o {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f4654l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: m  reason: collision with root package name */
    public static ConcurrentHashMap<String, Method> f4655m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: n  reason: collision with root package name */
    public static ConcurrentHashMap<String, Field> f4656n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public int f4657a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4658b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f4659c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f4660d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f4661e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f4662f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f4663g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f4664h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f4665i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f4666j;

    /* renamed from: k  reason: collision with root package name */
    public final f f4667k;

    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i11, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i11, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        public static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    public static final class b {
        public static boolean a(View view) {
            return view.isInLayout();
        }
    }

    public static final class c {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i11, int i12, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i11);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i12 == -1) {
                i12 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i12);
            try {
                fVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    public static class d extends f {
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) o.p(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class e extends d {
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class f {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) o.p(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public o(TextView textView) {
        this.f4665i = textView;
        this.f4666j = textView.getContext();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            this.f4667k = new e();
        } else if (i11 >= 23) {
            this.f4667k = new d();
        } else {
            this.f4667k = new f();
        }
    }

    public static <T> T a(Object obj, String str, T t11) {
        try {
            Field m11 = m(str);
            if (m11 == null) {
                return t11;
            }
            return m11.get(obj);
        } catch (IllegalAccessException e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e11);
            return t11;
        }
    }

    public static Field m(String str) {
        try {
            Field field = f4656n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f4656n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e11);
            return null;
        }
    }

    public static Method n(String str) {
        try {
            Method method = f4655m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f4655m.put(str, method);
            }
            return method;
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e11);
            return null;
        }
    }

    public static <T> T p(Object obj, String str, T t11) {
        try {
            return n(str).invoke(obj, new Object[0]);
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e11);
            return t11;
        }
    }

    public final boolean A(int i11, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f4665i.getText();
        TransformationMethod transformationMethod = this.f4665i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f4665i)) == null)) {
            text = transformation;
        }
        int b11 = Build.VERSION.SDK_INT >= 16 ? a.b(this.f4665i) : -1;
        o(i11);
        StaticLayout e11 = e(text, (Layout.Alignment) p(this.f4665i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b11);
        return (b11 == -1 || (e11.getLineCount() <= b11 && e11.getLineEnd(e11.getLineCount() - 1) == text.length())) && ((float) e11.getHeight()) <= rectF.bottom;
    }

    public final boolean B() {
        return !(this.f4665i instanceof AppCompatEditText);
    }

    public final void C(float f11, float f12, float f13) throws IllegalArgumentException {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f11 + "px) is less or equal to (0px)");
        } else if (f12 <= f11) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f12 + "px) is less or equal to minimum auto-size text size (" + f11 + "px)");
        } else if (f13 > 0.0f) {
            this.f4657a = 1;
            this.f4660d = f11;
            this.f4661e = f12;
            this.f4659c = f13;
            this.f4663g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f13 + "px) is less or equal to (0px)");
        }
    }

    public void b() {
        int i11;
        if (q()) {
            if (this.f4658b) {
                if (this.f4665i.getMeasuredHeight() > 0 && this.f4665i.getMeasuredWidth() > 0) {
                    if (this.f4667k.b(this.f4665i)) {
                        i11 = 1048576;
                    } else {
                        i11 = (this.f4665i.getMeasuredWidth() - this.f4665i.getTotalPaddingLeft()) - this.f4665i.getTotalPaddingRight();
                    }
                    int height = (this.f4665i.getHeight() - this.f4665i.getCompoundPaddingBottom()) - this.f4665i.getCompoundPaddingTop();
                    if (i11 > 0 && height > 0) {
                        RectF rectF = f4654l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i11;
                            rectF.bottom = (float) height;
                            float g11 = (float) g(rectF);
                            if (g11 != this.f4665i.getTextSize()) {
                                w(0, g11);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f4658b = true;
        }
    }

    public final int[] c(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            if (i11 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i11)) < 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr2[i12] = ((Integer) arrayList.get(i12)).intValue();
        }
        return iArr2;
    }

    public final void d() {
        this.f4657a = 0;
        this.f4660d = -1.0f;
        this.f4661e = -1.0f;
        this.f4659c = -1.0f;
        this.f4662f = new int[0];
        this.f4658b = false;
    }

    public StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23) {
            return c.a(charSequence, alignment, i11, i12, this.f4665i, this.f4664h, this.f4667k);
        } else if (i13 >= 16) {
            return a.a(charSequence, alignment, i11, this.f4665i, this.f4664h);
        } else {
            return f(charSequence, alignment, i11);
        }
    }

    public final StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i11) {
        return new StaticLayout(charSequence, this.f4664h, i11, alignment, ((Float) a(this.f4665i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f4665i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f4665i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    public final int g(RectF rectF) {
        int length = this.f4662f.length;
        if (length != 0) {
            int i11 = 0;
            int i12 = 1;
            int i13 = length - 1;
            while (true) {
                int i14 = i12;
                int i15 = i11;
                i11 = i14;
                while (i11 <= i13) {
                    int i16 = (i11 + i13) / 2;
                    if (A(this.f4662f[i16], rectF)) {
                        i12 = i16 + 1;
                    } else {
                        i15 = i16 - 1;
                        i13 = i15;
                    }
                }
                return this.f4662f[i15];
            }
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public int h() {
        return Math.round(this.f4661e);
    }

    public int i() {
        return Math.round(this.f4660d);
    }

    public int j() {
        return Math.round(this.f4659c);
    }

    public int[] k() {
        return this.f4662f;
    }

    public int l() {
        return this.f4657a;
    }

    public void o(int i11) {
        TextPaint textPaint = this.f4664h;
        if (textPaint == null) {
            this.f4664h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f4664h.set(this.f4665i.getPaint());
        this.f4664h.setTextSize((float) i11);
    }

    public boolean q() {
        return B() && this.f4657a != 0;
    }

    public void r(AttributeSet attributeSet, int i11) {
        int resourceId;
        Context context = this.f4666j;
        int[] iArr = R$styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        TextView textView = this.f4665i;
        h0.v0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i11, 0);
        int i12 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f4657a = obtainStyledAttributes.getInt(i12, 0);
        }
        int i13 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i13) ? obtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i14) ? obtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i15) ? obtainStyledAttributes.getDimension(i15, -1.0f) : -1.0f;
        int i16 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i16) && (resourceId = obtainStyledAttributes.getResourceId(i16, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            y(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!B()) {
            this.f4657a = 0;
        } else if (this.f4657a == 1) {
            if (!this.f4663g) {
                DisplayMetrics displayMetrics = this.f4666j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                C(dimension2, dimension3, dimension);
            }
            x();
        }
    }

    public void s(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        if (B()) {
            DisplayMetrics displayMetrics = this.f4666j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(i14, (float) i11, displayMetrics), TypedValue.applyDimension(i14, (float) i12, displayMetrics), TypedValue.applyDimension(i14, (float) i13, displayMetrics));
            if (x()) {
                b();
            }
        }
    }

    public void t(int[] iArr, int i11) throws IllegalArgumentException {
        if (B()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i11 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f4666j.getResources().getDisplayMetrics();
                    for (int i12 = 0; i12 < length; i12++) {
                        iArr2[i12] = Math.round(TypedValue.applyDimension(i11, (float) iArr[i12], displayMetrics));
                    }
                }
                this.f4662f = c(iArr2);
                if (!z()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f4663g = false;
            }
            if (x()) {
                b();
            }
        }
    }

    public void u(int i11) {
        if (!B()) {
            return;
        }
        if (i11 == 0) {
            d();
        } else if (i11 == 1) {
            DisplayMetrics displayMetrics = this.f4666j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (x()) {
                b();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i11);
        }
    }

    public final void v(float f11) {
        if (f11 != this.f4665i.getPaint().getTextSize()) {
            this.f4665i.getPaint().setTextSize(f11);
            boolean a11 = Build.VERSION.SDK_INT >= 18 ? b.a(this.f4665i) : false;
            if (this.f4665i.getLayout() != null) {
                this.f4658b = false;
                try {
                    Method n11 = n("nullLayouts");
                    if (n11 != null) {
                        n11.invoke(this.f4665i, new Object[0]);
                    }
                } catch (Exception e11) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e11);
                }
                if (!a11) {
                    this.f4665i.requestLayout();
                } else {
                    this.f4665i.forceLayout();
                }
                this.f4665i.invalidate();
            }
        }
    }

    public void w(int i11, float f11) {
        Resources resources;
        Context context = this.f4666j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        v(TypedValue.applyDimension(i11, f11, resources.getDisplayMetrics()));
    }

    public final boolean x() {
        if (!B() || this.f4657a != 1) {
            this.f4658b = false;
        } else {
            if (!this.f4663g || this.f4662f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f4661e - this.f4660d) / this.f4659c))) + 1;
                int[] iArr = new int[floor];
                for (int i11 = 0; i11 < floor; i11++) {
                    iArr[i11] = Math.round(this.f4660d + (((float) i11) * this.f4659c));
                }
                this.f4662f = c(iArr);
            }
            this.f4658b = true;
        }
        return this.f4658b;
    }

    public final void y(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = typedArray.getDimensionPixelSize(i11, -1);
            }
            this.f4662f = c(iArr);
            z();
        }
    }

    public final boolean z() {
        int[] iArr = this.f4662f;
        int length = iArr.length;
        boolean z11 = length > 0;
        this.f4663g = z11;
        if (z11) {
            this.f4657a = 1;
            this.f4660d = (float) iArr[0];
            this.f4661e = (float) iArr[length - 1];
            this.f4659c = -1.0f;
        }
        return z11;
    }
}
