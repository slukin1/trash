package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;

public class ViewPagerHelper {

    public static class a implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MagicIndicator f58473b;

        public a(MagicIndicator magicIndicator) {
            this.f58473b = magicIndicator;
        }

        public void onPageScrollStateChanged(int i11) {
            this.f58473b.a(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            this.f58473b.b(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            this.f58473b.c(i11);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}
