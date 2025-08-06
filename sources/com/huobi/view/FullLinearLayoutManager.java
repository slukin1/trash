package com.huobi.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;

public class FullLinearLayoutManager extends StableLinearLayoutManager {
    private static final String TAG = "FullLinearLayoutManager";
    private int[] mMeasuredDimension = new int[2];

    public FullLinearLayoutManager(Context context) {
        super(context);
    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int i11, int i12, int i13, int[] iArr) {
        try {
            View o11 = recycler.o(0);
            if (o11 != null) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) o11.getLayoutParams();
                o11.measure(ViewGroup.getChildMeasureSpec(i12, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                iArr[0] = o11.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                iArr[1] = o11.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
                recycler.G(o11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < getItemCount(); i15++) {
            measureScrapChild(recycler, i15, View.MeasureSpec.makeMeasureSpec(i15, 0), View.MeasureSpec.makeMeasureSpec(i15, 0), this.mMeasuredDimension);
            if (getOrientation() == 0) {
                int[] iArr = this.mMeasuredDimension;
                i14 += iArr[0];
                if (i15 == 0) {
                    i13 = iArr[1];
                }
            } else {
                int[] iArr2 = this.mMeasuredDimension;
                i13 += iArr2[1];
                if (i15 == 0) {
                    i14 = iArr2[0];
                }
            }
        }
        if (mode != 1073741824) {
            size = i14;
        }
        if (mode2 != 1073741824) {
            size2 = i13;
        }
        setMeasuredDimension(size, size2);
    }

    public FullLinearLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }
}
