package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.h0;
import androidx.recyclerview.R$id;

public class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f10900a = new l();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            if (childAt != view) {
                float z11 = h0.z(childAt);
                if (z11 > f11) {
                    f11 = z11;
                }
            }
        }
        return f11;
    }

    public void a(View view) {
    }

    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11) {
        if (Build.VERSION.SDK_INT >= 21 && z11) {
            int i12 = R$id.item_touch_helper_previous_elevation;
            if (view.getTag(i12) == null) {
                Float valueOf = Float.valueOf(h0.z(view));
                h0.F0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i12, valueOf);
            }
        }
        view.setTranslationX(f11);
        view.setTranslationY(f12);
    }

    public void c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i11 = R$id.item_touch_helper_previous_elevation;
            Object tag = view.getTag(i11);
            if (tag instanceof Float) {
                h0.F0(view, ((Float) tag).floatValue());
            }
            view.setTag(i11, (Object) null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f11, float f12, int i11, boolean z11) {
    }
}
