package com.huobi.index.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.e0;
import java.util.List;

public class d extends e0 {

    /* renamed from: h  reason: collision with root package name */
    public List<String> f73875h;

    /* renamed from: i  reason: collision with root package name */
    public List<? extends Fragment> f73876i;

    public d(FragmentManager fragmentManager, List<String> list, List<? extends Fragment> list2) {
        super(fragmentManager);
        this.f73875h = list;
        this.f73876i = list2;
    }

    public int getCount() {
        List<? extends Fragment> list = this.f73876i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Fragment getItem(int i11) {
        return (Fragment) this.f73876i.get(i11);
    }

    public CharSequence getPageTitle(int i11) {
        List<String> list = this.f73875h;
        return list == null ? "" : list.get(i11);
    }
}
