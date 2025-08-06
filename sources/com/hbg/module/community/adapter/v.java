package com.hbg.module.community.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import java.util.ArrayList;

public final class v extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f17226a;

    public v(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.f17226a = arrayList;
    }

    public int getCount() {
        return this.f17226a.size();
    }

    public Fragment getItem(int i11) {
        return this.f17226a.get(i11);
    }
}
