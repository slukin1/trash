package com.huobi.invite.ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class AdapterHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: b  reason: collision with root package name */
    public BaseAdapter f74516b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f74517c;

    /* renamed from: d  reason: collision with root package name */
    public DataSetObserver f74518d = new a();

    public class a extends DataSetObserver {
        public a() {
        }

        public void onChanged() {
            super.onChanged();
            AdapterHorizontalScrollView.this.b();
        }

        public void onInvalidated() {
            super.onInvalidated();
            AdapterHorizontalScrollView.this.postInvalidate();
        }
    }

    public AdapterHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void b() {
        this.f74517c.removeAllViews();
        for (int i11 = 0; i11 < this.f74516b.getCount(); i11++) {
            this.f74517c.addView(this.f74516b.getView(i11, (View) null, this));
        }
    }

    public void onDetachedFromWindow() {
        BaseAdapter baseAdapter = this.f74516b;
        if (baseAdapter != null) {
            baseAdapter.unregisterDataSetObserver(this.f74518d);
        }
        super.onDetachedFromWindow();
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        BaseAdapter baseAdapter2 = this.f74516b;
        if (baseAdapter2 != null) {
            baseAdapter2.unregisterDataSetObserver(this.f74518d);
        }
        this.f74516b = baseAdapter;
        baseAdapter.registerDataSetObserver(this.f74518d);
        if (this.f74517c == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f74517c = linearLayout;
            addView(linearLayout);
        }
        b();
    }

    public AdapterHorizontalScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
