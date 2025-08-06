package ne;

import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f25383a = new d();

    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoIndicator f25384a;

        public a(CoIndicator coIndicator) {
            this.f25384a = coIndicator;
        }

        public void onPageScrollStateChanged(int i11) {
            this.f25384a.a(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            this.f25384a.b(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            this.f25384a.b(i11, 0.0f, 0);
            this.f25384a.c(i11);
        }
    }

    public static /* synthetic */ void b(d dVar, CoIndicator coIndicator, ViewPager2 viewPager2, c cVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            cVar = null;
        }
        dVar.a(coIndicator, viewPager2, cVar);
    }

    public final void a(CoIndicator coIndicator, ViewPager2 viewPager2, c cVar) {
        viewPager2.registerOnPageChangeCallback(new a(coIndicator));
    }
}
