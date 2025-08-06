package com.luck.picture.lib.style;

import com.luck.picture.lib.R;

public class PictureWindowAnimationStyle {
    public int activityEnterAnimation;
    public int activityExitAnimation;
    public int activityPreviewEnterAnimation;
    public int activityPreviewExitAnimation;

    public PictureWindowAnimationStyle() {
    }

    public static PictureWindowAnimationStyle ofDefaultWindowAnimationStyle() {
        return new PictureWindowAnimationStyle(R.anim.ps_anim_enter, R.anim.ps_anim_exit);
    }

    public int getActivityEnterAnimation() {
        return this.activityEnterAnimation;
    }

    public int getActivityExitAnimation() {
        return this.activityExitAnimation;
    }

    public int getActivityPreviewEnterAnimation() {
        return this.activityPreviewEnterAnimation;
    }

    public int getActivityPreviewExitAnimation() {
        return this.activityPreviewExitAnimation;
    }

    public void setActivityEnterAnimation(int i11) {
        this.activityEnterAnimation = i11;
    }

    public void setActivityExitAnimation(int i11) {
        this.activityExitAnimation = i11;
    }

    public void setActivityPreviewEnterAnimation(int i11) {
        this.activityPreviewEnterAnimation = i11;
    }

    public void setActivityPreviewExitAnimation(int i11) {
        this.activityPreviewExitAnimation = i11;
    }

    public PictureWindowAnimationStyle(int i11, int i12) {
        this.activityEnterAnimation = i11;
        this.activityExitAnimation = i12;
        this.activityPreviewEnterAnimation = i11;
        this.activityPreviewExitAnimation = i12;
    }
}
