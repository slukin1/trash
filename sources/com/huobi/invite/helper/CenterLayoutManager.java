package com.huobi.invite.helper;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;

public class CenterLayoutManager extends LinearLayoutManager {

    public static class a extends n {
        public a(Context context) {
            super(context);
        }

        public int calculateDtToFit(int i11, int i12, int i13, int i14, int i15) {
            return (i13 + ((i14 - i13) / 2)) - (i11 + ((i12 - i11) / 2));
        }
    }

    public CenterLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i11);
        startSmoothScroll(aVar);
    }
}
