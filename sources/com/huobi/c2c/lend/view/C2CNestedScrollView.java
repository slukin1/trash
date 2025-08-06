package com.huobi.c2c.lend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.MyNestedScrollView;
import i6.d;
import pro.huobi.R;

public class C2CNestedScrollView extends MyNestedScrollView {
    public C2CNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        d.b("MyNestedScrollView2-->onNestedPreFling-->" + view);
        try {
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.c2c_lend_trade_recyclerView);
                if (recyclerView != null && recyclerView.canScrollVertically(1)) {
                    return false;
                }
                if (recyclerView != null && recyclerView.canScrollVertically(-1)) {
                    return false;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return super.onNestedPreFling(view, f11, f12);
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        d.b("MyNestedScrollView2-->onNestedPreScroll-->" + view);
        try {
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.c2c_lend_trade_recyclerView);
                if (recyclerView != null && recyclerView.canScrollVertically(1)) {
                    return;
                }
                if (recyclerView != null && recyclerView.canScrollVertically(-1)) {
                    return;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        super.onNestedPreScroll(view, i11, i12, iArr, i13);
    }

    public C2CNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
