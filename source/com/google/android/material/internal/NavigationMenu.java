package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;

public class NavigationMenu extends e {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        g gVar = (g) addInternal(i11, i12, i13, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, gVar);
        gVar.x(navigationSubMenu);
        return navigationSubMenu;
    }
}
