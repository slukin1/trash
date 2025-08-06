package com.huobi.view.rv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewWithHeaderAndFooter extends RecyclerView {
    private HeaderAndFooterRecyclerViewAdapter mWrapAdapter;

    public RecyclerViewWithHeaderAndFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    public void addFooterView(View view) {
        this.mWrapAdapter.addFooterView(view);
    }

    public void addHeaderView(View view) {
        this.mWrapAdapter.addHeaderView(view);
    }

    public void clearAllFooterView() {
        this.mWrapAdapter.clearAllFooterView();
    }

    public void clearAllHeaderView() {
        this.mWrapAdapter.clearAllHeaderView();
    }

    public View getFooterView(int i11) {
        return this.mWrapAdapter.getFooterView(i11);
    }

    public int getFooterViewCount() {
        return this.mWrapAdapter.getFooterViewsCount();
    }

    public View getHeaderView(int i11) {
        return this.mWrapAdapter.getHeaderView(i11);
    }

    public int getHeaderViewCount() {
        return this.mWrapAdapter.getHeaderViewsCount();
    }

    public HeaderAndFooterRecyclerViewAdapter getWrapAdapter() {
        return this.mWrapAdapter;
    }

    public void init() {
        HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter();
        this.mWrapAdapter = headerAndFooterRecyclerViewAdapter;
        super.setAdapter(headerAndFooterRecyclerViewAdapter);
    }

    public boolean isAddHeaderOrFooterView(View view) {
        return this.mWrapAdapter.isAddHeaderOrFooterView(view);
    }

    public void removeFooterView(View view) {
        this.mWrapAdapter.removeFooterView(view);
    }

    public void removeHeaderView(View view) {
        this.mWrapAdapter.removeHeaderView(view);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mWrapAdapter.setInnerAdapter(adapter);
    }

    public RecyclerViewWithHeaderAndFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void removeFooterView(int i11) {
        this.mWrapAdapter.removeFooterView(i11);
    }

    public void removeHeaderView(int i11) {
        this.mWrapAdapter.removeHeaderView(i11);
    }

    public RecyclerViewWithHeaderAndFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
