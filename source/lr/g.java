package lr;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class g implements ViewPager.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public int f84442a;

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f84443b;

    /* renamed from: c  reason: collision with root package name */
    public float f84444c;

    public g(Context context, float f11) {
        this.f84444c = f11;
        this.f84442a = a(context, 210.0f);
    }

    public final int a(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void transformPage(View view, float f11) {
        if (this.f84443b == null) {
            this.f84443b = (ViewPager) view.getParent();
        }
        float abs = ((1.0f - Math.abs(f11)) * 0.19999999f) + 0.8f;
        float left = (((float) (((view.getLeft() - this.f84443b.getScrollX()) + (view.getMeasuredWidth() / 2)) - (this.f84443b.getMeasuredWidth() / 2))) * this.f84444c) / ((float) this.f84443b.getMeasuredWidth());
        if (abs > 0.0f) {
            view.setScaleX(abs);
            view.setScaleY(abs);
            view.setTranslationX(((float) (-this.f84442a)) * left);
        }
    }
}
