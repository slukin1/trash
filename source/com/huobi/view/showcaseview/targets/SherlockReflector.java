package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;

class SherlockReflector implements Reflector {
    private Activity mActivity;

    public SherlockReflector(Activity activity) {
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
        View findViewById2 = this.mActivity.findViewById(this.mActivity.getResources().getIdentifier("abs__home", "id", this.mActivity.getPackageName()));
        if (findViewById2 != null) {
            return findViewById2;
        }
        throw new RuntimeException("insertShowcaseViewWithType cannot be used when the theme has no ActionBar");
    }

    public void showcaseActionItem(int i11) {
    }
}
