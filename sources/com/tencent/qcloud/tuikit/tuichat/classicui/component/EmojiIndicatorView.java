package com.tencent.qcloud.tuikit.tuichat.classicui.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiIndicatorView extends LinearLayout {
    /* access modifiers changed from: private */
    public Bitmap bmpNomal;
    /* access modifiers changed from: private */
    public Bitmap bmpSelect;
    private Context mContext;
    private int mHeight;
    private ArrayList<ImageView> mImageViews;
    private int mMaxHeight;
    /* access modifiers changed from: private */
    public AnimatorSet mPlayByInAnimatorSet;
    private AnimatorSet mPlayByOutAnimatorSet;
    private AnimatorSet mPlayToAnimatorSet;

    public EmojiIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeight = 16;
        this.mContext = context;
        setOrientation(0);
        this.mMaxHeight = ScreenUtil.dip2px((float) this.mHeight);
        this.bmpSelect = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_select);
        this.bmpNomal = BitmapFactory.decodeResource(getResources(), R.drawable.indicator_point_nomal);
    }

    public void init(int i11) {
        this.mImageViews = new ArrayList<>();
        removeAllViews();
        for (int i12 = 0; i12 < i11; i12++) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            int i13 = this.mMaxHeight;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            ImageView imageView = new ImageView(this.mContext);
            if (i12 == 0) {
                imageView.setImageBitmap(this.bmpSelect);
                relativeLayout.addView(imageView, layoutParams2);
            } else {
                imageView.setImageBitmap(this.bmpNomal);
                relativeLayout.addView(imageView, layoutParams2);
            }
            addView(relativeLayout, layoutParams);
            this.mImageViews.add(imageView);
        }
    }

    public void playBy(int i11, int i12) {
        boolean z11;
        int i13 = 0;
        if (i11 < 0 || i12 < 0 || i12 == i11) {
            i11 = 0;
            i12 = 0;
        }
        if (i11 < 0) {
            z11 = true;
            i12 = 0;
        } else {
            i13 = i11;
            z11 = false;
        }
        final ImageView imageView = this.mImageViews.get(i13);
        final ImageView imageView2 = this.mImageViews.get(i12);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 0.25f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 0.25f});
        AnimatorSet animatorSet = this.mPlayByOutAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mPlayByOutAnimatorSet.cancel();
            this.mPlayByOutAnimatorSet = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPlayByOutAnimatorSet = animatorSet2;
        animatorSet2.play(ofFloat).with(ofFloat2);
        this.mPlayByOutAnimatorSet.setDuration(100);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView2, "scaleX", new float[]{0.25f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView2, "scaleY", new float[]{0.25f, 1.0f});
        AnimatorSet animatorSet3 = this.mPlayByInAnimatorSet;
        if (animatorSet3 != null && animatorSet3.isRunning()) {
            this.mPlayByInAnimatorSet.cancel();
            this.mPlayByInAnimatorSet = null;
        }
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.mPlayByInAnimatorSet = animatorSet4;
        animatorSet4.play(ofFloat3).with(ofFloat4);
        this.mPlayByInAnimatorSet.setDuration(100);
        if (z11) {
            this.mPlayByInAnimatorSet.start();
            return;
        }
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                imageView.setImageBitmap(EmojiIndicatorView.this.bmpNomal);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat).with(ofFloat2);
                animatorSet.start();
                imageView2.setImageBitmap(EmojiIndicatorView.this.bmpSelect);
                EmojiIndicatorView.this.mPlayByInAnimatorSet.start();
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        this.mPlayByOutAnimatorSet.start();
    }

    public void playTo(int i11) {
        Iterator<ImageView> it2 = this.mImageViews.iterator();
        while (it2.hasNext()) {
            it2.next().setImageBitmap(this.bmpNomal);
        }
        this.mImageViews.get(i11).setImageBitmap(this.bmpSelect);
        ImageView imageView = this.mImageViews.get(i11);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{0.25f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{0.25f, 1.0f});
        AnimatorSet animatorSet = this.mPlayToAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mPlayToAnimatorSet.cancel();
            this.mPlayToAnimatorSet = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPlayToAnimatorSet = animatorSet2;
        animatorSet2.play(ofFloat).with(ofFloat2);
        this.mPlayToAnimatorSet.setDuration(100);
        this.mPlayToAnimatorSet.start();
    }

    public void setIndicatorCount(int i11) {
        ArrayList<ImageView> arrayList = this.mImageViews;
        if (arrayList != null && i11 <= arrayList.size()) {
            for (int i12 = 0; i12 < this.mImageViews.size(); i12++) {
                if (i12 >= i11) {
                    this.mImageViews.get(i12).setVisibility(8);
                    ((View) this.mImageViews.get(i12).getParent()).setVisibility(8);
                } else {
                    this.mImageViews.get(i12).setVisibility(0);
                    ((View) this.mImageViews.get(i12).getParent()).setVisibility(0);
                }
            }
        }
    }

    public EmojiIndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }
}
