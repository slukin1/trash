package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class t {
    public static int a(RecyclerView.State state, r rVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z11) {
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(rVar.n(), rVar.d(view2) - rVar.g(view));
    }

    public static int b(RecyclerView.State state, r rVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z11, boolean z12) {
        int i11;
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z12) {
            i11 = Math.max(0, (state.b() - max) - 1);
        } else {
            i11 = Math.max(0, min);
        }
        if (!z11) {
            return i11;
        }
        return Math.round((((float) i11) * (((float) Math.abs(rVar.d(view2) - rVar.g(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (rVar.m() - rVar.g(view))));
    }

    public static int c(RecyclerView.State state, r rVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z11) {
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return state.b();
        }
        return (int) ((((float) (rVar.d(view2) - rVar.g(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.b()));
    }
}
