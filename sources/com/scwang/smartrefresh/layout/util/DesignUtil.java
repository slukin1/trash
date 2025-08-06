package com.scwang.smartrefresh.layout.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import ky.i;
import ky.j;

public class DesignUtil {

    public static class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ oy.a f29939b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f29940c;

        public a(oy.a aVar, j jVar) {
            this.f29939b = aVar;
            this.f29940c = jVar;
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            oy.a aVar = this.f29939b;
            boolean z11 = true;
            boolean z12 = i11 >= 0;
            if (!this.f29940c.h() || appBarLayout.getTotalScrollRange() + i11 > 0) {
                z11 = false;
            }
            aVar.a(z12, z11);
        }
    }

    public static void a(View view, i iVar, oy.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.f().c(false);
                b((ViewGroup) view, iVar.f(), aVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(ViewGroup viewGroup, j jVar, oy.a aVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(aVar, jVar));
            }
        }
    }
}
