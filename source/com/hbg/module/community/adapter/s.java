package com.hbg.module.community.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.util.ArrayList;
import java.util.List;

public final class s extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f17215a;

    /* renamed from: b  reason: collision with root package name */
    public final List<PersonalCenterInfo.TabInfo> f17216b;

    public s(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, List<? extends PersonalCenterInfo.TabInfo> list) {
        super(fragmentManager);
        this.f17215a = arrayList;
        this.f17216b = list;
    }

    public int getCount() {
        return this.f17215a.size();
    }

    public Fragment getItem(int i11) {
        return this.f17215a.get(i11);
    }

    public CharSequence getPageTitle(int i11) {
        return this.f17216b.get(i11).getTitle();
    }
}
