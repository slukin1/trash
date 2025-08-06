package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;

public class ActionItemTarget implements Target {
    public ActionBarViewWrapper mActionBarWrapper;
    private final Activity mActivity;
    private final int mItemId;

    public ActionItemTarget(Activity activity, int i11) {
        this.mActivity = activity;
        this.mItemId = i11;
    }

    public Point getPoint() {
        setUp();
        return new ViewTarget(this.mActionBarWrapper.getActionItem(this.mItemId)).getPoint();
    }

    public void setUp() {
        this.mActionBarWrapper = new ActionBarViewWrapper(ReflectorFactory.getReflectorForActivity(this.mActivity).getActionBarView());
    }
}
