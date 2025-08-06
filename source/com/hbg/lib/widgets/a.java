package com.hbg.lib.widgets;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public abstract class a<V extends View, D> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<V> f71728a;

    /* renamed from: b  reason: collision with root package name */
    public List<D> f71729b;

    public abstract V a();

    public int b(int i11) {
        int size = this.f71729b.size();
        if (size <= 0) {
            return -1;
        }
        if (i11 >= c()) {
            return (i11 - c()) % size;
        }
        int c11 = size - ((c() - i11) % size);
        if (c11 == size) {
            return 0;
        }
        return c11;
    }

    public int c() {
        return getCount() / 2;
    }

    public D d(int i11) {
        int b11 = b(i11);
        if (b11 < 0) {
            return null;
        }
        return this.f71729b.get(b11);
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f71728a.add(view);
    }

    public abstract void e(V v11, D d11);

    public int getCount() {
        return 1000;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        View view;
        if (this.f71728a.size() != 0) {
            view = (View) this.f71728a.remove(0);
        } else {
            view = a();
        }
        viewGroup.addView(view);
        e(view, d(i11));
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
