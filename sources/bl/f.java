package bl;

import androidx.viewpager.widget.ViewPager;

public class f implements ViewPager.OnPageChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f66740b;

    /* renamed from: c  reason: collision with root package name */
    public float f66741c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66742d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66743e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66744f = false;

    public f(ViewPager viewPager) {
        this.f66740b = viewPager;
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        if (((double) f11) != 0.0d) {
            float f12 = this.f66741c;
            if (f12 > f11) {
                this.f66743e = false;
                this.f66744f = true;
            } else if (f12 < f11) {
                this.f66743e = true;
                this.f66744f = false;
            } else if (f12 == f11) {
                this.f66743e = false;
                this.f66744f = false;
            }
            this.f66741c = f11;
            this.f66742d = true;
        }
    }
}
