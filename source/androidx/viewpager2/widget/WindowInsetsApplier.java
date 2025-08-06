package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.h0;
import androidx.core.view.v;
import androidx.recyclerview.widget.RecyclerView;

public final class WindowInsetsApplier implements v {
    private WindowInsetsApplier() {
    }

    private WindowInsetsCompat consumeAllInsets(WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) {
            return windowInsetsCompat;
        }
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.f8494b;
        if (windowInsetsCompat2.w() != null) {
            return windowInsetsCompat2;
        }
        return windowInsetsCompat.c().b();
    }

    public static boolean install(ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && applicationInfo.targetSdkVersion >= 30) {
            return false;
        }
        h0.O0(viewPager2, new WindowInsetsApplier());
        return true;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat i02 = h0.i0(viewPager2, windowInsetsCompat);
        if (i02.q()) {
            return i02;
        }
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            h0.j(recyclerView.getChildAt(i11), new WindowInsetsCompat(i02));
        }
        return consumeAllInsets(i02);
    }
}
