package com.hbg.lib.widgets.adapter.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.hbg.lib.widgets.R$id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s9.a;

public abstract class CacheViewAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, List<View>> f71747a = new HashMap();

    public abstract int a(int i11);

    public abstract View b(int i11, View view, ViewGroup viewGroup);

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        int intValue = ((Integer) view.getTag(R$id.item_viewtype)).intValue();
        List list = this.f71747a.get(Integer.valueOf(intValue));
        if (list == null) {
            list = new ArrayList();
            this.f71747a.put(Integer.valueOf(intValue), list);
        }
        list.add(view);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        View view;
        List list = this.f71747a.get(Integer.valueOf(a(i11)));
        if (list == null) {
            list = new ArrayList();
            this.f71747a.put(Integer.valueOf(a(i11)), list);
        }
        if (!list.isEmpty()) {
            view = b(i11, (View) list.remove(0), viewGroup);
        } else {
            view = b(i11, (View) null, viewGroup);
        }
        view.setTag(R$id.item_viewtype, Integer.valueOf(a(i11)));
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
