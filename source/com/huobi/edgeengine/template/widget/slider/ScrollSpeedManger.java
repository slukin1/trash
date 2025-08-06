package com.huobi.edgeengine.template.widget.slider;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;

public class ScrollSpeedManger extends LinearLayoutManager {

    public class a extends n {
        public a(Context context) {
            super(context);
        }

        public int calculateTimeForDeceleration(int i11) {
            return 400;
        }
    }

    public ScrollSpeedManger(Context context, LinearLayoutManager linearLayoutManager) {
        super(context, linearLayoutManager.getOrientation(), false);
    }

    public static void a(ViewPager2 viewPager2) {
        try {
            RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            ScrollSpeedManger scrollSpeedManger = new ScrollSpeedManger(viewPager2.getContext(), (LinearLayoutManager) recyclerView.getLayoutManager());
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

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i11);
        startSmoothScroll(aVar);
    }
}
