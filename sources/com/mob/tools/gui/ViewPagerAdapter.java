package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

public abstract class ViewPagerAdapter {
    private MobViewPager parent;

    public abstract int getCount();

    public abstract View getView(int i11, View view, ViewGroup viewGroup);

    public void invalidate() {
        MobViewPager mobViewPager = this.parent;
        if (mobViewPager != null) {
            mobViewPager.setAdapter(this);
        }
    }

    public void onScreenChange(int i11, int i12) {
    }

    public void onScreenChanging(float f11) {
    }

    public final void setMobViewPager(MobViewPager mobViewPager) {
        this.parent = mobViewPager;
    }
}
