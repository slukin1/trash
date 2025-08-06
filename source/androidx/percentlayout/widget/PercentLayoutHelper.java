package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import androidx.core.view.i;
import androidx.percentlayout.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;

@Deprecated
public class PercentLayoutHelper {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f10458a;

    @Deprecated
    public static class PercentLayoutInfo {

        /* renamed from: a  reason: collision with root package name */
        public float f10459a = -1.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f10460b = -1.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f10461c = -1.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f10462d = -1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f10463e = -1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f10464f = -1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f10465g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f10466h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f10467i;

        /* renamed from: j  reason: collision with root package name */
        public final b f10468j = new b(0, 0);

        public void a(ViewGroup.LayoutParams layoutParams, int i11, int i12) {
            b bVar = this.f10468j;
            int i13 = layoutParams.width;
            bVar.width = i13;
            int i14 = layoutParams.height;
            bVar.height = i14;
            boolean z11 = false;
            boolean z12 = (bVar.f10470b || i13 == 0) && this.f10459a < 0.0f;
            if ((bVar.f10469a || i14 == 0) && this.f10460b < 0.0f) {
                z11 = true;
            }
            float f11 = this.f10459a;
            if (f11 >= 0.0f) {
                layoutParams.width = Math.round(((float) i11) * f11);
            }
            float f12 = this.f10460b;
            if (f12 >= 0.0f) {
                layoutParams.height = Math.round(((float) i12) * f12);
            }
            float f13 = this.f10467i;
            if (f13 >= 0.0f) {
                if (z12) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * f13);
                    this.f10468j.f10470b = true;
                }
                if (z11) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.f10467i);
                    this.f10468j.f10469a = true;
                }
            }
        }

        public void b(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
            a(marginLayoutParams, i11, i12);
            b bVar = this.f10468j;
            bVar.leftMargin = marginLayoutParams.leftMargin;
            bVar.topMargin = marginLayoutParams.topMargin;
            bVar.rightMargin = marginLayoutParams.rightMargin;
            bVar.bottomMargin = marginLayoutParams.bottomMargin;
            i.e(bVar, i.b(marginLayoutParams));
            i.d(this.f10468j, i.a(marginLayoutParams));
            float f11 = this.f10461c;
            if (f11 >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(((float) i11) * f11);
            }
            float f12 = this.f10462d;
            if (f12 >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(((float) i12) * f12);
            }
            float f13 = this.f10463e;
            if (f13 >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(((float) i11) * f13);
            }
            float f14 = this.f10464f;
            if (f14 >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(((float) i12) * f14);
            }
            boolean z11 = false;
            float f15 = this.f10465g;
            boolean z12 = true;
            if (f15 >= 0.0f) {
                i.e(marginLayoutParams, Math.round(((float) i11) * f15));
                z11 = true;
            }
            float f16 = this.f10466h;
            if (f16 >= 0.0f) {
                i.d(marginLayoutParams, Math.round(((float) i11) * f16));
            } else {
                z12 = z11;
            }
            if (z12 && view != null) {
                i.c(marginLayoutParams, h0.F(view));
            }
        }

        public void c(ViewGroup.LayoutParams layoutParams) {
            b bVar = this.f10468j;
            if (!bVar.f10470b) {
                layoutParams.width = bVar.width;
            }
            if (!bVar.f10469a) {
                layoutParams.height = bVar.height;
            }
            bVar.f10470b = false;
            bVar.f10469a = false;
        }

        public void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            c(marginLayoutParams);
            b bVar = this.f10468j;
            marginLayoutParams.leftMargin = bVar.leftMargin;
            marginLayoutParams.topMargin = bVar.topMargin;
            marginLayoutParams.rightMargin = bVar.rightMargin;
            marginLayoutParams.bottomMargin = bVar.bottomMargin;
            i.e(marginLayoutParams, i.b(bVar));
            i.d(marginLayoutParams, i.a(this.f10468j));
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.f10459a), Float.valueOf(this.f10460b), Float.valueOf(this.f10461c), Float.valueOf(this.f10462d), Float.valueOf(this.f10463e), Float.valueOf(this.f10464f), Float.valueOf(this.f10465g), Float.valueOf(this.f10466h)});
        }
    }

    @Deprecated
    public interface a {
        PercentLayoutInfo a();
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10469a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10470b;

        public b(int i11, int i12) {
            super(i11, i12);
        }
    }

    public PercentLayoutHelper(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.f10458a = viewGroup;
            return;
        }
        throw new IllegalArgumentException("host must be non-null");
    }

    public static void b(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i11, int i12) {
        layoutParams.width = typedArray.getLayoutDimension(i11, 0);
        layoutParams.height = typedArray.getLayoutDimension(i12, 0);
    }

    public static PercentLayoutInfo c(Context context, AttributeSet attributeSet) {
        PercentLayoutInfo percentLayoutInfo;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            percentLayoutInfo = new PercentLayoutInfo();
            percentLayoutInfo.f10459a = fraction;
        } else {
            percentLayoutInfo = null;
        }
        float fraction2 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10460b = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10461c = fraction3;
            percentLayoutInfo.f10462d = fraction3;
            percentLayoutInfo.f10463e = fraction3;
            percentLayoutInfo.f10464f = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10461c = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10462d = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10463e = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10464f = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10465g = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10466h = fraction9;
        }
        float fraction10 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction10 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f10467i = fraction10;
        }
        obtainStyledAttributes.recycle();
        return percentLayoutInfo;
    }

    public static boolean f(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredHeightAndState() & RoundedDrawable.DEFAULT_BORDER_COLOR) == 16777216 && percentLayoutInfo.f10460b >= 0.0f && percentLayoutInfo.f10468j.height == -2;
    }

    public static boolean g(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredWidthAndState() & RoundedDrawable.DEFAULT_BORDER_COLOR) == 16777216 && percentLayoutInfo.f10459a >= 0.0f && percentLayoutInfo.f10468j.width == -2;
    }

    public void a(int i11, int i12) {
        PercentLayoutInfo a11;
        int size = (View.MeasureSpec.getSize(i11) - this.f10458a.getPaddingLeft()) - this.f10458a.getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i12) - this.f10458a.getPaddingTop()) - this.f10458a.getPaddingBottom();
        int childCount = this.f10458a.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = this.f10458a.getChildAt(i13);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof a) && (a11 = ((a) layoutParams).a()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    a11.b(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    a11.a(layoutParams, size, size2);
                }
            }
        }
    }

    public boolean d() {
        PercentLayoutInfo a11;
        int childCount = this.f10458a.getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f10458a.getChildAt(i11);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof a) && (a11 = ((a) layoutParams).a()) != null) {
                if (g(childAt, a11)) {
                    layoutParams.width = -2;
                    z11 = true;
                }
                if (f(childAt, a11)) {
                    layoutParams.height = -2;
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public void e() {
        PercentLayoutInfo a11;
        int childCount = this.f10458a.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ViewGroup.LayoutParams layoutParams = this.f10458a.getChildAt(i11).getLayoutParams();
            if ((layoutParams instanceof a) && (a11 = ((a) layoutParams).a()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    a11.d((ViewGroup.MarginLayoutParams) layoutParams);
                } else {
                    a11.c(layoutParams);
                }
            }
        }
    }
}
