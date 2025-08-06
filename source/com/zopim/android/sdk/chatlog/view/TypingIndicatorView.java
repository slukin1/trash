package com.zopim.android.sdk.chatlog.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import java.util.concurrent.TimeUnit;

public class TypingIndicatorView extends LinearLayout {
    private static final String LOG_TAG = "TypingIndicatorView";
    private static final long TYPING_INDICATOR_MAX_DELAY = TimeUnit.SECONDS.toMillis(2);
    private AnimationDrawable[] mAnimations;
    private long mTransitionDelay = TYPING_INDICATOR_MAX_DELAY;

    public TypingIndicatorView(Context context) {
        super(context);
    }

    @TargetApi(16)
    private AnimationDrawable[] prepareAnimations() {
        int childCount = getChildCount();
        int integer = getResources().getInteger(R.integer.typing_dot_duration);
        long j11 = (long) integer;
        long j12 = TYPING_INDICATOR_MAX_DELAY;
        if (j11 > j12) {
            j11 = j12;
        }
        this.mTransitionDelay = j11;
        Drawable drawable = getResources().getDrawable(R.drawable.ic_typing_dot_secondary);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_typing_dot_primary);
        AnimationDrawable[] animationDrawableArr = new AnimationDrawable[childCount];
        for (int i11 = 0; getChildAt(i11) instanceof ImageView; i11++) {
            ImageView imageView = (ImageView) getChildAt(i11);
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.addFrame(drawable, (childCount - 1) * integer);
            animationDrawable.addFrame(drawable2, integer);
            animationDrawable.setOneShot(false);
            if (Build.VERSION.SDK_INT < 16) {
                imageView.setBackgroundDrawable(animationDrawable);
            } else {
                imageView.setBackground(animationDrawable);
            }
            animationDrawableArr[i11] = animationDrawable;
        }
        return animationDrawableArr;
    }

    public void start() {
        AnimationDrawable[] prepareAnimations = prepareAnimations();
        this.mAnimations = prepareAnimations;
        long j11 = 0;
        for (final AnimationDrawable animationDrawable : prepareAnimations) {
            postDelayed(new Runnable() {
                public void run() {
                    animationDrawable.start();
                }
            }, j11);
            j11 += this.mTransitionDelay;
        }
    }

    public void stop() {
        AnimationDrawable[] animationDrawableArr = this.mAnimations;
        if (animationDrawableArr == null) {
            Logger.l(LOG_TAG, "Animations are not initialized. Aborting stop.", new Object[0]);
            return;
        }
        for (AnimationDrawable animationDrawable : animationDrawableArr) {
            animationDrawable.selectDrawable(0);
            animationDrawable.stop();
        }
    }

    public TypingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
