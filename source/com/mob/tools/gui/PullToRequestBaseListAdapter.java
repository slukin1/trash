package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

public abstract class PullToRequestBaseListAdapter extends PullToRequestAdatper {
    public PullToRequestBaseListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
    }

    public abstract int getCount();

    public abstract Object getItem(int i11);

    public abstract long getItemId(int i11);

    public int getItemViewType(int i11) {
        return 0;
    }

    public abstract View getView(int i11, View view, ViewGroup viewGroup);

    public int getViewTypeCount() {
        return 1;
    }

    public abstract boolean isFling();

    public abstract void onScroll(Scrollable scrollable, int i11, int i12, int i13);
}
