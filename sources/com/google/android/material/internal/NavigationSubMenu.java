package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;

public class NavigationSubMenu extends l {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, g gVar) {
        super(context, navigationMenu, gVar);
    }

    public void onItemsChanged(boolean z11) {
        super.onItemsChanged(z11);
        ((e) getParentMenu()).onItemsChanged(z11);
    }
}
