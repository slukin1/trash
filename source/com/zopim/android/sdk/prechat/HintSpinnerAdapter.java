package com.zopim.android.sdk.prechat;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class HintSpinnerAdapter implements SpinnerAdapter, ListAdapter {
    public static final int EXTRA = 1;
    public SpinnerAdapter adapter;
    public Context context;
    public int hintLayout;
    public int itemDropdownLayout;
    public LayoutInflater layoutInflater;

    public HintSpinnerAdapter(SpinnerAdapter spinnerAdapter, int i11, Context context2) {
        this(spinnerAdapter, i11, -1, context2);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        int count = this.adapter.getCount();
        if (count == 0) {
            return 0;
        }
        return count + 1;
    }

    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        if (i11 != 0) {
            return this.adapter.getDropDownView(i11 - 1, (View) null, viewGroup);
        }
        if (this.itemDropdownLayout == -1) {
            return new View(this.context);
        }
        return getItemDropdownView(viewGroup);
    }

    public View getHintView(ViewGroup viewGroup) {
        return this.layoutInflater.inflate(this.hintLayout, viewGroup, false);
    }

    public Object getItem(int i11) {
        if (i11 == 0) {
            return null;
        }
        return this.adapter.getItem(i11 - 1);
    }

    public View getItemDropdownView(ViewGroup viewGroup) {
        return this.layoutInflater.inflate(this.itemDropdownLayout, viewGroup, false);
    }

    public long getItemId(int i11) {
        return i11 >= 1 ? this.adapter.getItemId(i11 - 1) : (long) (i11 - 1);
    }

    public int getItemViewType(int i11) {
        return 0;
    }

    public final View getView(int i11, View view, ViewGroup viewGroup) {
        if (i11 == 0) {
            return getHintView(viewGroup);
        }
        return this.adapter.getView(i11 - 1, (View) null, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.adapter.hasStableIds();
    }

    public boolean isEmpty() {
        return this.adapter.isEmpty();
    }

    public boolean isEnabled(int i11) {
        return i11 != 0;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.adapter.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.adapter.unregisterDataSetObserver(dataSetObserver);
    }

    public HintSpinnerAdapter(SpinnerAdapter spinnerAdapter, int i11, int i12, Context context2) {
        this.adapter = spinnerAdapter;
        this.context = context2;
        this.hintLayout = i11;
        this.itemDropdownLayout = i12;
        this.layoutInflater = LayoutInflater.from(context2);
    }
}
