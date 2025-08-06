package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;

public final class NavigationBarMenu extends e {
    private final int maxItemCount;
    private final Class<?> viewClass;

    public NavigationBarMenu(Context context, Class<?> cls, int i11) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i11;
    }

    public MenuItem addInternal(int i11, int i12, int i13, CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i11, i12, i13, charSequence);
            if (addInternal instanceof g) {
                ((g) addInternal).t(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.maxItemCount + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
