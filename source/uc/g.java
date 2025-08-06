package uc;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.contract.R$dimen;
import i6.e;
import i6.n;

public final class g {
    public static void a(View view, Activity activity) {
        if (view != null && activity != null) {
            Resources resources = view.getResources();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dimensionPixelOffset = resources.getDisplayMetrics().heightPixels - resources.getDimensionPixelOffset(R$dimen.dimen_116);
            if (e.b(activity)) {
                dimensionPixelOffset += n.h(view.getContext()) + resources.getDimensionPixelOffset(R$dimen.dimen_10);
            }
            layoutParams.height = dimensionPixelOffset;
            view.setLayoutParams(layoutParams);
        }
    }
}
