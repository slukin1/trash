package com.huobi.view.rollviewpager.hintview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$drawable;
import com.huobi.view.VerticalHintPagerView;

public class AnimHintView extends LinearLayout implements VerticalHintPagerView.IVerticalHintView {
    private int bgResId;
    private int focusResId = R$drawable.index_banner_focus_indicator;
    public int lastPosition = 0;
    public int length = 0;
    private ImageView mAnimView;
    private Callback mCallback;
    private int mDotPadding;
    private int mDotWidth;
    public ImageView[] mDots;
    private FrameLayout mFrameLayout;
    private int mHeight;
    private int normalResId = R$drawable.index_banner_normal_indicator;
    private boolean useAnim = true;

    public interface Callback {
        void onPageChange(int i11);
    }

    public AnimHintView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mDotWidth = PixelUtils.a(20.0f);
        this.mHeight = PixelUtils.a(2.0f);
    }

    public void doAnim(View view, int i11) {
        view.animate().translationX((float) i11);
    }

    public void initView(int i11, int i12) {
        initView(i11, i12, 0);
    }

    public void setBgResId(int i11) {
        this.bgResId = i11;
        FrameLayout frameLayout = this.mFrameLayout;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(i11);
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrent(int i11) {
        if (i11 >= 0 && i11 <= this.length - 1 && this.lastPosition != i11) {
            this.lastPosition = i11;
            int i12 = (this.mDotWidth + this.mDotPadding) * i11;
            if (this.useAnim) {
                doAnim(this.mAnimView, i12);
            } else {
                this.mAnimView.setTranslationX((float) i12);
            }
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onPageChange(i11);
            }
        }
    }

    public void setDotHeight(int i11) {
        this.mHeight = i11;
    }

    public void setDotPadding(int i11) {
        this.mDotPadding = i11;
    }

    public void setDotWidth(int i11) {
        this.mDotWidth = i11;
    }

    public void setFocusResId(int i11) {
        this.focusResId = i11;
    }

    public void setNormalResId(int i11) {
        this.normalResId = i11;
    }

    public void setUseAnim(boolean z11) {
        this.useAnim = z11;
    }

    public void updateDotBg() {
        ImageView[] imageViewArr = this.mDots;
        if (imageViewArr != null) {
            for (ImageView imageView : imageViewArr) {
                if (imageView != null) {
                    imageView.setImageResource(this.normalResId);
                }
            }
        }
        ImageView imageView2 = this.mAnimView;
        if (imageView2 != null) {
            imageView2.setImageResource(this.focusResId);
        }
    }

    public void initView(int i11, int i12, int i13) {
        if (this.length == i11) {
            setCurrent(i13);
            return;
        }
        removeAllViews();
        this.length = i11;
        this.mDots = new ImageView[i11];
        if (i12 == 0) {
            setGravity(19);
        } else if (i12 == 1) {
            setGravity(17);
        } else if (i12 == 2) {
            setGravity(21);
        }
        setOrientation(0);
        this.mFrameLayout = new FrameLayout(getContext());
        this.mFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, this.mHeight));
        addView(this.mFrameLayout);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, this.mHeight));
        this.mFrameLayout.addView(linearLayout);
        for (int i14 = 0; i14 < i11; i14++) {
            this.mDots[i14] = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mDotWidth, this.mHeight);
            if (i14 > 0) {
                layoutParams.setMargins(this.mDotPadding, 0, 0, 0);
            }
            this.mDots[i14].setLayoutParams(layoutParams);
            this.mDots[i14].setImageResource(this.normalResId);
            linearLayout.addView(this.mDots[i14]);
        }
        this.mAnimView = new ImageView(getContext());
        this.mAnimView.setLayoutParams(new LinearLayout.LayoutParams(this.mDotWidth, this.mHeight));
        this.mAnimView.setImageResource(this.focusResId);
        this.mFrameLayout.addView(this.mAnimView);
        int i15 = this.bgResId;
        if (i15 != 0) {
            this.mFrameLayout.setBackgroundResource(i15);
        }
        setCurrent(0);
    }
}
