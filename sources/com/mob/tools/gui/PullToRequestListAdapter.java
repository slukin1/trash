package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public abstract class PullToRequestListAdapter extends PullToRequestBaseListAdapter {
    /* access modifiers changed from: private */
    public PullToRequestBaseAdapter adapter;
    /* access modifiers changed from: private */
    public boolean fling;
    /* access modifiers changed from: private */
    public ScrollableListView listView;
    /* access modifiers changed from: private */
    public OnListStopScrollListener osListener;
    /* access modifiers changed from: private */
    public boolean pullUpReady;

    public PullToRequestListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        ScrollableListView onNewListView = onNewListView(getContext());
        this.listView = onNewListView;
        onNewListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int firstVisibleItem;
            private int visibleItemCount;

            public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
                this.firstVisibleItem = i11;
                this.visibleItemCount = i12;
                View childAt = absListView.getChildAt(i12 - 1);
                boolean unused = PullToRequestListAdapter.this.pullUpReady = i11 + i12 == i13 && childAt != null && childAt.getBottom() <= absListView.getBottom();
                PullToRequestListAdapter pullToRequestListAdapter = PullToRequestListAdapter.this;
                pullToRequestListAdapter.onScroll(pullToRequestListAdapter.listView, i11, i12, i13);
            }

            public void onScrollStateChanged(AbsListView absListView, int i11) {
                boolean unused = PullToRequestListAdapter.this.fling = i11 == 2;
                if (i11 != 0) {
                    return;
                }
                if (PullToRequestListAdapter.this.osListener != null) {
                    PullToRequestListAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
                } else if (PullToRequestListAdapter.this.adapter != null) {
                    PullToRequestListAdapter.this.adapter.notifyDataSetChanged();
                }
            }
        });
        PullToRequestBaseAdapter pullToRequestBaseAdapter = new PullToRequestBaseAdapter(this);
        this.adapter = pullToRequestBaseAdapter;
        this.listView.setAdapter(pullToRequestBaseAdapter);
    }

    public Scrollable getBodyView() {
        return this.listView;
    }

    public ListView getListView() {
        return this.listView;
    }

    public boolean isFling() {
        return this.fling;
    }

    public boolean isPullDownReady() {
        return this.listView.isReadyToPull();
    }

    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    public ScrollableListView onNewListView(Context context) {
        return new ScrollableListView(context);
    }

    public void onScroll(Scrollable scrollable, int i11, int i12, int i13) {
    }

    public void setDivider(Drawable drawable) {
        this.listView.setDivider(drawable);
    }

    public void setDividerHeight(int i11) {
        this.listView.setDividerHeight(i11);
    }
}
