package com.huobi.view.showcaseview;

import android.view.MotionEvent;

public interface OnShowcaseEventListener {
    public static final OnShowcaseEventListener NONE = new OnShowcaseEventListener() {
        public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
        }

        public void onShowcaseViewHide(ShowcaseView showcaseView) {
        }

        public void onShowcaseViewShow(ShowcaseView showcaseView) {
        }

        public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {
        }
    };

    void onShowcaseViewDidHide(ShowcaseView showcaseView);

    void onShowcaseViewHide(ShowcaseView showcaseView);

    void onShowcaseViewShow(ShowcaseView showcaseView);

    void onShowcaseViewTouchBlocked(MotionEvent motionEvent);
}
