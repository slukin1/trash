package lr;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class j implements ViewPager.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f84445a;

    /* renamed from: b  reason: collision with root package name */
    public float f84446b;

    public j(ViewPager viewPager, float f11) {
        this.f84445a = viewPager;
        this.f84446b = f11;
    }

    public void transformPage(View view, float f11) {
        if (this.f84445a == null) {
            this.f84445a = (ViewPager) view.getParent();
        }
        float left = ((float) ((view.getLeft() - this.f84445a.getPaddingLeft()) - this.f84445a.getScrollX())) / ((float) ((this.f84445a.getMeasuredWidth() - this.f84445a.getPaddingLeft()) - this.f84445a.getPaddingRight()));
        if (left <= -1.0f) {
            view.setScaleX(this.f84446b);
            view.setScaleY(this.f84446b);
        } else if (left > 1.0f) {
            view.setScaleX(this.f84446b);
            view.setScaleY(this.f84446b);
        } else if (left < 0.0f) {
            float f12 = this.f84446b;
            float f13 = f12 + ((1.0f - f12) * (left + 1.0f));
            view.setScaleX(f13);
            view.setScaleY(f13);
        } else {
            float f14 = this.f84446b;
            float f15 = f14 + ((1.0f - f14) * (1.0f - left));
            view.setScaleX(f15);
            view.setScaleY(f15);
        }
    }
}
