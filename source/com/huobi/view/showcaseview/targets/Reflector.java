package com.huobi.view.showcaseview.targets;

import android.view.View;
import android.view.ViewParent;

interface Reflector {

    public enum ActionBarType {
        STANDARD,
        APP_COMPAT,
        ACTIONBAR_SHERLOCK
    }

    ViewParent getActionBarView();

    View getHomeButton();

    void showcaseActionItem(int i11);
}
