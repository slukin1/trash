package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PullToRequestBaseAdapter extends BaseAdapter {
    private PullToRequestBaseListAdapter adapter;

    public PullToRequestBaseAdapter(PullToRequestBaseListAdapter pullToRequestBaseListAdapter) {
        this.adapter = pullToRequestBaseListAdapter;
    }

    public int getCount() {
        return this.adapter.getCount();
    }

    public Object getItem(int i11) {
        return this.adapter.getItem(i11);
    }

    public long getItemId(int i11) {
        return this.adapter.getItemId(i11);
    }

    public int getItemViewType(int i11) {
        return this.adapter.getItemViewType(i11);
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        return this.adapter.getView(i11, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.adapter.getViewTypeCount();
    }
}
