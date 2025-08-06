package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;

class ActionBarReflector implements Reflector {
    private Activity mActivity;

    public ActionBarReflector(Activity activity) {
        this.mActivity = activity;
    }

    public ViewParent getActionBarView() {
        return getHomeButton().getParent().getParent();
    }

    public View getHomeButton() {
        View findViewById = this.mActivity.findViewById(16908332);
        if (findViewById != null) {
            return findViewById;
        }
        throw new RuntimeException("insertShowcaseViewWithType cannot be used when the theme has no ActionBar");
    }

    public void showcaseActionItem(int i11) {
    }
}
