package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.percentlayout.widget.PercentLayoutHelper;

@Deprecated
public class PercentFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final PercentLayoutHelper f10456b = new PercentLayoutHelper(this);

    public PercentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f10456b.e();
    }

    public void onMeasure(int i11, int i12) {
        this.f10456b.a(i11, i12);
        super.onMeasure(i11, i12);
        if (this.f10456b.d()) {
            super.onMeasure(i11, i12);
        }
    }

    @Deprecated
    public static class LayoutParams extends FrameLayout.LayoutParams implements PercentLayoutHelper.a {

        /* renamed from: b  reason: collision with root package name */
        public PercentLayoutHelper.PercentLayoutInfo f10457b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10457b = PercentLayoutHelper.c(context, attributeSet);
        }

        public PercentLayoutHelper.PercentLayoutInfo a() {
            if (this.f10457b == null) {
                this.f10457b = new PercentLayoutHelper.PercentLayoutInfo();
            }
            return this.f10457b;
        }

        public void setBaseAttributes(TypedArray typedArray, int i11, int i12) {
            PercentLayoutHelper.b(this, typedArray, i11, i12);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
