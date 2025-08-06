package com.youth.banner.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import androidx.viewpager2.widget.ViewPager2;
import com.youth.banner.Banner;
import java.lang.reflect.Field;

public class ScrollSpeedManger extends LinearLayoutManager {
    /* access modifiers changed from: private */
    public Banner banner;

    public ScrollSpeedManger(Banner banner2, LinearLayoutManager linearLayoutManager) {
        super(banner2.getContext(), linearLayoutManager.getOrientation(), false);
        this.banner = banner2;
    }

    public static void reflectLayoutManager(Banner banner2) {
        if (banner2.getScrollTime() >= 100) {
            try {
                ViewPager2 viewPager2 = banner2.getViewPager2();
                RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
                recyclerView.setOverScrollMode(2);
                ScrollSpeedManger scrollSpeedManger = new ScrollSpeedManger(banner2, (LinearLayoutManager) recyclerView.getLayoutManager());
                recyclerView.setLayoutManager(scrollSpeedManger);
                Field declaredField = ViewPager2.class.getDeclaredField("mLayoutManager");
                declaredField.setAccessible(true);
                declaredField.set(viewPager2, scrollSpeedManger);
                Field declaredField2 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(viewPager2);
                if (obj != null) {
                    Field declaredField3 = obj.getClass().getDeclaredField("mLayoutManager");
                    declaredField3.setAccessible(true);
                    declaredField3.set(obj, scrollSpeedManger);
                }
                Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
                declaredField4.setAccessible(true);
                Object obj2 = declaredField4.get(viewPager2);
                if (obj2 != null) {
                    Field declaredField5 = obj2.getClass().getDeclaredField("mLayoutManager");
                    declaredField5.setAccessible(true);
                    declaredField5.set(obj2, scrollSpeedManger);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        AnonymousClass1 r22 = new n(recyclerView.getContext()) {
            public int calculateTimeForDeceleration(int i11) {
                return ScrollSpeedManger.this.banner.getScrollTime();
            }
        };
        r22.setTargetPosition(i11);
        startSmoothScroll(r22);
    }
}
